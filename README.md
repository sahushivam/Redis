# Redis
<p>Implementation of few functionalities of Redis</p>

## Built With
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[MongoDB](https://www.mongodb.com/) - MongoDB is a general purpose, document-based, distributed database.

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do
- [x] RESTful Web Service (CRUD)
- [x] Cache implementation
- [ ] Security (Basic Authentication)
- [ ] Docker
- [ ] Spring Boot Admin
- [ ] LRU Cache Eviction Policy
- [ ] Multithreaded operation support

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
### APIS
|  URL |  Method | Parameter
|----------|--------------|--------------|
|`http://localhost:8080/get/`      | GET | key(String) |
|`http://localhost:8080/getAll/`    | GET | |
|`http://localhost:8080/set/`    	 | GET | key(String)&value(String)| 
|`http://localhost:8080/expire/`    | GET | key(String)&time(Integer)|
|`http://localhost:8080/ttl/`    | GET | key(String)|
|`http://localhost:8080/delete/`    | GET | key(String)|
|`http://localhost:8080/zadd/`      | GET | key(String)&score(Integer)&value(String)|
|`http://localhost:8080/zrank/`     | GET | key(String)&value(String)|
|`http://localhost:8080/zrange/`    | GET | key(String)&low(Integer)&high(Integer)|

### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/`                           |   | Redirects you to forms for testing different apis|
|`http://localhost:8080/get.html/`                 | GET | Form accepts key (String)|
|`http://localhost:8080/set.html/`                 | GET | Form accepts key (String) and value (String)|
|`http://localhost:8080/zadd.html/`                  | GET | Form accepts key (String) and member(String) and score(Integer)|
|`http://localhost:8080/zrank.html/`                 | GET | Form accepts key (String) and member(String)|
|`http://localhost:8080/zrange.html`                 | GET | Form accepts key (String), low(Integer) and  high(Integer)|

## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── com.example.demo
│           ├── com.example.demo.repository
│           ├── com.example.demo.model
│           ├── com.example.demo.repository
│           └── com.example.demo.service
├── src
│   └── main
│       └── resources
│           └── static
│           │   ├── zrank.html
│           │   ├── zrange.html
│           │   ├── zadd.html
│           │   ├── set.html
│           │   ├── get.html
│           │   └── index.html
│           ├── templates
│           ├── application.properties
│         
│           
├── src
│   └── test
│       └── java
├── Maven Dependencies
├── src
├── target
├── .settings
├── mvnw
├── mvnw.cmd
├── pom.xml
└── HELP.md
```
## packages

- `models` — to hold our entities;
- `repositories` — to communicate with the database;
- `services` — to hold our business logic;
- `controllers` — to listen to the client;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests
- `pom.xml` - contains all the project dependencies

## Resources

* [My API Lifecycle Checklist and Scorecard](https://dzone.com/articles/my-api-lifecycle-checklist-and-scorecard)
* [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)
* [Common application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
 
