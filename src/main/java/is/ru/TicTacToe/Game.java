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
		if(isOver()){
			printScore();

			System.out.println("Do you wish to continue? (Y/N)");
			Scanner s = new Scanner(System.in);
			char tmp = s.next().charAt(0);
			if(tmp == 'Y' || tmp == 'y'){
				newRound();
			}
			else if(tmp == 'N' || tmp == 'n'){
				System.out.print("Game is over. Congratulations player");
				if(p1.getWins() > p2.getWins()){
					System.out.print(p1.getToken());
					System.out.println(" you are the winner!!!");
				}
				else if (p2.getWins() > p1.getWins()){
					System.out.print(p2.getToken());
					System.out.println(" you are the winner!!!");
				}
				else{
					System.out.println("Game is over. It´s a tie");
				}
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

	public boolean isOver() {
		return true;
	}
	public static void main(String[] args) {
		Game game = new Game();
	}
	
	public boolean checkForWinner(char token) {
		boolean topLine = false;
		boolean middleLineHorizontal = false;
		boolean bottomLine = false;
		boolean leftLine = false;
		boolean middleLineVertical = false;
		boolean rightLine = false;
		boolean rightDiagonal = false;
		boolean leftDiagonal = false;

		if(board[0] == token && 
		   board[1] == token && 
		   board[2] == token) {
			firstLine = true
		}

		if(board[3] == token && 
		   board[4] == token && 
		   board[5] == token) {
			middleLineHorizontal = true
		}

		if(board[6] == token && 
		   board[7] == token && 
		   board[8] == token) {
			bottomLine = true
		}

		if(board[0] == token && 
		   board[3] == token && 
		   board[6] == token) {
			leftLine = true
		}

		if(board[1] == token && 
		   board[4] == token && 
		   board[7] == token) {
			middleLineVertical = true
		}

		if(board[2] == token && 
		   board[5] == token && 
		   board[8] == token) {
			rightLine = true
		}

		if(board[0] == token && 
		   board[4] == token && 
		   board[8] == token) {
			rightDiagonal = true
		}

		if(board[2] == token && 
		   board[4] == token && 
		   board[6] == token) {
			leftDiagonal = true
		}

		return (topLine || 
			middleLineHorizontal || 
			bottomLine || 
			leftLine || 
			middleLineVertical || 
			rightLine || 
			rightDiagonal || 
			leftDiagonal);
	}

	public void setNumberOfGames(int x){
		if(x < 0){
			 throw new IllegalArgumentException("Please Insert a number higher than 0");
		}
		numberOfGames = x;
	}

	public Board getBoard(){
		return board;
	}
}
