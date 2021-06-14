CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, genre) values
    ('Dark Knight', 152, 'ACTION'),
    ('Mmento', 113, 'THRILLER'),
    ('Matrix', 136, 'ACTION');