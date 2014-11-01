package is.ru.TicTacToe;
import java.util.Random;

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

	public void takeTurn(Board board) {
		if (winPossible(token, board) != -1) { // if win is possible in next move
			board.updateBoard(winPossible(token, board), token);
		}
		else if (lossPrevention(board) != -1) { //loss prevention
			board.updateBoard(lossPrevention(board), token);
		} 
		else {
			board.updateBoard(preferredMove(board), token);
		}
	}
	public void winner() {
		numberOfWins++;
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
			if (cellEmpty(board, c)) {
				return c;
			}
			else {
				return -1;
			}
		}
		else if (board.getBoardCells(a) == checkToken && board.getBoardCells(c) == checkToken) {
			if (cellEmpty(board, b)) {
				return b;
			}
			else {
				return -1;
			}
		}
		else if (board.getBoardCells(b) == checkToken && board.getBoardCells(c) == checkToken) {
			if (cellEmpty(board, a)) {
				return a;
			}
			else {
				return -1;
			}
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
		int enemyWin = winPossible(enemyToken, board);
		if (enemyWin != -1) {
			return enemyWin; 
		}
		else {
			return -1;
		}
	}
	private int preferredMove(Board board) {
		char enemyToken = getEnemyToken();
		Random r = new Random();

		if (evaluate(board) == 0) { //first = put in corners
			return randomCorner();
		} 
		else if (evaluate(board) == 1) { // second = put in center if p1 put in corner
			if (board.getBoardCells(0) == enemyToken || 
				board.getBoardCells(2) == enemyToken || 
				board.getBoardCells(6) == enemyToken || 
				board.getBoardCells(8) == enemyToken) {
				return 4;
			}
			else if (board.getBoardCells(4) == enemyToken) { // p1 put in center, put in corner
				return randomCorner();
			}
		}
		else {
			int rand = 0;
			do {
				rand = r.nextInt(8);
			} while (board.getBoardCells(rand) != ' ');
			return rand;
		}
		return 0;
	}
	private boolean cellEmpty(Board board, int cell) {
		if (board.getBoardCells(cell) == ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	private int evaluate(Board board) {
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (board.getBoardCells(i) != ' ') {
				count++;
			}
		}
		return count;
	}
	private int randomCorner() {
		Random r = new Random();
		int rand = r.nextInt(3);
			if (rand == 0) {
				return 0;
			}
			else if (rand == 1) {
				return 2;
			}
			else if (rand == 2) {
				return 6;
			}
			else {
				return 8;
			}
	}
}
