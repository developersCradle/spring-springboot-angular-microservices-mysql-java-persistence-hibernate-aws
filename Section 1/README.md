# Section 1: NEW - Spring Boot 3 Quick Start

# What I Learned

- Need to install JDK 17 or **higher**, **Spring Boot 3**

<img src="problem.JPG" alt="alt text" width="500"/>

- 1. Normally setting up **Spring** is difficult, need to think many things first
    - Here, **Spring Boot** comes in to play, it makes thing pre-configured all ready. 

<img src="solution.JPG" alt="alt text" width="500"/>

- **Spring boot** solves these things for you for providing these things


- **Spring Boot** uses **Spring** behind scenes
    - **Spring** and **Spring boot** are two different things! 

- Spring boot gives **Spring Initializr** for easy configruation
    - [SpringInitalizr](https://start.spring.io/)

<img src="SpringInit.JPG" alt="alt text" width="500"/>

- 1. Will be using Eclipse

<img src="EmbeddedServer.JPG" alt="alt text" width="500"/>

- 1. Not like with **JSP** application where your **.jar** needs to be run with separate server application, like **tomcat**
- 2. Server is provided whit in **.jar** file with your code

- This make it easy to just run in command line `java -jar mycoolapp.jar` **MAGIC!**
    - What about deploying app like in normal way? No worries, **Spring boot** can deploy **.war** also
        - Deployed as **.war** file, which can be ran with external server like **Tomcat**

<img src="war.JPG" alt="alt text" width="500"/>

- 1. One server installed in company
- 2. This one server runs many applications like in the past

<img src="springConfiguration.JPG" alt="alt text" width="400"/>

- 1. **Spring Boot** uses and configures these components **under it**, for easy to use

- You can use **any** IDE for Spring Boot apps!

- When building Java applications, you need JAR files
    - You can do this by hand, but in **recommended** let build tool take care of this. Like maven
    - [Additional info](https://softwareengineering.stackexchange.com/questions/340223/should-you-include-libraries-and-code-unrelated-files-in-your-git-project-and-up)

<img src="MavenSummary.JPG" alt="alt text" width="400"/>

- Maven takes care of `.jar` files, summary here. External **.JAR** files like Spring, Hibernate which Spring boot uses

<img src="caution.JPG" alt="alt text" width="400"/>


<img src="springBootDencies.JPG" alt="alt text" width="400"/>
 
- 1. We want to add decencies to our **Spring Boot** project.
- 2. **Spring Web** is for full stack web project

- After importing into your favorite **IDE** as Maven project. You can run as **Java application!** Not with server since, it's included in bundles


<img src="embeddedServerInSpringBoot.JPG" alt="alt text" width="600"/>
 
 - 1. As you can see Embedded server is included and running

 - Default starting place `http://localhost:8080/`



- We can make basic app, by telling with such annotations

<img src="RESTcontrollerMapping.JPG" alt="alt text" width="600"/>

<img src="GoalsOfSpring.JPG" alt="alt text" width="600"/>

- 1. Much simple work with POJO:s than [EJB](https://www.javatpoint.com/what-is-ejb). EJB is like **COM** object
     - [POJO](https://en.wikipedia.org/wiki/Plain_old_Java_object)
     - [POJO2](https://www.baeldung.com/java-pojo-class)
- 2. Loose coublibling with depency injection
- 3. In old days JavaEE needed to write lot of code


- Core components of SpringBoot

<img src="coreComponentsStringBoot.JPG" alt="alt text" width="600"/>

 - **SpEL** spring configuration language

 <img src="coreComponentsStringBoot2.JPG" alt="alt text" width="600"/>

<img src="coreComponentsStringBoot3.JPG" alt="alt text" width="600"/>

- 1. ORM **Object Relation Mapping**. Popular one and important!