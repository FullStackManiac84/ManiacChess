package Perform;

public abstract class Piece {
		private int rank;
		private boolean isCaptured = false;
		private boolean isInitialMove = true;
		private Color color;
		private String pieceName = "";
		private String imageName = "";
		
		public Piece(Color color) { this.color = color; }
		
		public void setRank(int rank) { this.rank = rank; }
		
		public int getRank() { return rank; }
		
		public void setPieceName(String pieceName) { this.pieceName = pieceName; }
		
		public String getPieceName() { return pieceName; }
		
		public String getImageName() { return imageName; }

		public void setImageName(String imageName) { this.imageName = imageName; }

		public void setToCaptured(boolean isCaptured) { this.isCaptured = isCaptured; }
		
		public boolean getCapturedStatus() { return isCaptured; }
		
		public boolean getIsInitialMove() { return isInitialMove; }
		
		public void setIsInitialMove(boolean isInitialMove) { this.isInitialMove = isInitialMove; }
		
		public Color getColor() { return color; }
		
		public void move() {}
		public void move(String sq1, String sq2) throws Exception {}
		
		public void printLocale() {
			//System.out.println(
					//GridMaps.rev_grid.get(Integer.toString(x) + 
							//Integer.toString(y)));
		}
			public void checkForObstacles(int x1, int x2, int y1, int y2) throws Exception {
				int x_it = 0;
				int y_it = 0;
				
				x_it = x2 - x1 > 0 ? 1 : x_it;
				x_it = x2 - x1 < 0 ? -1 : x_it;
				y_it = y2 - y1 > 0 ? 1 : y_it;
				y_it = y2 - y1 < 0 ? -1 : y_it;
				
				x1 += x_it;
				y1 += y_it;
				
				while(!GridMaps.xyToSquare(x1, y1).equals(GridMaps.xyToSquare(x2, y2))) {
					if(GridMaps.chessboard.containsKey(GridMaps.xyToSquare(x1, y1))) {
						throw new Exception("A piece is obstructing your path. Please choose again!");
					}
					
					x1 += x_it;
					y1 += y_it;
				}
			}
	}
