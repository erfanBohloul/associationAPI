# Association API
## Overwiew
This project is an API and it's purpose is to controll the relation of Events, Staffs, Companies. also Writers can make post about anything (mostly on Events). this project was a good practice for me to learn Spring boot security.

# How does it work?

## interface
we can intract with application from terminal. when we run this project, automatically it will pop up a terminal. in the Command section i will go through all the commands of this application

## database
this application uses **MySQL** database that runs on port 3306 on local system. to lunch the database, i used **docker compose**. docker compose will lunch a database named associationDB.
you can see other properties of associationDB from compose.yml file and application.properties file.

this application using JPA. you can see the relation between entities through the source code yourself.

## Security
the major of configured security is about acl security. i defined a custome permission evaluater and with help of A and B classes, we will figuring out how to evalute permission
