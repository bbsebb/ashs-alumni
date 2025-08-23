# Architecture et Documentation Technique - ASHS Alumni

## 📋 **Vue d'ensemble du projet**

### Objectif

Créer une application web pour permettre aux anciens et actuels membres des équipes 1 de l'ASHS (joueurs, coachs,
présidents, autres contributeurs) de se retrouver, de s'inscrire à une soirée retrouvaille, d'inviter de nouveaux
contacts et de garantir une gestion sécurisée et transparente par plusieurs administrateurs.

### Acteurs du système

- **Anciens & actuels joueurs** des équipes 1
- **Anciens & actuels coachs**
- **Anciens & actuels présidents**
- **Contributeurs actifs** (table de marque, chauffeur, etc.)
- **Inscrits spontanés ou invités**
- **Administrateurs** (plusieurs possibles)

### Distinction fondamentale : Utilisateurs vs Contacts

- **Contact** : Représente une personne physique avec ses informations personnelles (nom, prénom, téléphone, email,
  etc.). Statuts possibles : en attente, validé, non sollicité/refusé, non joignable.
- **Utilisateur** : Représente un compte d'accès à l'application. **Règle fondamentale** : Tout utilisateur inscrit doit
  obligatoirement être associé à un contact validé.

## 🏗️ **Architecture générale**

### Approche architecturale

- **Architecture Hexagonale (Ports & Adapters)**
- **Domain Driven Design (DDD)**
- **Monorepo Gradle multi-modules**
- **Séparation claire des responsabilités**

### Stack technique

- **Backend** : Spring Boot, Java/Kotlin
- **Frontend** : Angular
- **Base de données** : PostgreSQL avec UUID comme clés primaires
- **Migration** : Flyway pour le versioning de la base de données
- **Sécurité** : Spring Security, JWT, bcrypt/argon2
- **SMS** : Twilio
- **Monitoring** : Prometheus/Actuator, Grafana/Loki/Tempo
- **Conteneurisation** : Docker & Docker Compose

## 📂 **Structure monorepo Gradle multi-modules**

```
monorepo-root/
│
├── backend/
│   ├── build.gradle.kts
│   ├── settings.gradle.kts
│   ├── app/               # Module principal Spring Boot (web, config)
│   ├── module-currentUser/       # Gestion utilisateurs (domaine, application, infra)
│   ├── module-contact/    # Gestion contacts (+ historique)
│   ├── module-event/      # Gestion événements
│   ├── module-admin/      # Fonctions admin, droits...
│   ├── module-sms/        # Adapter Twilio, business SMS
│   ├── module-historic/   # Historisation, audit log
│   ├── module-security/   # Authent/JWT
│   ├── shared/            # Valeur commune, utils, maybe base classes
│   ├── src/               # Optionnel, pour codes globaux (rare)
│   └── docker/
│       ├── Dockerfile
│       ├── application.yml
│       └── docker-compose.yml
│
├── frontend/
│   ├── angular.json
│   ├── src/
│   ├── Dockerfile
│   └── ...
│
├── .github/
│   └── workflows/
│       └── ci-cd.yml
│
├── README.md
└── .env.example
```

## 📦 **Architecture DDD/Hexagonale des modules**

### Exemple de structure pour `module-contact`

```
module-contact/
│
├── src/main/java/fr/ashs/contact/
│   ├── domain/
│   │    └── model/            // Contact, Historique
│   │    └── service/          // Règles métier
│   │    └── event/            // Event DDD ContactCreated, etc.
│   ├── application/
│   │    └── port/in/          // UseCases (commandes, queries)
│   │    └── port/out/         // Ports secondaires (repo, sms)
│   ├── infrastructure/
│   │    └── repository/       // Implémentation JPA
│   │    └── sms/              // TwilioAdapter
│   └── web/
│        └── ContactController // Expose API REST local au module
```

### Principes architecturaux par module

- **Domain** : Logique métier pure, indépendante des frameworks
- **Application** : Orchestration des cas d'usage, ports d'entrée et de sortie
- **Infrastructure** : Implémentations techniques (BDD, APIs externes, etc.)
- **Web** : Exposition des APIs REST

## 🔧 **Modules détaillés**

### Module User

- **Responsabilités** : Gestion des comptes utilisateurs, intégration Keycloak
- **Entités principales** : User, UserRole
- **Règles métier** : Authentification et autorisation via Keycloak, indépendant des contacts

### Module Contact

- **Responsabilités** : Gestion des contacts, validation, historique
- **Entités principales** : Contact, ContactHistory
- **Statuts** : SUBMITTED, PENDING, VALIDATED, NOT_REQUESTED, UNREACHABLE
- **Règles métier** :
    - Création par utilisateurs anonymes (statut SUBMITTED) ou inscrits (statut PENDING/UNREACHABLE)
    - Prévention des doublons (téléphone ou nom/prénom/email)
    - Historisation obligatoire de toute modification
    - Modification réservée aux utilisateurs inscrits

### Module Event

- **Responsabilités** : Gestion des événements et inscriptions
- **Entités principales** : Event, EventRegistration
- **Règles métier** : Seuls les utilisateurs authentifiés peuvent s'inscrire aux événements

