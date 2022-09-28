package Save;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Perform.DBCaller;
import Perform.Player;

import java.io.PrintWriter;

/**
 * Servlet implementation class SaveBoard
 */
@WebServlet("/SaveBoard")
public class SaveBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		//out.println("New Servlet hee!");
		Player p1 = (Player) request.getSession().getAttribute("player1");
		Player p2 = (Player) request.getSession().getAttribute("player2");
		DBCaller.mongoConnect(p1.getPlayerName(), p2.getPlayerName());
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
