package Chess;

import BoardGame.Board;

public class ChessMatch {

	private Board board ; 
	
	
	public ChessMatch () {
		board = new Board ( 8 , 8 );
		
	}
	
	public ChessPiece[][] getPieces () {
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int L =0  ; L < board.getRows() ; L++ ) {
			for (int C = 0 ; C < board.getColumns() ; C++   ) {
				mat[L][C] = (ChessPiece) board.piece(L,C);
			}
		}
		
		return mat ; 
	}
	
}
