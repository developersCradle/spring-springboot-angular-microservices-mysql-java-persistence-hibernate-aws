# Section 2: NEW - Spring Boot 3 - Inversion of Control and Dependency Injection

Spring Boot 3 - Inversion of Control and Dependency Injection

# What I Learned

- **IoC** Inversion of Control (IoC)

> The approach of outsourcing the construction and management of objects.

- Why we would need this?

<img src="whyWouldnNeedInversionOfControll.JPG" alt="alt text" width="500"/>

1. We could easily change sport to our implementation with **IoC**

- In ideal solution:

<img src="idealSolution.JPG" alt="alt text" width="500"/>

1. Object Factory would return specific object based on configuration **2.**

- Spring Container work like "object factory" 

<img src="SpringContainers2Responsibilities.JPG" alt="alt text" width="500"/>

- There are two main responsibilities for **Spring Container**

- There are **three** main ways to configure Spring Container
1. XML configuration file **(LEGACY)!** ❌
2. Java Annotations **(Modern)** ✔️
3. Java Source Code **(Modern)** ✔️

> **Dependency Injection**
> The dependency inversion principle.
> 
> The Client delegates to another object
> the responsibility of providing its 
> dependencies.

<img src="carFactory.jpg" alt="alt text" width="500"/>

1. Car Object is wanted
2. In background **Car Factory** needs to build and return Car Object
    - Decency injection idea is to give us **full/complete** object. Do what you need to do, use helper classes/services/components

<img src="demoOfInjection.jpg" alt="alt text" width="500"/>

1. We want to **inject** the coach into **DemoController**


### Injection Types

- There is many injection types in **Spring**
- We will use two most recommended ones
1. **Constructor Injection**
2. **Setter Injection**

<img src="injectionTypes.jpg" alt="alt text" width="500"/>

- While **Constructor Injection** is preferred one

1. If decencies are not provided this is OK to use

<img src="autoWired.jpg" alt="alt text" width="500"/>

<br>

<img src="autoWiredExample.jpg" alt="alt text" width="500"/>

1. Spring scans classes with `@Components`

- To demonstrate this we are going to do this

<img src="exampleApplication.jpg" alt="alt text" width="500"/>

<br>

<img src="step1DefineDepency.jpg" alt="alt text" width="600"/>

- `@Compenent` marks class as a Spring Bean

#### Step 1: @Component annotation

>**@Component** marks the class as a Spring Bean
> A Spring Bean is just a regular Java class that is managed by Spring
> @Component also makes the bean available for dependency injection

<br>

<img src="step2CreateDemo.jpg" alt="alt text" width="600"/>

<br>

<img src="step3CreateConstructor.jpg" alt="alt text" width="600"/>

<br>

<img src="step4GetMapping.jpg" alt="alt text" width="600"/>
