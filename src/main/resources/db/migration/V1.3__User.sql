DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id bigserial PRIMARY KEY,
  name varchar(250) NOT NULL,
  email varchar(250) NOT NULL UNIQUE,
  password varchar(250) NOT NULL
);
