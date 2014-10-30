package is.ru.TicTacToe;

public class HumanPlayer {
	private int numberOfWins;
	private char token;

	public HumanPlayer(char token) {
		if(token != 'X' && token != 'O'){
			throw new IllegalArgumentException("Please Insert either X or O");
		}
		this.numberOfWins = 0;
		this.token = token;
	}

	public void takeTurn(Board board) {

	}

	public int getWins() {
		return numberOfWins;
	}

}

