package entity;

import dto.EmployeeDto;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "CountByDepartmentProcedure",
            procedureName = "count_employee_by_department",
            parameters = {
                    @StoredProcedureParameter(
                            name = "dept",
                            type = String.class,
                            mode = ParameterMode.IN),
                    @StoredProcedureParameter(
                            name = "count",
                            type = Integer.class,
                            mode = ParameterMode.OUT)
            }
    ),
    @NamedStoredProcedureQuery(
            name = "FindByDepartmentProcedure",
            procedureName = "find_employee_by_department",
            resultClasses = Employee.class,
            parameters = {
                    @StoredProcedureParameter(
                            name = "dept",
                            type = String.class,
                            mode = ParameterMode.IN)
            }
    ),
    @NamedStoredProcedureQuery(
            name = "FindNameAndSalaryByDepartmentProcedure",
            procedureName = "find_name_and_salary_by_department",
            resultSetMappings = "EmployeeDtoMapping",
            parameters = {
                    @StoredProcedureParameter(
                            name = "dept",
                            type = String.class,
                            mode = ParameterMode.IN)
            }
    )
})
@SqlResultSetMapping(
		name = "EmployeeDtoMapping",
		classes = @ConstructorResult(
							targetClass = EmployeeDto.class,
							columns = {
												@ColumnResult(name = "name"),
												@ColumnResult(name = "salary")
							}
					)
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer salary;
    
    private String department;

    public Employee() {}
	public Employee(String name, Integer salary, String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	} 
    
}
