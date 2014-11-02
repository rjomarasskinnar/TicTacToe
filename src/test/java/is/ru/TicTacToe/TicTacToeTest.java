package is.ru.TicTacToe;

import org.junit.Test;
import static org.junit.Assert.*;
/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'grimur' at '10/30/14 3:18 PM' with Gradle 2.1
 *
 * @author grimur, @date 10/30/14 3:18 PM
 */
public class TicTacToeTest {
    	@Test (expected = IllegalArgumentException.class)
	public void testIncorrectCharAsVariableInHumanPlayerConstrustor() {
	    HumanPlayer Player1 = new HumanPlayer('Y');
	}

	@Test
	public void testBoardIsFullWithNonFullBoard() {
            HumanPlayer p1 = new HumanPlayer('X'); // create new player with token X
            Board testBoard = new Board(); //creates a new board
            testBoard.updateBoard(0, p1.getToken()); //put some values in
            testBoard.updateBoard(3, p1.getToken()); //but not enough
            testBoard.updateBoard(6, p1.getToken()); //to fill the board
            testBoard.updateBoard(2, p1.getToken());
            testBoard.updateBoard(8, p1.getToken());
            assertEquals(false, testBoard.boardIsFull());
    	}

    	@Test
    	public void testBoardIsFullWithFullBoard() {
            HumanPlayer p1 = new HumanPlayer('X'); // create new player with token X
            Board testBoard = new Board(); //creates a new board
            for(int i = 0; i < 9; i++){
            	testBoard.updateBoard(i, p1.getToken()); //fills the board with X's
            }
            assertEquals(true, testBoard.boardIsFull());
    	}

	@Test
	public void testStarterPlayerOdd(){
		Game testgame = new Game();
		testgame.setNumberOfGames(7);//odd number = should return player 2
		HumanPlayer p = testgame.startingPlayer();
		assertEquals('O', p.getToken());
	}

	@Test
        public void testStarterPlayerEven(){
                Game testgame = new Game();
                testgame.setNumberOfGames(8); //Even number = should return player 1
		HumanPlayer p = testgame.startingPlayer();
                assertEquals('X', p.getToken());
	}

	@Test(expected = IllegalArgumentException.class)
        public void testSetNumberOfGamesNegative(){
               	Game testgame = new Game();
		testgame.setNumberOfGames(-8); //Negative number should throw an exception
	}
	@Test
	public void testCheckForWinnerHorizontal(){
		Game testGame = new Game();
		testGame.getBoard().updateBoard(0, 'X');
		testGame.getBoard().updateBoard(1, 'X');
		testGame.getBoard().updateBoard(2, 'X');
		assertEquals(true, testGame.checkForWinner('X'));
	}

	@Test
        public void testCheckForWinnerVertical(){
                Game testGame = new Game();
                testGame.getBoard().updateBoard(1, 'X');
                testGame.getBoard().updateBoard(4, 'X');
                testGame.getBoard().updateBoard(7, 'X');
                assertEquals(true, testGame.checkForWinner('X'));
        }

	@Test
        public void testCheckForWinnerDiagonal(){
                Game testGame = new Game();
                testGame.getBoard().updateBoard(2, 'X');
                testGame.getBoard().updateBoard(4, 'X');
                testGame.getBoard().updateBoard(6, 'X');
                assertEquals(true, testGame.checkForWinner('X'));
        }
	
	@Test
	public void testCheckForWinnerNoWin(){
                Game testGame = new Game();
                testGame.getBoard().updateBoard(0, 'X');
                testGame.getBoard().updateBoard(4, 'X');
                testGame.getBoard().updateBoard(5, 'X');
                assertEquals(false, testGame.checkForWinner('X'));
        }

	@Test
	public void testIsOverWinner() {
		Game testGame = new Game();
		testGame.getBoard().updateBoard(0, 'X');
		testGame.getBoard().updateBoard(1, 'X');
		testGame.getBoard().updateBoard(2, 'X');
		assertEquals(true, testGame.isOver());
	}
	
	@Test
	public void testIsOverFullBoard() {
		Game testGame = new Game();
		testGame.getBoard().updateBoard(0, 'O');
		testGame.getBoard().updateBoard(1, 'X');
                testGame.getBoard().updateBoard(2, 'O');
                testGame.getBoard().updateBoard(3, 'X');
		testGame.getBoard().updateBoard(4, 'O');
                testGame.getBoard().updateBoard(5, 'X');
                testGame.getBoard().updateBoard(6, 'O');
		testGame.getBoard().updateBoard(7, 'X');
                testGame.getBoard().updateBoard(8, 'O');
		assertEquals(true, testGame.isOver());
	}
	
	@Test
	public void testIsOverNoWinnerNotFull() {
		Game testGame = new Game();
		testGame.getBoard().updateBoard(1, 'X');
                testGame.getBoard().updateBoard(5, 'O');
                testGame.getBoard().updateBoard(3, 'X');
		assertEquals(false, testGame.isOver());
	}
	
	@Test
	public void testUpdateBoardEmptyBoard() {
		Board board = new Board();
		assertEquals(true, board.updateBoard(1, 'X'));
	}
	
	@Test
	public void testUpdateBoardSameBox() {
		Board board = new Board();
		board.updateBoard(1, 'X');
		assertEquals(false, board.updateBoard(1, 'O'));
	}
}
