CREATE SEQUENCE IF NOT EXISTS users_id_seq;

CREATE TABLE IF NOT EXISTS users
(
    "id"       int8 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    "username" varchar(20),
    "email"    varchar(50),
    "password" varchar(120),
    PRIMARY KEY ("id")
);