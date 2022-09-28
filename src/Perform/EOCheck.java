package Perform;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EOCheck
 */
@WebServlet("/EOCheck")
public class EOCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EOCheck() {
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
		//doGet(request, response);
		String gamePiece = request.getParameter("piece");
		String initialSquare = request.getParameter("sq1");
		String finalSquare = request.getParameter("sq2");
		Player myPlayer1 = (Player) request.getSession().getAttribute("player1");
		Player myPlayer2 = (Player) request.getSession().getAttribute("player2");
		String myPlayerPawnName = myPlayer1.pawn1.getPieceName();
		//switch(gamePiece){
		//case "Pawn":
			//Pawn myPawn = new Pawn(Color.WHITE, "P1W");
			try {
				//myPawn.move(initialSquare, finalSquare);
				Piece myPiece = GridMaps.chessboard.get(initialSquare);
				if(myPiece != null)
				//myPlayer.pawn1.move(initialSquare, finalSquare);
				//break;
					myPiece.move(initialSquare, finalSquare);
				//Library.stain();
				//DBCaller.mongoConnect(myPlayer1, myPlayer2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				/*PrintWriter out = null;
				response.setContentType("text/html");
				out = response.getWriter();
				out.println(finalSquare);*/
				//response.setStatus(88);
				/*out.println("<br><br>");
				out.println("<a href=Chessboard.html>Click HERE</a>");
				out.println("<input type=text>Success on backend!!></input>");
				out.println("</center>");*/
				request.setAttribute("myInitial", "E");
				request.setAttribute("mySquare", "P1W");
				//request.setAttribute("myPiece", "P1W");
				RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
	            rd.forward(request, response);
				
			}
		//}
		
	}

}
