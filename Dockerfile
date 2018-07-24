FROM  java:8
MAINTAINER  Burdiuzha Villi <v.burdiuzha@ossystem.com.ua>
COPY . /var/www/tests
WORKDIR /var/www/tests
RUN apt-get update -qq
RUN apt-get install -y maven
RUN sh ./src/main/resources/bash/setFullRunPlatform.sh
RUN sh ./src/main/resources/bash/setFullRunSelenium.sh
RUN sh ./src/main/resources/bash/setPom.sh
