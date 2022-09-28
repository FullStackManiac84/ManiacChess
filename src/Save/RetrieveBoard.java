package Save;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Perform.DBCaller;
import Perform.Player;

/**
 * Servlet implementation class RetrieveBoard
 */
@WebServlet("/RetrieveBoard")
public class RetrieveBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Player p1 = (Player) request.getSession().getAttribute("player1");
		Player p2 = (Player) request.getSession().getAttribute("player2");
		DBCaller.mongoRetrieve(p1.getPlayerName(), p2.getPlayerName());
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
