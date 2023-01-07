# Attendance Portal

This attendance tracking java-based application can be used by any university. Using this software application a teacher can give students attendance, a student can check attendance of their courses and an admin can add new teachers and students.

All data is saved in a SQL database.

## To use this application

### 1.
   ### `git clone https://github.com/DJSCE-Projects/Attendance-Portal.git`
   Run the above command to download the application in your desired directory.

### 2.
   Run all the commands in the `attendacePortal.sql` file in your MySQL Workbench to create a basic database template for you.

### 3.
   Change the `jdbcConnection` String variable to the jdbc-connection of your database along with chanage to your user password in the `LoginPage.java` file (Line 30).

## Note

The application is to be run from `LoginPage.java` itself (which is the entry point of the application).

Admin credentials are: username: `admin`
                       password: `pass@123`

Other users can then login into the portal using their login credentials.

## App Info

### Authors

[Kushal Vadodaria](http://linkedin.com/in/kushal-vadodaria) | [Umang Jain](https://www.linkedin.com/in/umang-jain-52ba01212/)

### Version

1.0.0

### License

This project is currently unlicensed.
