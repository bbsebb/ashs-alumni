CREATE TABLE former_teammate_history_entity
(
    id                   UUID         NOT NULL,
    former_teammate_id   UUID         NOT NULL,
    phone_at_time        VARCHAR(255),
    email_at_time        VARCHAR(255),
    birth_date_at_time   DATE,
    status_at_time       SMALLINT     NOT NULL,
    updated_at           DATE         NOT NULL,
    history_action       SMALLINT     NOT NULL,
    updated_by           VARCHAR(255) NOT NULL,
    description          TEXT         NOT NULL,
    CONSTRAINT pk_former_teammate_history_entity PRIMARY KEY (id)
);

-- Table pour les rôles historiques (ElementCollection)
CREATE TABLE former_teammate_history_entity_roles_at_time
(
    former_teammate_history_entity_id UUID NOT NULL,
    roles_at_time                     SMALLINT
);

-- Contraintes de clé étrangère
ALTER TABLE former_teammate_history_entity
    ADD CONSTRAINT fk_former_teammate_history_former_teammate
        FOREIGN KEY (former_teammate_id)
            REFERENCES former_teammate_entity (id);

ALTER TABLE former_teammate_history_entity_roles_at_time
    ADD CONSTRAINT fk_former_teammate_history_roles_on_history_entity
        FOREIGN KEY (former_teammate_history_entity_id)
            REFERENCES former_teammate_history_entity (id);

-- Index pour les performances
CREATE INDEX idx_former_teammate_history_former_teammate_id
    ON former_teammate_history_entity (former_teammate_id);

CREATE INDEX idx_former_teammate_history_updated_at
    ON former_teammate_history_entity (updated_at);

CREATE INDEX idx_former_teammate_history_action
    ON former_teammate_history_entity (history_action);
