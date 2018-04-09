CREATE DATABASE krustybase;

CREATE USER 'spongebob'@'localhost' IDENTIFIED BY 'krusty';
GRANT ALL PRIVILEGES ON krustybase . * TO 'spongebob'@'localhost';
