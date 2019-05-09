DROP TABLE IF EXISTS frequency;

CREATE TABLE frequency (
id bigserial PRIMARY KEY,
arraySize bytea,
timeTaken bytea
);
