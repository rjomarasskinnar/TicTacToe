package is.ru.TicTacToe;

public class AIPlayer {

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
			board.updateBoard(lossPrevention(), a);
		} 
		else if (winPossible(token) != -1) { // if win is possible in next move
			board.updateBoard(winPossible(token), a);
		}
		else {
			board.updateBoard(preferredMove(), a);
		}

		//board.updateBoard(bestMove(), a);
	}

	private int winPossible(char checkToken) {
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

		return -1;
	}	
	public int lossPrevention() {
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
	public int preferredMove() {
		return 0;
	}
}