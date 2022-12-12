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

@WebServlet("/SaveBoard")
public class SaveBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaveBoard() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		Player p1 = (Player) request.getSession().getAttribute("player1");
		Player p2 = (Player) request.getSession().getAttribute("player2");
		DBCaller.mongoConnect(p1.getPlayerName(), p2.getPlayerName());
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
