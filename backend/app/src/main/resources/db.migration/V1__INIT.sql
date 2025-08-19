CREATE TABLE former_teammate_entity
(
    id         UUID         NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    gender     SMALLINT,
    phone      VARCHAR(255),
    birth_date date,
    roles      SMALLINT,
    status     SMALLINT,
    CONSTRAINT pk_formerteammateentity PRIMARY KEY (id)
);