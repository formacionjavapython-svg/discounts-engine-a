#!/bin/bash

echo "=== Checkstyle: Validando código Java ==="

# Nombre del archivo JAR
CHECKSTYLE_JAR="checkstyle-10.12.1-all.jar"

# URL de descarga (versión más reciente de Checkstyle)
URL="https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.1/checkstyle-10.12.1-all.jar"

# Descargar Checkstyle si no existe
if [ ! -f "$CHECKSTYLE_JAR" ]; then
    echo "Descargando Checkstyle..."
    curl -L -o "$CHECKSTYLE_JAR" "$URL"
    if [ $? -ne 0 ]; then
        echo "Error: No se pudo descargar Checkstyle"
        exit 1
    fi
fi

# Ejecutar Checkstyle
echo "Ejecutando validacion..."
java -jar "$CHECKSTYLE_JAR" -c checkstyle.xml src/main/java/

# Guardar el resultado
RESULT=$?

if [ $RESULT -eq 0 ]; then
    echo "¡Todo bien! Codigo válido segun Checkstyle"
else
    echo " Se encontraron problemas de estilo"
    echo "Revisa los mensajes arriba y corrige los errores"
fi

exit $RESULT