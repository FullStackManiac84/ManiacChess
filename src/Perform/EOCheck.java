package Perform;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EOCheck")
public class EOCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EOCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gamePiece = request.getParameter("piece");
		String initialSquare = request.getParameter("sq1");
		String finalSquare = request.getParameter("sq2");
		Player myPlayer1 = (Player) request.getSession().getAttribute("player1");
		Player myPlayer2 = (Player) request.getSession().getAttribute("player2");
		String myPlayerPawnName = myPlayer1.pawn1.getPieceName();
			try {
				Piece myPiece = GridMaps.chessboard.get(initialSquare);
				if(myPiece != null) {
					myPiece.move(initialSquare, finalSquare);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.setAttribute("myInitial", "E");
				request.setAttribute("mySquare", "P1W");
				RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
	            rd.forward(request, response);
			}
	}

}
