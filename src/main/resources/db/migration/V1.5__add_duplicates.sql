DROP TABLE IF EXISTS duplicate;

CREATE TABLE duplicate (
id bigserial PRIMARY KEY,
arraySize bytea,
timeTaken bytea
);
