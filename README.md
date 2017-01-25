# Login & registration form
JavaFX registration and login form example. Made for future use.<br/> 
To provide database connection remember to fill in "dbPath", "user" and "password" details in "Util" class.<br/>
If you are not using MS SQL database then replace also driver details.<br/>

Used technologies:<br/>
-JavaFX<br/>
-MS SQL database<br/>
-Bcrypt algorithm<br/>

Known issues:<br/>
-Styling issue in registration form. If validation error occured, style in this textfield wont be changed.
"txt.getStyleClass().remove("errorOut");" command is not working correctly.

Future improvements:<br/>
-Switch Java JDBC to Spring JdbcTemplate.<br/>
-Divide "Patient" table to "User" and "Patient" tables.
