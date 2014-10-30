package TicTacToe;

public class HumanPlayer {
	private int numberOfWins = 0;
	
	public HumanPlayer(char token) {
		if(token != 'X' && token != 'O'){
			throw new IllegalArgumentException("Please Insert either X or O");
		}
		int score = 0;
		token = token;
	}

	public void takeTurn(Board board) {
		
	}

	public int score() {
		return 0;
	}
}

