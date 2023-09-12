ALTER TABLE credit
    ADD number_of_installments INT;

ALTER TABLE credit
    ALTER COLUMN number_of_installments SET NOT NULL;