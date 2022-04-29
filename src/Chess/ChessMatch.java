package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import Chess.Pieces.King;
import Chess.Pieces.Rock;

public class ChessMatch {
	
	private int Turn ; 
	
	private Color CurrentPlayer ; 
	
	private Board board ; 	
	
	private List <Piece> pieceOnTheBoard = new ArrayList<>(); 
	
	private boolean Check ; 
	
	private List <Piece> CapturedpieceList = new ArrayList<>();
	public ChessMatch () {
		board = new Board ( 8 , 8 );
		Turn = 1 ; 
		CurrentPlayer = Color.White; 
		
		InitialSetUp (); 
	}
	
	public boolean getCheck () {
		return Check ; 
	}
	
	public int getTurn() {
		return Turn;
	}

	public Color getCurrentPlayer() {
		return CurrentPlayer;
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
	
	public boolean [][] PosibleMoves (ChessPosition SourcePosition){
		Position position = SourcePosition.toPosition(); 
		validateSourcePosition(position);
		return board.piece(position).possibleMoves(); 
		
	}
	
	public  ChessPiece performChessMove (ChessPosition sourcePosition , ChessPosition TargetPosition  ) {
		Position source = sourcePosition.toPosition();
		Position target = TargetPosition.toPosition(); 
		
		validateSourcePosition (source); 
		validadeTargetPosition (source, target); 
		
		Piece capturedPiece = MakeMove (source , target);  
		if (TestCheck(CurrentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessExp("You can´t put yourself in check "); 
		}
		
		Check = (TestCheck(Opponent(CurrentPlayer)))? true : false ; 
		
		nextTurn();
		return 	(ChessPiece) capturedPiece; 
			
	}
	
	
	
	
	private Piece MakeMove (Position source , Position target  ) {
		
		Piece p = board.removePiece(source); 
		
		Piece  CapturedPiece = board.removePiece(target); 
		
		board.placePiece(p, target);
		
		if (CapturedPiece != null  ) {
			pieceOnTheBoard.remove(CapturedPiece); 
			CapturedpieceList.add(CapturedPiece);  
		}
		
		return CapturedPiece; 
		
		
	}
	
	private void undoMove(Position Source , Position target , Piece Capturedpiece ) {
		
		Piece p = board.removePiece(target); 
		board.placePiece(p, Source);
		
		if (Capturedpiece != null ) {
			board.placePiece(Capturedpiece, target);
			CapturedpieceList.remove(Capturedpiece); 
			pieceOnTheBoard.add(Capturedpiece); 
		}
	}
	
	private void validateSourcePosition (Position position) {
		if (!board.ThereIsAPiece(position) ) {
			throw new ChessExp ("There is no piece on source position"); }
		
		if (CurrentPlayer != ((ChessPiece)board.piece(position)).getColor() ) {
			throw new ChessExp("The chosen piece not is yours");
		}
				
		if (!board.piece(position).IsThereAnyPossibleMove()) {	
			throw new ChessExp("There is possible moves for the chosen piece "); 
		}
		
	}
	
	
	private void validadeTargetPosition (Position source , Position target  ) {
		if (!board.piece(source).possibleMoves(target)) {
			throw new ChessExp("The chosen piece can't move to target position"); 
			
		}
	}
	
	private void nextTurn () {
		Turn++ ; 
		CurrentPlayer = (CurrentPlayer == Color.White ) ? Color.Black : Color.White ; 
	}
	
	private Color Opponent (Color color  ) {
		return  (color == Color.White)? Color.Black: Color.White; 
	}
	
	private ChessPiece King (Color color) {
		List<Piece> list = pieceOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()== color).collect(Collectors.toList()); 
		
		for (Piece p : list ) {
			if (p instanceof King ) {
				return (ChessPiece) p ;
			}
		}
		
		throw new IllegalStateException("There is no "+ color + " King on the board "); 
	}
	
	private boolean TestCheck (Color color ) {
		Position kingPosition = King(color).getChessPosition().toPosition();
		
		List <Piece> OponentPieces = pieceOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()== Opponent(color)).collect(Collectors.toList());
		
		for (Piece p :  OponentPieces ) {
			boolean [][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColun()] ) {
				return true ; 
			}
			
		}
		return false ; 
	}
	
	private void PlaceNewPieace (char Colunm , int Row , ChessPiece piece ) { 
		board.placePiece(piece, new  ChessPosition(Colunm, Row).toPosition());
		
		pieceOnTheBoard.add(piece); 
	}
	
	private void InitialSetUp () {
		//PlaceNewPieace('b', 6, new Rock(board, Color.White));
		PlaceNewPieace('e', 8, new King(board, Color.Black));
		//PlaceNewPieace('e', 4, new King(board, Color.White));
        PlaceNewPieace('c', 2, new Rock(board, Color.White));
        PlaceNewPieace('d', 2, new Rock(board, Color.White));
        PlaceNewPieace('e', 2, new Rock(board, Color.White));
      //  PlaceNewPieace('e', 1, new Rock(board, Color.White));
        PlaceNewPieace('d', 1, new King(board, Color.White));

        PlaceNewPieace('c', 7, new Rock(board, Color.Black));
        PlaceNewPieace('b', 5, new Rock(board, Color.Black));
        PlaceNewPieace('d', 7, new Rock(board, Color.Black));
        PlaceNewPieace('e', 7, new Rock(board, Color.Black));
       // PlaceNewPieace('e', 8, new Rock(board, Color.Black));
        PlaceNewPieace('f', 6, new King(board, Color.Black));
	} 
	
}
