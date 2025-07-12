Write-Host "Library Management System" -ForegroundColor Green
Write-Host "========================" -ForegroundColor Green
Write-Host ""

# Check Java installation
Write-Host "Checking Java installation..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1
    Write-Host "Java is installed ✓" -ForegroundColor Green
    Write-Host "Version: $($javaVersion[0])" -ForegroundColor Gray
} catch {
    Write-Host "ERROR: Java is not installed or not in PATH" -ForegroundColor Red
    Write-Host "Please install Java 8 or higher and add it to your PATH" -ForegroundColor Red
    Write-Host "You can download Java from:" -ForegroundColor Red
    Write-Host "  https://www.oracle.com/java/technologies/downloads/" -ForegroundColor Cyan
    Write-Host "  https://adoptopenjdk.net/" -ForegroundColor Cyan
    Read-Host "Press Enter to exit"
    exit 1
}

# Compile Java files
Write-Host ""
Write-Host "Compiling Java files..." -ForegroundColor Yellow
try {
    javac *.java
    Write-Host "Compilation successful ✓" -ForegroundColor Green
} catch {
    Write-Host "ERROR: Compilation failed" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

# Run the application
Write-Host ""
Write-Host "Running the application..." -ForegroundColor Yellow
Write-Host "The application will demonstrate all API operations" -ForegroundColor Cyan
Write-Host ""

try {
    java LibraryAPI
} catch {
    Write-Host "Application stopped." -ForegroundColor Yellow
}

Read-Host "Press Enter to exit" 