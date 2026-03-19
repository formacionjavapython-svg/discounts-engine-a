#!/bin/bash
CHECKSTYLE_JAR="checkstyle.jar"
curl -L -o $CHECKSTYLE_JAR \
https://github.com/checkstyle/checkstyle/releases/download/checkstyle-13.3.0/checkstyle-13.3.0-all.jar
java -jar $CHECKSTYLE_JAR \
-c scripts/checkstyle.xml src/
