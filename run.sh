#!/bin/bash

DOCKER_IMAGE=sdtests

docker build -f ./Dockerfile -t sdtests .
docker run sdtests bash -c "mvn clean test"
rm -r ./allure-results/
docker ps -a
docker cp ecstatic_knuth:/var/www/tests/allure-results .
allure-commandline/bin/allure serve