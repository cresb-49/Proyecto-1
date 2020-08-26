CREATE USER IF NOT EXISTS 'benjamin'@'localhost' IDENTIFIED BY 'Benjamin_201931012';
USE mi_empresa_proyecto1;
GRANT ALL PRIVILEGES ON mi_empresa_proyecto1.* TO 'benjamin'@'localhost';
FLUSH PRIVILEGES;
