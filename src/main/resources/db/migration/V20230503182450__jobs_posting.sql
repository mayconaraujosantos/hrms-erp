DROP TYPE IF EXISTS job_status_type CASCADE;

CREATE TYPE job_status_type AS ENUM ('DRAFT', 'OPEN', 'CLOSED', 'FILLED', 'CANCELED');

CREATE CAST(varchar AS job_status_type)
WITH
    INOUT AS IMPLICIT;

DROP TYPE IF EXISTS job_type CASCADE;

CREATE TYPE job_type AS ENUM (
    'FULL_TIME',
    'PART_TIME',
    'CONTRACT',
    'INTERNSHIP',
    'TEMPORARY'
);

CREATE CAST(varchar AS job_type)
WITH
    INOUT AS IMPLICIT;

DROP TYPE IF EXISTS salary_type CASCADE;

CREATE TYPE salary_type AS ENUM ('HOURLY', 'MONTHLY', 'YEARLY');

CREATE CAST(varchar AS salary_type)
WITH
    INOUT AS IMPLICIT;

DROP TYPE IF EXISTS experience_level CASCADE;

CREATE TYPE experience_level AS ENUM (
    'ENTRY_LEVEL',
    'MID_LEVEL',
    'SENIOR_LEVEL',
    'EXECUTIVE'
);

CREATE CAST(varchar AS experience_level)
WITH
    INOUT AS IMPLICIT;

DROP TYPE IF EXISTS education_level CASCADE;

CREATE TYPE education_level AS ENUM (
    'HIGH_SCHOOL',
    'ASSOCIATE',
    'BACHELOR',
    'MASTER',
    'DOCTORATE'
);

CREATE CAST(varchar AS education_level)
WITH
    INOUT AS IMPLICIT;

-- Creating job_postings table 
CREATE TABLE
    IF NOT EXISTS job_postings (
        id SERIAL PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        company_name VARCHAR(255) NOT NULL,
        LOCATION VARCHAR(255) NOT NULL,
        job_type job_type NOT NULL,
        job_description TEXT NOT NULL,
        salary NUMERIC(10, 2),
        salary_type salary_type,
        experience_level experience_level NOT NULL,
        education_level education_level,
        requirements TEXT,
        responsibilities TEXT,
        benefits TEXT,
        job_posted_date DATE NOT NULL,
        application_deadline DATE,
        job_status job_status_type NOT NULL
    );