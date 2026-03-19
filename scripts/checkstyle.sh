#!/bin/bash

CHECKSTYLE_JAR="checkstyle.jar"

# Descargar Checkstyle
curl -L -o $CHECKSTYLE_JAR https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.4/checkstyle-10.12.4-all.jar

# Ejecutar Checkstyle
java -jar $CHECKSTYLE_JAR -c checkstyle.xml src/