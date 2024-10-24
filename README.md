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
the major of configured security is about acl security. i defined a custome permission evaluater and with help of GrantedAuthority class, we figure out how to evalute permissions.

## Role
there are only two major Roles. ADMIN and WRITER. we can have several objects from thease types (for example, several admins can be exist). thease role classes are extending **User** class.

## Commands
as i said before, the only way to communicate with application is from bash and through commands. here are all commands:

### whatrole
this command shows your role. there is only two role {ADMIN, WRITER}

### whoami
this command show your username.

### login -u username -p password
this command will login with username and password that you enterd.

### logout
logout from your account

### create-writer -u username -p password
only admins can call this function. it will create a new account with role WRITER.

### grant auth -u username -p permission -c path of the class -i id of the objcect
only admins can call this function. it will grant user with username, the permission for the sepecific option. the path of the class should now be an absoloute path! we should write it as a path from model folder
(for example if you want to grant EDIT authority to user Erfan for Event object of id 44. you should enter this:
"grant auth erfan edit event/Event 44"
