import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private Integer StudentID;
	private String FirstName;
	private String LastName;
	
	public Integer getStudentID() {
		return StudentID;
	}
	
	public void setStudentID(Integer i) {
		StudentID = i;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String s) {
		FirstName = s;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public void setLastName(String s) {
		LastName = s;
	}
}
