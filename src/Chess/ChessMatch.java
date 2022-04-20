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
		PlaceNewPieace('b', 6, new Rock(board, Color.White));
		PlaceNewPieace('e', 8, new King(board, Color.Black));
		PlaceNewPieace('e', 1, new King(board, Color.White));
        PlaceNewPieace('c', 2, new Rock(board, Color.White));
        PlaceNewPieace('d', 2, new Rock(board, Color.White));
        PlaceNewPieace('e', 2, new Rock(board, Color.White));
      //  PlaceNewPieace('e', 1, new Rock(board, Color.White));
        PlaceNewPieace('d', 1, new King(board, Color.White));

        PlaceNewPieace('c', 7, new Rock(board, Color.Black));
        PlaceNewPieace('c', 8, new Rock(board, Color.Black));
        PlaceNewPieace('d', 7, new Rock(board, Color.Black));
        PlaceNewPieace('e', 7, new Rock(board, Color.Black));
       // PlaceNewPieace('e', 8, new Rock(board, Color.Black));
        PlaceNewPieace('d', 8, new King(board, Color.Black));
	} 
	
}
