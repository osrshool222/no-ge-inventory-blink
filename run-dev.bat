@echo off
setlocal
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-11.0.32.9-hotspot"
set "PATH=%JAVA_HOME%\bin;%PATH%"
set "GRADLE_USER_HOME=%LOCALAPPDATA%\Temp\opencode\gradle-home"
if not exist "%GRADLE_USER_HOME%" mkdir "%GRADLE_USER_HOME%"

set "DIAG=C:\Users\6675\.runelite\logs\nogeblink_debug.log"
set "MARKER=C:\Users\6675\.runelite\logs\nogeblink_devclient.log"

echo ============================================
echo Starting No GE Inventory Blink dev client
echo Time: %date% %time%
echo Diag file: %DIAG%
echo Dev log:   %MARKER%
echo ============================================
if exist "%DIAG%" del "%DIAG%"
if exist "%MARKER%" del "%MARKER%"

call gradlew.bat run %*

echo.
echo ============================================
echo Dev client exited.
if exist "%DIAG%" (
    echo [OK] Diagnostic file was created: %DIAG%
) else (
    echo [FEHLER] Diagnostic file was NOT created. The new plugin code did not run!
)
if exist "%MARKER%" (
    echo [OK] Dev client log created: %MARKER%
) else (
    echo [FEHLER] Dev client log was NOT created. The dev client did not start!
)
echo ============================================
endlocal