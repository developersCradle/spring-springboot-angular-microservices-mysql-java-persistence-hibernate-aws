## [NEW] Spring Boot 3, Spring 6 & Hibernate for Beginners

![Spring Boot](pic.jpg)

All course material from Spring Boot 3, Spring 6 & Hibernate for Beginners by Chad Darby.

Contains my own notes with some course material to enforce learning experience.

If the content sparked :fire: your interest, please consider buying the course and start learning :book:

[The Course at Udemy](https://www.udemy.com/course/spring-hibernate-tutorial/)   
[Content Maker](https://luv2code.com/)

Insert certificate here when completed

**Note: The material provided in this repository is only for helping those who may get stuck at any point of time in the course. It is very advised that no one should just copy the solutions(violation of Honor Code) presented here.**

## Progress/Curriculum new

- [x] [Section 01](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%201) - Section 1: NEW - Spring Boot 3 Quick Start
- [x] [Section 02](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%202) - Section 2: NEW - Spring Core
- [x] [Section 03](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%203) - Section 3: NEW - Hibernate/JPA CRUD 
- [ ] [Section 04](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%204) - Section 4: NEW - REST CRUD APIs
- [ ] [Section 05](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%205) - Section 5: NEW - REST API Security 
- [ ] [Section 06](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%206) - Section 6: NEW - Spring MVC
- [ ] [Section 07](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%207) - Section 7: NEW - Spring MVC CRUD
- [ ] [Section 08](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%208) - Section 8: NEW - Spring MVC Security
- [ ] [Section 09](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%209) - Section 9: NEW - JPA / Hibernate Advanced Mappings
- [ ] [Section 10](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%210) - Section 10: NEW - AOP: Aspect-Oriented Programming
- [ ] [Section 11](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%211) - Section 11: Summary
- [ ] [Section 12](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%212) - Section 12: Appendix
- [ ] [Section 13](https://github.com/developersCradle/spring-springboot-hibernate-for-Beginners/tree/main/Section%213) - Section 13: Bonus


- Todo read/skim thought spring documentation when finished this course

- Todo tsekkaa typot

## Old(legacy) course Curriculum, old course still accessible, if useful do. 

## Progress/Curriculum

- [x] [Section 01](#) - Course Introduction
- [X] [Section 02](#) - Spring Overview
- [ ] [Section 03](#) - Setting Up Your Development Environment
- [ ] [Section 4](#) - Spring Inversion of Control - XML Configuration
- [ ] [Section 5](#) - Spring Dependency Injection - XML Configuration



- TODO task heikki When every is finished

```
COUNTRY SERVICE

 

Implement a microservice which provides a list of countries and, in addition, provides more detailed information per country.

 

Requirements:

 

1. Use spring-boot

https://start.spring.io/

https://spring.io/guides/gs/spring-boot/

 

2. Use maven

https://spring.io/guides/gs/maven/  

https://www.baeldung.com/maven

 

3. Use best practices and microservice approach

 

4. Implement the following REST API with spring-boot:

 

GET /countries/

 

response:

          {

                   "countries": [

                             {

                                       "name": "Finland",

                                       "country_code": "FI"

                             },

                             ...

                   ]

          }

 

GET /countries/{name}

 

response:

          {

                   "name": "Finland",

                   "country_code": "FI",

                   "capital": "Helsinki",

                   "population": 5491817,

                   "flag_file_url": "<url to the flag file>"

          }

 

5. Country service must fetch the relevant information for countries from some other service

- You could use for example the following service: https://countriesnow.space/

 

6. Test the implementation as well as it's needed from your perspective

 

7. All the implementations must be runnable locally with our own computer. Write needed instructions to README.md file.

 

8. Publish all sources code and relevant files in github or similar service and send the link to the repo so that the implementation can be reviewed.

 

You get bonus points if:

- you use and understand reactor (https://www.baeldung.com/reactor-core)

- you create a separate wep application which utilizes the created REST API and shows the relevant country information in a browser

 
```