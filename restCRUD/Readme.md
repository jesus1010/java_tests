# Description

Simple rest Spring boot application with the next features:

* Spring boot application.
* Custom errors and exceptions.
* JPA with HSQLDB with autoconfig.
* Method argument validation
* Code prepare for concurrent tasks.
* Log4j integrated.

# Requirements
* Apache Maven >= 3.5.0
* Java JDK >=1.8

# Http verbs used and model definition

* user model
* Id // database identity 
* Name Birthdate

## Endpoints

### get all
* url: http://server/api/user/getall
* method: GET
* params: <none>
* returns: List<user>

### get
* url: http://server/api/user/get/{id}
* method: GET
* params: id (int)
* returns: user

### create
* url: http://server/api/user/create
* method: POST
* params: user
* returns: user (with generated id)

### update
* url: http://server/api/user/update
* method: POST
* params: user
* returns: user

### remove
* url: http://server/api/user/remove/{id}
* method: GET
* params: id (int)
* returns: <void>


# To run the application
$ mvn spring-boot:run


# To run tests
$ mvn test
