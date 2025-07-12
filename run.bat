@echo off
echo Library Management System
echo ========================

echo.
echo Checking Java installation...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 8 or higher and add it to your PATH
    echo You can download Java from: https://www.oracle.com/java/technologies/downloads/
    echo or from: https://adoptopenjdk.net/
    pause
    exit /b 1
)

echo Java is installed ✓

echo.
echo Compiling Java files...
javac *.java
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed
    pause
    exit /b 1
)

echo Compilation successful ✓

echo.
echo Running the application...
echo The application will demonstrate all API operations
echo.
java LibraryAPI

pause 