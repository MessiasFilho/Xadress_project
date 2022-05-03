package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean [][] mat = new boolean [getBoard().getRows()][getBoard().getColumns() ]; 
		
		Position p =new Position(0,0); 
		
		
		if (getColor() == Color.White) {
			p.setValues(position.getRow() - 1 , position.getColun());
			if (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p)) {
				mat[p.getRow()][p.getColun()] = true; 
			}	
		
			
			p.setValues(position.getRow() - 2 , position.getColun());
			
			Position p2 = new Position(position.getRow() -1 , position.getColun() ); 
			if (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p) && getBoard().PostionExist(p2) && !getBoard().ThereIsAPiece(p2) && GetMoveCount() == 0 ) {
				mat[p.getRow()][p.getColun()] = true; 
			
			}
			
			p.setValues(position.getRow() - 1 , position.getColun() - 1 );
			if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
				mat[p.getRow()][p.getColun()] = true; 
			}	
			
			p.setValues(position.getRow() - 1 , position.getColun() + 1 );
			if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
				mat[p.getRow()][p.getColun()] = true; 
			}
			
			
			
		}else {	
			
			p.setValues(position.getRow() + 1 , position.getColun());
			if (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p)) {
				mat[p.getRow()][p.getColun()] = true; 
			}	
		
			
			p.setValues(position.getRow() + 2 , position.getColun());
			
			Position p2 = new Position(position.getRow() +1 , position.getColun() ); 
			if (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p) && getBoard().PostionExist(p2) && !getBoard().ThereIsAPiece(p2) && GetMoveCount() == 0 ) {
				mat[p.getRow()][p.getColun()] = true; 
			
			}
			
			p.setValues(position.getRow() + 1 , position.getColun() - 1 );
			if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
				mat[p.getRow()][p.getColun()] = true; 
			}	
			
			p.setValues(position.getRow() + 1 , position.getColun() - 1 );
			if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
				mat[p.getRow()][p.getColun()] = true; 
			}
			
			
		}
		
		
		
		return mat;
	}

}
