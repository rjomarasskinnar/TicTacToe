package TicTacToe;

public class Game {
	private int numberOfGames = 0;
	
	public void newGame() {
		
	}
	
	public void newRound() {
		
	}
	
	public void endRound() {
		
	}
	
	public HumanPlayer startingPlayer(HumanPlayer p1, HumanPlayer p2) {
		return p1;
	}
	
	public boolean checkIfOver() {
		return false;
	}
	
	public HumanPlayer checkForWinner() {
		return new HumanPlayer();
	}
}
