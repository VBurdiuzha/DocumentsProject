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


RUN apt-get install -y xvfb

RUN apt-get update
RUN sudo apt-get  install -y xvfb x11vnc x11-xkb-utils xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic x11-apps

ADD xvfb_init /var/www/tests/xvfb/init.d/xvfb
RUN chmod a+x /var/www/tests/xvfb/init.d/xvfb
ADD xvfb_daemon_run /usr/bin/xvfb-daemon-run
RUN chmod a+x /usr/bin/xvfb-daemon-run

ENV DISPLAY :99



#RUN apt-cache search chrome browser
#RUN apt-get install chrome-browser
COPY . /var/www/tests
#RUN sh src/main/resources/bash/setFullRunPlatform.sh
#RUN sh src/main/resources/bash/setPom.sh
