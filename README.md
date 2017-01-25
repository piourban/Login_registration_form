# Login_registration_form
JavaFX registration and login form example. Made for future use. 
To provide database connection remember to fill in "dbPath", "user" and "password" details in "Util" class.
If you are not using MS SQL database then replace also driver details. 

Used technologies:
-JavaFX
-MS SQL database
-Bcrypt algorithm

Known issues:
-Styling issue in registration form. If validation error occured, style in this textfield wont be changed.
"txt.getStyleClass().remove("errorOut");" command is not working correctly.

Future improvements:
-Switch Java JDBC to Spring JdbcTemplate.
-Divide "Patient" table to "User" and "Patient" tables.
