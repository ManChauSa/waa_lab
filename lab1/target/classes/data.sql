-- insert data table user
INSERT INTO "user" (name, email, username, password) VALUES ('Alice', 'admin@gmail.com', 'alice', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
INSERT INTO "user" (name, email, username, password) VALUES ('Bob', 'bob@gmail.com', 'bob', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
INSERT INTO "user" (name, email, username, password) VALUES ('Charlie', 'charlie@gmail.com', 'charlie', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO "role" (role) VALUES ('ADMIN');
INSERT INTO "role" (role) VALUES ('USER');

INSERT INTO "user_roles" (user_id, role_id) VALUES (1, 1);
INSERT INTO "user_roles" (user_id, role_id) VALUES (2, 2);
INSERT INTO "user_roles" (user_id, role_id) VALUES (3, 2);
-- insert data table post
INSERT INTO post (title, content, author, user_id) VALUES ('First Post', 'This is the content of the first post.', 'Alice', 1);
INSERT INTO post (title, content, author, user_id) VALUES ('Second Post', 'This is the content of the second post.', 'Alice', 1);
INSERT INTO post (title, content, author, user_id) VALUES ('Third Post', 'This is the content of the third post.', 'Bob', 2);
INSERT INTO post (title, content, author, user_id) VALUES ('Fourth Post', 'This is the content of the fourth post.', 'Charlie', 3);
INSERT INTO post (title, content, author, user_id) VALUES ('Fifth Post', 'This is the content of the fifth post.', 'Charlie', 3);

-- Insert Comments for Post
INSERT INTO comment (name, post_id) VALUES ('Comment 1 for Post 1', 1);
INSERT INTO comment (name, post_id) VALUES ('Comment 1 for Post 2', 2);
INSERT INTO comment (name, post_id) VALUES ('Comment 2 for Post 2', 2);