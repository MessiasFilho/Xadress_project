package Aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessExp;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner (System.in); 
		ChessMatch mat = new ChessMatch(); 
		
		while (true) {
			try {
				UI.ClearScream();
				UI.printBoard(mat.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.ReadChessPosition(sc);
				
				System.out.println();
				
				System.out.print("Tareget: ");
				
				ChessPosition target = UI.ReadChessPosition(sc); 
				
					ChessPiece capturedPiece = mat.performChessMove(source, target); 
			}catch(ChessExp e ) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e ) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}
		 
		
		
	}

}
