-- Creating job_postings table
CREATE TABLE IF NOT EXISTS job_postings
(
    id                   SERIAL PRIMARY KEY,
    title            VARCHAR(255)     NOT NULL,
    company_name         VARCHAR(255)     NOT NULL,
    location             VARCHAR(255)     NOT NULL,
    job_type             VARCHAR(255)     NOT NULL, -- was job_type ENUM
    job_description      TEXT             NOT NULL,
    salary               NUMERIC(10, 2),
    salary_type          VARCHAR(255), -- was salary_type ENUM
    experience_level     VARCHAR(255)     NOT NULL, -- was experience_level ENUM
    education_level      VARCHAR(255), -- was education_level ENUM
    requirements         TEXT,
    responsibilities     TEXT,
    benefits             TEXT,
    job_posted_date      DATE             NOT NULL,
    application_deadline DATE,
    job_status           VARCHAR(255)     NOT NULL -- was job_status_type ENUM
);
