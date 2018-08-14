#!/usr/bin/env bash
pwd
cat src/main/resources/xml/FullRun.xml | sed 's/<parameter name=\"platform\" value=\"mac\" \/>/<parameter name=\"platform\" value=\"linux\" \/>/g' > src/main/resources/xml/out.xml && mv src/main/resources/xml/out.xml src/main/resources/xml/FullRun.xml