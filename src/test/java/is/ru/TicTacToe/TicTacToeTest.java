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
            testBoard.updateBoard(0, p1); //put some values in
            testBoard.updateBoard(3, p1); //but not enough
            testBoard.updateBoard(6, p1); //to fill the board
            testBoard.updateBoard(2, p1);
            testBoard.updateBoard(8, p1);
            assertEquals(false, testBoard.boardIsFull());
    }
    @Test
    public void testBoardIsFullWithFullBoard() {
            HumanPlayer p1 = new HumanPlayer('X'); // create new player with token X
            Board testBoard = new Board(); //creates a new board
            for(int i = 0; i < 9; i++){
                            testBoard.updateBoard(i, p1); //fills the board with X's
            }
            assertEquals(true, testBoard.boardIsFull());


    }
	@Test
	public void testStarterPlayerOdd(){
		Game testgame = new Game();
		HumanPlayer p1 = new HumanPlayer('X');
		HumanPlayer p2 = new HumanPlayer('O');//makes the 2 neccesary players to be able to call the function
		testgame.setNumberOfGames(7);//odd number = should return player 2
		assertEquals(p2, testgame.startingPlayer(p1, p2));
	}
	@Test
        public void testStarterPlayerEven(){
                Game testgame = new Game();
                HumanPlayer p1 = new HumanPlayer('X');
                HumanPlayer p2 = new HumanPlayer('O');//makes the 2 neccesary players to be able to call the function
                testgame.setNumberOfGames(8);//Even number = should return player 1
                assertEquals(p1, testgame.startingPlayer(p1, p2));

	}

	 @Test(expected = IllegalArgumentException.class)
        public void testSetNumberOfGamesNegative(){
               Game testgame = new Game();
		 testgame.setNumberOfGames(-8);//Negative number should throw an exception
	}
}
