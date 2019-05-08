DROP TABLE IF EXISTS last;

CREATE TABLE last (
id bigserial PRIMARY KEY,
arraySize bytea,
timeTaken bytea
);
