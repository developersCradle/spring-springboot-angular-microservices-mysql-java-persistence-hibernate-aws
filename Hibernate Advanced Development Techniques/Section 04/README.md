# Section 04: Mapping Components - Embeddable.

Mapping Components - Embeddable.

# What I Learned.

# Embeddable Overview.

<img src="refresherOnTheHibernateTypes.PNG"  alt="hibernate course" width="600"/>

1. **Hibernate** has **two main** types:
    - **Value**.
    - **Entity**.
2. **Value** types have **no identity** nor the own **lifecycle**.
**Entity** has **unique identifier**.

- Todo copy here.

<img src="categoriesOfValueTypes.PNG"  alt="hibernate course" width="500"/>
	
1. **Basic type**: `String`, `Integer`, `Double`, `Boolean`, `Date`, etc ...

2. **Embedded type**: `Address`, `PhoneNumber` (any custom object).

3. **Collections**: `Set`, `List`, `Map`, etc ... We used this earlier with `@ElementCollection`.

<img src="embeddedValueType.PNG"  alt="hibernate course" width="500"/>

1. This **encourages**, for multiple uses inside other objects.	

<img src="useCasesForEmbeddedValueTypes.PNG"  alt="hibernate course" width="500"/>

1. This will be **Address** will be composition of `street`, `city`, `zip code`. These fields will be same in the **database**!

<img src="databseDiagram.PNG"  alt="hibernate course" width="500"/>

1. These will be included as we previously mentioned : `street`, `city`, `zip code`.
    - We can **re-use** in multiple tables!

<img src="umlDiagram.PNG"  alt="hibernate course" width="500"/>

<img src="devProcess.PNG"  alt="hibernate course" width="500"/>

<img src="step1.PNG"  alt="hibernate course" width="500"/>

<img src="annotationsForEmbeddable.PNG"  alt="hibernate course" width="500"/>

1. `@Embeddable` For identifying, that this is **Embeddable value type**. Example of `Adress`.
2. For referencing this, we use `@Embedded`.

<img src="step2.PNG"  alt="hibernate course" width="500"/>

<img src="step3.PNG"  alt="hibernate course" width="500"/>

1. We have The `@Embedded private Address homeAddress;` in the `Student`.

<img src="step3SecondDia.PNG"  alt="hibernate course" width="500"/>

1. Table `student` will have these fields included. 

<img src="step4.PNG"  alt="hibernate course" width="500"/>

<img src="runningTheApp.PNG"  alt="hibernate course" width="500"/>

1. The new field will be logged.

# Embeddable - Develop an Embedded Component.