package Chess;

import BoardGame.Board;
import BoardGame.Piece;
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
	
	public  ChessPiece performChessMove (ChessPosition sourcePosition , ChessPosition TargetPosition  ) {
		Position source = sourcePosition.toPosition();
		Position target = TargetPosition.toPosition(); 
		
		validateSourcePosition (source); 
		Piece capturedPiece = MakeMove (source , target);  
		return 	(ChessPiece) capturedPiece; 
			
	}
	
	private Piece MakeMove (Position source , Position target  ) {
		
		Piece p = board.removePiece(source); 
		
		Piece  CapturedPiece = board.removePiece(target); 
		
		board.placePiece(p, target);
		
		return CapturedPiece; 
		
		
	}
	
	private void validateSourcePosition (Position position) {
		if (!board.ThereIsAPiece(position) ) {
			throw new ChessExp ("There is no piece on source position"); }
				
			
		
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
