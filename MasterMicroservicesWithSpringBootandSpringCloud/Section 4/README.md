# Section 4:  Quick Introduction to Microservices

 Quick Introduction to Microservices

# What I Learned

# 68. Section Introduction - Microservices with Spring Cloud

 - Git [Microservices](https://github.com/in28minutes/spring-microservices-v3/tree/main/03.microservices)

 # 69. Step 00 - 01 - Introduction to Microservices

 - Microservices definitions.
  
> Small autonomous services that works together.

 <img src="microservices.PNG" alt="Jpa Course here" width="700"/>

 <br>

 <img src="microservicesDefinations.PNG" alt="Jpa Course here" width="700"/>

1. These are deployable by **REST**.
2. Theses are small and deployable units.
3. Cloud enabled.

 <img src="microservicesBehindEachOther.PNG" alt="Jpa Course here" width="700"/>

 1. When **microservices** are build such, they are in monolithic architecture.

- When **microservices** are cloud enabled, they are deployed as following.

<img src="microservicesCloudEnabled.PNG" alt="Jpa Course here" width="700"/>

1. Microservice1 has two instances **A1** and **A2** on.
2. Microservice2 has **B1**, **B2**, **B3** and **B4** on. 
3. Microservice3 has **C1**.

- These can be run up when more load comes to server. These should not have much configuration.

# 70. Step 00 - 02 - Challenges with Microservices

### Bounded Context

<img src="boundedContext.PNG" alt="some" width="700"/>

1. When there is lot of **microservices**, how you spot **where to draw line** between microservices.
    - You may not have right **business logic** to understand separation.
    - **ANSWER** This is based on experience.

### Configuration Management

<img src="configurationManagement.PNG" alt="some" width="700"/>

- These have much of configurations to manage. All the servers and deployments.

### Dynamic scale up and scale down

<img src="microservicesScalingUpAndDown.PNG" alt="some" width="700"/>

1. When needed, need to bring **Microservice2** up or down based on need and with dynamic load balancing load between these one.

### Visibility

<img src="boundedContext.PNG" alt="some" width="700"/>

1. If there is bug in this **microservice**, how to identify this one.
    - We need centralized clock.
    - We need monitoring around microservices.

### PACK OF CARDS

- There should be well designed architecture in microservices. They can collapse as **pack of cards**.
    - These need to be **fault tolerant**.


# 71. Step 00 - 03 - Introduction to Spring Cloud

- There is multiple projects under **SPRING CLOUD**.
    - You can see these [on](https://spring.io/projects/spring-cloud#overview).

<img src="configurationStored.PNG" alt="some" width="700"/>

1. **Spring Cloud Config Server** in GIT. Can be used to hold configurations in place.