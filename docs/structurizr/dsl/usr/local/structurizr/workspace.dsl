workspace "ASHS Alumni - Analyse des besoins" "Diagrammes de haut niveau pour l'application de retrouvailles ASHS" {

    model {
        # Acteurs externes
        ancienJoueur = person "Ancien/Actuel Joueur" "Membre des équipes 1 de l'ASHS souhaitant participer aux retrouvailles"
        ancienCoach = person "Ancien/Actuel Coach" "Entraîneur des équipes 1 de l'ASHS"
        ancienPresident = person "Ancien/Actuel Président" "Dirigeant de l'ASHS"
        contributeur = person "Contributeur Actif" "Personne ayant contribué aux équipes 1 (table de marque, chauffeur, etc.)"
        inviteExterieur = person "Invité/Inscrit Spontané" "Personne invitée ou s'inscrivant spontanément"
        administrateur = person "Administrateur" "Gestionnaire de l'application avec droits étendus"
        
        # Système externe
        serviceSMS = softwareSystem "Service SMS" "Service externe d'envoi de SMS pour les invitations" "External"
        
        # Système principal
        ashsAlumni = softwareSystem "ASHS Alumni" "Application web de gestion des retrouvailles des anciens membres" {
            
            # Espaces fonctionnels conceptuels (pas techniques)
            gestionContacts = container "Gestion des Contacts" "Espace de gestion des informations personnelles et statuts des contacts" "Fonctionnel"
            gestionUtilisateurs = container "Gestion des Utilisateurs" "Espace de gestion des comptes d'accès et authentification" "Fonctionnel"
            gestionEvenements = container "Gestion des Événements" "Espace de gestion des soirées retrouvailles et inscriptions" "Fonctionnel"
            administration = container "Administration" "Espace de gestion administrative et supervision" "Fonctionnel"
            historisation = container "Historisation" "Espace de traçabilité et conservation des historiques" "Fonctionnel"
        }
        
        # Relations acteurs -> système
        ancienJoueur -> ashsAlumni "Consulte les contacts, s'inscrit aux événements"
        ancienCoach -> ashsAlumni "Consulte les contacts, s'inscrit aux événements"
        ancienPresident -> ashsAlumni "Consulte les contacts, s'inscrit aux événements"
        contributeur -> ashsAlumni "Consulte les contacts, s'inscrit aux événements"
        inviteExterieur -> ashsAlumni "Valide son contact, s'inscrit aux événements"
        administrateur -> ashsAlumni "Gère tous les aspects du système"
        
        # Relations acteurs -> containers (nécessaires pour les vues dynamiques)
        ancienJoueur -> gestionContacts "Ajoute et consulte les contacts"
        ancienJoueur -> gestionEvenements "Consulte et s'inscrit aux événements"
        inviteExterieur -> gestionContacts "Valide son contact"
        administrateur -> gestionEvenements "Définit les dates de soirée"
        administrateur -> gestionContacts "Gère les contacts"
        
        # Relations système -> système externe
        ashsAlumni -> serviceSMS "Envoie des invitations par SMS"
        
        # Relations internes (conceptuelles)
        gestionUtilisateurs -> gestionContacts "Un utilisateur doit être associé à un contact validé"
        gestionContacts -> gestionEvenements "Seuls les contacts validés peuvent s'inscrire"
        gestionEvenements -> gestionUtilisateurs "Vérifie que l'utilisateur est associé à un contact validé"
        administration -> gestionContacts "Gestion complète des contacts"
        administration -> gestionEvenements "Gestion des dates et inscriptions"
        administration -> gestionUtilisateurs "Gestion des droits d'accès"
        historisation -> gestionContacts "Trace toutes les modifications"
        historisation -> gestionEvenements "Enregistre les inscriptions et événements"
        gestionContacts -> serviceSMS "Déclenche l'envoi d'invitations"
        gestionContacts -> gestionContacts "Processus interne de vérification"
    }

    views {
        # Diagramme de contexte système
        systemContext ashsAlumni "SystemContext" {
            include *
            autoLayout
            title "Diagramme de contexte - ASHS Alumni"
            description "Vue d'ensemble des acteurs et interactions avec le système de retrouvailles"
        }
        
        # Diagramme des espaces fonctionnels
        container ashsAlumni "Containers" {
            include *
            autoLayout
            title "Espaces fonctionnels - ASHS Alumni"
            description "Organisation conceptuelle des grandes fonctions du système"
        }
        
        # Diagramme de flux - Processus d'invitation
        dynamic ashsAlumni "ProcessusInvitation" "Processus d'ajout et validation d'un contact" {
            ancienJoueur -> gestionContacts "1. Ajoute un nouveau contact"
            gestionContacts -> gestionContacts "2. Vérifie les doublons"
            gestionContacts -> serviceSMS "3. Envoie SMS d'invitation (si téléphone valide)"
            inviteExterieur -> gestionContacts "4. Valide son contact via lien SMS"
            gestionContacts -> gestionUtilisateurs "5. Création du compte utilisateur"
            historisation -> gestionContacts "6. Enregistre l'historique"
            autoLayout
            title "Processus d'invitation et validation"
        }
        
        # Diagramme de flux - Inscription à un événement
        dynamic ashsAlumni "ProcessusInscription" "Processus d'inscription à une soirée retrouvaille" {
            administrateur -> gestionEvenements "1. Définit les dates de soirée"
            ancienJoueur -> gestionEvenements "2. Consulte les événements disponibles"
            gestionEvenements -> gestionUtilisateurs "3. Vérifie que l'utilisateur est associé à un contact validé"
            ancienJoueur -> gestionEvenements "4. S'inscrit à la soirée"
            historisation -> gestionEvenements "5. Enregistre l'inscription"
            autoLayout
            title "Processus d'inscription à un événement"
        }
        
        styles {
            element "Person" {
                color #ffffff
                fontSize 22
                shape Person
            }
            element "External" {
                background #999999
                color #ffffff
            }
            element "Fonctionnel" {
                background #1168bd
                color #ffffff
            }
            relationship "Relationship" {
                dashed false
            }
        }
        
        themes default
    }
}