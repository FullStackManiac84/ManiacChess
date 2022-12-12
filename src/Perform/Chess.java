package Perform;
import java.util.HashMap;
import java.util.Map;

class Rook extends Piece {
	
	Rook(Color color, String pieceName, String imageName) {
		super(color);
		this.setRank(5);
		this.setPieceName(pieceName);
		this.setImageName(imageName);
	}
	
	public void move(String sq1, String sq2) {
		// need a method to convert from string to x,y coor
		int x_init = GridMaps.squareToXY(sq1)[0];
		int x_fin = GridMaps.squareToXY(sq2)[0];
		int delta_x = Math.abs(x_fin - x_init);
		
		int y_init = GridMaps.squareToXY(sq1)[1];
		int y_fin = GridMaps.squareToXY(sq2)[1];
		int delta_y = Math.abs(y_fin - y_init);
		
		if(!((delta_x == 0 && delta_y != 0) || (delta_x != 0 && delta_y == 0))) {
			System.out.println("Rook must move in a straight line! Please try again.");
			return;
		}
		
		try {
			checkForObstacles(x_init, x_fin, y_init, y_fin);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			return;
		}
		
		if(!GridMaps.chessboard.containsKey(sq2)) {
			GridMaps.chessboard.put(sq2, this);
			GridMaps.chessboard.remove(sq1, this);
		} else if (GridMaps.chessboard.get(sq2).getColor().equals(this.getColor())) {
			System.out.println("One of your pieces is occupying desired square!");
			return;
		} else {
			GridMaps.chessboard.get(sq2).setToCaptured(true);
			GridMaps.chessboard.remove(sq1, this);
			GridMaps.chessboard.put(sq2, this);
		}
	}
}


public class Chess {
	
	public static Map<Integer, Integer> patMap = new HashMap<>();
	public static Map<String, Piece> pieceToPiece = new HashMap<>();
	public static void main(String... args) {
				
		Player p1 = new Player(Color.WHITE, "Jeff");
		Player p2 = new Player(Color.BLACK, "Jim");
		
	}
}
