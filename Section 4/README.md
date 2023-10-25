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

1:30