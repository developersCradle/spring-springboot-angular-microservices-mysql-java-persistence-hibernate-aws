package entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

    @EmbeddedId
    private UserId userId;
    
    @Column(nullable=false)
    private String email;

    @ManyToOne
    @JoinColumn(name="department_id_fk")
    @MapsId("departmentId")
    protected Department department;
    
    protected User() {}
    public User(UserId userId, String email) {
        this.userId = userId;
        this.email = email;
    }
    
    public UserId getUserId() {
		return userId;
	}
    public String getEmail() {
		return email;
	}
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + 
				", department=" + department + "]";
	}
    
}