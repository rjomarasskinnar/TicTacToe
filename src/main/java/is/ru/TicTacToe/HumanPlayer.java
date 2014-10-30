package is.ru.TicTacToe;

public class HumanPlayer {
	private int numberOfWins;

	public HumanPlayer(char token) {
		if(token != 'X' && token != 'O'){
			throw new IllegalArgumentException("Please Insert either X or O");
		}
		numberOfWins = 0;
		token = token;
	}

	public void takeTurn(Board board) {

	}

	public int getWins() {
		return numberOfWins;
	}

}

