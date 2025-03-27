package entity;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Guide.class)
public abstract class Guide_ {

	public static volatile SingularAttribute<Guide, String> name;
	public static volatile SetAttribute<Guide, Student> students;
	public static volatile SingularAttribute<Guide, Long> id;
	public static volatile SingularAttribute<Guide, Integer> salary;
	public static volatile SingularAttribute<Guide, String> staffId;

	public static final String NAME = "name";
	public static final String STUDENTS = "students";
	public static final String ID = "id";
	public static final String SALARY = "salary";
	public static final String STAFF_ID = "staffId";

}

