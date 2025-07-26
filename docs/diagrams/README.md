# Diagrammes pour l'Analyse Fonctionnelle - ASHS Alumni

Ce dossier contient tous les diagrammes PlantUML créés pour enrichir l'analyse fonctionnelle de l'application ASHS Alumni.

## Liste des diagrammes

### Diagrammes architecturaux et techniques

#### 1. Modèle de données (data-model-erd.puml)
- **Type** : Diagramme d'entités-relations (ERD)
- **Objectif** : Visualiser la structure complète de la base de données
- **Contenu** : 
  - Toutes les entités avec leurs attributs
  - Relations et cardinalités
  - Contraintes de clés primaires et étrangères
  - Notes explicatives sur les règles métier
- **Intégré dans** : Section 4 - Modèles de données

### 2. États des contacts (contact-status-states.puml)
- **Type** : Diagramme d'états UML
- **Objectif** : Illustrer le cycle de vie des statuts des contacts
- **Contenu** :
  - 4 états possibles (EN_ATTENTE, VALIDE, NON_SOLLICITE, NON_JOIGNABLE)
  - Transitions autorisées entre les états
  - Conditions et acteurs pour chaque transition
  - Règles métier associées
- **Intégré dans** : Section 5 - Règles métier

### 3. Matrice de sécurité (security-access-matrix.puml)
- **Type** : Diagramme de cas d'utilisation avec matrice de droits
- **Objectif** : Visualiser les permissions par type d'utilisateur
- **Contenu** :
  - 3 types d'acteurs (Visiteur, Utilisateur, Administrateur)
  - 15 fonctionnalités principales
  - Droits d'accès avec codage couleur
  - Règles spéciales et exceptions
- **Intégré dans** : Section 7 - Gestion des droits et sécurité

### 4. Maquettes d'interface (ui-wireframes.puml)
- **Type** : Wireframes/maquettes d'interface
- **Objectif** : Représenter visuellement les principales interfaces utilisateur
- **Contenu** :
  - 6 écrans principaux (accueil, connexion, tableau de bord, etc.)
  - Structure et composants de chaque page
  - Codage couleur par type d'élément
  - Règles d'affichage et de validation
- **Intégré dans** : Section 6 - Spécifications d'interface utilisateur

### 5. Parcours utilisateur (user-journey-flows.puml)
- **Type** : Diagrammes d'activité
- **Objectif** : Détailler les parcours utilisateur complets
- **Contenu** :
  - 4 parcours principaux (invitation, inscription spontanée, inscription événement, administration)
  - Points de décision et conditions
  - Actions alternatives et gestion d'erreurs
  - Règles métier intégrées
- **Intégré dans** : Section 9 - Workflows et processus

### 6. Interactions entre modules (module-interactions.puml)
- **Type** : Diagrammes de séquence UML
- **Objectif** : Montrer les communications entre modules fonctionnels
- **Contenu** :
  - 4 séquences principales (création contact, validation SMS, inscription événement, administration)
  - Interactions entre les 5 modules (MGU, MGC, MIV, MGE, MAD)
  - Services externes (SMS, Historisation)
  - Règles de communication et dépendances
- **Intégré dans** : Section 2 - Architecture fonctionnelle

### Diagrammes par fonctionnalité

#### 7. Création d'un contact (functionality-creation-contact.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Détailler le processus de création d'un nouveau contact
- **Contenu** :
  - Workflow complet de création
  - Validation des données et vérification des doublons
  - Gestion des contacts avec/sans téléphone
  - Envoi automatique de SMS d'invitation
- **Intégré dans** : Section 3.1.1 - Fonctionnalité : Création d'un contact

#### 8. Modification d'un contact (functionality-modification-contact.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Illustrer le processus de modification des informations d'un contact
- **Contenu** :
  - Vérification des droits d'accès selon le profil utilisateur
  - Validation des modifications et gestion des doublons
  - Gestion des changements de statut (admin uniquement)
  - Historisation des modifications
- **Intégré dans** : Section 3.1.2 - Fonctionnalité : Modification d'un contact

#### 9. Gestion des statuts (functionality-gestion-statuts.puml)
- **Type** : Diagramme d'états
- **Objectif** : Visualiser le cycle de vie des statuts des contacts
- **Contenu** :
  - 4 états possibles et leurs caractéristiques
  - Transitions autorisées entre les états
  - Conditions et acteurs pour chaque transition
  - Règles métier intégrées
