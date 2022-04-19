package BoardGame;

public class Position {
	
	private int Row ; 
	private int Colun ;
	
	
	public Position(int row, int colun) {
		super();
		Row = row;
		Colun = colun;
	}


	public int getRow() {
		return Row;
	}


	public void setRow(int row) {
		Row = row;
	}


	public int getColun() {
		return Colun;
	}


	public void setColun(int colun) {
		Colun = colun;
	} 
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Row + "" + Colun;
}

}
