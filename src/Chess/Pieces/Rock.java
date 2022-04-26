package Chess.Pieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Rock extends ChessPiece {

	public Rock(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "R";
	}

	public boolean[][] possibleMoves() {

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		// marcar acima da peça
		// above
		Position p = new Position(0,0);
		
		p.setValues(position.getRow() - 1, position.getColun());

		while (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
		}

		 
		// marcar a esquerda da peça
		// left
		
		p.setValues(position.getRow() , position.getColun() -1);

		while (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
			p.setColun(p.getColun() - 1);
		}
		if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
		}

		// marcar a Direita da peça
		// reght
		p.setValues(position.getRow(), position.getColun() +1);

		while (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
			p.setColun(p.getColun() + 1);
		}
		
		if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
		}

		// marcar a baixo da peça
		// below 
		
		p.setValues(position.getRow() + 1, position.getColun());

		while (getBoard().PostionExist(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().PostionExist(p) && IsThereOponentPiece(p)) {
			mat[p.getRow()][p.getColun()] = true;
		}
		return mat;
	}
}
