FROM java:8
FROM selenium/standalone-chrome
MAINTAINER  Burdiuzha Villi <v.burdiuzha@ossystem.com.ua>
WORKDIR /var/www/tests
USER root
RUN apt-get update -qqy
RUN apt-get install -y maven


ENV JAVA_VER 8
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# install JDK
RUN echo 'deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main' >> /etc/apt/sources.list && \
    echo 'deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main' >> /etc/apt/sources.list && \
    apt-key adv --keyserver keyserver.ubuntu.com --recv-keys C2518248EEA14886 && \
    apt-get update && \
    echo oracle-java${JAVA_VER}-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections && \
    apt-get install -y --force-yes --no-install-recommends oracle-java${JAVA_VER}-installer oracle-java${JAVA_VER}-set-default && \
    apt-get clean && \
    rm -rf /var/cache/oracle-jdk${JAVA_VER}-installer

#RUN apt-cache search chrome browser
#RUN apt-get install chrome-browser
COPY . /var/www/tests
#RUN sh src/main/resources/bash/setFullRunPlatform.sh
#RUN sh src/main/resources/bash/setPom.sh
