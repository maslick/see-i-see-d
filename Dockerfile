FROM amazoncorretto:11 as builder
COPY . /tmp
WORKDIR /tmp
RUN ./gradlew --no-daemon build -x test

FROM amazoncorretto:11
EXPOSE 7777
COPY --from=builder /tmp/build/libs/ /app/
WORKDIR /app
CMD java -jar see-i-see-d-1.0.jar