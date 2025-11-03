-- Modification de la colonne updated_at de DATE à TIMESTAMP
ALTER TABLE former_teammate_history_entity
    ALTER COLUMN updated_at TYPE TIMESTAMP USING updated_at::TIMESTAMP;

-- S'assurer que NOT NULL est maintenu (normalement déjà présent)
ALTER TABLE former_teammate_history_entity
    ALTER COLUMN updated_at SET NOT NULL;