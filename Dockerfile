FROM gradle:5.4.1-jdk11 as builder
COPY . /tmp
RUN cd /tmp && \
    gradle build -x test && \
    find build/libs -name '*.jar' -and ! -name '*-javadoc.jar' -and ! -name '*-sources.jar' -exec cp {} /tmp/app.jar \;

FROM amazoncorretto:11
LABEL maintainer="pavel.masloff@gmail.com"
EXPOSE 8080
WORKDIR /app
COPY --from=builder /tmp/app.jar ./
CMD java $JAVA_OPTIONS -jar app.jar
