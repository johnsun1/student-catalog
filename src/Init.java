import java.util.ArrayList;

public class Init {

	public static void main(String[] args) {
		QueryDB test = new QueryDB();
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Registrar> registrar = new ArrayList<Registrar>();
		
		//Test Course data
		Course CS157A = new Course();
		CS157A.setCourseID("CS157A");
		CS157A.setCourseName("Introduction to Databases");
		
		Course CS157B = new Course();
		CS157B.setCourseID("CS157B");
		CS157B.setCourseName("Advanced Databases");
		
		Course CS152 = new Course();
		CS152.setCourseID("CS152");
		CS152.setCourseName("Programming Paradigms");
		
		Course PHIL134 = new Course();
		PHIL134.setCourseID("PHIL134");
		PHIL134.setCourseName("Computers, Technology and Ethics");
		
		Course BIOL101 = new Course();
		BIOL101.setCourseID("BIOL101");
		BIOL101.setCourseName("Introduction to Biology");
		
		Course CS147 = new Course();
		CS147.setCourseID("CS147");
		CS147.setCourseName("Advanced Computer Architecture");
		
		//Add all Course information to array list
		courses.add(CS157A); 
		courses.add(CS157B); 
		courses.add(CS152); 
		courses.add(PHIL134);
		courses.add(BIOL101);
		courses.add(CS147);
		
		//Test Student
		Student JohnSun = new Student();
		JohnSun.setFirstName("John");
		JohnSun.setLastName("Sun");
		JohnSun.setStudentID(5832749);
		
		Student AlexPreston = new Student();
		AlexPreston.setFirstName("Alex");
		AlexPreston.setLastName("Preston");
		AlexPreston.setStudentID(8423713);
		
		//Add all test Student data to array list
		students.add(JohnSun);
		students.add(AlexPreston);
		
		//Test Registrar
		Registrar JS1 = new Registrar();
		JS1.setSID(JohnSun.getStudentID());
		JS1.setCID("CS157A");
		
		Registrar JS2 = new Registrar();
		JS2.setSID(JohnSun.getStudentID());
		JS2.setCID("CS152");
		
		Registrar JS3 = new Registrar();
		JS3.setSID(JohnSun.getStudentID());
		JS3.setCID("PHIL134");
		
		Registrar AP1 = new Registrar();
		AP1.setSID(AlexPreston.getStudentID());
		AP1.setCID("BIOL101");
		
		Registrar AP2 = new Registrar();
		AP2.setSID(AlexPreston.getStudentID());	
		AP2.setCID("CS157B");
		
		Registrar AP3 = new Registrar();
		AP3.setSID(AlexPreston.getStudentID());
		AP3.setCID("CS147");
		
		//Add all Registrar test data to array list
		registrar.add(JS1);
		registrar.add(JS2);
		registrar.add(JS3);
		
		registrar.add(AP1);
		registrar.add(AP2);
		registrar.add(AP3);
		
		
		//CREATE - Pass test data into populateDB to be saved into the DB 
		test.populateDB(students, courses, registrar);
}
}
