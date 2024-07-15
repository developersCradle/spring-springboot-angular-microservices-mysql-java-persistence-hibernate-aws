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

 <img src="planMicroservice.PNG" alt="Course here" width="600"/>

<br>

- We need to use `@EnableConfigServer` for config server in spring boot. Below example.

```
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}

```


- We need to save configure folder where our Git Repo is in.

 <img src="windowsProperties.PNG" alt="Course here" width="600"/>

- Below my example fo mine configuration

## application.properties

```
spring.application.name=spring-cloud-config-server
server.port=8888
spring.cloud.config.server.git.uri=file://C:/Users/heikki/Desktop/Git projektit/spring-springboot-angular-microservices-mysql-java-persistence-hibernate/MasterMicroservicesWithSpringBootandSpringCloud/Section 6/git-localconfig-repo

```

- `spring.cloud.config.server.git.uri` where points where local configs server in locating in.

- Now to look if **Spring Cloud** have picked up the configuration from **git local config file**. We can navigate to config file for microservice.

<img src="nameOfMicroService.PNG" alt="Course here" width="400"/>

1. URL name have name of microservice config property first part.

- **URL** for this **microservice** config is `http://localhost:8888/limits-service/default`.

- Below example config picked by **Spring Config Server**.

 <img src="configPickedByCloudConfig.PNG" alt="Course here" width="600"/>

1. As you can see, **minimum** and **maximum** is picked up.
2. You can see what **profile** is being loaded.

# 144. Step 07 - Connect Limits Service to Spring Cloud Config Server - V2

- Property values should match for configured one, in **limit-service**  `spring.application.name=limits-service` and name of service inside **Git repo**.

<img src="theseAreConnected.PNG" alt="Course here" width="400"/>

1. We connected all of these.

- As you can see **git config repo** is being prioritized over **local configuration**.  

# 145. What should I do when I face a challenge

- Try harder.
- Use chatGBT, just for asking lead.
- Ask questions.

# 146. Step 08 - Configuring Profiles for Limits Service - V2

<img src="differentEnveriomentConfigurations.PNG" alt="Course here" width="400"/>

1. How to save different configurations for **microservice** for different environment.

- We just write different `limits-service-dev.properties` and `limits-service-qa.properties`. Then we go for URL `http://localhost:8888/limits-service/qa`. For example **qa** environment.

# 147.


# 148. Step 09 - Introduction to Currency Conversion & Exchange Microservices - V2

- We are going to make two microservice and they talk each other.

<img src="weAreGoingToMakeSuchMicroServices.PNG" alt="Course here" width="400"/>

<br>

<img src="micro1.PNG" alt="Course here" width="400"/>

1. What is the conversion rate between these two?

- In here one **USD** is 65 **INR**.

<img src="micro2.PNG" alt="Course here" width="400"/>

1. 65 is multiplied by 10 is total 650. **USD** to **INR** **ten** units.
2. **Currency conversion microservice** is asking **Currency exchange microservice** about the **rate**.

# 149. Step 09 - Introduction to Currency Conversion & Exchange Microservices - V2

### Configurations for currency-exchange

```
spring.application.name=currency-exchange
server.port=8080
spring.config.import=optional:configserver:http://localhost:8888
```

# 150. URL and Response Structure for Currency Exchange Service

- We will make following.

### URL

`http://localhost:8000/currency-exchange/from/USD/to/INR`

### Response Structure

```
{
   "id":10001,
   "from":"USD",
   "to":"INR",
   "conversionMultiple":65.00,
   "environment":"8000 instance-id"
}
```

# 151. Step 11 - Create a simple hard coded currency exchange service - V2

- We made basic microservice.

```
@RestController
public class CurrencyExchangeController {

	@GetMapping("/currency-conversion/from/{from}/to/{to}")
	public CurrencyExchange retrieveExhangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		
		return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		
	}
}

```

# 152. Step 12 - Setting up Dynamic Port in the the Response - V2

```
@Autowired
private Environment environment;

String port = environment.getProperty("local.server.port");
```

- Making two instances of this running.

