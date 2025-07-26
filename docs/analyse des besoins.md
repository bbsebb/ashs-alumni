# Analyse des besoins fonctionnels

## 1.1 Objectif du projet

Créer une application web pour permettre aux anciens et actuels membres des équipes 1 de l'ASHS (joueurs, coachs, présidents, autres contributeurs) de se retrouver, de s'inscrire à une soirée retrouvaille, d'inviter de nouveaux contacts et de garantir une gestion sécurisée et transparente par plusieurs administrateurs.

## 1.2 Acteurs

Le diagramme suivant présente une vue d'ensemble des acteurs du système et de leurs interactions :

```plantuml
@startuml
!include structurizr/images/structurizr-SystemContext.puml
@enduml
```

### Types d'acteurs
- **Anciens & actuels joueurs** des équipes 1
- **Anciens & actuels coachs**
- **Anciens & actuels présidents**
- **Contributeurs actifs** (table de marque, chauffeur, etc.)
- **Inscrits spontanés ou invités**
- **Administrateurs** (plusieurs possibles)

### Distinction entre utilisateurs et contacts
**Important :** Les utilisateurs et les contacts sont deux entités distinctes mais peuvent être liées par une relation 1-1 :

- **Contact** : Représente une personne physique avec ses informations personnelles (nom, prénom, téléphone, email, etc.). Un contact peut avoir différents statuts (en attente, validé, non sollicité/refusé, non joignable).

- **Utilisateur** : Représente un compte d'accès à l'application permettant de se connecter et d'utiliser les fonctionnalités. Un utilisateur inscrit doit obligatoirement être associé à un contact validé.

**Règle fondamentale :** Tout utilisateur inscrit sur la plateforme doit avoir un contact validé associé. Cette association est obligatoire et permet de garantir que chaque utilisateur correspond à une personne réelle identifiée dans la base de contacts.

## 1.3 Cas d'utilisation (fonctionnalités)

Le diagramme suivant illustre l'architecture fonctionnelle du système et les interactions entre les différents espaces :

```plantuml
@startuml
!include structurizr/images/structurizr-Containers.puml
@enduml
```

#### 1. Gestion des contacts
- **Données enregistrées pour chaque contact :**
    - Nom, prénom
    - Genre (masculin ou féminin)
    - Date de naissance
    - Numéro de téléphone (France uniquement, affiché partiellement côté frontend, optionnel - les contacts sans numéro valide reçoivent le statut "non joignable")
    - Email
    - Rôles occupés dans l'équipe 1 (liste de rôles possibles, cumulables)

- Un utilisateur inscrit ne peut modifier que les données de son contact associé, mais peut également modifier les contacts en attente (non validés).
- **Historique intégré** : chaque ajout ou modification de contact doit enregistrer l'identité de la personne ayant procédé à l'action, horodatée.

#### 2. Ajout, invitation et validation des contacts

Le diagramme suivant illustre le processus d'invitation et de validation des contacts :

```plantuml
@startuml
!include structurizr/images/structurizr-ProcessusInvitation.puml
@enduml
```

- Tout utilisateur inscrit peut ajouter de nouveaux contacts qui seront "en attente".
- **Prévention des doublons :**
    - Avant l'ajout d'un nouveau contact, le système doit vérifier l'existence d'un contact avec le même numéro de téléphone (si disponible).
    - Si un contact existe déjà (quel que soit son statut : en attente, validé, non sollicité, ou non joignable), l'ajout est bloqué et l'utilisateur en est informé.
    - Cette vérification évite l'envoi de SMS multiples à la même personne.
    - **Cas particulier :** Pour les contacts sans numéro de téléphone valide, la vérification de doublon se base sur la combinaison nom/prénom/email.

- **Invitation par SMS (pour les contacts joignables) :**
    - Envoi automatique d'un SMS avec un lien personnalisé, menant directement au processus d'inscription.
    - **Important :** Le processus via SMS inclut la validation du contact ET la création du compte utilisateur. Le contact ne devient "validé" qu'après la création réussie du compte utilisateur et son association au contact. L'inscription à la soirée est une étape séparée qui ne peut être effectuée qu'après ce processus complet.
    - L'envoi de SMS n'a lieu que si aucun doublon n'est détecté lors de la création du contact et si le contact possède un numéro de téléphone valide.
    - **Contacts non joignables :** Les contacts sans numéro de téléphone valide reçoivent automatiquement le statut "non joignable" et nécessitent une validation manuelle par un administrateur.

