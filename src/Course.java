import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	private Integer CourseID;
	private String CourseName;
	private Integer EnrolledStudent;
	
	public Integer getCourseID() {
		return CourseID;
	}
	
	public void setCourseID(Integer i) {
		CourseID = i;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	
	public void setCourseName(String s) {
		CourseName = s;
	}
	
	public Integer getEnrolledStudent() {
		return EnrolledStudent;
	}
	
	public void setEnrolledStudent(Integer i) {
		EnrolledStudent = i;
	}
}
