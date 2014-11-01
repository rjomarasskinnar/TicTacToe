package is.ru.TicTacToe;

public class Board {
	private char[] board = new char[9];

	public Board() {
		for(int i = 0; i < 9; i++){
				board[i] = ' ';
		}// initializes Board cells with whitespace in them
	}

	public void printBoard() {
		System.out.printf(" %s %s %s %s %s\n", board[0], "|", board[1], "|", board[2]);
		System.out.printf("-----------\n");
		System.out.printf(" %s %s %s %s %s\n", board[3], "|", board[4], "|", board[5]);
		System.out.printf("-----------\n");
		System.out.printf(" %s %s %s %s %s\n", board[6], "|", board[7], "|", board[8]);
	}

	public boolean updateBoard(int x, char token) {
		if (board[x] != ' ') {
			//throw new IllegalArgumentException("Cannot put " + token + " there, the cell has already been ticked");
			System.out.println("Cannot put " + token + " there, the cell has already been ticked");
			return false;
		}
		else {
			board[x] = token;
			return true;
		}
	}

	public boolean boardIsFull(){
		for(int i = 0; i < 9; i++){
			if(board[i] == ' '){
				return false;
			}
		}
		return true;
	}

	// for AI
	public char getBoardCells(int cell) {
		return board[cell];
	}
}