- Toute personne peut également s'inscrire spontanément (sans parrainage).
    - **Contrôle des doublons lors de l'inscription spontanée :** Le système vérifie également l'existence d'un contact avec le même numéro de téléphone lors de l'inscription spontanée (si disponible), ou par combinaison nom/prénom/email pour les contacts sans téléphone valide.
- Les utilisateurs inscrits peuvent modifier l'information de tout contact en attente (non validé).

#### 3. Statut des contacts
- Statuts possibles pour chaque contact :
    - **En attente** (ajouté mais pas encore validé)
    - **Validé** (contact confirmé avec compte utilisateur associé)
    - **Non sollicité/refusé** : liste administrateur, non contactés, invisibles pour les autres.
    - **Non joignable** : contact qui n'a pas de numéro de téléphone ou pas de numéro de téléphone valide, ne peut pas recevoir de SMS de validation.

- Seuls les utilisateurs associés à des contacts validés peuvent voir l'ensemble des fonctionnalités et s'inscrire à la soirée.

#### 4. Inscription à la soirée retrouvaille

Le diagramme suivant illustre le processus d'inscription à un événement :

```plantuml
@startuml
!include structurizr/images/structurizr-ProcessusInscription.puml
@enduml
```

- Dates fixées par un ou plusieurs administrateurs.
- Les utilisateurs associés à des contacts validés peuvent s'inscrire à la soirée via la plateforme.
- La liste des inscrits est ouverte à tous (même non connectés), mais les numéros de téléphone sont partiellement masqués pour éviter le scrapping.
- Les administrateurs doivent pouvoir retirer ou supprimer tout inscrit.

#### 5. Administration
- Plusieurs administrateurs sont possibles.
- Fonctions :
    - Gestion des dates de soirée
    - Accès et modifications complètes sur tous les contacts et inscrits
    - Chargement et gestion de deux pré-listes :
        - Liste "à ne pas contacter" (refus explicite, jamais contactés/invisibles)
        - Liste des participants à d'anciennes éditions (pour enrichir la base initiale)

    - Accès à l'historique des ajouts/modifications de chaque contact.
    - Relances et rappels par SMS envoyés manuellement (uniquement pour les contacts avec numéro de téléphone valide).

- **Conservation d'un historique** de participation pour chaque membre (ex : édition(s) précédente(s)).

## 1.4 Contraintes fonctionnelles

### Contraintes de sécurité et confidentialité
- **Protection des données personnelles** : Numéros de téléphone partiellement visibles côté frontend pour éviter le scrapping
- **Traçabilité** : Historisation obligatoire de toute création et modification d'un contact (qui/quand)
- **Contrôle d'accès** : Seuls les utilisateurs associés à des contacts validés peuvent accéder à l'ensemble des fonctionnalités

### Contraintes de gestion des droits
- **Utilisateurs standards** :
  - Ne peuvent modifier que les données de leur propre contact associé (une fois validé)
  - Peuvent modifier tout contact en attente (non validé)
- **Administrateurs** : Droit global de modification et de suppression sur tous les contacts et inscrits

### Contraintes métier
- **Règle fondamentale** : Tout utilisateur inscrit sur la plateforme doit avoir un contact validé associé
- **Prévention des doublons** : Vérification obligatoire avant ajout d'un nouveau contact (par téléphone ou combinaison nom/prénom/email)
- **Validation des contacts** : 
  - Contacts avec téléphone valide : processus complet d'inscription via SMS (validation + création compte utilisateur)
  - Contacts sans téléphone valide : statut "non joignable" et validation manuelle par administrateur
- **Séparation des processus** : La validation du contact et l'inscription à la soirée sont deux étapes distinctes

### Contraintes techniques
- **Numéros de téléphone** : France uniquement
- **SMS** : Envoi uniquement pour les contacts avec numéro de téléphone valide
- **Historique** : Conservation obligatoire de l'historique de participation pour chaque membre

