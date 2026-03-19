#!/bin/bash

# Configuración de variables
CHECKSTYLE_JAR="checkstyle-10.12.0-all.jar"
CONFIG_FILE="checkstyle.xml"
SOURCE_DIR="../src/main/java"

echo "Iniciando validación de estilo..."

# Ejecutar Checkstyle
java -jar "$CHECKSTYLE_JAR" -c "$CONFIG_FILE" "$SOURCE_DIR"

# Capturar el resultado
if [ $? -eq 0 ]; then
    echo "------------------------------------------"
    echo "✅ ¡Éxito! El código cumple con las reglas."
else
    echo "------------------------------------------"
    echo "❌ Se encontraron errores de estilo."
fi
