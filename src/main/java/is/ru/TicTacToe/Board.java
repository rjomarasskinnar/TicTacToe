package is.ru.TicTacToe;

public class Board {
	private char[][] board = new char[3][3];
	
	public void printBoard() {
		System.out.printf(" %s %s %s %s %s\n", board[0][0], "|", board[0][1], "|", board[0][2]);
		System.out.printf("-----------\n");
		System.out.printf(" %s %s %s %s %s\n", board[1][0], "|", board[1][1], "|", board[1][2]);
		System.out.printf("-----------\n");
		System.out.printf(" %s %s %s %s %s\n", board[2][0], "|", board[2][1], "|", board[2][2]);
	}
	
	public void clearBoard() {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = '';
				}
			}
		}
	}
	
	public void updateBoard(int x, int y, HumanPlayer p) {
		if (board[x][y] != '') {
			throw new IllegalArgumentException("Cannot put " + p.token + " there, the cell has already been ticked");
		}
		else {
			board[x][y] = p.token;
		}
	}
	public boolean boardIsFull(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == ' '){
					return false;
				}
			}
		}
		return true;

	}
}