- **Intégré dans** : Section 3.1.3 - Fonctionnalité : Gestion des statuts

#### 10. Création de compte utilisateur (functionality-creation-compte-utilisateur.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Détailler les processus de création de compte utilisateur
- **Contenu** :
  - Processus via SMS (intégré à la validation)
  - Processus via administrateur
  - Association obligatoire contact-utilisateur
  - Gestion des sessions et authentification
- **Intégré dans** : Section 3.2.1 - Fonctionnalité : Création de compte utilisateur

#### 11. Authentification (functionality-authentification.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Illustrer le processus de connexion des utilisateurs
- **Contenu** :
  - Validation des identifiants et sécurité
  - Gestion des tentatives échouées et blocages
  - Création de session et gestion des rôles
  - Mesures de sécurité intégrées
- **Intégré dans** : Section 3.2.2 - Fonctionnalité : Authentification

#### 12. Envoi d'invitation SMS (functionality-envoi-invitation-sms.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Détailler le processus d'envoi automatique de SMS
- **Contenu** :
  - Conditions de déclenchement et vérifications
  - Génération des tokens et liens personnalisés
  - Gestion des erreurs et mécanismes de retry
  - Intégration avec service SMS externe
- **Intégré dans** : Section 3.3.1 - Fonctionnalité : Envoi d'invitation SMS

#### 13. Validation de contact et inscription utilisateur (functionality-validation-contact-inscription-utilisateur.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Illustrer le processus intégré de validation et inscription
- **Contenu** :
  - Processus complet via SMS (validation + création compte)
  - Validation alternative par administrateur
  - Association contact-utilisateur obligatoire
  - Contact devient "Validé" UNIQUEMENT après création compte
- **Intégré dans** : Section 3.3.2 - Fonctionnalité : Validation de contact et inscription utilisateur

#### 14. Création d'événement (functionality-creation-evenement.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Détailler le processus de création d'événements par les administrateurs
- **Contenu** :
  - Saisie et validation des informations d'événement
  - Vérification des conflits de dates
  - Gestion des statuts d'événement
  - Notifications et publication
- **Intégré dans** : Section 3.4.1 - Fonctionnalité : Création d'événement

#### 15. Inscription à un événement (functionality-inscription-evenement.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Illustrer le processus d'inscription des utilisateurs aux événements
- **Contenu** :
  - Vérifications multiples (authentification, contact validé, places disponibles)
  - Gestion des contraintes d'inscription
  - Processus de confirmation et historisation
  - Gestion des places et notifications
- **Intégré dans** : Section 3.4.2 - Fonctionnalité : Inscription à un événement

#### 16. Gestion des listes de référence (functionality-gestion-listes-reference.puml)
- **Type** : Diagramme d'activité
- **Objectif** : Détailler la gestion des listes "à ne pas contacter" et "anciens participants"
- **Contenu** :
  - Gestion de la liste "à ne pas contacter"
  - Gestion de la liste "anciens participants"
  - Fonctions d'import/export CSV
  - Audit et traçabilité des actions
- **Intégré dans** : Section 3.5.1 - Fonctionnalité : Gestion des listes de référence

## Utilisation

### Rendu des diagrammes
Les diagrammes sont intégrés dans le document d'analyse fonctionnelle via la syntaxe PlantUML :

```plantuml
@startuml
!include ../diagrams/nom-du-diagramme.puml
@enduml
```

### Outils de rendu
- **PlantUML** : Outil principal pour le rendu des diagrammes
- **Extensions IDE** : PlantUML pour VS Code, IntelliJ, etc.
- **En ligne** : PlantUML Server (http://www.plantuml.com/plantuml/)

### Maintenance
- Les diagrammes doivent être mis à jour en parallèle des modifications de l'analyse fonctionnelle
- Chaque modification doit être documentée et cohérente avec les spécifications
- Les diagrammes servent de référence visuelle et ne remplacent pas les spécifications textuelles

## Cohérence avec l'architecture existante

Ces diagrammes complètent les diagrammes Structurizr existants :
- **Structurizr** : Vue d'ensemble architecturale et contexte système
- **PlantUML** : Détails fonctionnels et spécifications techniques

Les deux approches sont complémentaires et offrent différents niveaux de détail pour une compréhension complète du système.

---

**Créé le** : 26/07/2025  
**Version** : 1.0  
**Auteur** : Analyse fonctionnelle ASHS Alumni