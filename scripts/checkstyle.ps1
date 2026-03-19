# scripts/checkstyle.ps1

Write-Host "=== Checkstyle - Validando código Java ===" -ForegroundColor Cyan

$CHECKSTYLE_JAR = "checkstyle-10.12.1-all.jar"
$CHECKSTYLE_URL = "https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.1/checkstyle-10.12.1-all.jar"

# Ir a la raíz del proyecto
Set-Location ..

# Descargar Checkstyle si no existe
if (-not (Test-Path $CHECKSTYLE_JAR)) {
    Write-Host "Descargando Checkstyle..." -ForegroundColor Yellow
    Invoke-WebRequest -Uri $CHECKSTYLE_URL -OutFile $CHECKSTYLE_JAR
    if (-not $?) {
        Write-Host "Error descargando Checkstyle" -ForegroundColor Red
        exit 1
    }
}

# Ejecutar Checkstyle
Write-Host "Ejecutando validacion..." -ForegroundColor Yellow
java -jar $CHECKSTYLE_JAR -c checkstyle.xml src/

if ($LASTEXITCODE -eq 0) {
    Write-Host "¡Todo bien! Codigo valido" -ForegroundColor Green
}
else {
    Write-Host "Se encontraron problemas de estilo" -ForegroundColor Red
}

Set-Location scripts