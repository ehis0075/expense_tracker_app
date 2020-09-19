DROP USER IF EXISTS 'expensify'@'localhost';
CREATE USER 'expensify'@'localhost' IDENTIFIED BY 'expensify';
GRANT ALL PRIVILEGES ON expense_tracker.* TO 'expensify'@'localhost';
FLUSH PRIVILEGES ;

DROP DATABASE IF EXISTS expense_tracker;
CREATE DATABASE expense_tracker;