package is.ru.TicTacToe;

import java.util.*;

public class Game {
	private int numberOfGames = 0;
	
	public void newGame() {
		Board board = new Board();
		HumanPlayer p1 = new HumanPlayer('X');
		HumanPlayer p2 = new HumanPlayer('O');
		numberOfGames = 0;
	}
	
	public void newRound(HumanPlayer p1, HumanPlayer p2) {
		Board board = new Board();
		numberOfGames++;
	}
	
	public void endRound(HumanPlayer p1, HumanPlayer p2) {
		if(checkIfOver()){
			System.out.print("Score: PlayerX ");
			System.out.print(p1.getWins());
			System.out.print(" - ");
			System.out.print("PlayerO ");
			System.out.println(p1.getWins());

			System.out.println("Do you wish to continue? (Y/N)");
			Scanner s = new Scanner(System.in);
			char tmp = s.next().charAt(0);
			if(tmp == 'Y' || tmp == 'y'){
				newRound(p1, p2);
			}
			else if(tmp == 'N' || tmp == 'n'){
				System.out.print("Game is over. Congratulations player");
				System.out.print(checkForWinner(p1, p2).getToken());
				System.out.println(" you are the winner!!!");
			}
		}
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

	public static void main(String[] args) {
		Game game = new Game();
		game.newGame();
	}
	
	public HumanPlayer checkForWinner(HumanPlayer p1, HumanPlayer p2) {
		return p1;
	} 
}
