CREATE SEQUENCE IF NOT EXISTS participant_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE participant
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    comments   VARCHAR(255),
    kc_id      UUID         NOT NULL,
    CONSTRAINT pk_participant PRIMARY KEY (id)
);

ALTER TABLE participant
    ADD CONSTRAINT uc_participant_kcid UNIQUE (kc_id);

ALTER TABLE participant
    ADD CONSTRAINT uk_participant_first_last_name UNIQUE (first_name, last_name);