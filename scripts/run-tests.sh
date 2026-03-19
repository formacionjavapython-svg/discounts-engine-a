#!/bin/bash
# scripts/run-tests.sh

set -e

echo "=== COMPILACION Y EJECUCION DE TESTS ==="

rm -rf out
mkdir -p out/classes out/test-classes

echo "[1/3] Compilando codigo fuente..."
javac -d out/classes src/main/java/*.java
echo "[OK] Fuentes compiladas."

echo "[2/3] Compilando tests..."
javac -cp out/classes -d out/test-classes src/test/java/*.java
echo "[OK] Tests compilados."

echo "[3/3] Ejecutando TestRunner..."
echo ""

if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "cygwin" || "$OSTYPE" == "win32" ]]; then
    CP_SEP=";"
else
    CP_SEP=":"
fi

java -cp "out/classes${CP_SEP}out/test-classes" TestRunner

echo ""
echo "[DONE] Tests finalizados."