# Section 1: NEW - Spring Boot 3 Quick Start
All thing which needs get started with Spring Boot

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

<img src="GoalsOfSpring.JPG" alt="alt text" width="500"/>

- 1. Much simple work with POJO:s than [EJB](https://www.javatpoint.com/what-is-ejb). EJB is like **COM** object
     - [POJO](https://en.wikipedia.org/wiki/Plain_old_Java_object)
     - [POJO2](https://www.baeldung.com/java-pojo-class)
- 2. Loose coupling with dependency injection
- 3. In old days JavaEE needed to write a lot of code


- Core components of SpringBoot

<img src="coreComponentsStringBoot.JPG" alt="alt text" width="400" height="400"/>

 - **SpEL** spring configuration language

 <img src="coreComponentsStringBoot2.JPG" alt="alt text" width="500"/>

<img src="coreComponentsStringBoot3.JPG" alt="alt text" width="500"/>

- 1. ORM **Object Relation Mapping**. Popular one and important!

<img src="coreComponentsStringBoot4.JPG" alt="alt text" width="500"/>

- Integration test supported

- Spring projects
    - are just Spring **modules**

<img src="springProjects.JPG" alt="alt text" width="500"/>

- List of different projects  [Spring Projects](https://spring.io/projects)

<img src="mavenSolve.JPG" alt="alt text" width="500"/>

- This can be also beneficial, if you don't want to push external library to your repository. You can let **Maven** do the work!

<img src="mavenInAction.JPG" alt="alt text" width="500"/>

- Maven downloads our JAR files from internet
    - 1. Remote repository is in internet

<img src="howMavenWorks.JPG" alt="alt text" width="500"/>

- How Maven works
    - 1. Maven will read config file 
    - 2. Check local repo
    - 3. If no in local repo, get it from internet remote(remote)
    - 4. Saves it to local repository
    - 5. Build and run application

- When building and running app
    - Maven takes care class and build path for you

- Maven project structure, standard
    - 0. POM project configuration file
    - 1. Java source code
    - 2. Property files, config file ... etc
    - 3. **webapp**, is css, web-config files
    - 4. Test files comes here
    - 5. Compiled codes come here, artifacts what maven will compile

- Why is important to have directory structure

<img src="whyMavenImportant.JPG" alt="alt text" width="500"/>

- Maven projects are portable, Eclipse, IntelliJ, NetBeans etc

- As summary why using Maven

<img src="SummaryUsingMaven.JPG" alt="alt text" width="400"/>

- Additionally, when new developer joins team, personnel can get easily into project whit out worrying about project config details

<img src="pomFileFileStructure.JPG" alt="alt text" width="500"/>

- **Project meta data** Data about your project.
- **Dependencies** Data list of projects which are depending on our project.
- **Plug ins** Addition custom task. Junit, logging

- This structure reflected to **POM.xml**

<img src="pomFileFileStructureReflected.JPG" alt="alt text" width="600"/>

- 2. Dependencies get added here, example Junit

<img src="projectCoordinates.JPG" alt="alt text" width="600"/>

- Project Coordinates -> Like UID

<img src="projectCoordinatesExample.JPG" alt="alt text" width="600"/>

- 1. Should use reverse domain naming convention
- 2. Version number, **SNAPSHOT** mean product is still under development

- To add dependency we need add following

<img src="addingDepency.JPG" alt="alt text" width="500"/>

- When adding dependency we need, **Group ID**, **Artifact ID**, but version is optional
    - It's good to input such information
    - For **DevOps** this is important, that you can say it have been tested and proven to work with following versions of decencies. Acronym **GAV**

<img src="depencyCoordinates.JPG" alt="alt text" width="500"/>

- Finding coordinates to input to POM
    - Option 2, is far the eazyest

<img src="findDepencyCoordinates.JPG" alt="alt text" width="500"/>

- Maven Wrapper files, helps run and download correct versions of maven.  


<img src="mavenFrapperFiles.JPG" alt="alt text" width="500"/>

- If Maven is all ready installed, no need for wrapper files.

<img src="mavenSpringPom.JPG" alt="alt text" width="500"/>
   
 - 1. ``spring-boot-starter-web`` is collection of decencies, for easy import on maven.