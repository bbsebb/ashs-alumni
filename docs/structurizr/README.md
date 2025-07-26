# Diagrammes Structurizr - ASHS Alumni

## Vue d'ensemble

Ce dossier contient les diagrammes Structurizr de haut niveau pour l'application ASHS Alumni, créés dans le cadre de l'analyse des besoins fonctionnels.

**Important :** Ces diagrammes restent volontairement à un niveau conceptuel et fonctionnel, sans détails techniques ou choix architecturaux, conformément à la phase d'analyse des besoins.

## Fichiers

- `workspace.dsl` : Définition complète de l'espace de travail Structurizr avec tous les diagrammes

## Diagrammes inclus

### 1. Diagramme de contexte système (`SystemContext`)
**Objectif :** Vue d'ensemble des acteurs et de leurs interactions avec le système

**Éléments représentés :**
- Tous les types d'acteurs identifiés dans l'analyse des besoins
- Le système ASHS Alumni dans son ensemble
- Le service SMS externe pour les invitations
- Les interactions principales entre acteurs et système

### 2. Diagramme des espaces fonctionnels (`Containers`)
**Objectif :** Organisation conceptuelle des grandes fonctions du système

**Espaces fonctionnels :**
- **Gestion des Contacts** : Informations personnelles et statuts
- **Gestion des Utilisateurs** : Comptes d'accès et authentification
- **Gestion des Événements** : Soirées retrouvailles et inscriptions
- **Administration** : Gestion administrative et supervision
- **Historisation** : Traçabilité et conservation des historiques

**Note :** Ces "containers" représentent des espaces fonctionnels conceptuels, pas des composants techniques.

### 3. Diagramme de flux - Processus d'invitation (`ProcessusInvitation`)
**Objectif :** Visualiser le processus d'ajout et validation d'un contact

**Étapes clés :**
1. Ajout d'un nouveau contact par un utilisateur
2. Vérification des doublons
3. Envoi SMS d'invitation (si téléphone valide)
4. Validation du contact via lien SMS
5. Création du compte utilisateur
6. Enregistrement de l'historique

### 4. Diagramme de flux - Inscription à un événement (`ProcessusInscription`)
**Objectif :** Visualiser le processus d'inscription à une soirée retrouvaille

**Étapes clés :**
1. Définition des dates par l'administrateur
2. Consultation des événements par l'utilisateur
3. Vérification de l'association utilisateur-contact validé
4. Inscription à la soirée
5. Enregistrement de l'inscription

## Utilisation

### Avec Structurizr Lite (recommandé pour la visualisation locale)
1. Installer Structurizr Lite : https://structurizr.com/help/lite
2. Pointer vers le fichier `workspace.dsl`
3. Visualiser les diagrammes dans le navigateur

### Avec Structurizr Cloud
1. Créer un workspace sur https://structurizr.com
2. Importer le contenu du fichier `workspace.dsl`
3. Visualiser et partager les diagrammes en ligne

### Avec l'extension VS Code
1. Installer l'extension "Structurizr DSL"
2. Ouvrir le fichier `workspace.dsl`
3. Utiliser la prévisualisation intégrée

## Principes de conception

Ces diagrammes respectent les principes suivants pour rester au niveau de l'analyse des besoins :

- **Haut niveau** : Focus sur les concepts métier et les interactions utilisateur
- **Non technique** : Aucun détail d'implémentation ou choix technologique
- **Fonctionnel** : Représentation des grandes fonctions et processus métier
- **Compréhensible** : Accessible aux parties prenantes non techniques

## Évolution

Ces diagrammes pourront être enrichis et détaillés lors des phases ultérieures du projet (conception, architecture technique), mais doivent rester stables au niveau conceptuel défini ici.