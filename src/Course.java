import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	private String CourseID;
	private String CourseName;
	
	public String getCourseID() {
		return CourseID;
	}
	
	public void setCourseID(String s) {
		CourseID = s;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	
	public void setCourseName(String s) {
		CourseName = s;
	}
}
