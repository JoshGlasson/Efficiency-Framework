ALTER TABLE posts
ADD COLUMN userid bigserial REFERENCES users(id);