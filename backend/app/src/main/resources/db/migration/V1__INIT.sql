CREATE TABLE former_teammate_entity
(
    id         UUID         NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    gender     SMALLINT,
    phone      VARCHAR(255),
    email      VARCHAR(255),
    birth_date date,
    status     SMALLINT,
    CONSTRAINT pk_formerteammateentity PRIMARY KEY (id)
);

CREATE TABLE former_teammate_entity_roles
(
    former_teammate_entity_id UUID NOT NULL,
    roles                     SMALLINT
);

ALTER TABLE former_teammate_entity_roles
    ADD CONSTRAINT fk_formerteammateentity_roles_on_former_teammate_entity FOREIGN KEY (former_teammate_entity_id) REFERENCES former_teammate_entity (id);