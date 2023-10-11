# Section 3: NEW - Hibernate/JPA CRUD 

NEW - Hibernate/JPA CRUD 

# What I Learned


<img src="whatIsHibernate.JPG" alt="alt text" width="600"/>

1. Lot of enterprise companies uses **Hibernate**

- Used retrieving and saving file from/to database

<img src="benefitsOfHibernate.JPG" alt="alt text" width="600"/>

- Less JDBC code with usage of **ORM**

<img src="orm.JPG" alt="alt text" width="600"/>

1. Camel case naming

<img src="onlyspesification.JPG" alt="alt text" width="600"/>

- Remember its only specification

- Many vendors implement - **JPA** specification  

- [JPA Vendor Implementation](luv2code.com/jpa-spec)

<img src="jpaVendorImplementation.JPG" alt="alt text" width="600"/>



- Meaning we could easily "technically" swap JPA Implementation to another
    - If ABC stop supporting the product
        - You could switch to Vendor XYZ

<img src="JPAVendorImplementationSwapping.JPG" alt="alt text" width="600"/>

- Example **ExlipseLink** is no more around!
    - We just switch it
- This is the benefit for Coding **STANDARD API** for ORM

<img src="JPAVendorImplementationSwapping2.JPG" alt="alt text" width="600"/>

<br>

<img src="savingAJavaObjectWithJPA.JPG" alt="alt text" width="600"/>

1. Behind the scenes Hibernates implementation of JPA will do all the work for you. **MAKING ALL SQL RELATED THINGS**

- In old days you had to write SQL code for these operations, now hibernate does all the work for you!

<img src="retrieveingJavaObjectWithJPA.JPG" alt="alt text" width="600"/>

1. Technique for retrieving Student from database. Using **Primary Key** 

```

int theId = 1;
Student myStudent = entityManager.find(Student.calss, theId);
 
```

- This is basically what we need to retrieve **Object** from database.

- TODO too joku JDBC kurssi, koska historian havina.

<img src="queryingForJavaObjects.JPG" alt="alt text" width="600"/>

1. We are using simple **JPA query language** We are not writing any **SQL** code!
    - We can use `like` `where` and such in Java code!


- JDBC is still **used background** of JPA/Hibernate

<img src="JPA_JDBC.JPG" alt="alt text" width="600"/>
    
- MySQL is being used here.
- [WorkBench](https://dev.mysql.com/downloads/workbench/)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

- Creating user SQL

```
-- Drop user first if they exist
DROP USER if exists 'springstudent'@'%' ;

-- Now create user with prop privileges
CREATE USER 'springstudent'@'%' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';
```

 - Student tracker SQL

```
CREATE DATABASE  IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

<img src="SpringBootDefaultsetting.JPG" alt="alt text" width="600"/>

<br>

<img src="applicationProperryWillBeUsed.JPG" alt="alt text" width="600"/>

1. We will be using following configurations, **db** which we created previously
2. Datasource URL

<img src="creatingSpringBootAppConsole.JPG" alt="alt text" width="600"/>

1. **CommandLineRunner** is **Spring Boot** hook to run after **Spring Boot** have been loaded
2. We can add DAO code later on 

- For now, we can use following to illustrate `CommandLineRunner`

```
	//Executed after Spring Beans have been loaded
	@Bean 
	public CommandLineRunner commandLineRunner(String[] args)
	{
		return runner -> {
			System.out.println("Hello World");
		};
	}
```

<img src="settingUpJdbc.JPG" alt="alt text" width="600"/>

1. This connects our local MySql to our JDBC

<img src="logsForConnecting.JPG" alt="alt text" width="600"/>

1. We can see that our JDBC drivers successfully logged in to Database

<img src="ourCodeAfterBeans.JPG" alt="alt text" width="600"/>

1. We can see our CondeLineRunner is working, executed after bean have been loaded


# JPA development

1. Annotate Java Class
2. Make Java Code to perform database operation

<img src="entity.JPG" alt="alt text" width="600"/>

<br>

- Entity class should have:

<img src="entityclass.JPG" alt="alt text" width="600"/>

2:00