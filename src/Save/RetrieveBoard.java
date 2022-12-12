package Save;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Perform.DBCaller;
import Perform.Player;

@WebServlet("/RetrieveBoard")
public class RetrieveBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RetrieveBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player p1 = (Player) request.getSession().getAttribute("player1");
		Player p2 = (Player) request.getSession().getAttribute("player2");
		DBCaller.mongoRetrieve(p1.getPlayerName(), p2.getPlayerName());
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
