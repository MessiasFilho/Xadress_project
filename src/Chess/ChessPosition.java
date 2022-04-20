package Chess;

import BoardGame.Position;

public class ChessPosition {
	
	private char Colunm;  
	private int Row ;
	
	
	public ChessPosition(char colunm, int row) {
		
		if (colunm < 'a' || colunm > 'h'  || row < 1 || row > 8  ) {
			throw new ChessExp ("Erro intantiating ChessPosition. valid values are h1 to h8 "); 
		}
		
		Colunm = colunm;
		Row = row;
	}


	public char getColunm() {
		return Colunm;
	}


	public int getRow() {
		return Row;
	}
	
	protected Position toPosition () {
		return new Position (8 -  Row , Colunm - 'a' ); 
	}
	
	protected static ChessPosition fromPosition (Position position ) {
		return new ChessPosition((char) ('a' - position.getColun()) , 8 - position.getRow()); 
		
	}
	
	@Override
	public String toString() {
		
		return "" + Colunm + Row;
	}
	
	
	
}
