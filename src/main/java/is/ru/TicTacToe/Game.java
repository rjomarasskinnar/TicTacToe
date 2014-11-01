package is.ru.TicTacToe;

import java.util.*;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Game {
	private int numberOfGames;
	private Board board;
	private HumanPlayer p1;
	private HumanPlayer p2;
	private AIPlayer a1;	
	public ObjectProperty<HumanPlayer> whoseTurn = new SimpleObjectProperty<HumanPlayer>();
	//private int turns;

	public Game() {
		board = new Board();
		numberOfGames = 0;
		p1 = new HumanPlayer('X');
		p2 = new HumanPlayer('O');
		a1 = new AIPlayer('X');	
		whoseTurn.set(startingPlayer());
		//turns = 0;
	}

	public void newRound() {
		board = new Board();
		numberOfGames++;
		play();
		endRound();
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
				System.out.print("Game is over. Congratulations Player ");
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
		System.out.print("Score: Player X ");
		System.out.print(p1.getWins());
		System.out.print(" - ");
		System.out.print("Player O ");
		System.out.println(p2.getWins());
	}

	public HumanPlayer startingPlayer() {
		if(numberOfGames % 2 == 0){
			return p1;
		}
		else {
			return p2;
		}
	}

	public HumanPlayer whoPlays() {
		if(turns % 2 == 0){
                        return p1;
                }
                else {
                        return p2;
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

	public Player getHumanPlayer1() {
		return p1;
	}

	public Player getHumanPlayer2() {
		return p2;
	}

	public Player getAIPlayer() {
		return a1;
	}

	public Board getBoard(){
		return board;
	}
	
	public void play() {
		//board.printBoard();
		startingPlayer().takeTurn(board);
		board.printBoard();
		turns++;
		while (!isOver()) {
			whoPlays().takeTurn(board);
			board.printBoard();
			turns++;
		}
		if (checkForWinner('X')) {
			p1.winner();
		} 
		else if (checkForWinner('O')) {
			p2.winner();
		}
		else {
			System.out.println("It's a tie!");
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
		game.instructions();	
		game.play();
		game.endRound();
	}
	
	public void takeTurn(int cell) {
		if (cell >= 0 && cell <= 8)
        {
                board.updateBoard(cell , whoseTurn.get().getToken());
                if(whoseTurn.get() == p1) {
                	whoseTurn.set(p2);
                }
                else {
                	whoseTurn.set(p1);
                }
        }
	}
}