<img src="configuringTwoMicroServicesOnEclipse.PNG" alt="Course here" width="700"/>

1. To make **duplicate** configurations, right click and click **duplicate**.

- To make running config for other port in **Eclipse**. We write following into **VM args** `-Dserver.port=8001`. These will override configures provided by `.properties` file. 

# 153. Step 13 - Configure JPA and Initialized Data - V2

<img src="naming.PNG" alt="Course here" width="600"/>

1. In **databases** underscores are use to!
2. In Java we tend to use **Camel case**.

- `data.sql` should inside **resources** folder. `/currency-exchange-service/src/main/resources/data.sql` for initialization.
	- OR use schema.sql instead of data.sql
### data.sql

```
insert into currency_exchange
(id,currency_from,currency_to,conversion_multiple,environment)
values(10001,'USD','INR',65,'');
insert into currency_exchange
(id,currency_from,currency_to,conversion_multiple,environment)
values(10002,'EUR','INR',75,'');
insert into currency_exchange
(id,currency_from,currency_to,conversion_multiple,environment)
values(10003,'AUD','INR',25,'');
```

- Data ins inserted **before** tables are created. This was updated **Spring Boot 2.4+**. This can be configured with `spring.jpa.defer-datasource-initialization=true` for inserting after table creation.

### application.properties

```
spring.application.name=currency-exchange
server.port=8000
spring.config.import=optional:configserver:http://localhost:8888


spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
 
# For >2.5.0
spring.jpa.defer-datasource-initialization=true
```

# 154. CODE BACKUP FILES and STEP BY STEP CHANGES : For Reference

 - ✅

 # 155. Step 14 - Create a JPA Repository - V2

- Spring DATA will convect these into SQL notation behind scenes. 

```

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}

```

- And our Rest Controller. `String port = environment.getProperty("local.server.port");` pics **port** from our configurations. 

```

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}")
	public CurrencyExchange retrieveExhangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(port);
		
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to );
		}
		
		return currencyExchange;
		
	}
}
```

# 156. How to take care of yourselves

- Sleep & eat & walk.

# 157. Step 15 - Setting up Currency Conversion Microservice - V2

- We setting up ``currency-conversion` service.

# 158. URL and Response Structure for Currency Conversion Service



### URL 

```
http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
```
### Response Structure

```
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.00,
  "quantity": 10,
  "totalCalculatedAmount": 650.00,
  "environment": "8000 instance-id"
}
```

# 159. Step 16 - Creating a service for currency conversion - V2

- We create controller.

```
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		return new CurrencyConversion(10001L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
		}
```

# 160. Step 17 - Invoking Currency Exchange from Currency Conversion Microservice - V2

<img src="callingMicroserviceFromOtherMicroservice.PNG" alt="Course here" width="400"/>

1. Calling other **microservice** from other **microservice**.

- To make **simple** REST api call, we need configure much attributes. This is using **RestTemplate** to make REST calls.

- More tedious example below.
	- 
```
@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		System.out.println("currency-conversion");
		
		// .getForEntity() we want get entity back
		// CurrencyConversion.class to what class we want to our class to convert
		// for mapping both JSON and Mapped class needs to be in same order.
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity
		("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		
```

# 161. Step 18 - Using Feign REST Client for Service Invocation - V2

- To make **less code when** calling, we can use **Feign** from **Spring Cloud**.

- To talk other class we need create **Proxy interface**.
	- This interface `@FeignClient(name = "currency-exchange", url = "localhost:8000")`
		- **name** is name of service inside the property file.
		- **url** is the base URL.

- To use such, we need annotate main **SpringApp** with `@EnableFeignClients` and import following from cloud.
```
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```


```
// name is usually service name
// url should be local url

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
}
```

- and following implementation will be used:
	- Now, we just call `CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);` proxy services.

```
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
				
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment() + " " + "feign"); // coming from feign
		
	}
```

# 162. Step 19 - Understand Naming Server and Setting up Eureka Naming Server - V2

<img src="serviceNamingRegistery.PNG" alt="Course here" width="700"/>

1. All the **Microservices** needs to register to **Naming Server** or **Service Registry**