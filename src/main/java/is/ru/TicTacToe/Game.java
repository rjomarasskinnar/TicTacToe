package is.ru.TicTacToe;

import java.util.*;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Game {
	private int numberOfGames;
	private int turns;
	private Board board;
	private HumanPlayer p1;
	private HumanPlayer p2;
	private AIPlayer a1;
	public ObjectProperty<HumanPlayer> whoseTurn = new SimpleObjectProperty<HumanPlayer>();

	public Game() {
		board = new Board();
		numberOfGames = 0;
		turns = 0;
		p1 = new HumanPlayer('X');
		p2 = new HumanPlayer('O');
		a1 = new AIPlayer('X');
	}

	public void newRound(char players) {
		board = new Board();
		numberOfGames++;
		play(players);
		endRound(players);
	}

	public void endRound(char players) {
		if(isOver()){
			printScore();

			System.out.println("Do you wish to continue? (Y/N)");
			Scanner s = new Scanner(System.in);
			char tmp = s.next().charAt(0);
			if(tmp == 'Y' || tmp == 'y'){
				newRound(players);
			}
			else if(tmp == 'N' || tmp == 'n'){
				System.out.print("Game is over. Congratulations Player ");
				if(p1.getWins() > p2.getWins()){
					System.out.print(p1.getToken());
					System.out.println(" you are the winner!!!");
				}
				else if (players == '1') {
					if (a1.getWins() > p1.getWins()) {
						System.out.print(a1.getToken());
						System.out.println(" is the winner!");
					}
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
		System.out.print("Score: Player X ");
		System.out.print(p1.getWins());
		System.out.print(" - ");
		System.out.print("Player O ");
		System.out.println(p2.getWins());
	}

	public char startingPlayer(char players) {
		if(numberOfGames % 2 == 0){
			return 'p1';
		}
		else {
			if (players == '2') { return 'p2'; }
            		else { return 'a1'; }
		}
	}
	public char whoPlays(char players) {
		if(turns % 2 == 0){
            return 'p1';
    	}
    	else {
    		if (players == '2') { return 'p2'; }
        	else { return 'a1'; }
    	}
    }
	public boolean isOver() {
		if (checkForWinner('X')) {
			return true;
		}
		else if (checkForWinner('O')) {
			return true;
		}
		else if (board.boardIsFull()) {
			return true;
		}
		else {
			return false;
		}
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

		if(board.getBoardCells(0) == token && 
		   board.getBoardCells(1) == token && 
		   board.getBoardCells(2) == token) {
			topLine = true;
		}

		if(board.getBoardCells(3) == token && 
		   board.getBoardCells(4) == token && 
		   board.getBoardCells(5) == token) {
			middleLineHorizontal = true;
		}

		if(board.getBoardCells(6) == token && 
		   board.getBoardCells(7) == token && 
		   board.getBoardCells(8) == token) {
			bottomLine = true;
		}

		if(board.getBoardCells(0) == token && 
		   board.getBoardCells(3) == token && 
		   board.getBoardCells(6) == token) {
			leftLine = true;
		}

		if(board.getBoardCells(1) == token && 
		   board.getBoardCells(4) == token && 
		   board.getBoardCells(7) == token) {
			middleLineVertical = true;
		}

		if(board.getBoardCells(2) == token && 
		   board.getBoardCells(5) == token && 
		   board.getBoardCells(8) == token) {
			rightLine = true;
		}

		if(board.getBoardCells(0) == token && 
		   board.getBoardCells(4) == token && 
		   board.getBoardCells(8) == token) {
			rightDiagonal = true;
		}

		if(board.getBoardCells(2) == token && 
		   board.getBoardCells(4) == token && 
		   board.getBoardCells(6) == token) {
			leftDiagonal = true;
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

	public HumanPlayer getHumanPlayer1() {
		return p1;
	}

	public HumanPlayer getHumanPlayer2() {
		return p2;
	}

	public AIPlayer getAIPlayer() {
		return a1;
	}

	public Board getBoard(){
		return board;
	}

	public void play(char players) {
		char currentPlayer = startingPlayer(players);
		playTurn(currentPlayer);
		board.printBoard();
		turns++;
		while (!isOver()) {
			currentPlayer = whoPlays(players);
			playTurn(currentPlayer);
			board.printBoard();
			turns++;
		}
		if (checkForWinner('X')) {
			p1.winner();
		}
		else if (checkForWinner('O')) {
			if (players == '2') { 
					p2.winner();
				}
        	else {
				a1.winner(); 
			}
		}
		else {
			System.out.println("It's a tie!");
		}
	}

	public void playTurn(char player) {
		if (player == 'p1') {
			p1.takeTurn(board);
		}
		else if (player == 'p2') {
			p2.takeTurn(board);
		}
		else {
			a1.takeTurn(board);
		}
	}

	public void instructions() {
		System.out.printf(" %s %s %s %s %s\n", '1', "|", '2', "|", '3');
        System.out.printf("-----------\n");
        System.out.printf(" %s %s %s %s %s\n", '4', "|", '5', "|", '6');
        System.out.printf("-----------\n");
        System.out.printf(" %s %s %s %s %s\n", '7', "|", '8', "|", '9');
	}

	public static void main(String[] args) {
		Game game = new Game();
		System.out.printf("1 player or 2 players? (1/2) ");
                Scanner s = new Scanner(System.in);
                        char tmp = s.next().charAt(0);
		game.instructions();
		game.play(tmp);
		game.endRound(tmp);
	}
}

