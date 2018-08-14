#!/bin/bash

DOCKER_IMAGE=sdtests

docker build --shm-size=512M -f ./Dockerfile -t sdtests .
