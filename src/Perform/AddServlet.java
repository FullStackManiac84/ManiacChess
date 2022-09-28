package Perform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hey I'm about to add stuff");
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		int c = a + b;
		
		//PrintWriter out = response.getWriter();
		//out.println("Sum is " + c);
		
		// Uncomment below for Dispatch to SqServlet
		/*request.setAttribute("c", c);
		
		RequestDispatcher rd = request.getRequestDispatcher("sq");
		rd.forward(request, response);*/
		
		// Uncomment below for Session Management
		//HttpSession session = request.getSession();
		//session.setAttribute("c", c);
		
		Cookie cook = new Cookie("c", c + "");
		response.addCookie(cook);
		
		// Uncomment below for URL Re-Write
		//response.sendRedirect("sq?c="+c); // URL re-writing
		response.sendRedirect("sq"); // Session management and Cookies
		
	}

}
