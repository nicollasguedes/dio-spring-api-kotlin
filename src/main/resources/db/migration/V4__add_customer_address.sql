ALTER TABLE customer
    ADD street VARCHAR(255);

ALTER TABLE customer
    ADD zip_code VARCHAR(255);

ALTER TABLE customer
    ALTER COLUMN street SET NOT NULL;

ALTER TABLE customer
    ALTER COLUMN zip_code SET NOT NULL;