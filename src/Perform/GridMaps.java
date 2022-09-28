package Perform;

import java.util.HashMap;
import java.util.Map;

public class GridMaps{
		public static Map<String, String> grid = new HashMap<>();
		public static Map<String, String> rev_grid = new HashMap<>();
		public static Map<String, Piece> chessboard = new HashMap<>();
		
		public static void fillGrid() {
			grid.put("B2", "11");
			grid.put("B3", "12");
			grid.put("C2", "21");
			grid.put("C3", "22");
			rev_grid.put("11", "B2");
			rev_grid.put("12", "B3");
			rev_grid.put("21", "C2");
			rev_grid.put("22", "C3");
		}
		
		public static int[] squareToXY(String sq) {
			// (A-H , 1-8) is input
			int[] xyCoords = new int[2];
			xyCoords[0] = (int)sq.charAt(0) - 65;
			xyCoords[1] = (int)sq.charAt(1) - 49;
			return xyCoords;
		}
		
		public static String xyToSquare(int x, int y) {
			String square = "";
			square += (char)(x + 65);
			square += (char)(y + 49);
			return square;
		}
	}
