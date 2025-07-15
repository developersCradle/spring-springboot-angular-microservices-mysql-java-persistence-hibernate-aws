# Section 03: Mapping Collections - Maps, Sorted Maps and Sorted Sets.

Mapping Collections - Maps, Sorted Maps and Sorted Sets.

# What I Learned.

# Maps - Overview.

> **Map**
>   Object that maps unique **keys** to **values**.
>   Cannot contain **duplicates**.
>   **Key** is used to store values and retrieving values.

<img src="useForTheMaps.PNG"  alt="hibernate course" width="500"/>

1. Examples of usage:
	- Map of error codes and error messages.
	- Map of country codes and country names.
	- Map of image file names and image descriptions.
2. Example of using **maps**, there will be **keys** mapped to **value**.
3. When you want access using **key** rather than using **integer** index.

<img src="studentAndImages.PNG"  alt="hibernate course" width="500"/>

1. We will have **map** that maps to **images**.
2. Map **keys cannot** have **duplicates**!

<img src="dbDiagram.PNG"  alt="hibernate course" width="500"/>

<img src="step1.PNG"  alt="hibernate course" width="500"/>

<img src="step2.PNG"  alt="hibernate course" width="500"/>

<img src="annotationForTheMaps.PNG"  alt="hibernate course" width="500"/>

1. `@MapKeyColumn` for mapping
    - For the given **key** in map, mapped into the database.

- Example of usage for the **map**.


```
@Entity
public class Department {
    @Id
    private Long id;

    private String name;

    @ElementCollection
    @MapKeyColumn(name = "employee_name") // this column stores the map's keys
    @Column(name = "employee_salary")     // this column stores the map's values
    @CollectionTable(name = "department_employees", 
                     joinColumns = @JoinColumn(name = "department_id"))
    private Map<String, Integer> employees = new HashMap<>();
}
```

- This maps the **map** key to the database column `department_id`.
    - `employee_name` is used to as **key**.

| `department_id` | `employee_name` | `employee_salary` |
|---------------|----------------|-----------------|
| 1             | Alice          | 90000           |
| 1             | Bob            | 95000           |
| 2             | Charlie        | 70000           |

<img src="MakingMapTable.PNG"  alt="hibernate course" width="500"/>

1. **Maps** the **key** of the **map** for given column in the database. `@MapKeyColumn(name="file_name")`
2. The database column where the mapped value will be. In this example `image_name`.

<img src="step3Coding.PNG"  alt="hibernate course" width="500"/>

<img src="runningTheApp.PNG"  alt="hibe![alt text](image.png)rnate course" width="500"/>

1. Like in the code, we will map **one** value for the **three** images in database.

# Maps - Write Some Code.

- We are **mapping** :D the **map** in Hibernate.

- The Student Entity:

```
package com.luv2code.hibernate.demo.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
		
	@ElementCollection
	@CollectionTable(name="image")
	@MapKeyColumn(name="file_name")
	@Column(name="image_name")
	private Map<String, String> images = new HashMap<String, String>();
	
	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
```

- The Client:


```
package com.luv2code.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentImagesMapDemo {


	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
		//create the object
			Student tempStudent = new Student("John","Doe","john@luv2code.com");
			Map<String, String> theImages = tempStudent.getImages();
			
			theImages.put("photo1.jpg", "Photo 1");
			theImages.put("photo2.jpg", "Photo 2");
			theImages.put("photo3.jpg", "Photo 3");

		//start a transaction
			session.beginTransaction();
			
		//save the object
			System.out.println("Saving the student and images..");
			session.persist(tempStudent);
			
		//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally {
		//clean up code
			session.close();
			factory.close();
		}
		

	}

}
```

<img src="mapInDb.PNG"  alt="hibernate course" width="500"/>

1. `image_name` is used as **key**.
2. `file_name` **value** is being saved.
3. `image` is the table name.

# Sorted Sets - Overview.

> **Sorted Set**
> **Collection** that does **not** contain **duplicates**.
> When, get, the order is given.

