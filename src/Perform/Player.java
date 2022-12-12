package Perform;

public class Player {
	private String playerName;
	
	public Piece pawn1;
	public Piece pawn2;
	public Piece pawn3;
	public Piece pawn4;
	public Piece pawn5;
	public Piece pawn6;
	public Piece pawn7;
	public Piece pawn8;
	
	public Piece rook1;
	public Piece rook2;
	
	public Piece knight1;
	public Piece knight2;
	
	public Piece bishop1;
	public Piece bishop2;
	
	public Piece queen;
	
	public King king;
	
	public Player(Color color, String playerName){
		if(color.equals(Color.WHITE)) {
			pawn1 = new Pawn(color, "pawn1w", "WhitePawn"); 
			GridMaps.chessboard.put("B1", pawn1); 
			Chess.pieceToPiece.put(pawn1.getPieceName(), pawn1);
			
			pawn2 = new Pawn(color, "pawn2w", "WhitePawn"); 
			GridMaps.chessboard.put("B2", pawn2);
			Chess.pieceToPiece.put(pawn2.getPieceName(), pawn2);
			
			pawn3 = new Pawn(color, "pawn3w", "WhitePawn"); 
			GridMaps.chessboard.put("B3", pawn3);
			Chess.pieceToPiece.put(pawn3.getPieceName(), pawn3);
			
			pawn4 = new Pawn(color, "pawn4w", "WhitePawn"); 
			GridMaps.chessboard.put("B4", pawn4);
			Chess.pieceToPiece.put(pawn4.getPieceName(), pawn4);
			
			pawn5 = new Pawn(color, "pawn5w", "WhitePawn"); 
			GridMaps.chessboard.put("B5", pawn5);
			Chess.pieceToPiece.put(pawn5.getPieceName(), pawn5);
			
			pawn6 = new Pawn(color, "pawn6w", "WhitePawn"); 
			GridMaps.chessboard.put("B6", pawn6);
			Chess.pieceToPiece.put(pawn6.getPieceName(), pawn6);
			
			pawn7 = new Pawn(color, "pawn7w", "WhitePawn"); 
			GridMaps.chessboard.put("B7", pawn7);
			Chess.pieceToPiece.put(pawn7.getPieceName(), pawn7);
			
			pawn8 = new Pawn(color, "pawn8w", "WhitePawn"); 
			GridMaps.chessboard.put("B8", pawn8);
			Chess.pieceToPiece.put(pawn8.getPieceName(), pawn8);
			
			rook1 = new Rook(color, "rook1w", "WhiteRook"); 
			GridMaps.chessboard.put("A1", rook1);
			Chess.pieceToPiece.put(rook1.getPieceName(), rook1);
			
			rook2 = new Rook(color, "rook2w", "WhiteRook"); 
			GridMaps.chessboard.put("A8", rook2);
			Chess.pieceToPiece.put(rook2.getPieceName(), rook2);

			knight1 = new Knight(color, "knight1w", "WhiteKnight"); 
			GridMaps.chessboard.put("A2", knight1);
			Chess.pieceToPiece.put(knight1.getPieceName(), knight1);
			
			knight2 = new Knight(color, "knight2w", "WhiteKnight"); 
			GridMaps.chessboard.put("A7", knight2);
			Chess.pieceToPiece.put(knight2.getPieceName(), knight2);
			
			bishop1 = new Bishop(color, "bishop1w", "WhiteBishop"); 
			GridMaps.chessboard.put("A3", bishop1);
			Chess.pieceToPiece.put(bishop1.getPieceName(), bishop1);

			bishop2 = new Bishop(color, "bishop2w", "WhiteBishop"); 
			GridMaps.chessboard.put("A6", bishop2);
			Chess.pieceToPiece.put(bishop2.getPieceName(), bishop2);

			queen = new Queen(color, "queenw", "WhiteQueen"); 
			GridMaps.chessboard.put("A4", queen);
			Chess.pieceToPiece.put(queen.getPieceName(), queen);

			king = new King(color, "kingw", "WhiteKing", "A5"); 
			GridMaps.chessboard.put("A5", king);
			Chess.pieceToPiece.put(king.getPieceName(), king);

		} else {
			pawn1 = new Pawn(color, "pawn1b", "BlackPawn"); 
			GridMaps.chessboard.put("G1", pawn1);
			Chess.pieceToPiece.put(pawn1.getPieceName(), pawn1);
			
			pawn2 = new Pawn(color, "pawn2b", "BlackPawn"); 
			GridMaps.chessboard.put("G2", pawn2);
			Chess.pieceToPiece.put(pawn2.getPieceName(), pawn2);
			
			pawn3 = new Pawn(color, "pawn3b", "BlackPawn"); 
			GridMaps.chessboard.put("G3", pawn3);
			Chess.pieceToPiece.put(pawn3.getPieceName(), pawn3);
			
			pawn4 = new Pawn(color, "pawn4b", "BlackPawn"); 
			GridMaps.chessboard.put("G4", pawn4);
			Chess.pieceToPiece.put(pawn4.getPieceName(), pawn4);
			
			pawn5 = new Pawn(color, "pawn5b", "BlackPawn"); 
			GridMaps.chessboard.put("G5", pawn5);
			Chess.pieceToPiece.put(pawn5.getPieceName(), pawn5);
			
			pawn6 = new Pawn(color, "pawn6b", "BlackPawn"); 
			GridMaps.chessboard.put("G6", pawn6);
			Chess.pieceToPiece.put(pawn6.getPieceName(), pawn6);
			
			pawn7 = new Pawn(color, "pawn7b", "BlackPawn"); 
			GridMaps.chessboard.put("G7", pawn7);
			Chess.pieceToPiece.put(pawn7.getPieceName(), pawn7);
			
			pawn8 = new Pawn(color, "pawn8b", "BlackPawn"); 
			GridMaps.chessboard.put("G8", pawn8);
			Chess.pieceToPiece.put(pawn8.getPieceName(), pawn8);
			
			rook1 = new Rook(color, "rook1b", "BlackRook"); 
			GridMaps.chessboard.put("H1", rook1);
			Chess.pieceToPiece.put(rook1.getPieceName(), rook1);
			
			rook2 = new Rook(color, "rook2b", "BlackRook"); 
			GridMaps.chessboard.put("H8", rook2);
			Chess.pieceToPiece.put(rook2.getPieceName(), rook2);
			
			knight1 = new Knight(color, "knight1b", "BlackKnight"); 
			GridMaps.chessboard.put("H2", knight1);
			Chess.pieceToPiece.put(knight1.getPieceName(), knight1);
			
			knight2 = new Knight(color, "knight2b", "BlackKnight"); 
			GridMaps.chessboard.put("H7", knight2);
			Chess.pieceToPiece.put(knight2.getPieceName(), knight2);
			
			bishop1 = new Bishop(color, "bishop1b", "BlackBishop"); 
			GridMaps.chessboard.put("H3", bishop1);
			Chess.pieceToPiece.put(bishop1.getPieceName(), bishop1);
			
			bishop2 = new Bishop(color, "bishop2b", "BlackBishop"); 
			GridMaps.chessboard.put("H6", bishop2);
			Chess.pieceToPiece.put(bishop2.getPieceName(), bishop2);
			
			queen = new Queen(color, "queenb", "BlackQueen"); 
			GridMaps.chessboard.put("H4", queen);
			Chess.pieceToPiece.put(queen.getPieceName(), queen);
			
			king = new King(color, "kingb", "BlackKing", "H5"); 
			GridMaps.chessboard.put("H5", king);
			Chess.pieceToPiece.put(king.getPieceName(), king);
		}
		
		this.setPlayerName(playerName);	
	}

	public String getPlayerName() { return playerName; }

	public void setPlayerName(String playerName) { this.playerName = playerName; }
}

class White extends Player {

	White(Color color, String name) {
		super(color, name);
	}
	
	public void initiateSquares() {
		GridMaps.chessboard.put("B1", pawn1);
		GridMaps.chessboard.put("B2", pawn2);
		GridMaps.chessboard.put("A1", rook1);
		GridMaps.chessboard.put("A8", rook2);
	}
	
}

class Black extends Player {

	Black(Color color, String name) {
		super(color, name);
	}
	
	public void initiateSquares() {
		GridMaps.chessboard.put("G1", pawn1);
		GridMaps.chessboard.put("G2", pawn2);
		GridMaps.chessboard.put("H1", rook1);
		GridMaps.chessboard.put("H8", rook2);
	}
}
