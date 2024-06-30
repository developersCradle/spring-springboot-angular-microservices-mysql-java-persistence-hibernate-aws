# Section 6: NEW - Spring MVC

NEW - Spring MVC.

# What I Learned

# 160. Spring Boot - Spring MVC with Thymeleaf - Overview

<img src="thymeleaf.jpg"  alt="alt text" width="500"/>

- Templating engine, more information [Thymeleaf](www.thymeleaf.org).

- **Thymeleaf** separated project, but shares a lot of synergy with Spring.

# What is Thymeleaf template?

- Can be HTML page with **Thymeleaf** expressions.
    - These can access HTML code, java code, Beans.
    
<img src="templateThymeleaf.jpg"  alt="alt text" width="500"/>

1. Web Browser makes request, it goes to **Spring MVC Controller**.
2. Controller adds data to model.
3. Template sends back HTML.

<img src="addingThymeLeaf.JPG"  alt="alt text" width="500"/>

- Adding Thymeleaf to POM. 

<img src="developingSpringMVC.jpg"  alt="alt text" width="500"/>

1. When **Thymeleaf** is configured, Spring will automatically look for template with corresponding name.

- In Spring Boot **Thymeleaf** templates go into `src/main/resources/templates`.
    - For web apps, **Thymeleaf** uses `.html` extension.

<img src="Thymelef template.jpg"  alt="alt text" width="500"/>

- HTML page will be having **Thymeleaf** namespace.
    - Elements referring to he **Thymeleaf** will be having same namespace `th:element here`.
- Spring will access `theDate` from Spring model and use it.

- Thymeleaf support other features:
  - Lopping and conditionals.
  - CSS and JavaScript integration.
  - Template layouts and fragments.
    - More here [Thymeleaf](www.thymeleaf.org).


# 161. Spring Boot - Spring MVC with Thymeleaf - Coding - Part 1

- We are importing **Thymeleaf** for POM file.

```
<dependency>
  <groupId>org.thymeleaf</groupId>
  <artifactId>thymeleaf</artifactId>
  <version>3.1.2.RELEASE</version>
</dependency>
```

# 162. Spring Boot - Spring MVC with Thymeleaf - Coding - Part 2


- Example making use of **Thymeleaf**.


## helloworld.html

- **Thymeleaf** uses `${theDate}` to be pick attribute form the model.

```

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

  <head>
    <title>Thymes Demo</title>
  </head>

  <body>
  
   		<p th:text="'Time on the server is ' + ${theDate}"> /p>
  
  </body>

</html>

```

### DemoController.java

```

@Controller
public class DemoController {
	
	@GetMapping("/hello")
	public String sayHello(Model model) {

		model.addAttribute("theDate", new java.util.Date()); //Adding to model, for later to be processed 
		
		return "helloworld";//Spring will automatically look for "helloworld.html" template
		
	}
}

```

- We can see rendered in realtime.

<img src="thymeLeafInRealTime.JPG"  alt="alt text" width="500"/>

# 163. Spring Boot - Spring MVC with Thymeleaf and CSS - Overview

- Using CSS with **Thymeleaf**.

<img src="usingCssInThymeleaf.JPG"  alt="alt text" width="500"/>

1. There is two ways to apply css for this resource.

<img src="createCSSinStaticResource.JPG
"  alt="alt text" width="500"/>

1. Naming of folders does not matter if your under static. 

<img src="referencingInCSS.JPG"  alt="alt text" width="500"/>

1. We are referring in css.

- **@** symbol referencing context path of your application. This references **app root**.

- There is other paths for finding resource.
  - Default is from **top-down** in following order.

<img src="OtherSearchDirectories.JPG"  alt="alt text" width="500"/>

1. Most common place to store resources. 

<br>

- We can reference in following way using **Bootstrap**.

<img src="referencingCSSBootstarp.JPG"  alt="alt text" width="500"/>

- Or we can reference **Bootstrap** which is in internet.

<img src="referencingCSSBootstarpInNetwork.JPG"  alt="alt text" width="500"/>

# 164. Spring Boot - Spring MVC with Thymeleaf and CSS - Coding
 
- Attaching css for **Thymeleaf**.

```
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

  <head>
    <title>Thymeleaf Demo</title>
  
    <link rel="stylesheet"
          th:href="@{/css/demo.css}" />
          
  
  </head>

  <body>
  
   		<p th:text="'Time on the server is ' + ${theDate}" class="funny" />
  
  </body>

</html>
```

<img src="cssWorking.JPG"  alt="alt text" width="500"/>

# 165. Spring Boot - Spring MVC Behind the Scenes

<img src="behindScenes.JPG"  alt="alt text" width="500"/>

1. It collection of UI components.
2. Collection of Spring beans.
3. You can configure **Spring** in three ways:
  - XML.
  - Annotations.
  - Java.

- In big look, Spring mvc works like such.

<img src="springMVCworking.JPG"  alt="alt text" width="500"/>

<br>

<img src="springMVCworkingFrontController.JPG"  alt="alt text" width="500"/>

1. **You** develop these ones!
2. Front Controller has **DispatcherServlet** implemented. This is inside Spring `.jar` file.
  - This one delegates requests to other object in the system.

- **Business logic** is usually inside Controller.