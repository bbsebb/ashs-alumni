CREATE TABLE sms_history
(
    id                  UUID         NOT NULL,
    former_teammate_id  UUID         NOT NULL,
    phone_number        VARCHAR(255) NOT NULL,
    message             TEXT         NOT NULL,
    status              SMALLINT     NOT NULL,
    sent_at             TIMESTAMP    NOT NULL,
    updated_at          TIMESTAMP,
    external_id         VARCHAR(255),
    error_message       TEXT,
    CONSTRAINT pk_sms_history PRIMARY KEY (id)
);

ALTER TABLE sms_history
    ADD CONSTRAINT fk_sms_history_former_teammate
        FOREIGN KEY (former_teammate_id)
            REFERENCES former_teammate_entity (id);

CREATE INDEX idx_sms_history_former_teammate_id ON sms_history (former_teammate_id);
CREATE INDEX idx_sms_history_sent_at ON sms_history (sent_at);
