import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryDB {

	private Session s;
	private SessionFactory sf;
	
	/**
	 * Constructor
	 */
	public QueryDB() {
		//SessionFactory is very expensive, so it is only created once
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * Populate DB with test sales data
	 */
	public void populateDB(ArrayList<Student> stu, ArrayList<Course> cou) {
		//Create a new session and save data to the DB
		s = sf.openSession();
		s.beginTransaction();
		
		//Save all new Student and Course records to the DB
		for (Student i : stu) {
			s.save(i);
		}
		
		for (Course i : cou) {
			s.save(i);
		}

		s.getTransaction().commit();
		s.close();
	}
	
	/**
	 * Add a student record
	 * @param id Student ID
	 * @param fname First name
	 * @param lname Last name
	 * @return The student record that was just added
	 */
	public Student addStudent(Integer id, String fname, String lname) {
		s = sf.openSession();
		s.beginTransaction();
		
		Student stu = new Student();
		stu.setFirstName(fname);
		stu.setLastName(lname);
		stu.setStudentID(id);
		s.save(stu);
		
		s.getTransaction().commit();
		s.close();
		
		return stu;
	}
	
	/**
	 * Query DB for a certain Student's information
	 * @param i The student's ID
	 * @return An array with the student's ID, first and last names, then all of their courses
	 */
	public ArrayList<String> readStudent(Integer i) {
		
		//Reopen a session with DB
		s = sf.openSession();
		s.beginTransaction();
		
		Student student = (Student) s.get(Student.class, i);
		
		String query = String.format("SELECT CourseName FROM Course WHERE EnrolledStudent = %d", i);
		ArrayList<String> courseResults = (ArrayList<String>) s.createQuery(query).getResultList();
		
		//Add results to array
		courseResults.add(student.getStudentID().toString());
		courseResults.add(student.getFirstName() + " " + student.getLastName());
		
		s.close();
		
		return courseResults;
	}
	
	/**
	 * Update a student's first and last name according to a provided student id
	 * @param fname new first name
	 * @param lname new last name
	 * @param id the id of the student whose information to update
	 */
	public void updateStudent(String fname, String lname, Integer id) {
		s = sf.openSession();
		s.beginTransaction();
		
		String query = String.format("UPDATE Student SET FirstName = '%s', LastName = '%s' WHERE StudentID = %d", fname, lname, id);
		s.createQuery(query).executeUpdate();

		s.close();
		
	}
	
	/**
	 * Delete a course from a student's schedule
	 * @param id the student ID whose information we're updating
	 * @param courseName the name of the course we're deleting
	 */
	public void deleteCourse(Integer id, String courseName) {
		s = sf.openSession();
		s.beginTransaction();
		
		String query = String.format("DELETE FROM Course WHERE EnrolledStudent=%d AND CourseName='%s'",id, courseName);
		s.createQuery(query).executeUpdate();
		
		s.close();
	}
	
	/**
	 * Delete a student record
	 * @param id Student ID
	 * @param fname First name
	 * @param lname Last name
	 */
	public void deleteStudent(Integer id, String fname, String lname) {
		s = sf.openSession();
		s.beginTransaction();
		
		String query = String.format("DELETE FROM Student WHERE StudentID = %d AND FirstName = '%s' AND LastName = '%s'",id, fname, lname);
		s.createQuery(query).executeUpdate();
		
		s.close();
	}
	
	/**
	 * Query DB with aggregate functions
	 * @param cmd the aggregate function
	 * @param arg the relevant parameter
	 */
	public void aggregateFunctions(String cmd, String arg) {
		s = sf.openSession();
		s.beginTransaction();
		String query = "";
		
		if (cmd.equals("ORDER BY")) {
			query = String.format("SELECT StudentID FROM Student ORDER BY %s", arg);
			ArrayList<String> rs = (ArrayList<String>) s.createQuery(query).getResultList();
			
			for (String result : rs) {
				System.out.println(result);
			}
				
		} else if (cmd.equals("MIN")) {
			query = String.format("SELECT MIN(%s) FROM Student", arg);
			System.out.println(s.createQuery(query).getSingleResult());

		} else if (cmd.equals("MAX")) {
			query = String.format("SELECT MAX(%s) FROM Student",arg);
			System.out.println(s.createQuery(query).getSingleResult());
			
		} else if (cmd.equals("DISTINCT")) {
			query = String.format("SELECT COUNT(DISTINCT %s) FROM Student", arg);
			System.out.println(s.createQuery(query).getSingleResult());
		}
		s.close();
		
	}
}