### Module SMS

- **Responsabilités** : Envoi de SMS via Twilio
- **Entités principales** : SmsMessage, SmsStatus
- **Statuts** : SENT, FAILED, PENDING
- **Règles métier** : Gestion des échecs et tentatives de relance

### Module Historic

- **Responsabilités** : Audit trail et historisation
- **Entités principales** : AuditLog, ContactHistory
- **Règles métier** : Conservation permanente même en cas de suppression

### Module Security

- **Responsabilités** : Authentification, autorisation, JWT
- **Entités principales** : JwtToken, UserPrincipal
- **Règles métier** : Gestion des rôles et permissions

### Module Admin

- **Responsabilités** : Fonctions d'administration
- **Entités principales** : AdminAction, SystemConfiguration
- **Règles métier** : Droits étendus sur tous les modules

## 🔐 **Sécurité & Authentification**

### Intégration Keycloak

- **Authentification** : Déléguée entièrement à Keycloak
- **Tokens** : JWT émis par Keycloak avec durée configurable
- **Stockage** : HttpOnly cookies (best practices Angular)
- **Claims** : Rôles utilisateur embarqués dans le JWT Keycloak
- **Algorithme** : RS256 (clés publiques Keycloak)

### Gestion des utilisateurs

- **Création** : Via interface Keycloak ou API Keycloak
- **Mots de passe** : Gérés entièrement par Keycloak
- **Politique** : Configurée dans Keycloak
- **Réinitialisation** : Via workflows Keycloak

### Autorisation

- **Mécanisme** : `@PreAuthorize` avec validation des tokens Keycloak
- **Rôles** : USER, ADMIN (définis dans Keycloak)
- **Permissions granulaires** :
    - Utilisateurs standards : création et modification des contacts
    - Administrateurs : droits complets sur tous les contacts et événements

### Protection des données

- **Numéros de téléphone** : Affichage partiel côté frontend (anti-scrapping)
- **Données personnelles** : Conformité RGPD
- **Traçabilité** : Historisation obligatoire (qui/quand)

## 📊 **Modèle de données**

### Entités principales

#### Contact

```sql
CREATE TABLE contact (
    id UUID PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    genre VARCHAR(10) NOT NULL, -- MASCULIN, FEMININ
    date_naissance DATE,
    telephone VARCHAR(15), -- France uniquement
    email VARCHAR(255),
    roles TEXT[], -- Rôles cumulables dans l'équipe
    statut VARCHAR(20) NOT NULL, -- SUBMITTED, PENDING, VALIDATED, NOT_REQUESTED, UNREACHABLE
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by UUID, -- Nullable pour les créations anonymes
    updated_by UUID -- Nullable pour les créations anonymes
);
```

#### ContactHistory

```sql
CREATE TABLE contact_history (
    id UUID PRIMARY KEY,
    contact_id UUID NOT NULL,
    utilisateur_trigger_uuid UUID NOT NULL,
    date_time TIMESTAMP NOT NULL,
    champ_affecte VARCHAR(100),
    ancienne_valeur TEXT,
    nouvelle_valeur TEXT,
    type_action VARCHAR(20) NOT NULL -- CREATION, MODIFICATION, SUPPRESSION
);
```

#### User

```sql
CREATE TABLE currentUser (
    id UUID PRIMARY KEY,
    keycloak_user_id VARCHAR(255) UNIQUE NOT NULL, -- ID utilisateur Keycloak
    username VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    roles VARCHAR(50)[] NOT NULL,
    enabled BOOLEAN DEFAULT true,
    created_at TIMESTAMP NOT NULL,
    last_login TIMESTAMP
);
```

#### Event

```sql
CREATE TABLE event (
    id UUID PRIMARY KEY,
    nom VARCHAR(200) NOT NULL,
    description TEXT,
    date_debut TIMESTAMP NOT NULL,
    date_fin TIMESTAMP,
    lieu VARCHAR(255),
    max_participants INTEGER,
    created_at TIMESTAMP NOT NULL,
    created_by UUID NOT NULL
);
```

#### EventRegistration

```sql
CREATE TABLE event_registration (
    id UUID PRIMARY KEY,
    event_id UUID NOT NULL,
    user_id UUID NOT NULL,
    registered_at TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'CONFIRMED'
);
```

#### SmsMessage

```sql
CREATE TABLE sms_message (
    id UUID PRIMARY KEY,
    contact_id UUID NOT NULL,
    telephone VARCHAR(15) NOT NULL,
    message TEXT NOT NULL,
    status VARCHAR(20) NOT NULL, -- SENT, FAILED, PENDING
    twilio_sid VARCHAR(100),
    sent_at TIMESTAMP,
    error_message TEXT,
    retry_count INTEGER DEFAULT 0
);
```

## 📝 **Historique et Audit**

### Stratégie d'historisation

- **Déclencheurs** : Toute création, modification, suppression de contact
- **Informations conservées** :
    - Identité de l'utilisateur déclencheur
    - Horodatage précis
    - Champ affecté
    - Ancienne et nouvelle valeur
    - Type d'action

