
CHECKSTYLE_VERSION="10.21.0"
CHECKSTYLE_JAR="checkstyle-${CHECKSTYLE_VERSION}-all.jar"
CHECKSTYLE_URL="https://github.com/checkstyle/checkstyle/releases/download/checkstyle-${CHECKSTYLE_VERSION}/${CHECKSTYLE_JAR}"

if [ ! -f "$CHECKSTYLE_JAR" ]; then
    echo "Descargando Checkstyle v${CHECKSTYLE_VERSION}..."
    curl -L --fail -o "$CHECKSTYLE_JAR" "$CHECKSTYLE_URL"
    if [ $? -ne 0 ]; then
        echo "Error: fallo la descarga."
        rm -f "$CHECKSTYLE_JAR"
        exit 1
    fi
fi

java -jar "$CHECKSTYLE_JAR" -c discounts/checkstyle.xml src/
