package is.ru.TicTacToe;

public class AIPlayer extends Player{

	private int numberOfWins;
	private char token;

	public AIPlayer(char token) {
		if(token != 'X' && token != 'O'){
            throw new IllegalArgumentException("Please Insert either X or O");
        }
        this.numberOfWins = 0;
        this.token = token;
	}
	private char getEnemyToken() {
		if (token == 'X') {
			return 'O';
		}
		else {
			return 'X';
		}
	}

	public void takeTurn(Board board, AIPlayer a) {
		if (lossPrevention() != -1) { //loss prevention
			board.updateBoard(lossPrevention(board), a);
		} 
		else if (winPossible(token) != -1) { // if win is possible in next move
			board.updateBoard(winPossible(token, board), a);
		}
		else {
			board.updateBoard(preferredMove(board), a);
		}

		//board.updateBoard(bestMove(), a);
	}

	private int winPossible(char checkToken, Board board) {
		//8 ways to win
		/*
			1. 0-1-2
			2. 3-4-5
			3. 6-7-8
			4. 0-3-6
			5. 1-4-7
			6. 2-5-8
			7. 0-4-8
			8. 2-4-6
		*/
		if (checkThrees(0, 1, 2, board, checkToken) != -1) {
			return checkThrees(0, 1, 2, board, checkToken);
		}
		else if (checkThrees(3, 4, 5, board, checkToken) != -1) {
			return checkThrees(3, 4, 5, board, checkToken);
		}
		else if (checkThrees(6, 7, 8, board, checkToken) != -1) {
			return checkThrees(6, 7, 8, board, checkToken);
		}
		else if (checkThrees(0, 3, 6, board, checkToken) != -1) {
			return checkThrees(0, 3, 6, board, checkToken);
		}
		else if (checkThrees(1, 4, 7, board, checkToken) != -1) {
			return checkThrees(1, 4, 7, board, checkToken);
		}
		else if (checkThrees(2, 5, 8, board, checkToken) != -1) {
			return checkThrees(2, 5, 8, board, checkToken);
		}
		else if (checkThrees(0, 4, 8, board, checkToken) != -1) {
			return checkThrees(0, 4, 8, board, checkToken);
		}
		else if (checkThrees(2, 4, 6, board, checkToken) != -1) {
			return checkThrees(2, 4, 6, board, checkToken);
		}
		return -1;
	}	
	private int checkThrees(int a, int b, int c, Board board, char checkToken) {
		if (board.getBoardCells(a) == checkToken && board.getBoardCells(b) == checkToken) {
			return c;
		}
		else if (board.getBoardCells(a) == checkToken && board.getBoardCells(c) == checkToken) {
			return b;
		}
		else if (board.getBoardCells(b) == checkToken && board.getBoardCells(c) == checkToken) {
			return a;
		}
		else {
			return -1;
		}
	}
	private int lossPrevention(Board board) {
		//check if loss prevention is possible
		//if other player can't win next turn,
		//take turn
		char enemyToken = getEnemyToken();
		int enemyWin = winPossible(enemyToken);
		if (enemyWin != -1) {
			return enemyWin; 
		}
		else {
			return -1;
		}
	}
	private int preferredMove(Board board) {
		return 0;
	}
}