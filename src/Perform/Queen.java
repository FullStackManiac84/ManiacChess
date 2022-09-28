package Perform;

public class Queen extends Piece {
	
	Queen(Color color, String pieceName, String imageName) {
		super(color);
		this.setRank(8);
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
		
		if(!((delta_x == delta_y) || 
				((delta_x == 0 && delta_y != 0) || (delta_x != 0 && delta_y == 0)))) {
			System.out.println("Queen must move in a diagonal or straight line! Please try again.");
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
			GridMaps.chessboard.put(sq2, this);
			GridMaps.chessboard.remove(sq1, this);
		}
	}

}
