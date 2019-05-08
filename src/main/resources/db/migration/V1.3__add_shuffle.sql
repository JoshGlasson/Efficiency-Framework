DROP TABLE IF EXISTS shuffle;

CREATE TABLE shuffle (
id bigserial PRIMARY KEY,
arraySize bytea,
timeTaken bytea
);
