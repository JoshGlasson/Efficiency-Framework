DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
  id bigserial PRIMARY KEY,
  content varchar(250) NOT NULL,
  time_stamp varchar(100) NOT NULL,
  post_id bigserial REFERENCES posts(id)
);
