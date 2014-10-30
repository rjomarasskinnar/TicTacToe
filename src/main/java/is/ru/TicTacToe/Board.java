package is.ru.TicTacToe;

public class Board {
	private char[][] board = new char[3][3];
	
	public void printBoard() {
		
	}
	
	public void clearBoard() {
		
	}
	
	public void updateBoard(int x, int y, HumanPlayer p) {
		
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

