DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    is_completed BOOLEAN NOT NULL
);

INSERT INTO tasks (
    id, name, is_completed
) VALUES
(
    'a2b2ccad-4da3-4443-be80-c65b76854f10',
    'Clean dishes',
    true
),
(
    'a2b2ccad-4da3-4443-be80-c65b76854f11',
    'Walk the dog',
    false
),
(
    'a2b2ccad-4da3-4443-be80-c65b76854f12',
    'Send emails',
    false
);