# Section 02: Understanding object/relational persistence.

Understanding object/relational persistence.

# What I Learned.

# 2. Object Relational Impedance Mismatch.

<img src="objMismatchAndRelationalDb.PNG"  alt="alt text" width="600"/>

1. This will represent **OOP**.
    - One of OOP language is **Java** language.
        - These will have interconnected relations objects.
2. This will represent the **Database relational model**.
    - Like in **table** format.

- There will be different relations with **Object Relational** and **Relational database**!

3. Since these models are **different**, these will have **mismatch** of **relationship**.
    - We will call this `Object Relational Impedance Mismatch`. **(Paradigm Mismatch)**

> [!IMPORTANT]
> We can say this, **Object Model** and **Relational Model** do not work very well together.

<img src="granularity.PNG"  alt="alt text" width="600"/>

1. First mismatch is **Granularity** mismatch.
2. One can think this as **system** can be broke down into **smaller pieces**.
3. **Person** can be broken down into smaller pieces: 
    - **Address**.
    - **Order**.
    - **Billing Details**.

<img src="granularityContd.PNG"  alt="alt text" width="600"/>

1. In **Object Model** we can have **various level** **granularity**.
    - In **Relational Model** this is restricted to **two level**
        - `Tables`.
        - `Columns`.

- This means sometimes, there will be more **Object Model** classes than the **Database Model**
    - Meaning more `Java Classes` than `Relational Model Tables`.
2. Two **Java classes**.
3. Only **One** Table in database.