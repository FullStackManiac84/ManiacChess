package Perform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SqServlet
 */
@WebServlet("/SqServlet")
public class SqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.println("I'm gonna square the sum now!");
		
		//int c = Integer.parseInt(request.getParameter("c")); // use for URL Re-Writing
		//int c = (int)request.getAttribute("c"); // use for dispatching
		
		// Uncomment below for Session Management
		/*HttpSession session = request.getSession();
		int c = (int) session.getAttribute("c");*/
		
		int c = 0;
		Cookie[] myCookies = request.getCookies();
		for(Cookie cook : myCookies) {
			if(cook.getName().equals("c")) {
				c = Integer.parseInt(cook.getValue());
			}
		}
		
		c *= c;
		out.println("Square of sum is " + c);
	}

}
