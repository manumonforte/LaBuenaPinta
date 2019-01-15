# LaBuenaPinta


## About
LaBuenaPinta is an manage beers shop desktop java organizer made for the subject Software Engineering of Software Engineer Bachelor's Degree at Universidad Complutense Madrid.

The documentation has been written in spanish because of a language constraint in the assignment for the subject as some classes at the code.
## How to use it
LaBuenaPinta uses [mariadb 10.3](https://downloads.mariadb.org/mariadb/10.3.10/), [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [JUnit 5](https://junit.org/junit5/); these tools are necessary to run the application.
### Running mariadb
Once you've installed [mariadb 10.3](https://downloads.mariadb.org/mariadb/10.3.10/), launch MySQL client, create a user with _manager_ as username and _manager-if_ as password.
After that, run the following command:

`CREATE DATABASE labuenapinta`

LaBuenaPinta is the name of the database.

Create a new user:

`CREATE USER 'manager'@'localhost' IDENTIFIED BY 'manager_if';`

Set privileges for the user created:

`GRANT ALL PRIVILEGES ON * . * TO 'manager'@'localhost';`

`FLUSH PRIVILEGES;`

Go to /bin directory:

`{INSTALLATION PATH}/bin`

If you are in MariaDb terminal: (keys) Ctrl + C

`mysql -u manager -p LaBuenaPinta < {PATH}/labuenapinta-create-db.sql`

Insert the password `manager_if`.

this imports an existing database with a valid structure for labuenapinta.

E-R Diagram

![Diagrama ER](https://gitlab.com/LaBuenaPinta/LaBuenaPinta/raw/master/BBDD/ER.png)


Equipo de Trabajo:<br />
  --> [Manuel Monforte](https://github.com/manumonforte)<br />
  --> [Pablo Agudo](https://github.com/pibloo94)<br />
  --> [Daniel Fidalgo](https://github.com/epocopa)<br />
  --> [Eduardo Martínez](https://github.com/EdwardMartinz)<br />
