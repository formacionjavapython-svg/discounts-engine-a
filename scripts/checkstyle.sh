#!/bin/bash
CHECKSTYLE_JAR="checkstyle.jar"

if [ ! -f "$CHECKSTYLE_JAR" ]; then
    echo "Downloading Checkstyle tool..."
    curl -L -o $CHECKSTYLE_JAR https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.4/checkstyle-10.12.4-all.jar
fi

echo "Running Checkstyle analysis..."
java -jar $CHECKSTYLE_JAR -c checkstyle.xml src/