ALTER TABLE former_teammate_entity
    ADD CONSTRAINT uc_formerteammateentity_code UNIQUE (code);

ALTER TABLE former_teammate_entity
    ALTER COLUMN code SET NOT NULL;