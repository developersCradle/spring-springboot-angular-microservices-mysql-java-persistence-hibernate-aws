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
    