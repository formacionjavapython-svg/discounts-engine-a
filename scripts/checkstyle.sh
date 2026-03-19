#!/bin/bash

CHECKSTYLE_VERSION=10.12.4
CHECKSTYLE_JAR="checkstyle-$CHECKSTYLE_VERSION-all.jar"

if [ ! -f "$CHECKSTYLE_JAR" ]; then
  echo "Descargando Checkstyle..."
  curl -L -o $CHECKSTYLE_JAR \
    https://github.com/checkstyle/checkstyle/releases/download/checkstyle-$CHECKSTYLE_VERSION/$CHECKSTYLE_JAR
fi

echo "Ejecutando Checkstyle..."
java -jar $CHECKSTYLE_JAR -c checkstyle.xml src/main/java
