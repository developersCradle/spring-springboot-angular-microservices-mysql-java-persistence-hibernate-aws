# Section 13: N+1 SELECTs Problem, Batch Fetching and Entity Graphs.

N+1 SELECT's Problem, Batch Fetching and Entity Graphs.

# Learned what the N+1 Selects Problem is and why it causes unnecessary database queries and performance issues.

<div align="center">
    <img src="HIbernate_N_Plus_One_Problem.PNG"  alt="Hibernate Java Persistence!" width="700"/>
</div>

1. We will be covering the `n+1` problem. This is **very common** problem in the database field!
    - We will be having the following **data** inside the **table**!

### **student** table.

| id | enrollment_id | name       | guide_id |
|----|---------------|------------|----------|
| 1  | 2014AL50456   | Amy Gill   | 2        |
| 2  | 2014JT50123   | John Smith | 2        |
| 3  | 2014BE50789   | Bruce Lee  | NULL     |

### **guide** table.

| id | name         | salary | staff_id   |
|----|--------------|--------|------------|
| 1  | Mike Lawson  | 1000   | 2000MO10789 |
| 2  | Ian Lamb     | 2000   | 2000IM10901 |


<div align="center">
    <img src="Student_And_Guide.PNG"  alt="Hibernate Java Persistence!" width="600"/>
</div>

1. We have **one-to-many** relation shit!

<div align="center">
    <img src="N_Plus_One_Problem_Cleint_Code.PNG"  alt="Hibernate Java Persistence!" width="600"/>
</div>

1. We will be having following **client** code:
    ````Java
    package client;

    import java.util.List;
    import javax.persistence.*;

    import entity.Guide;
    import entity.Student;

    public class HelloWorldClient {

        public static void main(String[] args) {

            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("hello-world");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Guide guide = new Guide("2000DO10777", "David Crow", 3000);
            Student student = new Student("2014RG50347", "Rahul Singh");

            guide.addStudent(student);
            em.persist(guide);

            em.getTransaction().commit();
            em.close();
        }
    }
    ````
2. We associate the **student** is added to the **guide**! 
    - At `.perisist(...)`, we have the **Guide** is persisted, with the associated **Student**'s with it!


- We will be having the following data persisted!

<div align="center">
    <img src="N_Plus_One_Problem_Cleint_Code_Is_Being_Persisted.PNG"  alt="Hibernate Java Persistence!" width="600"/>
</div>

- Notice the current **data associations**!

<div align="center">
    <img src="Current_Data_Associations.PNG"  alt="Hibernate Java Persistence!" width="600"/>
</div>

1. See the assignations:
    | Student     | guide_id | Associated Guide |
    | ----------- | -------- | ---------------- |
    | Amy Gill    | 2        | Ian Lamb         |
    | John Smith  | 2        | Ian Lamb         |
    | Bruce Lee   | NULL     | No Guide         |
    | Rahul Singh | 3        | David Crow       |

> [!NOTE]
> How would we **query** all the data from the **student** table? We would need the `name` of the student and the `enrollment_id`.

<div align="center">
    <img src="How_We_Would_LIke_To_Get_The_Data_From_The_Studen_Table.PNG"  alt="Hibernate Java Persistence!" width="600"/>
</div>

1. We would be wanting following data as **end result**!




# Practiced identifying and reproducing the N+1 Selects Problem through a hands-on lab exercise.

# Learned how Batch Fetching reduces the number of SQL queries by loading related entities in batches.

# Implemented Batch Fetching in a lab exercise to optimize data retrieval.

# Learned how to useEntity Graphs to explicitly control entity fetching and avoid over-fetching or under-fetching.

# Applied Entity Graphs in a practical lab exercise.

# Reinforced my understanding of solving performance issues using N+1 prevention techniques, Batch Fetching, and Entity Graphs through the section quiz.