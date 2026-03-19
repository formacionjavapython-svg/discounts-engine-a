#!/bin/bash
# scripts/checkstyle.sh

set -e

CHECKSTYLE_VERSION="10.21.4"
CHECKSTYLE_JAR="checkstyle-${CHECKSTYLE_VERSION}-all.jar"
CHECKSTYLE_URL="https://github.com/checkstyle/checkstyle/releases/download/checkstyle-${CHECKSTYLE_VERSION}/${CHECKSTYLE_JAR}"
CONFIG_FILE="checkstyle.xml"
SOURCE_DIR="src/main/java"

echo "=== CHECKSTYLE - Validacion de Calidad de Codigo ==="

if [ ! -f "$CHECKSTYLE_JAR" ]; then
    echo "[INFO] Descargando Checkstyle ${CHECKSTYLE_VERSION}..."
    curl -L -o "$CHECKSTYLE_JAR" "$CHECKSTYLE_URL"
    echo "[OK] Checkstyle descargado."
else
    echo "[OK] Checkstyle ya existe localmente."
fi

if [ ! -f "$CONFIG_FILE" ]; then
    echo "[ERROR] No se encontro ${CONFIG_FILE}. Asegurate de estar en la raiz del proyecto."
    exit 1
fi

echo "[INFO] Ejecutando Checkstyle sobre ${SOURCE_DIR}..."
echo ""

java -jar "$CHECKSTYLE_JAR" -c "$CONFIG_FILE" "$SOURCE_DIR"

RESULT=$?

echo ""
if [ $RESULT -eq 0 ]; then
    echo "========================================"
    echo "  CHECKSTYLE PASSED - Codigo limpio!"
    echo "========================================"
else
    echo "========================================"
    echo "  CHECKSTYLE FAILED - Corrige los warnings"
    echo "========================================"
    exit 1
fi
