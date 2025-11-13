ALTER TABLE former_teammate_entity
    DROP COLUMN code;

ALTER TABLE former_teammate_entity
    ADD code VARCHAR(255) NOT NULL;

ALTER TABLE former_teammate_entity
    ADD CONSTRAINT uc_formerteammateentity_code UNIQUE (code);