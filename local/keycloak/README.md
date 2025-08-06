# Keycloak Local Development Setup

Ce dossier contient la configuration Docker Compose pour exécuter Keycloak en local pour le développement.

## Prérequis

- Docker
- Docker Compose

## Services inclus

- **Keycloak** : Serveur d'authentification et d'autorisation
- **PostgreSQL** : Base de données pour Keycloak

## Démarrage rapide

1. Naviguez vers ce dossier :
   ```bash
   cd local/keycloak
   ```

2. Démarrez les services :
   ```bash
   docker-compose up -d
   ```

3. Attendez que les services soient prêts (environ 1-2 minutes)

4. Accédez à Keycloak :
   - URL : http://localhost:8080
   - Nom d'utilisateur admin : `admin`
   - Mot de passe admin : `admin`

## Configuration par défaut

### Keycloak
- Port HTTP : 8080
- Port HTTPS : 8443
- Admin : admin/admin
- Mode développement activé

### PostgreSQL
- Port : 5432
- Base de données : keycloak
- Utilisateur : keycloak
- Mot de passe : keycloak

## Commandes utiles

### Démarrer les services
```bash
docker-compose up -d
```

### Arrêter les services
```bash
docker-compose down
```

### Voir les logs
```bash
docker-compose logs -f keycloak
```

### Redémarrer Keycloak uniquement
```bash
docker-compose restart keycloak
```

### Supprimer les volumes (reset complet)
```bash
docker-compose down -v
```

## Personnalisation

Vous pouvez modifier les variables d'environnement dans le fichier `.env` pour personnaliser la configuration selon vos besoins.

## Accès aux services

- **Console d'administration Keycloak** : http://localhost:8080/admin
- **Base de données PostgreSQL** : localhost:5432

## Notes importantes

- Ce setup est configuré pour le développement uniquement
- Les mots de passe par défaut ne doivent jamais être utilisés en production
- Les données sont persistées dans des volumes Docker nommés