package Aplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Color;

public class UI {
	
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";

		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
		// clear scream 
		public static void ClearScream () {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
		
		public static ChessPosition ReadChessPosition (Scanner sc ) {
			try {
				String s = sc.nextLine(); 
				char colunm = s.charAt(0); 
				int row = Integer.parseInt(s.substring(1)); 
				return new ChessPosition(colunm, row);	
			}catch (RuntimeException e  ) {
				throw new InputMismatchException("Error reading ChessPostion. valid values are from a1 to h8. "); 
			}
			 
		}
		
		public static void printMatch(ChessMatch chessmathc , List<ChessPiece> captureds ) {
			printBoard(chessmathc.getPieces());
			System.out.println();
			printCapturedPieces(captureds);
			System.out.println();
			System.out.println("Turn "+chessmathc.getTurn());
			
			
			if (!chessmathc.getCheckMate()) {	
				System.out.println("Waiting player "+chessmathc.getCurrentPlayer());
				if (chessmathc.getCheck()) {
					System.out.println(" CHECK!!!");
				}
			}else {
				System.out.println("!!! CHECKMATE !!!");
				System.out.println("Winner "+chessmathc.getCurrentPlayer());
			}
			
			
		}
		
		public static void printBoard (ChessPiece [][] pieces  ) {
		
		for (int i = 0 ; i < pieces.length ; i++ ) {
			
			System.out.print((8 - i) + " " );
			
			for (int j = 0 ; j < pieces.length ; j++) {
				printPiece(pieces [i] [j] , false ); 
			}
			
			System.out.println();
		}
		System.out.println("   a  b  c  d  e  f  g  h ");
	}
		
		public static void printBoard (ChessPiece [][] pieces , boolean[][] PossiblesMoves ) {
			
			for (int i = 0 ; i < pieces.length ; i++ ) {
				
				System.out.print((8 - i) + " " );
				
				for (int j = 0 ; j < pieces.length ; j++) {
					printPiece(pieces [i] [j] , PossiblesMoves[i][j] ); 
				}
				
				System.out.println();
			}
			System.out.println("   a  b  c  d  e  f  g  h ");
		}

	
		private static void printPiece(ChessPiece piece , boolean backgroud) {
			if (backgroud) {
				System.out.print(ANSI_GREEN_BACKGROUND);
			}
			
			System.out.print(" ");
	    	if (piece == null) {
	            System.out.print("-"+ ANSI_RESET);
	        }
	        else {
	            if ( piece.getColor() == Color.White) {
	                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
	            }
	            else {
	                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
	            }
	        }
	        System.out.print(" ");
		}
		
		private  static void printCapturedPieces (List <ChessPiece> captureds) {
			
			List<ChessPiece> White = captureds.stream().filter(x -> x.getColor() == Color.White).collect(Collectors.toList()); 

			List<ChessPiece> Black = captureds.stream().filter(x -> x.getColor() == Color.Black).collect(Collectors.toList()); 
			
			
			System.out.println("Captured Piceies");
			
			System.out.print("White");
			System.out.println(ANSI_WHITE);
			System.out.println(Arrays.toString(White.toArray()));
			System.out.print(ANSI_RESET);	
			
			System.out.print("Yelow");
			System.out.println(ANSI_YELLOW);
			System.out.println(Arrays.toString(Black.toArray()));
			System.out.print(ANSI_RESET);	
			
			
			
		}
}
