FROM  java:8

MAINTAINER  Burdiuzha Villi <v.burdiuzha@ossystem.com.ua>
COPY . /var/www/tests
WORKDIR /var/www/tests
RUN apt-get update -qq
RUN apt-get install -y maven
RUN sh ./src/main/resources/bash/setFullRun.sh
RUN sh ./src/main/resources/bash/setPom.sh
