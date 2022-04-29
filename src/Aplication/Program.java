package Aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPiece> captured = new ArrayList<>(); 
		
		
		
		while (true) {
			try {
				UI.ClearScream();
				UI.printMatch(mat , captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.ReadChessPosition(sc);
				
				boolean [][]possibleMoves = mat.PosibleMoves(source); 
				UI.ClearScream();
				UI.printBoard(mat.getPieces() , possibleMoves );
				
				System.out.println();
				
				System.out.print("Tareget: ");
				
				ChessPosition target = UI.ReadChessPosition(sc); 
				
					ChessPiece capturedPiece = mat.performChessMove(source, target); 
					
					if (capturedPiece != null) {
						captured.add(capturedPiece); 
					}
			}
			catch(ChessExp e ) {
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
