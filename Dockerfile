FROM fabric8/s2i-java:latest-java11

ENV JAVA_APP_JAR app.jar
ENV AB_ENABLED off
ENV AB_JOLOKIA_AUTH_OPENSHIFT true
ENV JAVA_OPTIONS -Xmx256m -Djava.security.egd=file:///dev/./urandom

EXPOSE 8000

ADD build/libs/see-i-see-d-1.0.jar /deployments/app.jar