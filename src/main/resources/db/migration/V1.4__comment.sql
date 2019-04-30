DROP TABLE IF EXISTS posts;

CREATE TABLE comments (
  id bigserial PRIMARY KEY,
  content varchar(250) NOT NULL,
  time_stamp varchar(100) NOT NULL,
  post_id bigserial FOREIGN KEY
);
