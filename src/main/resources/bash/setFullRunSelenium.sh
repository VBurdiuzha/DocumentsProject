#!/usr/bin/env bash
cat FullRun.xml | sed 's/<parameter name=\"selenium\" value=\"local\" \/>/<parameter name=\"selenium\" value=\"remove\" \/>/g' > out.xml && mv out.xml FullRun.xml