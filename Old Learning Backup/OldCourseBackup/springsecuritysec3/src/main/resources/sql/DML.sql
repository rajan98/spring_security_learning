-- Inserting data into the 'users' table
INSERT INTO users (username, password, enabled)
VALUES
    ('batman', 'iambatman', true),
    ('superman', 'iamsuperman', true),
    ('wonderwomen', 'iamwonderwomen', false);

-- Inserting data into the 'authorities' table
INSERT INTO authorities (username, authority)
VALUES
    ('batman', 'admin'),
    ('superman', 'write'),
    ('wonderwomen', 'read');