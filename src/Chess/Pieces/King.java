package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece{

	public King  (Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "K";
	}
	
	
	
	
	private boolean CanMove (Position posit ) {
		ChessPiece pec =(ChessPiece) getBoard().piece(posit);
		return pec == null  || pec.getColor() != getColor();
		
	}
	
	@Override
	public boolean[][] possibleMoves() {
		
		boolean [][]  mat = new boolean [getBoard().getRows()][getBoard().getColumns()] ; 
		
		Position p = new Position(0,0); 
		
		//above
		p.setValues(position.getRow() -1 , position.getColun());
		if (getBoard().PostionExist(p) && CanMove(p)  ) {
			mat[p.getRow()][p.getColun()] = true ; 
		}
		
		// below
		p.setValues(position.getRow() + 1 , position.getColun());
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		
		//left 
		p.setValues(position.getRow(), position.getColun() +1 );
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		
		// right 
		p.setValues(position.getRow(), position.getColun() - 1 );
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		
		// Ne 
		p.setValues(position.getRow() -1 ,  position.getColun() -1 );
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		// Se
		p.setValues(position.getRow() + 1 , position.getColun()-1);
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		
		//So 
		
		p.setValues(position.getRow() - 1 , position.getColun()+1);
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		// No 
		
		p.setValues(position.getRow() + 1 , position.getColun() +1 );
		if (getBoard().PostionExist(p) && CanMove(p) ) {
			mat[p.getRow()][p.getColun()] = true ;
		}
		  
		
		
		return mat;
	}
	
	
}
