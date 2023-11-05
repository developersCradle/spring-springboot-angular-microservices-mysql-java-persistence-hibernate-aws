# Section 4: NEW - REST CRUD APIs

NEW - REST CRUD APIs

# What I Learned

- [Reference Manual](luv2code.com/spring-reference-manual)

<img src="weAringDoingThisOneRestWeatherApplication.JPG" alt="alt text" width="600"/>

<br>

- **Connecting** Weather Service, is thought REST API calls over HTTP

- REST is language independent

- We be using [WeatherAPI](openweathermap.org)

<img src="callWeatherApp.JPG" alt="alt text" width="600"/>

<br>

<img src="response.JPG" alt="alt text" width="600"/>

<br>

<img src="RestOverHTTP.JPG" alt="alt text" width="400"/>

<br>

<img src="jsonExample.JPG" alt="alt text" width="500"/>

<br>

- You can nest as many levels as you can in JSON Object model

<img src="nestedJSON.JPG" alt="alt text" width="500"/>

<br>

<img src="jsonArrays.JPG" alt="alt text" width="500"/>

<br>

<img src="restOverHTTPVerbs.JPG" alt="alt text" width="500"/>

<br>

<img src="HTTPrequestMessage.JPG" alt="alt text" width="500"/>

- **Message body:**
  Message of content will be inside message body as **JSON**. If adding is happening.

<img src="HTTPresponse.JPG" alt="alt text" width="500"/>

- **MIME** Content Type, media type of the payload.

<img src="mimeContentType.JPG" alt="alt text" width="500"/>

- For getting dummy JSON files

