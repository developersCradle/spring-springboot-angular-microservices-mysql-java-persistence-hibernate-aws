package entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserId implements Serializable {

	@Column(name="username_cpk_col1")
    protected String username;
    
	@Column(name="derpartment_id_cpk_col2")
    protected Long departmentId;

    protected UserId() {
    }

    public UserId(String username, Long departmentId) {
        this.username = username;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object obj) {       
        if (!(obj instanceof UserId)) {
            return false;
        }
        UserId that = (UserId) obj;
        return new EqualsBuilder().append(this.username, that.username)
        											  .append(this.departmentId, that.departmentId)
        											  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(username)
        													 .append(departmentId)
        													 .toHashCode();
    }

    public String getUsername() {
        return username;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

	@Override
	public String toString() {
		return "UserId [username=" + username + ", departmentId=" + departmentId + "]";
	}
    
}
