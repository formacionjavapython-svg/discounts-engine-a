if [ ! -f "scripts/checkstyle.jar" ]; then
    echo "Descargando Checkstyle..."
    curl -L https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.4/checkstyle-10.12.4-all.jar -o scripts/checkstyle.jar
fi

java -jar scripts/checkstyle.jar -c checkstyle.xml src/main/java/*.java