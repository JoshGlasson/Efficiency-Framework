DROP TABLE IF EXISTS likes;

CREATE TABLE likes (
  id bigserial PRIMARY KEY,
  postid bigserial REFERENCES posts(id),
  userid bigserial REFERENCES users(id)
);
