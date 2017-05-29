package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class Basic extends HttpServlet {
	private WebConversation wc = new WebConversation();
	private WebResponse response;
	private WebForm form;
	
	
	public void testCreate() {
		try {
			response = wc.getResponse("http://localhost:8080/student-catalog/create.html");
			form = response.getForms()[0];
			form.setParameter("StudentID", "5832749");
			form.setParameter("fname", "John");
			form.setParameter("lname", "Sun");
			form.submit();
			
			assertTrue(wc.getCurrentPage().getText().contains("<p>Student John Sun (5832749) created!</p>"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRead() {
		try {
			response = wc.getResponse("http://localhost:8080/student-catalog/");
			form = response.getForms()[0];
			form.setParameter("StudentID", "5832749");
			form.submit();
			
			assertTrue(wc.getCurrentPage().getText().contains("<p>[Data Structures and Algorithms, Programming Languages, 5832749, Ben Franklin]</p>"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		try {
			response = wc.getResponse("http://localhost:8080/student-catalog/update.html");
			form = response.getForms()[0];
			form.setParameter("StudentID", "5832749");
			form.setParameter("fname", "Andrew");
			form.setParameter("lname", "Franklin");
			form.submit();
			
			assertTrue(wc.getCurrentPage().getText().contains("<p>Student record updated for student Andrew Franklin(5832749)</p>"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testDelete() {
		try {
			response = wc.getResponse("http://localhost:8080/student-catalog/delete.html");
			form = response.getForms()[0];
			form.setParameter("StudentID", "5832749");
			form.setParameter("fname", "Andrew");
			form.setParameter("lname", "Franklin");
			form.submit();
			
			assertTrue(wc.getCurrentPage().getText().contains("<p>Student record deleted for student Andrew Franklin(5832749)</p>"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
