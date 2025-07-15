# Section 04: Mapping Components - Embeddable.

Mapping Components - Embeddable.

# What I Learned.

# 20. Embeddable Overview.

<img src="refresherOnTheHibernateTypes.PNG"  alt="hibernate course" width="400"/>

1. **Hibernate** has two main types:
    - **Value**.
    - **Entity**.
2. **Value** types have **no identity**.
**Entity** has **unique identifier**.

<img src="categoriesOfValueTypes.PNG"  alt="hibernate course" width="400"/>
	
1. **Basic type**: `String`, `Integer`, `Double`, `Boolean`, `Date`, etc ...

2. **Embedded type**: `Address`, `PhoneNumber` (any custom object).

3. **Collections**: `Set`, `List`, `Map`, etc ... We used this earlier with `@ElementCollection`.