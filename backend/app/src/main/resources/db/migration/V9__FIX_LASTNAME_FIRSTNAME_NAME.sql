-- Ajout des nouvelles colonnes
ALTER TABLE participant
    ADD firstname VARCHAR(255);

ALTER TABLE participant
    ADD lastname VARCHAR(255);

-- Rendre les nouvelles colonnes non null
ALTER TABLE participant
    ALTER COLUMN firstname SET NOT NULL;

ALTER TABLE participant
    ALTER COLUMN lastname SET NOT NULL;

-- Supprimer l’ancienne contrainte unique si elle existe
ALTER TABLE participant
    DROP CONSTRAINT IF EXISTS uk_participant_first_last_name;

-- Supprimer les anciennes colonnes
ALTER TABLE participant
    DROP COLUMN first_name;

ALTER TABLE participant
    DROP COLUMN last_name;

-- Recréer la contrainte unique sur les nouvelles colonnes
ALTER TABLE participant
    ADD CONSTRAINT uk_participant_first_last_name UNIQUE (firstname, lastname);