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

	public void takeTurn(Board board[][], HumanPlayer p) {
		boolean validInput = false;
		while (!validInput) {
			System.out.println("Player " + p.token + " please choose a box (1-9): ");
			int boxno = System.in.read();
			boxno--;
			if (board[boxno / 3][boxno % 3] == ' ') {

				board[boxno / 3][boxno % 3] = p.token;
				validInput = true;
			
			} else {
				System.out.println("This box is already taken!");
			}
		}
	}

	public int getWins() {
		return numberOfWins;
	}

	public char getToken() {
		return token;
	}
}

