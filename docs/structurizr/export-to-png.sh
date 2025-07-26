#!/bin/bash

# Script pour exporter le workspace.dsl en images PNG avec Docker Structurizr CLI
# Auteur: Script généré automatiquement
# Date: 2025-07-26

echo "🚀 Début de l'export du workspace Structurizr vers PNG..."

# Vérification que Docker est disponible
if ! command -v docker &> /dev/null; then
    echo "❌ Erreur: Docker n'est pas installé ou n'est pas dans le PATH"
    exit 1
fi

# Répertoire de base (où se trouve ce script)
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
echo "📁 Répertoire de travail: $SCRIPT_DIR"

# Chemins des fichiers et dossiers
WORKSPACE_FILE="$SCRIPT_DIR/dsl/usr/local/structurizr/workspace.dsl"
IMAGES_DIR="$SCRIPT_DIR/images"

# Vérification que le fichier workspace.dsl existe
if [ ! -f "$WORKSPACE_FILE" ]; then
    echo "❌ Erreur: Le fichier workspace.dsl n'existe pas à l'emplacement: $WORKSPACE_FILE"
    exit 1
fi

# Vérification que le dossier images existe
if [ ! -d "$IMAGES_DIR" ]; then
    echo "📁 Création du dossier images: $IMAGES_DIR"
    mkdir -p "$IMAGES_DIR"
fi

echo "📄 Fichier workspace: $WORKSPACE_FILE"
echo "📁 Dossier de sortie: $IMAGES_DIR"

# Export des diagrammes en PlantUML avec Docker Structurizr CLI
echo "🔄 Export en cours..."

# Utilisation du CLI Structurizr pour exporter en PlantUML (puis conversion en PNG)
# Le container va monter les volumes et exporter les diagrammes
docker run --rm \
    -v "$SCRIPT_DIR/dsl:/usr/local/structurizr" \
    -v "$IMAGES_DIR:/usr/local/images" \
    structurizr/cli:latest \
    export \
    -workspace /usr/local/structurizr/usr/local/structurizr/workspace.dsl \
    -format plantuml \
    -output /usr/local/images

# Vérification du succès de l'opération
if [ $? -eq 0 ]; then
    echo "✅ Export terminé avec succès!"
    echo "📁 Les fichiers PlantUML ont été générés dans: $IMAGES_DIR"
    
    # Affichage des fichiers générés
    if [ -d "$IMAGES_DIR" ] && [ "$(ls -A $IMAGES_DIR 2>/dev/null)" ]; then
        echo "📋 Fichiers générés:"
        ls -la "$IMAGES_DIR"/*.puml 2>/dev/null || echo "   Aucun fichier PlantUML trouvé"
    fi
else
    echo "❌ Erreur lors de l'export"
    exit 1
fi

echo "🎉 Script terminé!"