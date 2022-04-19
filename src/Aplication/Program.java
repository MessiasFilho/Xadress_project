package Aplication;

import Chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ChessMatch mat = new ChessMatch(); 
		
		UI.printBoard(mat.getPieces()); 
	}

}
