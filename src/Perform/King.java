package Perform;

public class King extends Piece {
	
	private String kingPosition;
	
	public King(Color color, String pieceName, String imageName, String kingPosition) {
		super(color);
		this.setRank(8);
		this.setPieceName(pieceName);
		this.setImageName(imageName);
		this.kingPosition = kingPosition;
	}
	
	public String getKingPosition() { return kingPosition; }
	
	public void setKingPosition(String kingPosition) { this.kingPosition = kingPosition; }
	
	public boolean scanForQuadEnemy(int row_it, int col_it) {
		int[] kingCoords = GridMaps.squareToXY(kingPosition);
		int scan_row = kingCoords[0];
		int scan_col = kingCoords[1];
		
		// check if king is on board boundary
		scan_row += row_it;
		scan_col += col_it;
		
		Piece enemy;
		while(scan_row >= 0 && scan_row <= 7 && scan_col >= 0 && scan_col <= 7) {
			enemy = GridMaps.chessboard.get(GridMaps.xyToSquare(scan_row, scan_col));
			if(enemy != null && !enemy.getColor().equals(this.getColor())) {
				if((row_it == 0 || col_it == 0) && 
						(enemy instanceof Rook || enemy instanceof Queen)) {
							return true;
				} else if((Math.abs(row_it) == Math.abs(col_it)) && 
						(enemy instanceof Bishop || enemy instanceof Queen)) {
							return true;
				} else if(this.getColor().equals(Color.BLACK) && row_it == -1 && 
						Math.abs(col_it) == 1 && enemy instanceof Pawn) {
							return true;
				} else if(this.getColor().equals(Color.WHITE) && row_it == 1 &&
						Math.abs(col_it) == 1 && enemy instanceof Pawn) {
							return true;
				} else
					return false;
			} else if(enemy != null) {
				return false;
			}
			scan_row += row_it;
			scan_col += col_it;
		}
		
		return false;
	}
	
	public boolean scanForKnights() {
		int[] kingCoords = GridMaps.squareToXY(kingPosition);
		int scan_row = kingCoords[0];
		int scan_col = kingCoords[1];
		
		int[][] potentialKnightCoords = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

		Piece potentialKnight;
		for(int i = 0; i < potentialKnightCoords.length; i++) {
			potentialKnight = GridMaps.chessboard.get(GridMaps.xyToSquare(scan_row + potentialKnightCoords[i][0], 
					scan_col + potentialKnightCoords[i][1]));
			if(potentialKnight != null && !potentialKnight.getColor().equals(this.getColor()) && 
					potentialKnight instanceof Knight){
						return true;
			}
		}
		
		return false;
	}
	
	public boolean kingInCheck(){
		int[][] enemyCoords = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for(int i = 0; i < enemyCoords.length; i++) {
			if(scanForQuadEnemy(enemyCoords[i][0], enemyCoords[i][1]) == true){
				return true;
			}
		}
		
		if(scanForKnights()) return true;
		
		return false;
	}
}
