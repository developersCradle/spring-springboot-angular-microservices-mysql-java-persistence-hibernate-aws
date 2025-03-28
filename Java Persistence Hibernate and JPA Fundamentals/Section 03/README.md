# Section 3: Getting Started with Hibernate and JPA Annotations.

Getting Started with Hibernate and JPA Annotations.

# What I Learned.

# 8. What is Hibernate.

<img src="hibernate.PNG"  alt="alt text" width="500"/>

1. This mapping shit will be solved by **Hibernate**.
    - Idea is that Java developers, are using **POJOS** rather than **SQL** language to persist objects.

- If **Object Mode** mapping is done correctly. We don't need to use low level languages or JDBC at all.

- **Hibernate** handles the 5 different mismatch problems.

# 9. Hello World with Hibernate and JPA Annotations.

<img src="helloWorldWithHibernate.PNG"  alt="alt text" width="500"/>

1. We are going create **Java object** into memory and persist it with **Hibernate**.
    - **Primary Key** get auto-generated for us.
    - `ID` will be mapped to `id` in POJO.
    - `TEXT` will be mapped to `text` in POJO.

<img src="session.PNG"  alt="alt text" width="500"/>

1. We are using **Session** object to **persist** Message POJO to `Message Table` 

<img src="configuringSession.PNG"  alt="alt text" width="500"/>

1. `Session` object is build by `SessionFactory` from configuration.
2. Configuration for hibernate to connect to database.
3. Tells hibernate to optimize SQL for specific database.