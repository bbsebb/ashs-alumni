ALTER TABLE former_teammate_entity
    ADD kc_user_id VARCHAR(255);

ALTER TABLE former_teammate_entity
    ADD CONSTRAINT uc_formerteammateentity_kc_user UNIQUE (kc_user_id);