- [Fake Online REST API for Testing and Prototyping](http://jsonplaceholder.typicode.com/)

- Performing postman **GET** to dummy website

- `http://jsonplaceholder.typicode.com/users`

<img src="postmanGet.JPG" alt="alt text" width="500"/>


### Rest client with REST Controller

<img src="restController.JPG" alt="alt text" width="500"/>

1. Annotation for class adds support for **REST**

- We can query this **URL** with many ways

<img src="webBrowserVsPostman.JPG" alt="alt text" width="500"/>

- **RestController** in Java

```

package com.luv2code.
demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
}

```

<img src="restControllerWorkign.JPG" alt="alt text" width="600"/>

### Spring Boot REST POJO 

<img src="javaJsonDataBinding.JPG" alt="alt text" width="600"/>

1. Other terms used 

- **Jackson Project** is used behind the scenes

- Jackson takes care data binding between JSON and Java POJO

<img src="JacksonDatabinding.JPG" alt="alt text" width="600"/>

1. We define getters/setters for **conversion** to **POJO** → **JSON** and other way around. Jackson can help this one out!

- Jackson calls `setXXX` method when setting up **POJO**

<img src="JSONtoJavaPOJO.JPG" alt="alt text" width="600"/>

1. Name from JSON, is used to call set in **POJO**
2. Jackson calls setter methods

<img src="POJOtoJSON.JPG" alt="alt text" width="600"/>

1. Getter methods are called

<img src="springAndJacksonSupport.JPG" alt="alt text" width="600"/>

<br>

<img src="willBeWritingSuchRestService.JPG" alt="alt text" width="600"/>

- We will pass `<List>Students`

<img src="creatingRestClient.JPG" alt="alt text" width="600"/>

1. List will be automatically converted to **JSON array**

<img src="restControllerWorkingWithJackson.JPG" alt="alt text" width="600"/>

### Spring Boot REST - Path Variables

<img src="pathVariable.JPG" alt="alt text" width="600"/>

1. For parametrizing path variable. Will be in **URL**

<img src="addingRequestMapping.JPG" alt="alt text" width="600"/>

1. `@PathVariables` **binds** to **method parameter** from incoming URL variable. Needs to be same name!
2. Gets since student and **Jackson** converts this one to JSON!

- We can use `@PostConstruct` for initializing data for bean. Is **processed** after bean have been loaded

```
	@PostConstruct
	public void loadData()
	{
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
		
	}
```

<img src="pathVariableWorking.JPG" alt="alt text" width="600"/>

### Spring Boot REST Exception Handling

<img src="sendingBackException.JPG" alt="alt text" width="500"/>

1. We want to send back exception inside response as JSON

<img src="processForMakingThis.JPG" alt="alt text" width="500"/>

1. We are making JAVA(POJO) for custom error response

2. We are making our own custom exception

<img src="step3.JPG" alt="alt text" width="500"/>

4. Step for whose taking care of exception and returning exception back to client

<img src="step4.JPG" alt="alt text" width="500"/>

<br>

<img src="addingStep4.JPG" alt="alt text" width="500"/>

1. We are making our own POJO class

- To catch exception we write

<img src="catchingExceptions.JPG" alt="alt text" width="500"/>

<br>

<img src="exceptionHandlingWorking.JPG" alt="alt text" width="500"/>

- After implementing our exception handling exception mechanism we did not cover all edge cases. The error we countered such error message 

`2023-10-29T13:23:44.486+02:00  WARN 3852 --- [io-8080-exec-10] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'int'; For input string: "sdasdasds"]`

- **Bad Request**. To fix this we can do one of two things:
	- Make **generic exception handler**, catch all exception
	- Or cover all **edge cases**


- Example writing Exception Handler for per **RestController** 

```
	// Catch all exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(Exception exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
```

<img src="jsonExceptionReturned.JPG" alt="alt text" width="500"/>

###  Spring Boot REST Global Exception Handling

<br>

- We can write **global** exception handlers, and they are kinda recommended.

<img src="globalExceptionHandler.JPG" alt="alt text" width="500"/>

<br>

<img src="SpringControllerAdvice.JPG" alt="alt text" width="500"/>

- We can `@ControllerAdvice` annotation

<img src="globarExceptionHandling.JPG" alt="alt text" width="500"/>

1. Here we will handle all global exception in this controller `@ControllerAdvice`
- We don't need to make exception handling REST specific. This can be used from **global controller** advice handler.

- We want following mechanism. **Full CRUD**
	- Get a list of employees (GET)
	- Get a single employee by id (GET)
	- Add a new employee (POST)
	- Update an employee (PUT)
	- Delete an employee (DELETE)

<img src="namingRestInterface.JPG" alt="alt text" width="500"/>

1. Since name "employee" is often present, we will use such naming


### REST ANTI-PATTERNS

<img src="antiPattern.JPG" alt="alt text" width="500"/>

- Use HTTP verbs for REST API names 

- SQL Script for database setting for CRUD application

```
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');
```

- We are adding `Employee Service`
	-  Between DAO and REST controller

<img src="weAreAddingServiceLayer.JPG" alt="alt text" width="500"/>

<br>

<img src="serviceLayer.JPG" alt="alt text" width="500"/>

<br>

<img src="integratingMultipleDataSource.JPG" alt="alt text" width="500"/>

1. Pulling data from multiple sources
2. Providing **Rest Controller** single view as Service from multiple data sources

- We want to pull data from many sources

<img src="BestPracticeArhitecture.JPG" alt="alt text" width="500"/>

1. Even if you have one DAO its recommended separating **Service** and **DAO** for future **architecture**.

<img src="serviceTag.JPG" alt="alt text" width="500"/>

1. Old ones
2. `@Service` is new one

- `@Service` enables component scanning

- Same as using **service** approach

```
package com.luv2code.springboot.cruddemo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
}

```

### Best practices using service layer

<img src="serviceLayerBestPractives.JPG" alt="alt text" width="500"/>

1. Transactions are refactored to service layer

<img src="performingMerge.JPG" alt="alt text" width="500"/>

1. `.merge` operation performs update or modifying depending on ID.
	- If not equal to 0, perform update other perform insert
2. In case of update its important return updated object.

- We want `@Transactional` refactored to **service layer**



<img src="delettingDao.JPG" alt="alt text" width="500"/>
