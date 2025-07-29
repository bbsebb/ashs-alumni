# Analyse Fonctionnelle Détaillée - Application ASHS Alumni

## Table des matières
1. [Introduction](#1-introduction)
2. [Architecture fonctionnelle](#2-architecture-fonctionnelle)
3. [Spécifications détaillées par module](#3-spécifications-détaillées-par-module)
4. [Modèles de données](#4-modèles-de-données)
5. [Règles métier](#5-règles-métier)
6. [Spécifications d'interface utilisateur](#6-spécifications-dinterface-utilisateur)
7. [Gestion des droits et sécurité](#7-gestion-des-droits-et-sécurité)
8. [Intégrations externes](#8-intégrations-externes)
9. [Workflows et processus](#9-workflows-et-processus)
10. [Critères d'acceptation](#10-critères-dacceptation)

---

## 1. Introduction

### 1.1 Contexte
Cette analyse fonctionnelle détaillée s'appuie sur l'analyse des besoins pour définir précisément les spécifications fonctionnelles de l'application web ASHS Alumni. Elle vise à permettre aux anciens et actuels membres des équipes 1 de l'ASHS de se retrouver et de s'inscrire à des soirées retrouvailles.

### 1.2 Objectifs de l'analyse
- Définir les spécifications fonctionnelles détaillées de chaque module
- Établir les règles métier précises
- Spécifier les modèles de données
- Définir les critères d'acceptation pour chaque fonctionnalité
- Préciser les workflows et processus métier

### 1.3 Périmètre fonctionnel
L'application couvre les domaines fonctionnels suivants :
- **Gestion des contacts** : CRUD complet avec historisation
- **Gestion des utilisateurs** : Authentification et autorisation
- **Processus d'invitation** : Workflow complet d'invitation et validation
- **Gestion des événements** : Création et gestion des soirées retrouvailles
- **Administration** : Outils de gestion pour les administrateurs

---

## 2. Architecture fonctionnelle

### 2.1 Vue d'ensemble architecturale

Le diagramme suivant présente l'architecture fonctionnelle globale du système sous forme de composants et leurs dépendances :

```plantuml
@startuml
!include ../diagrams/module-components.puml
@enduml
```

### 2.2 Modules principaux

#### Module Gestion des Contacts (MGC)
- **Responsabilité** : Gestion complète du cycle de vie des contacts
- **Sous-modules** :
  - Création et modification des contacts
  - Validation et statuts
  - Historisation des modifications
  - Prévention des doublons

#### Module Gestion des Utilisateurs (MGU)
- **Responsabilité** : Authentification, autorisation et profils utilisateurs
- **Sous-modules** :
  - Authentification
  - Gestion des profils
  - Association contact-utilisateur

#### Module Invitation et Validation (MIV)
- **Responsabilité** : Processus d'invitation et de validation des contacts
- **Sous-modules** :
  - Génération des invitations
  - Envoi de SMS
  - Validation des contacts
  - Inscription spontanée

#### Module Gestion des Événements (MGE)
- **Responsabilité** : Création et gestion des soirées retrouvailles
- **Sous-modules** :
  - Création d'événements
  - Inscriptions aux événements
  - Liste des participants

#### Module Administration (MAD)
- **Responsabilité** : Outils d'administration et de supervision
- **Sous-modules** :
  - Gestion des administrateurs
  - Supervision des contacts
  - Gestion des listes de référence
  - Historiques et audits

### 2.2 Interactions entre modules

```
MGU ←→ MGC : Association utilisateur-contact (1:1)
MIV → MGC : Création et validation des contacts
MGE ← MGU : Vérification des droits d'inscription
MAD → * : Supervision et administration de tous les modules
```

---

## 3. Spécifications détaillées par module

### 3.1 Module Gestion des Contacts (MGC)

#### 3.1.1 Fonctionnalité : Création d'un contact

**Description** : Permet à toute personne (authentifiée ou anonyme) de créer un nouveau contact dans le système. Le statut initial dépend du type d'utilisateur.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-creation-contact.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-creation-contact.puml
@enduml
```

**Acteurs** : Utilisateur anonyme, Utilisateur authentifié, Administrateur

**Pré-conditions** :
- Aucune pré-condition pour les utilisateurs anonymes
- Pour les utilisateurs authentifiés : avoir un contact validé associé

**Post-conditions** :
- **Utilisateur anonyme** : Contact créé avec le statut "Soumis", en attente d'approbation admin
- **Utilisateur authentifié** : Contact créé avec le statut "En attente" (si numéro valide) ou "Non joignable" (si pas de numéro valide)
- Un historique de création est enregistré
- Pour les utilisateurs authentifiés : Si le contact a un numéro de téléphone valide, un SMS d'invitation est envoyé automatiquement

**Scénario principal** :
1. L'utilisateur (anonyme ou authentifié) accède au formulaire de création de contact
2. L'utilisateur saisit les informations obligatoires :
   - Nom (obligatoire, 2-50 caractères)
   - Prénom (obligatoire, 2-50 caractères)
   - Genre (obligatoire : Masculin/Féminin)
   - Date de naissance (obligatoire, format DD/MM/YYYY)
   - Email (obligatoire, format valide)
   - Numéro de téléphone (optionnel, format français)
   - Rôles dans l'équipe 1 (au moins un rôle obligatoire)
3. Le système vérifie l'absence de doublons
4. Le système crée le contact avec le statut approprié selon le type d'utilisateur
5. Le système enregistre l'historique de création
6. **Si utilisateur authentifié** : Le système envoie une invitation SMS si numéro valide
7. **Si utilisateur anonyme** : Le contact reste en attente d'approbation admin

**Scénarios alternatifs** :
- **3a. Doublon détecté** :
  - Le système affiche un message d'erreur
  - Le système propose de consulter le contact existant
  - La création est annulée
- **6a. Numéro de téléphone invalide** :
  - Le contact est créé avec le statut "Non joignable"
  - Aucun SMS n'est envoyé

**Règles de validation** :
- Nom : 2-50 caractères, lettres et espaces uniquement
- Prénom : 2-50 caractères, lettres et espaces uniquement
- Email : format RFC 5322 valide
- Téléphone : format français (0X XX XX XX XX) ou international (+33 X XX XX XX XX)
- Date de naissance : âge minimum 16 ans, maximum 100 ans

#### 3.1.2 Fonctionnalité : Modification d'un contact

**Description** : Permet la modification des informations d'un contact selon les droits de l'utilisateur. Seuls les utilisateurs inscrits peuvent modifier les contacts.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-modification-contact.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-modification-contact.puml
@enduml
```

**Acteurs** : Utilisateur authentifié, Administrateur

**Pré-conditions** :
- L'utilisateur doit être authentifié et inscrit (avoir un contact validé associé)
- Pour un utilisateur standard : le contact doit être son contact associé OU être en statut "En attente" ou "Soumis"
- Pour un administrateur : aucune restriction sur tous les contacts

**Post-conditions** :
- Les informations du contact sont mises à jour
- Un historique de modification est enregistré
- Si le statut change, les actions appropriées sont déclenchées

**Scénario principal** :
1. L'utilisateur accède à la fiche du contact
2. L'utilisateur modifie les champs autorisés
3. Le système valide les modifications
4. Le système met à jour le contact
5. Le système enregistre l'historique de modification

**Règles métier spécifiques** :
- Un utilisateur standard ne peut pas modifier le statut d'un contact
- Seuls les administrateurs peuvent passer un contact de "Validé" à un autre statut
- La modification de l'email ou du téléphone déclenche une nouvelle vérification de doublons

#### 3.1.3 Fonctionnalité : Gestion des statuts

**Description** : Gestion du cycle de vie des statuts des contacts.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-gestion-statuts.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-gestion-statuts.puml
@enduml
```

**Statuts possibles** :
1. **Soumis** : Contact créé par un utilisateur anonyme, en attente d'approbation admin
2. **En attente** : Contact approuvé et en attente de validation
3. **Validé** : Contact confirmé avec compte utilisateur associé
4. **Non sollicité/Refusé** : Contact qui ne souhaite pas être contacté
5. **Non joignable** : Contact sans numéro de téléphone valide

**Transitions autorisées** :
- Soumis → En attente (approbation admin avec numéro valide + envoi SMS)
- Soumis → Non joignable (approbation admin sans numéro valide)
- Soumis → Non sollicité (rejet admin)
- En attente → Validé (via processus complet d'inscription SMS incluant création compte utilisateur, ou validation admin)
- En attente → Non sollicité (via lien de refus ou admin)
- En attente → Non joignable (automatique si pas de téléphone)
- Validé → Non sollicité (admin uniquement)
- Non joignable → Validé (admin uniquement)
- Non sollicité → Validé (admin uniquement)

### 3.2 Module Gestion des Utilisateurs (MGU)

#### 3.2.1 Fonctionnalité : Création de compte utilisateur

**Description** : Permet à une personne de créer un compte utilisateur. Ce processus est intégré dans la validation de contact via SMS (voir section 3.3.2) ou peut être effectué par un administrateur pour les contacts déjà validés.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-creation-compte-utilisateur.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-creation-compte-utilisateur.puml
@enduml
```

**Acteurs** : Visiteur avec contact en attente (via SMS), Administrateur

**Pré-conditions** :
- **Via SMS** : La personne doit avoir un contact avec le statut "En attente" et un token de validation valide
- **Via admin** : La personne doit avoir un contact avec le statut "Validé" et aucun compte utilisateur associé

**Post-conditions** :
- Un compte utilisateur est créé
- L'association contact-utilisateur est établie
- Le contact passe au statut "Validé" (si ce n'était pas déjà le cas)
- L'utilisateur peut se connecter à l'application

**Scénario principal (via SMS - processus intégré)** :
1. Voir section 3.3.2 "Validation de contact et inscription utilisateur"

**Scénario alternatif (création manuelle par admin)** :
1. L'administrateur accède à la fiche d'un contact validé sans compte utilisateur
2. L'administrateur initie la création du compte utilisateur
3. Le système génère des identifiants temporaires ou envoie un lien d'activation
4. La personne définit son mot de passe
5. Le système établit l'association contact-utilisateur

**Règles de sécurité** :
- Mot de passe : minimum 8 caractères, au moins une majuscule, une minuscule, un chiffre
- Session : expiration après 24h d'inactivité
- Tentatives de connexion : blocage après 5 échecs pendant 15 minutes

#### 3.2.2 Fonctionnalité : Authentification

**Description** : Processus de connexion des utilisateurs à l'application.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-authentification.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-authentification.puml
@enduml
```

**Méthodes d'authentification** :
- Email + mot de passe
- Lien de connexion temporaire (optionnel)

**Gestion des sessions** :
- Durée de session : 24 heures
- Renouvellement automatique si activité
- Déconnexion automatique après inactivité

### 3.3 Module Invitation et Validation (MIV)

#### 3.3.1 Fonctionnalité : Envoi d'invitation SMS

**Description** : Envoi automatique d'un SMS d'invitation lors de la création d'un contact avec numéro valide.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-envoi-invitation-sms.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-envoi-invitation-sms.puml
@enduml
```

**Déclencheurs** :
- Création d'un nouveau contact avec numéro de téléphone valide
- Aucun doublon détecté
- Contact en statut "En attente"

**Contenu du SMS** :
```
Bonjour [Prénom],
Vous êtes invité(e) à rejoindre la communauté ASHS Alumni.
Validez votre contact : [lien_personnalisé]
Pour refuser : [lien_refus]
```

**Caractéristiques techniques** :
- Lien personnalisé avec token unique (validité 30 jours)
- Lien de refus avec token unique
- Limitation : 1 SMS par numéro par période de 24h

#### 3.3.2 Fonctionnalité : Validation de contact et inscription utilisateur

**Description** : Processus de validation d'un contact via SMS (incluant l'inscription utilisateur) ou action administrative.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-validation-contact-inscription-utilisateur.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-validation-contact-inscription-utilisateur.puml
@enduml
```

**Méthodes de validation** :
1. **Via SMS** : Processus complet d'inscription via le lien dans le SMS
2. **Administrative** : Action d'un administrateur

**Processus de validation et inscription via SMS** :
1. La personne clique sur le lien de validation
2. Le système vérifie la validité du token
3. Le système affiche les informations du contact
4. La personne confirme ou corrige les informations
5. La personne saisit ses informations de connexion :
   - Mot de passe (8 caractères minimum, complexité requise)
   - Confirmation du mot de passe
6. Le système crée le compte utilisateur
7. Le système établit l'association contact-utilisateur
8. Le contact passe au statut "Validé"
9. L'utilisateur est automatiquement connecté

### 3.4 Module Gestion des Événements (MGE)

#### 3.4.1 Fonctionnalité : Création d'événement

**Description** : Permet aux administrateurs de créer des soirées retrouvailles.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-creation-evenement.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-creation-evenement.puml
@enduml
```

**Acteurs** : Administrateur

**Informations de l'événement** :
- Titre (obligatoire)
- Description
- Date et heure (obligatoire)
- Lieu (obligatoire)
- Nombre de places maximum (optionnel)
- Date limite d'inscription
- Statut (Brouillon/Ouvert/Fermé/Annulé)

#### 3.4.2 Fonctionnalité : Inscription à un événement

**Description** : Permet aux utilisateurs avec contact validé de s'inscrire à un événement.

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-inscription-evenement.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-inscription-evenement.puml
@enduml
```

**Acteurs** : Utilisateur authentifié avec contact validé

**Pré-conditions** :
- L'utilisateur doit être authentifié
- Le contact associé doit être validé
- L'événement doit être ouvert aux inscriptions
- Des places doivent être disponibles (si limitation)

**Processus d'inscription** :
1. L'utilisateur consulte la liste des événements
2. L'utilisateur sélectionne un événement
3. L'utilisateur confirme son inscription
4. Le système enregistre l'inscription
5. L'utilisateur reçoit une confirmation

### 3.5 Module Administration (MAD)

#### 3.5.1 Fonctionnalité : Gestion des listes de référence

**Description** : Permet aux administrateurs de gérer les listes "à ne pas contacter" et "anciens participants".

**Diagramme d'activité** :
```plantuml
@startuml
!include ../diagrams/functionality-gestion-listes-reference.puml
@enduml
```

**Diagramme d'interaction** :
```plantuml
@startuml
!include ../diagrams/interaction-gestion-listes-reference.puml
@enduml
```

**Types de listes** :
1. **Liste "à ne pas contacter"** :
   - Contacts qui ont explicitement refusé
   - Contacts marqués comme non sollicités
   - Invisibles pour les utilisateurs standards

2. **Liste "anciens participants"** :
   - Historique des participations aux éditions précédentes
   - Utilisée pour enrichir la base de contacts

**Fonctionnalités** :
- Import/export CSV
- Ajout/suppression manuel
- Recherche et filtrage
- Historique des modifications

---

## 4. Modèles de données

### 4.1 Vue d'ensemble du modèle de données

Le diagramme suivant présente l'ensemble des entités et leurs relations dans le système :

```plantuml
@startuml
!include ../diagrams/data-model-erd.puml
@enduml
```

### 4.2 Spécifications détaillées des entités

#### 4.2.1 Entité Contact

```
Contact {
  id: UUID (PK)
  nom: String(50) NOT NULL
  prenom: String(50) NOT NULL
  genre: Enum(MASCULIN, FEMININ) NOT NULL
  date_naissance: Date NOT NULL
  telephone: String(15) NULLABLE
  email: String(255) NOT NULL
  statut: Enum(SOUMIS, EN_ATTENTE, VALIDE, NON_SOLLICITE, NON_JOIGNABLE) NOT NULL
  date_creation: DateTime NOT NULL
  date_modification: DateTime NOT NULL
  cree_par: UUID (FK -> Utilisateur) NULLABLE
  modifie_par: UUID (FK -> Utilisateur) NULLABLE
}
```

### 4.2 Entité Utilisateur

```
Utilisateur {
  id: UUID (PK)
  contact_id: UUID (FK -> Contact) UNIQUE NOT NULL
  email: String(255) UNIQUE NOT NULL
  mot_de_passe_hash: String(255) NOT NULL
  est_administrateur: Boolean DEFAULT FALSE
  date_creation: DateTime NOT NULL
  derniere_connexion: DateTime NULLABLE
  statut: Enum(ACTIF, SUSPENDU, SUPPRIME) DEFAULT ACTIF
}
```

### 4.3 Entité Role

```
Role {
  id: UUID (PK)
  nom: String(50) NOT NULL
  description: String(255)
  actif: Boolean DEFAULT TRUE
}
```

### 4.4 Entité ContactRole (table de liaison)

```
ContactRole {
  contact_id: UUID (FK -> Contact)
  role_id: UUID (FK -> Role)
  date_debut: Date
  date_fin: Date NULLABLE
  PRIMARY KEY (contact_id, role_id)
}
```

### 4.5 Entité Evenement

```
Evenement {
  id: UUID (PK)
  titre: String(100) NOT NULL
  description: Text
  date_evenement: DateTime NOT NULL
  lieu: String(255) NOT NULL
  places_max: Integer NULLABLE
  date_limite_inscription: DateTime NULLABLE
  statut: Enum(BROUILLON, OUVERT, FERME, ANNULE) NOT NULL
  cree_par: UUID (FK -> Utilisateur) NOT NULL
  date_creation: DateTime NOT NULL
}
```

### 4.6 Entité Inscription

```
Inscription {
  id: UUID (PK)
  evenement_id: UUID (FK -> Evenement) NOT NULL
  utilisateur_id: UUID (FK -> Utilisateur) NOT NULL
  date_inscription: DateTime NOT NULL
  statut: Enum(INSCRIT, ANNULE) DEFAULT INSCRIT
  commentaire: String(500) NULLABLE
  UNIQUE (evenement_id, utilisateur_id)
}
```

### 4.7 Entité HistoriqueContact

```
HistoriqueContact {
  id: UUID (PK)
  contact_id: UUID (FK -> Contact) NOT NULL
  action: Enum(CREATION, MODIFICATION, CHANGEMENT_STATUT) NOT NULL
  champs_modifies: JSON
  valeurs_avant: JSON
  valeurs_apres: JSON
  utilisateur_id: UUID (FK -> Utilisateur) NOT NULL
  date_action: DateTime NOT NULL
  adresse_ip: String(45)
}
```

### 4.8 Entité TokenValidation

```
TokenValidation {
  id: UUID (PK)
  contact_id: UUID (FK -> Contact) NOT NULL
  token: String(255) UNIQUE NOT NULL
  type: Enum(VALIDATION, REFUS) NOT NULL
  date_creation: DateTime NOT NULL
  date_expiration: DateTime NOT NULL
  utilise: Boolean DEFAULT FALSE
  date_utilisation: DateTime NULLABLE
}
```

---

## 5. Règles métier

### 5.1 Règles de gestion des contacts

#### Diagramme d'états des contacts

Le diagramme suivant illustre les différents statuts possibles d'un contact et les transitions autorisées :

```plantuml
@startuml
!include ../diagrams/contact-status-states.puml
@enduml
```

#### RG-C001 : Unicité des contacts
- Un contact est unique par numéro de téléphone (si renseigné)
- Pour les contacts sans téléphone : unicité par combinaison nom/prénom/email
- La vérification s'effectue avant toute création ou modification

#### RG-C002 : Validation des données
- Nom et prénom : 2-50 caractères, lettres, espaces, apostrophes et tirets uniquement
- Email : format RFC 5322 valide et domaine existant
- Téléphone : format français uniquement (mobile ou fixe)
- Date de naissance : âge entre 16 et 100 ans

#### RG-C003 : Gestion des statuts
- Statut initial : "En attente" (sauf si pas de téléphone → "Non joignable")
- Seuls les administrateurs peuvent modifier le statut d'un contact validé
- Un contact "Non sollicité" est invisible pour les utilisateurs standards

#### RG-C004 : Historisation
- Toute création/modification doit être tracée
- L'historique inclut : qui, quand, quoi, valeurs avant/après
- Conservation permanente de l'historique

### 5.2 Règles de gestion des utilisateurs

#### RG-U001 : Association contact-utilisateur
- Relation 1:1 obligatoire entre utilisateur et contact validé
- Un contact validé ne peut être associé qu'à un seul utilisateur
- Un utilisateur ne peut être associé qu'à un seul contact

#### RG-U002 : Authentification
- Email unique dans le système
- Mot de passe : minimum 8 caractères, complexité requise
- Blocage temporaire après 5 tentatives échouées

#### RG-U003 : Droits d'accès
- Utilisateur standard : modification de son contact + contacts en attente
- Administrateur : tous droits sur tous les contacts et utilisateurs

### 5.3 Règles de gestion des invitations

#### RG-I001 : Envoi de SMS
- Un seul SMS par numéro de téléphone par période de 24h
- Envoi uniquement si numéro de téléphone français valide
- Pas d'envoi si doublon détecté

#### RG-I002 : Tokens de validation
- Durée de validité : 30 jours
- Token unique et non prédictible
- Un seul token actif par contact à la fois

#### RG-I003 : Processus de validation
- Validation possible uniquement avec token valide
- Possibilité de corriger les informations lors de la validation
- Passage automatique au statut "Validé" après validation

### 5.4 Règles de gestion des événements

#### RG-E001 : Inscription aux événements
- Seuls les utilisateurs avec contact validé peuvent s'inscrire
- Respect du nombre de places maximum (si défini)
- Respect de la date limite d'inscription

#### RG-E002 : Gestion des places
- Inscription dans l'ordre d'arrivée si limitation de places
- Possibilité de liste d'attente (fonctionnalité future)

---

## 6. Spécifications d'interface utilisateur

### 6.1 Maquettes d'interface

Le diagramme suivant présente les maquettes des principales interfaces utilisateur :

```plantuml
@startuml
!include ../diagrams/ui-wireframes.puml
@enduml
```

### 6.2 Principes généraux

#### Accessibilité
- Conformité RGAA (Référentiel Général d'Amélioration de l'Accessibilité)
- Support des lecteurs d'écran
- Navigation au clavier
- Contrastes suffisants

#### Responsive Design
- Adaptation mobile-first
- Breakpoints : 320px, 768px, 1024px, 1200px
- Interface tactile optimisée

#### Expérience utilisateur
- Interface intuitive et épurée
- Feedback immédiat sur les actions
- Messages d'erreur explicites
- Confirmation pour les actions critiques

### 6.2 Pages principales

#### 6.2.1 Page d'accueil (non connecté)
**Éléments** :
- Présentation de l'ASHS Alumni
- Lien vers inscription spontanée
- Lien vers connexion
- Liste publique des événements (sans détails sensibles)

#### 6.2.2 Page de connexion
**Éléments** :
- Formulaire email/mot de passe
- Lien "Mot de passe oublié"
- Lien vers inscription spontanée
- Messages d'erreur contextuels

#### 6.2.3 Tableau de bord utilisateur
**Éléments** :
- Informations du profil utilisateur
- Événements à venir
- Mes inscriptions
- Accès rapide aux fonctionnalités principales

#### 6.2.4 Gestion des contacts
**Éléments** :
- Liste des contacts avec filtres (statut, rôle, date)
- Formulaire de création/modification
- Historique des modifications
- Actions en lot (admin uniquement)

#### 6.2.5 Gestion des événements
**Éléments** :
- Liste des événements
- Détail d'un événement
- Formulaire d'inscription
- Liste des participants (avec masquage partiel des téléphones)

### 6.3 Composants d'interface

#### 6.3.1 Formulaires
- Validation en temps réel
- Messages d'erreur contextuels
- Indicateurs de champs obligatoires
- Sauvegarde automatique (brouillon)

#### 6.3.2 Listes et tableaux
- Pagination (25 éléments par page)
- Tri par colonnes
- Filtres avancés
- Export CSV (admin)

#### 6.3.3 Notifications
- Toast notifications pour les actions
- Alertes pour les erreurs
- Confirmations pour les suppressions

---

## 7. Gestion des droits et sécurité

### 7.1 Matrice des droits

Le diagramme suivant visualise la matrice des droits d'accès pour chaque type d'utilisateur :

```plantuml
@startuml
!include ../diagrams/security-access-matrix.puml
@enduml
```

#### Tableau détaillé des permissions

| Fonctionnalité | Visiteur/Anonyme | Utilisateur | Admin |
|----------------|------------------|-------------|-------|
| Consulter événements publics | ✓ | ✓ | ✓ |
| Créer un contact (statut SOUMIS) | ✓ | - | - |
| S'inscrire spontanément | ✓ | - | - |
| Se connecter | - | ✓ | ✓ |
| Consulter son profil | - | ✓ | ✓ |
| Modifier son contact | - | ✓ | ✓ |
| Créer un contact (statut EN_ATTENTE/NON_JOIGNABLE) | - | ✓ | ✓ |
| Modifier contact en attente/soumis | - | ✓ | ✓ |
| Modifier tout contact | - | - | ✓ |
| Approuver contacts soumis | - | - | ✓ |
| Gérer les statuts | - | - | ✓ |
| Créer des événements | - | - | ✓ |
| Gérer les inscriptions | - | - | ✓ |
| Accéder aux historiques | - | - | ✓ |
| Gérer les utilisateurs | - | - | ✓ |

### 7.2 Sécurité des données

#### Protection des données personnelles
- Chiffrement des mots de passe (bcrypt, coût 12)
- Masquage partiel des numéros de téléphone côté frontend
- Logs d'accès et de modification
- Anonymisation possible des données (RGPD)

#### Sécurité applicative
- Protection CSRF
- Validation et échappement des entrées
- Limitation du taux de requêtes (rate limiting)
- Headers de sécurité (HSTS, CSP, etc.)

#### Audit et traçabilité
- Logs d'authentification
- Historique des modifications de données
- Monitoring des actions sensibles
- Alertes sur les comportements suspects

---

## 8. Intégrations externes

### 8.1 Service SMS

#### Fournisseur recommandé
- OVH SMS API ou équivalent français
- Conformité RGPD
- Tarification compétitive

#### Spécifications techniques
- API REST
- Authentification par clé API
- Gestion des erreurs et retry
- Limitation : 1000 SMS/mois (estimation)

#### Contenu des SMS
- Messages courts (< 160 caractères)
- Liens raccourcis sécurisés
- Personnalisation avec prénom
- Opt-out automatique

### 8.2 Service Email (optionnel)

#### Utilisation
- Notifications administratives
- Confirmations d'inscription
- Rappels d'événements

#### Spécifications
- SMTP sécurisé (TLS)
- Templates HTML/texte
- Gestion des bounces
- Respect des règles anti-spam

---

## 9. Workflows et processus

### 9.1 Parcours utilisateur détaillés

Le diagramme suivant présente les parcours utilisateur complets pour les principales fonctionnalités :

```plantuml
@startuml
!include ../diagrams/user-journey-flows.puml
@enduml
```

### 9.2 Processus d'invitation et validation

```mermaid
graph TD
    A[Utilisateur crée un contact] --> B{Numéro de téléphone valide?}
    B -->|Oui| C[Vérification doublon par téléphone]
    B -->|Non| D[Vérification doublon par nom/prénom/email]
    C --> E{Doublon détecté?}
    D --> E
    E -->|Oui| F[Erreur - Contact existant]
    E -->|Non| G[Création du contact]
    G --> H{Numéro valide?}
    H -->|Oui| I[Statut: En attente]
    H -->|Non| J[Statut: Non joignable]
    I --> K[Envoi SMS d'invitation]
    J --> L[Validation manuelle requise]
    K --> M[Contact reçoit SMS]
    M --> N{Action du contact}
    N -->|Validation| O[Processus d'inscription utilisateur]
    N -->|Refus| P[Statut: Non sollicité]
    N -->|Pas de réponse| Q[Relance possible par admin]
    O --> R[Création compte utilisateur]
    R --> S[Association contact-utilisateur]
    S --> T[Statut: Validé]
```

### 9.2 Processus d'inscription à un événement

```mermaid
graph TD
    A[Utilisateur consulte les événements] --> B[Sélection d'un événement]
    B --> C{Utilisateur connecté?}
    C -->|Non| D[Redirection vers connexion]
    C -->|Oui| E{Contact validé?}
    E -->|Non| F[Message d'erreur - Contact non validé]
    E -->|Oui| G{Événement ouvert?}
    G -->|Non| H[Message - Inscriptions fermées]
    G -->|Oui| I{Places disponibles?}
    I -->|Non| J[Message - Complet]
    I -->|Oui| K[Formulaire d'inscription]
    K --> L[Confirmation d'inscription]
    L --> M[Inscription enregistrée]
    M --> N[Notification de confirmation]
```

### 9.3 Processus d'administration

```mermaid
graph TD
    A[Admin se connecte] --> B[Tableau de bord admin]
    B --> C{Action souhaitée}
    C -->|Gestion contacts| D[Liste des contacts avec filtres]
    C -->|Gestion événements| E[Liste des événements]
    C -->|Historiques| F[Consultation des logs]
    C -->|Listes de référence| G[Import/Export des listes]
    D --> H[Actions sur les contacts]
    E --> I[Création/modification d'événements]
    F --> J[Analyse des activités]
    G --> K[Mise à jour des listes]
```

---

## 10. Critères d'acceptation

### 10.1 Critères généraux

#### Performance
- Temps de réponse < 2 secondes pour les pages standards
- Temps de réponse < 5 secondes pour les exports
- Support de 100 utilisateurs simultanés minimum

#### Disponibilité
- Disponibilité 99% minimum
- Sauvegarde quotidienne des données
- Plan de reprise d'activité documenté

#### Compatibilité
- Navigateurs : Chrome, Firefox, Safari, Edge (2 dernières versions)
- Mobiles : iOS 12+, Android 8+
- Responsive design sur toutes les tailles d'écran

### 10.2 Critères par fonctionnalité

#### Gestion des contacts
- ✅ Création d'un contact avec toutes les informations obligatoires
- ✅ Validation des formats (email, téléphone, dates)
- ✅ Détection des doublons avant création
- ✅ Historisation de toutes les modifications
- ✅ Gestion des statuts selon les règles métier

#### Processus d'invitation
- ✅ Envoi automatique de SMS pour les contacts avec numéro valide
- ✅ Génération de liens personnalisés sécurisés
- ✅ Processus complet d'inscription via SMS (validation contact + création compte utilisateur)
- ✅ Gestion des refus et des non-réponses

#### Gestion des utilisateurs
- ✅ Création de compte intégrée dans le processus de validation des contacts
- ✅ Association 1:1 contact-utilisateur respectée
- ✅ Authentification sécurisée avec gestion des sessions
- ✅ Gestion des droits selon le profil utilisateur

#### Gestion des événements
- ✅ Création d'événements par les administrateurs
- ✅ Inscription limitée aux utilisateurs avec contact validé
- ✅ Respect des limites de places et dates
- ✅ Affichage public avec masquage des données sensibles

#### Administration
- ✅ Accès complet aux données pour les administrateurs
- ✅ Gestion des listes de référence
- ✅ Consultation des historiques et audits
- ✅ Outils d'import/export des données

### 10.3 Critères de sécurité

#### Protection des données
- ✅ Chiffrement des mots de passe
- ✅ Masquage partiel des numéros de téléphone
- ✅ Traçabilité complète des actions
- ✅ Conformité RGPD

#### Sécurité applicative
- ✅ Protection contre les attaques courantes (XSS, CSRF, injection SQL)
- ✅ Validation et échappement des entrées utilisateur
- ✅ Gestion sécurisée des sessions
- ✅ Limitation du taux de requêtes

---

## Conclusion

Cette analyse fonctionnelle détaillée fournit les spécifications complètes pour le développement de l'application ASHS Alumni. Elle couvre tous les aspects fonctionnels, techniques et sécuritaires nécessaires à la réalisation du projet.

Les prochaines étapes recommandées sont :
1. Validation de cette analyse par les parties prenantes
2. Conception technique détaillée
3. Planification du développement par itérations
4. Mise en place de l'environnement de développement

---

**Document créé le** : 26/07/2025  
**Version** : 1.0  
**Statut** : En révision