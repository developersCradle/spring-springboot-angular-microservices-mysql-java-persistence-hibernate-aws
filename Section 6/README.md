# Section 6: NEW - Spring MVC

NEW - Spring MVC

# What I Learned


<img src="thymeleaf.jpg"  alt="alt text" width="500"/>

- Templating engine, more information [Thymeleaf](www.thymeleaf.org)

- **Thymeleaf** separated project, but shares a lot of synergy with Spring

# What is Thymeleaf template?

- Can be HTML page with **Thymeleaf** expressions
    - These can access HTML code, java code, Beans
    
<img src="templateThymeleaf.jpg"  alt="alt text" width="500"/>

1. Web Browser makes request, it goes to **Spring MVC Controller**
2. Controller adds data to model
3. Template sends back HMTL

<img src="developingSpringMVC.jpg"  alt="alt text" width="500"/>

1. When **Thymeleaf** is configured, Spring will automatically look for template with corresponding name

- In Spring Boot **Thymeleaf** templates go into `src/main/resources/templates`
    - For web apps, **Thymeleaf** uses `.html` extension

<img src="Thymelef template.jpg"  alt="alt text" width="500"/>

- HTML page will be having **Thymeleaf** namespace
    - Elements referring to he **Thymeleaf** will be having same namespace `th:element here`
- Spring will access `theDate` from Spring model and use it

- [Thymeleaf](www.thymeleaf.org)

- Example making use of **Thymeleaf**
## helloworld.html

- **Thymeleaf** uses `${theDate}` to be pick attribute form the model

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

		model.addAttribute("theDate", new java.util.Date()); //Addint to model, for later to be processed 
		
		return "helloworld";//Spring will automatically look for "helloworld.html" template
		
	}
}

```