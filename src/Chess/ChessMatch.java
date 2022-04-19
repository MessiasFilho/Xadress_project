package Chess;

import BoardGame.Board;
import BoardGame.Position;
import Chess.Pieces.King;
import Chess.Pieces.Rock;

public class ChessMatch {

	private Board board ; 
	
	
	public ChessMatch () {
		board = new Board ( 8 , 8 );
		InitialSetUp (); 
		
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
	
	private void InitialSetUp () {
		board.placePiece(new Rock(board ,Color.Black), new Position(3,3));
		board.placePiece(new King(board , Color.white), new Position(3,3));
	} 
	
}
