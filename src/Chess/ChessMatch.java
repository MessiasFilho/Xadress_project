package Chess;

import BoardGame.Board;
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
	
	private void PlaceNewPieace (char Colunm , int Row , ChessPiece piece ) { 
		board.placePiece(piece, new  ChessPosition(Colunm, Row).toPosition());
	}
	
	private void InitialSetUp () {
		PlaceNewPieace('a' ,8, new Rock(board ,Color.Black));
		
		PlaceNewPieace('e',1, new King(board , Color.white));
	} 
	
}
