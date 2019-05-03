ALTER TABLE comments
ADD COLUMN userid bigserial REFERENCES users(id);