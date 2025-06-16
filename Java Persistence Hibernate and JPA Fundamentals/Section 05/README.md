# Section 05: Getting Started with JPA.

Getting Started with JPA.

# What I Learned.

# What is JPA.

<img src="whatIsJpa.PNG"  alt="hibernate course" width="600"/>

1. **JPA** is just **specification** that frameworks tries to implement, to called **JPA compatible**.
2. **Hibernate** is object relational mapping framework. Hibernate provides **both** `interface` and `implementation`.
3. **JPA** provides interfaces, but **NO** implementation.
4. Any framework, who implements **JPA** is **JPA provider**.
    - **Hibernate** is one of such! So **Hibernate** has two ways to call framework related things:
        - **Hibernates API**.
        - **Hibernates JPA implementation API**.

<img src="JPAandHibernate.PNG"  alt="hibernate course" width="600"/>

1. There are multiple **non JPA** things in **Hibernate** that are quite useful!
2. We can get ultimate usefulness of the **Hibernate** using `unwrap()`.

<img src="whyUseJPA.PNG"  alt="hibernate course" width="600"/>

- You could ask yourself what is the role of **JPA** if to **hibernate** provides all the functions?
    - If you **JPA** as interface provider, you could easily change to another vendor!

1. These vendors cans be seen here!


# Hibernate as JPA Provider.