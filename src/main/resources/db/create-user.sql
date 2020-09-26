create database expense_tracker_db_1; -- Creates the new database
create user 'expensify55'@'%' identified by 'expensify55'; -- Creates the user
grant all on expense_tracker_db_1.* to 'expensify55'@'%'; -- Gives all privileges to the new user on the newly created database