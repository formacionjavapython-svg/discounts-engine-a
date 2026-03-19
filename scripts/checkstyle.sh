#!/bin/bash
# 1. Descargar el motor de Checkstyle si no existe
CHECKSTYLE_JAR="checkstyle.jar"
if [ ! -f "$CHECKSTYLE_JAR" ]; then
    echo "Descargando Checkstyle..."
    curl -L -o $CHECKSTYLE_JAR https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.4/checkstyle-10.12.4-all.jar
fi

# 2. Ejecutar la validación sobre tu carpeta src
java -jar $CHECKSTYLE_JAR -c checkstyle.xml src/