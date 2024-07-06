# Section 6: Microservices with Spring Cloud - V2

Microservices with Spring Cloud - V2

# What I Learned

# 132. What's NEW in V2?

 <img src="v2.PNG" alt="Course here" width="600"/>

- We will be using **Spring Cloud LoadBalancer** instead of **Ribbon**.

- We will be using **Spring Cloud Gateway** instead of **Zuul**.

- We will be using **Resilience4j** instead of **Hystrix**.

- Its important to standardize ports for microservice.

 <img src="portStandardization.PNG" alt="Course here" width="600"/>

# 133. RECOMMENDED: Use Latest Spring Boot Version

- ✅

# 134. Have you already completed V1?

- ✅

# 135. Course Downloads

- ✅

# 136. Step 01 - Setting up Limits Microservice - V2

 <img src="planMicroservice.PNG" alt="Course here" width="600"/>

 1. We create **Microservice**, which is connected to **Spring Cloud Config Server**.

 - When creating **Microservices** for Spring Cloud.
    - Name the project whiteout any whitespace:s.

- We are using config server for microservice. This needs to be configured in .properties `spring.config.import=optional:configserver:http://localhost:8888`

# 137. CODE BACKUP FILES and STEP BY STEP CHANGES : For Reference

- ✅

# 138. Step 02 - Creating a hard coded limits service - V2

- Here we write simple microservice.

# 139. Step 03 - Enhance limits service - Get configuration from application props - V2

- Rather than passing configuraration values in code, we can create configuration, which handles these process. Example of old way below

```
@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(1,1000);
	}
```

- We can auto inject/or map the **configuration values** using `@ConfigurationProperties("limits-service")`. Where input is **service name**. Workign example below:



# Java files
```
package com.in28minutes.microservices.limit_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limit_service.bean.Limits;
import com.in28minutes.microservices.limit_service.configuration.Configuration;

@RestController
public class LimitsController {

	
	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
		//		return new Limits(1,1000);
	}
	
}
```

```
package com.in28minutes.microservices.limit_service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	private int minimum;
	private int maximum;
	
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
```

## configuration file
```
limits-service-minimum=2
limits-service-maximum=998
```

- This is picked by **Spring**.

 <img src="pickedByMicroservice.PNG" alt="Course here" width="600"/>

# 140. Step 04 - Setting up Spring Cloud Config Server - V2

- **Config Server** from **Spring initializer**.

- Other microservice practice is to give good name for services. `spring.application.name=spring-cloud-config-server`.

# 141. Step 05 - Installing Git and Creating Local Git Repository - V2

- Creating local git repo with property file `limits-service.properties`.

# 142. Debugging problems with Spring Cloud Config Server - V2

- ✅

# 143. Step 06 - Connect Spring Cloud Config Server to Local Git Repository - V2