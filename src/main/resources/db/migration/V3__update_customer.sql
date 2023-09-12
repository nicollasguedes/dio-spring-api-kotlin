ALTER TABLE customer
    ADD income DECIMAL;

ALTER TABLE customer
    ALTER COLUMN income SET NOT NULL;