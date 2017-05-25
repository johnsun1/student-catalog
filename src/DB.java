import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DB
 */
@WebServlet("/DB")
public class DB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		QueryDB test = new QueryDB();
		
		//Read
		if (request.getParameter("type").equals("read")) {
			Integer StudentID = Integer.parseInt(request.getParameter("StudentID"));
		
			ArrayList<String> studentInfo = test.readStudent(StudentID);
			request.setAttribute("studentInfo", studentInfo);
			request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
		
		//Create
		} else if (request.getParameter("type").equals("create")) {
			Integer StudentID = Integer.parseInt(request.getParameter("StudentID"));
			String FirstName = request.getParameter("fname");
			String LastName = request.getParameter("lname");
			
			Student newStudent = test.addStudent(StudentID, FirstName, LastName);
			String confirm = "Student " + newStudent.getFirstName() + " " + newStudent.getLastName() + " (" + newStudent.getStudentID() + ") created!";
			request.setAttribute("studentInfo", confirm);
			request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
		
		//Update
		} else if (request.getParameter("type").equals("update")) {
			Integer StudentID = Integer.parseInt(request.getParameter("StudentID"));
			String FirstName = request.getParameter("fname");
			String LastName = request.getParameter("lname");
			
			test.updateStudent(FirstName, LastName, StudentID);
			
			String text = "Student record updated for student " + FirstName + " " + LastName + "(" + StudentID + ")";
			request.setAttribute("studentInfo", text);
			request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
			
		//Delete
		} else if (request.getParameter("type").equals("delete")) {
			Integer StudentID = Integer.parseInt(request.getParameter("StudentID"));
			String FirstName = request.getParameter("fname");
			String LastName = request.getParameter("lname");
			
			test.deleteStudent(StudentID, FirstName, LastName);
			
			String text = "Student record deleted for student " + FirstName + " " + LastName + "(" + StudentID + ")";
			request.setAttribute("studentInfo", text);
			request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
		}
		
	}

}