<img src="useCaseForTheSet.PNG"  alt="hibernate course" width="500"/>

1. When you are interested in `yes`**/**`no` answers from the `.contains()`. Also, when getting the **element** the **order** is important!
2. Take the examples here.

<img src="usingOrderSetInEntity.PNG"  alt="hibernate course" width="500"/>

1. We will have the `images` in the **set**. We want **get** image in the **descending** order. This cannot contain **duplicates**!

<img src="databaseDiagram.PNG"  alt="hibernate course" width="500"/>

1. **Notice** that we will not have the external **Entity**.

<img src="devProcessForTheSet.PNG"  alt="hibernate course" width="500"/>

<img src="step1CreatingDb.PNG"  alt="hiqbernate course" width="500"/>

1. We will be using `update`, for the **Hibernate** configuration!
2. The properties for the update:

<img src="annotationForTheOrdering.PNG"  alt="hibernate course" width="500"/>

1. `@OrderBy` specifies the **ordering** of the **elements when** a collection is **retrieved**.
2.  **Syntax**: `@OrderBy (" [field name or property name] [ASC | DESC]")`
**Example**: `@OrderBy ("file_name DESC")`.
3. Close comparison is for the **SQL** ordering syntax. Example [SQL Keyword](https://www.w3schools.com/sql/sql_orderby.asp).
	- SQL: `select * from image order by file_name`.
4. If `ASC` or `DESC` is **not specified** then `ASC` is the **default**.

<br>

- This will be **second** annotation for **ordering**:
	- With the **Collection type** it was `@OrderColumn` and as following:
	```
	@ElementCollection
	@CollectionTable(name = "image")
	@OrderColumn
	@Column(name="file_name") // Defaults to images.
	private List<String> images = new ArrayList<String>();¨
	```
	- With the **Sorted Set** it was `@OrderBy`.
	```
	@ElementCollection
	@CollectionTable(name="image")
	@org.hibernate.annotations.OrderBy(clause = "file_name") //default asc
	@Column(name="file_name") //defaults to images
	private Set<String> images = new LinkedHashSet<String>();
	
	```

<img src="mappingCollection.PNG"  alt="hibernate course" width="500"/>

1. We are using the `@OrderBy"file_name DESC")`. This will **order** by `file_name`.

<img src="step3CodingForTheOrdering.PNG"  alt="hibernate course" width="500"/>

- Code as following:

```
// create the object
Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
Set<String> theImages = tempStudent.getImages();

theImages.add("photo1.jpg");
theImages.add("photo2.jpg");
theImages.add("photo3.jpg");
theImages.add("photo4.jpg");
theImages.add("photo5.jpg");

// start a transaction
session.beginTransaction();

// save the object
System.out.println("Saving the student and images...");
session.persist(tempStudent);
```

<img src="step3ForTheDeveloping.PNG"  alt="hibernate course" width="500"/>

<img src="runTheApp.PNG"  alt="hibernate course" width="500"/>

1. These will be **saved** into the database as in order like in the database as in **Sorted Set**.

# Sorted Sets - Write Some Code - Part 1.

- The **Hibernate** configuration:

```
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>


        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC</property>
        <property name="connection.username">root</property>
        <property name="connection.password">password</property>
        <!-- JDBC connection pool settings ... using built-in test pool -->
        <property name="connection.pool_size">1</property>
        <!-- Select our SQL dialect -->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
        <!-- Echo the SQL to stdout -->
        <property name="show_sql">true</property>
        <!-- Auto create tables -->
        <property name="hibernate.hbm2ddl.auto">update</property>
		<!-- Set the current session context -->
		<property name="current_session_context_class">thread</property>
 
    </session-factory>

</hibernate-configuration>
```

- The student **Entity**:

```
package com.luv2code.hibernate.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
		
	@ElementCollection
	@CollectionTable(name="image")
@org.hibernate.annotations.OrderBy(clause = "file_name") //default asc
	@Column(name="file_name") //defaults to images
	private Set<String> images = new LinkedHashSet<String>();
	
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
```


- The **client** for creating the students:

```
package com.luv2code.hibernate.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentImagesSortedSetDemo {


	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
		//create the object
			Student tempStudent = new Student("John","Doe","john@luv2code.com");
			Set<String> theImages = tempStudent.getImages();
			
			theImages.add("photo1.jpg");
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg"); //Duplicate, filtered at java level by HashSet!!!
			theImages.add("photo5.jpg");
			theImages.add("photo5.jpg"); //Duplicate, filtered at java level by HashSet!!!
			
		//start a transaction
			session.beginTransaction();
			
		//save the object
			System.out.println("Saving the student and images..");
			session.persist(tempStudent);
			
		//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally {
		//clean up code
			session.close();
			factory.close();
		}
		

	}

}

```

<img src="savingIntoTheOrderedSortedSet.PNG"  alt="hibernate course" width="300"/>

1. We can see we have saved into to the database, thought to the **Ordered Set**.

# Sorted Sets - Write Some Code - Part 2.

- The student **Entity**:

```
package com.luv2code.hibernate.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
		
	@ElementCollection
	@CollectionTable(name="image")
//	@OrderBy we could use the the @orderBy form package import javax.persistence.OrderBy;
@org.hibernate.annotations.OrderBy(clause = "file_name") //default asc
	@Column(name="file_name") //defaults to images
	private Set<String> images = new LinkedHashSet<String>();
	
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
```


- The **client** for getting the students:

```
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class GetStudentImagesDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get the student id
			int theId = 1;
			Student student = session.get(Student.class, theId);
			
			//print the student detail
			System.out.println("Student details: "+student);
			
			//print the associated images
			System.out.println("The associated images: "+student.getImages());
			
			//commit the transaction
			session.getTransaction().commit();
			
			//done
			System.out.println("Done!");
		}
		finally {
			//close the transaction
			session.close();
			factory.close();
			
		}
		
		
	}

}
```

- You can get the **ordered images**, using with `@OrderBy` annotation.

```
Hibernate: select student0_.id as id1_1_0_, student0_.email as email2_1_0_, student0_.first_name as first_na3_1_0_, student0_.last_name as last_nam4_1_0_ from student student0_ where student0_.id=?
Student details: Student [id=1, firstName=John, lastName=Doe, email=john@luv2code.com]
Hibernate: select images0_.Student_id as Student_1_0_0_, images0_.file_name as file_nam2_0_0_ from image images0_ where images0_.Student_id=? order by images0_.file_name
The associated images: [photo1.jpg, photo2.jpg, photo3.jpg, photo4.jpg, photo5.jpg]
Done!
```

# Sorted Maps - Overview.

> **Sorted Map**
> Elements are **sorted** when insert happen!
> This can be used for mapping **unique** key:s to value:s.
> We can also, specify **sorting order**.

<img src="useCaseForSortedMaps.PNG"  alt="hibernate course" width="400"/>

1. **Example of error codes** and **error messages**.
2. **Example image file names** and **images description**.

<img src="studentAndImagesMaps.PNG"  alt="hibernate course" width="400"/>
 
 1. This will be sorted by the **filename** or sort based on **key**.

<img src="sortedMapDatabaseDiagram.PNG"  alt="hibernate course" width="400"/>

<img src="developementProgress.PNG"  alt="hibernate course" width="400"/>

<img src="step1sortedMap.PNG"  alt="hibernate course" width="400"/>

<img src="step2AnnotationMap.PNG"  alt="hibernate course" width="400"/>

<img src="annotationForOrdering.PNG"  alt="hibernate course" width="400"/>

1. The `@OrderBy` is applied when the **collection** is **retrieved**.

<img src="step2AnnotationMapAnnotations.PNG"  alt="hibernate course" width="400"/>

1. `@OrderBy` **defaults** by `file_name` as ASCENDING.

<img src="step3ForTheDevelopingMainApplication.PNG"  alt="hibernate course" width="400"/>

<img src="runTheAppOverView.PNG"  alt="hibernate course" width="400"/>

# Sorted Maps - Write Some Code.

- TODO this ones