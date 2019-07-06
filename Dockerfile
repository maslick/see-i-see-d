FROM amazoncorretto:11
LABEL maintainer="pavel.masloff@gmail.com"
EXPOSE 8080
COPY see-i-see-d-1.0.jar /app/app.jar
WORKDIR /app
CMD java -jar app.jar
