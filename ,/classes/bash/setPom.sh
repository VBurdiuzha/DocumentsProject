#!/usr/bin/env bash
cat pom.xml | sed 's/<suiteXmlFile>.*<\/suiteXmlFile>/<suiteXmlFile>src\/main\/resources\/xml\/FullRun.xml<\/suiteXmlFile>/' > out.xml && rm pom.xml && mv out.xml pom.xml