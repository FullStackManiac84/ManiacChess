package Perform;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import MongoConJava.Library;
import MongoConJava.ZywickSpecial;

public class DBCaller {
	public static void mongoConnect(String nameOfPlayer1, String nameOfPlayer2) {
		try {
			Map<String, Object> testMap =  GridMaps.chessboard.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey(), e -> (Object)e.getValue()));
			Library.stain(nameOfPlayer1, nameOfPlayer2, testMap);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mongoRetrieve(String nameOfPlayer1, String nameOfPlayer2) throws UnknownHostException {
		Map<String, ZywickSpecial> retrievedBoard = Library.refrain(nameOfPlayer1, nameOfPlayer2);
		GridMaps.chessboard.clear();
		Iterator<Map.Entry<String, ZywickSpecial>> it = retrievedBoard.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, ZywickSpecial> local_it = it.next();
			Piece localPiece = Chess.pieceToPiece.get(local_it.getValue().pieceName);
			if(localPiece != null) {
				localPiece.setToCaptured(local_it.getValue().isCaptured);
				localPiece.setIsInitialMove(local_it.getValue().isInitialMove);
				GridMaps.chessboard.put(local_it.getKey(), localPiece);
			}
		}
	}
}
