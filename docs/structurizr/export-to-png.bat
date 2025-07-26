@echo off
REM Script pour exporter le workspace.dsl en images PNG avec Docker Structurizr CLI
REM Auteur: Script généré automatiquement
REM Date: 2025-07-26

echo 🚀 Début de l'export du workspace Structurizr vers PNG...

REM Vérification que Docker est disponible
docker --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Erreur: Docker n'est pas installé ou n'est pas dans le PATH
    pause
    exit /b 1
)

REM Répertoire de base (où se trouve ce script)
set SCRIPT_DIR=%~dp0
echo 📁 Répertoire de travail: %SCRIPT_DIR%

REM Chemins des fichiers et dossiers (conversion des backslashes en forward slashes pour Docker)
set WORKSPACE_FILE=%SCRIPT_DIR%dsl\usr\local\structurizr\workspace.dsl
set IMAGES_DIR=%SCRIPT_DIR%images
set DOCKER_DSL_PATH=%SCRIPT_DIR%dsl
set DOCKER_IMAGES_PATH=%SCRIPT_DIR%images

REM Vérification que le fichier workspace.dsl existe
if not exist "%WORKSPACE_FILE%" (
    echo ❌ Erreur: Le fichier workspace.dsl n'existe pas à l'emplacement: %WORKSPACE_FILE%
    pause
    exit /b 1
)

REM Vérification que le dossier images existe
if not exist "%IMAGES_DIR%" (
    echo 📁 Création du dossier images: %IMAGES_DIR%
    mkdir "%IMAGES_DIR%"
)

echo 📄 Fichier workspace: %WORKSPACE_FILE%
echo 📁 Dossier de sortie: %IMAGES_DIR%

REM Export des diagrammes en PNG avec Docker Structurizr CLI
echo 🔄 Export en cours...

REM Conversion des chemins Windows en chemins compatibles Docker (forward slashes)
set DOCKER_DSL_MOUNT=%DOCKER_DSL_PATH:\=/%
set DOCKER_IMAGES_MOUNT=%DOCKER_IMAGES_PATH:\=/%

REM Utilisation du CLI Structurizr pour exporter en PlantUML (puis conversion en PNG)
docker run --rm -v "%DOCKER_DSL_MOUNT%:/usr/local/structurizr" -v "%DOCKER_IMAGES_MOUNT%:/usr/local/images" structurizr/cli:latest export -workspace /usr/local/structurizr/usr/local/structurizr/workspace.dsl -format plantuml -output /usr/local/images

REM Vérification du succès de l'opération
if %errorlevel% equ 0 (
    echo ✅ Export terminé avec succès!
    echo 📁 Les fichiers PlantUML ont été générés dans: %IMAGES_DIR%
    
    REM Affichage des fichiers générés
    echo 📋 Fichiers générés:
    if exist "%IMAGES_DIR%\*.puml" (
        dir "%IMAGES_DIR%\*.puml" /b
    ) else (
        echo    Aucun fichier PlantUML trouvé
    )
) else (
    echo ❌ Erreur lors de l'export
    pause
    exit /b 1
)

echo 🎉 Script terminé!
pause