### Conservation des données

- **Principe** : Historique conservé même en cas de suppression
- **Usage** : Audit par les administrateurs
- **Accès** : Réservé aux administrateurs

### Logs applicatifs

- **Destination** : Loki/Grafana/Tempo
- **Transport** : Prometheus/Actuator avec Spring Boot
- **Niveaux** : INFO, WARN, ERROR avec contexte métier

## 📲 **Gestion SMS**

### Architecture SMS

- **Port** : Interface `SmsService` dans le domaine
- **Adapter** : `TwilioSmsAdapter` dans l'infrastructure
- **Règles métier** : Envoi uniquement pour contacts avec téléphone valide

### Statuts et gestion d'erreur

- **Statuts** : `SENT`, `FAILED`, `PENDING`
- **Gestion d'échec** : Log détaillé + possibilité de relance manuelle
- **Retry** : Mécanisme de tentative avec compteur
- **Monitoring** : Alertes sur taux d'échec élevé

### Processus d'invitation

1. **Création contact** → Vérification doublon
2. **Si utilisateur anonyme** → Statut "SUBMITTED" + attente approbation admin
3. **Si utilisateur authentifié avec téléphone valide** → Statut "PENDING" + génération lien personnalisé + envoi SMS
4. **Si utilisateur authentifié sans téléphone** → Statut "UNREACHABLE" + validation manuelle admin
5. **Approbation admin (contacts SUBMITTED)** → Passage vers "PENDING" (si téléphone valide) ou "UNREACHABLE" + envoi
   SMS si applicable
6. **Validation via SMS** → Confirmation des informations du contact
7. **Finalisation** → Changement statut vers "VALIDATED" après validation

## 🚀 **Déploiement et CI/CD**

### Stratégie de déploiement

- **Conteneurisation** : Docker pour backend et frontend
- **Orchestration** : Docker Compose
- **Environnements** : dev, staging, production

### Pipeline CI/CD

```yaml
# .github/workflows/ci-cd.yml
name: CI/CD Pipeline
on:
  push:
    branches: [main, develop]
  pull_request:
    branches: [main]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Setup Java
        uses: actions/setup-java@v3
        with:
          java-version: '17'
      - name: Run tests
        run: ./gradlew test
      
  build-and-deploy:
    needs: test
    runs-on: ubuntu-latest
    steps:
      - name: Build Docker images
        run: |
          docker build -t ashs-backend ./backend
          docker build -t ashs-frontend ./frontend
      - name: Deploy
        run: docker-compose up -d
```

### Gestion des secrets

- **GitHub Actions Secrets** → Variables d'environnement
- **Génération `.env`** à chaque build
- **Rotation** : Clés API et secrets régulièrement renouvelés

### Migration de base de données

- **Flyway** : Exécution automatique au démarrage de l'application
- **Versioning** : Scripts SQL numérotés et horodatés
- **Rollback** : Stratégie de retour en arrière définie

## 🔍 **Monitoring et Observabilité**

### Métriques applicatives

- **Spring Boot Actuator** : Endpoints de santé et métriques
- **Prometheus** : Collecte des métriques
- **Grafana** : Dashboards et alerting

### Logging centralisé

- **Loki** : Agrégation des logs
- **Tempo** : Tracing distribué
- **Alerting** : Notifications sur erreurs critiques

### Métriques métier

- **Taux de validation des contacts**
- **Succès/échec des envois SMS**
- **Inscriptions aux événements**
- **Activité des utilisateurs**

## 🧪 **Stratégie de tests**

### Tests unitaires

- **Couverture** : Minimum 80% sur la logique métier
- **Framework** : JUnit 5 + Mockito
- **Isolation** : Tests du domaine sans dépendances externes

### Tests d'intégration

- **Base de données** : TestContainers avec PostgreSQL
- **APIs externes** : Mocks pour Twilio
- **Scénarios complets** : Parcours utilisateur end-to-end

### Tests de sécurité

- **Authentification** : Vérification des tokens JWT
- **Autorisation** : Tests des permissions par rôle
- **Injection** : Protection contre les attaques courantes

## 📋 **Contraintes et règles métier**

### Règles fondamentales

1. **Indépendance des modules** : Contacts et utilisateurs sont complètement indépendants
2. **Prévention doublons** : Vérification par téléphone ou nom/prénom/email
3. **Authentification Keycloak** : Gestion centralisée des utilisateurs via Keycloak
4. **Traçabilité** : Historisation obligatoire de toute modification

### Contraintes techniques

- **Téléphones** : France uniquement (format +33)
- **SMS** : Uniquement pour contacts joignables
- **UUID** : Clés primaires pour toutes les entités
- **Sécurité** : Chiffrement des données sensibles

### Contraintes fonctionnelles

- **Droits utilisateurs** : Création et modification des contacts selon les permissions Keycloak
- **Droits administrateurs** : Accès complet à tous les contacts et fonctionnalités
- **Affichage public** : Numéros de téléphone partiellement masqués

*Document créé le 26/07/2025 - Version 1.0*