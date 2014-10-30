package is.ru.TicTacToe;

public class Game {
	private int numberOfGames = 0;
	
	public void newGame() {
		Board board = new Board();
		HumanPlayer p1 = new HumanPlayer('X');
		HumanPlayer p2 = new HumanPlayer('O');
	}
	
	public void newRound(HumanPlayer p1, HumanPlayer p2) {
		Board board = new Board();
	}
	
	public void endRound() {
		
	}
	
	public HumanPlayer startingPlayer(HumanPlayer p1, HumanPlayer p2) {
		return p1;
	}
	
	public boolean checkIfOver() {
		return false;
	}
	/*	
	public HumanPlayer checkForWinner() {
		return new HumanPlayer();
	} */
}
