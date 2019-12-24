DROP SCHEMA IF EXISTS cinema CASCADE;
CREATE SCHEMA cinema;

CREATE TABLE IF NOT EXISTS cinema.users
(
    id         BIGINT PRIMARY KEY,
    name       VARCHAR(30)  NOT NULL,
    surname    VARCHAR(50)  NOT NULL,
    username   VARCHAR(120) NOT NULL UNIQUE,
    email      VARCHAR(120) NOT NULL UNIQUE,
    password   VARCHAR(200) NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    updated_by VARCHAR(120) NOT NULL
);

CREATE TABLE IF NOT EXISTS cinema.roles
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS cinema.user_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES cinema.users (id),
    FOREIGN KEY (role_id) REFERENCES cinema.roles (id)
);

CREATE TABLE IF NOT EXISTS cinema.movie
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    producer VARCHAR(100),
    description VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS cinema.movie_session
(
    id BIGINT PRIMARY KEY,
    movie_date TIMESTAMP NOT NULL,
    movie_id BIGINT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES cinema.movie (id)
);