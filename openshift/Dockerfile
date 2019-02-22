FROM jenkins/jnlp-slave:latest-jdk11

MAINTAINER Pavel Maslov <pavel.masloff@gmail.com>
USER root
RUN mkdir /tmp/oc && wget https://github.com/openshift/origin/releases/download/v3.11.0/openshift-origin-client-tools-v3.11.0-0cbc58b-linux-64bit.tar.gz \
    -O /tmp/oc/oc-3.11.0.tgz && tar -xf /tmp/oc/oc-3.11.0.tgz -C /tmp/oc/ --strip 1 && \
    cp /tmp/oc/oc /usr/bin/ && \
    rm -fr /tmp/oc/

USER jenkins
