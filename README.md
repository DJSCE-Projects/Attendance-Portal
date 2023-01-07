# Attendance Portal

This project contains a java application which can be used by any university. Using this software application a teacher can give students attendance, a student can check their attendance of their courses and an admin can add new admission teacher and students.

All data is saved in a SQL database.

## To use this application

### 1.
    ### `git clone https://github.com/DJSCE-Projects/Attendance-Portal.git`
    Run the above command to download the application in your desired directory.

### 2.
    Run all the commands in the `attendacePortal.sql` file in your MySQL Workbench to create your basic database template for you.

### 3.
    Change the `jdbcConnection` variable to the connection of your database along with chanage to your user password in the `LoginPage.java` file (Line 30).

## Note

The application can be run from `LoginPage.java` itself (which is the entry point of the program).

Admin credentials are: username: `admin`
                       password: `pass@123`

Other users can then login into the portal using their login credentials.

## App Info

### Authors

[Kushal Vadodaria](http://linkedin.com/in/kushal-vadodaria) | [Umang Jain](https://www.linkedin.com/in/umang-jain-52ba01212/)

### Version

1.0.0

### License

This project is not currently licenced.
