CREATE TABLE phone
(
    phone_number    VARCHAR(255) NOT NULL,
    is_black_listed BOOLEAN      NOT NULL,
    CONSTRAINT pk_phone PRIMARY KEY (phone_number)
);

ALTER TABLE former_teammate_entity
    ADD phone_phone_number VARCHAR(255);

ALTER TABLE sms_history
    ADD phone_phone_number VARCHAR(255);

ALTER TABLE former_teammate_entity
    ADD CONSTRAINT FK_FORMERTEAMMATEENTITY_ON_PHONE_PHONENUMBER FOREIGN KEY (phone_phone_number) REFERENCES phone (phone_number);

ALTER TABLE sms_history
    ADD CONSTRAINT FK_SMS_HISTORY_ON_PHONE_PHONENUMBER FOREIGN KEY (phone_phone_number) REFERENCES phone (phone_number);