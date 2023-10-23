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


- RestController in Java

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

2:00