package Perform;

public class Pawn extends Piece {
		
		//private boolean isInitialMove = true;
		
		//public boolean getIsInitialMove() { return isInitialMove; }
		
		//public void setIsInitialMove(boolean isInitialMove) { this.isInitialMove = isInitialMove; }
	
		public Pawn(Color color, String pieceName, String imageName) {
			super(color);
			this.setRank(1);
			this.setPieceName(pieceName);
			this.setImageName(imageName);
		}
		
		/*public boolean canMoveTwo() { return isInitialMove; }
		
		public void setCannotMoveTwo() { isInitialMove = false; }*/
		
		public void move(String sq1, String sq2) throws Exception {
			//x++;
			int x_init = GridMaps.squareToXY(sq1)[0];
			int x_fin = GridMaps.squareToXY(sq2)[0];
			int delta_x = x_fin - x_init;
			
			int y_init = GridMaps.squareToXY(sq1)[1];
			int y_fin = GridMaps.squareToXY(sq2)[1];
			int delta_y = y_fin - y_init;
			
			boolean takeDown = delta_y == 0 ? false : true;
			
			// begin experimental section
			if(!((this.getColor().equals(Color.WHITE) && delta_x == 1 && (delta_y == 0 || Math.abs(delta_y) == 1)) || 
					(this.getColor().equals(Color.BLACK) && delta_x == -1 && (delta_y == 0 || Math.abs(delta_y) == 1)) ||
					(this.getColor().equals(Color.WHITE) && delta_x == 2 && delta_y == 0 && this.getIsInitialMove() == true) || 
					(this.getColor().equals(Color.BLACK) && delta_x == -2 && delta_y == 0 && this.getIsInitialMove() == true))) {
				System.out.println("Pawn must move one space forward (two initially) or capture a piece diagonally forwards! Please try again.");
				return;
			}
			
			// not needed?? only for a 2 on initial move!!!!
			if(Math.abs(delta_x) == 2) {
				try {
					checkForObstacles(x_init, x_fin, y_init, y_fin);
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
					return;
				}
			}
			
			if(!GridMaps.chessboard.containsKey(sq2) && takeDown == false) {
				GridMaps.chessboard.put(sq2, this);
				GridMaps.chessboard.remove(sq1, this);
				this.setIsInitialMove(false);
			} else if (GridMaps.chessboard.get(sq2).getColor().equals(this.getColor())) {
				System.out.println("One of your pieces is occupying desired square!");
				return;
			} else if (takeDown == true ){
				GridMaps.chessboard.get(sq2).setToCaptured(true);
				GridMaps.chessboard.put(sq2, this);
				GridMaps.chessboard.remove(sq1, this);
				this.setIsInitialMove(false);
			}
			
			// end experimental section 
			
			// will add en-passant/+2 initial later
			/*if(Math.abs(delta_x) == 1 && delta_y == 0 && !GridMaps.chessboard.containsKey(sq2)) {
				GridMaps.chessboard.put(sq2, this);
				GridMaps.chessboard.remove(sq1, this);
			} else if (Math.abs(delta_x) == 1 && Math.abs(delta_y)== 1) {
				if(GridMaps.chessboard.get(sq2).getColor().equals(this.getColor())) {
					throw new Exception("One of your pieces is occupying desired square!");
					//System.out.print("One of your pieces is occupying desired square!");
				} else {
					GridMaps.chessboard.get(sq2).setToCaptured();
					//GridMaps.chessboard.containsValue(this);
					GridMaps.chessboard.put(sq2, this);
					GridMaps.chessboard.remove(sq1, this);
				}
			} else {
				System.out.println("Invalid move!! Please try again");
			}*/
		}
}
