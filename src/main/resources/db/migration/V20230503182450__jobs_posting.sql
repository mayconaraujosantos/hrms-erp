CREATE TABLE job_postings (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    location VARCHAR(255) NOT NULL,
    employment_type VARCHAR(50),
    posted_date DATE NOT NULL,
    status VARCHAR(6) NOT NULL CHECK (status IN ('open', 'closed'))
);
