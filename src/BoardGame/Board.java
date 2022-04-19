package BoardGame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		
		if (rows < 1 || columns < 1  ) {
			throw new BoardExp(" Error creating Board : there be at last 1 row and 1 colunm "); 
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];

	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int colun) {
		if (!PostionExist(row , colun) ) {
			throw new BoardExp("Error Postion not on the Board "); 
		}
		return pieces[row][colun];
	}

	public Piece piece(Position position) {
		if (!PostionExist(position) ) {
			throw new BoardExp("Error Postion not on the Board "); 
		}
		
		return pieces[position.getRow()][position.getColun()];
	}

	public void placePiece(Piece piece, Position position) {
		if (ThereIsAPiece(position)) {
			throw new BoardExp("there is already a piece on position "+ position); 
		}
		
		pieces[position.getRow()][position.getColun()] = piece;
		piece.position = position;
	
	}

	private boolean PostionExist(int row , int colunm ) {
		 return row >= 0  && row < rows && colunm >= 0 && colunm < columns  ;
	}

	public boolean PostionExist(Position position) {
		
		return PostionExist(position.getRow() , position.getColun() ); 
	}

	public boolean ThereIsAPiece(Position position) {	
		if (!PostionExist(position) ) {
			throw new BoardExp("Error Postion not on the Board "); 
		}	
	 	return piece(position)!= null ;   
				
	}

}
