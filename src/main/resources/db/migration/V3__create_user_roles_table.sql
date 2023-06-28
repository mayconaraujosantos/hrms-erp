CREATE TABLE IF NOT EXISTS user_roles
(
    "user_id" int8 NOT NULL,
    "role_id" int4 NOT NULL,
    CONSTRAINT "fkh8ciramu9cc9q3qcqiv4ue8a6" FOREIGN KEY ("role_id") REFERENCES roles ("id"),
    CONSTRAINT "fkhfh9dx7w3ubf1co1vdev94g3f" FOREIGN KEY ("user_id") REFERENCES users ("id"),
    PRIMARY KEY ("role_id", "user_id")
);