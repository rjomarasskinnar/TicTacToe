package is.ru.TicTacToe;

import java.util.*;

public class Game {
	private int numberOfGames;
	private Board board;
	private HumanPlayer p1;
	private HumanPlayer p2;

	public Game() {
		board = new Board();
		numberOfGames = 0;
		p1 = new HumanPlayer('X');
		p2 = new HumanPlayer('O');
	}

	public void newRound() {
		board = new Board();
		numberOfGames++;
	}

	public void endRound() {
		if(checkIfOver()){
			printScore();

			System.out.println("Do you wish to continue? (Y/N)");
			Scanner s = new Scanner(System.in);
			char tmp = s.next().charAt(0);
			if(tmp == 'Y' || tmp == 'y'){
				newRound();
			}
			else if(tmp == 'N' || tmp == 'n'){
				System.out.print("Game is over. Congratulations player");
				System.out.print(checkForWinner().getToken());
				System.out.println(" you are the winner!!!");
			}
		}
	}

	private void printScore() {
		System.out.print("Score: PlayerX ");
		System.out.print(p1.getWins());
		System.out.print(" - ");
		System.out.print("PlayerO ");
		System.out.println(p1.getWins());
	}

	public HumanPlayer startingPlayer() {
		if(numberOfGames % 2 == 0){
			return p1;
		}
		else {
			return p2;
		}
	}

	public boolean checkIfOver() {
		
		return false;
	}
	public static void main(String[] args) {
		Game game = new Game();
	}
	
	public HumanPlayer checkForWinner() {
		return p1;
	}
	public void setNumberOfGames(int x){
		if(x < 0){
			 throw new IllegalArgumentException("Please Insert a number higher than 0");
		}
		numberOfGames = x;
	}
}
