# Section 03: Mapping Collections - Maps, Sorted Maps and Sorted Sets.

Mapping Collections - Maps, Sorted Maps and Sorted Sets.

# What I Learned.

# Maps - Overview.

> **Map**
>   Object that maps unique **keys** to **values**.
>   Cannot contain **duplicates**.
>   **Key** is used to store values and retrieving values.

<img src="useForTheMaps.PNG"  alt="hibernate course" width="500"/>

1. insert examples here.s
2. Example of using **maps**, there will be **keys** mapped to **value**.
3. When you want access using **key** rather than using **integer** index.

<img src="studentAndImages.PNG"  alt="hibernate course" width="500"/>

1. We will have **map** that maps to **images**.
2. Map **keys cannot** have **duplicates**!

<img src="dbDiagram.PNG"  alt="hibernate course" width="500"/>

<img src="step1.PNG"  alt="hibernate course" width="500"/>

<img src="step2.PNG"  alt="hibernate course" width="500"/>

<img src="annotationForTheMaps.PNG"  alt="hibernate course" width="500"/>

1. `@MapKeyColumn` for mapping
    - For the given **key** in map, mapped into the database.

- Example of usage for the **map**.


```
@Entity
public class Department {
    @Id
    private Long id;

    private String name;

    @ElementCollection
    @MapKeyColumn(name = "employee_name") // this column stores the map's keys
    @Column(name = "employee_salary")     // this column stores the map's values
    @CollectionTable(name = "department_employees", 
                     joinColumns = @JoinColumn(name = "department_id"))
    private Map<String, Integer> employees = new HashMap<>();
}
```

- This maps the **map** key to the database column `department_id`.

| `department_id` | `employee_name` | `employee_salary` |
|---------------|----------------|-----------------|
| 1             | Alice          | 90000           |
| 1             | Bob            | 95000           |
| 2             | Charlie        | 70000           |

<img src="MakingMapTable.PNG"  alt="hibernate course" width="500"/>

1. **Maps** the **key** of the **map** for given column in the database. `@MapKeyColumn(name="file_name")`
2. The database column where the mapped value will be. In this example `image_name`.

<img src="step3Coding.PNG"  alt="hibernate course" width="500"/>

<img src="runningTheApp.PNG"  alt="hibernate course" width="500"/>

1. Like in the code, we will map **one** value for the **three** images in database.

# Maps - Write Some Code.