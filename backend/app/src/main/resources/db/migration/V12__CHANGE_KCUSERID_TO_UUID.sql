ALTER TABLE former_teammate_entity
    DROP COLUMN kc_user_id;

ALTER TABLE former_teammate_entity
    ADD kc_user_id UUID;

ALTER TABLE former_teammate_entity
    ADD CONSTRAINT uc_formerteammateentity_kc_user UNIQUE (kc_user_id);