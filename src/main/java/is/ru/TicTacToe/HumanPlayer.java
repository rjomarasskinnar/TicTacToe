package is.ru.TicTacToe;
import java.util.Scanner;

public class HumanPlayer extends Player {
        private int numberOfWins;
        private char token;

        public HumanPlayer(char token) {
                if(token != 'X' && token != 'O'){
                        throw new IllegalArgumentException("Please insert either X or O.");
                }
                this.numberOfWins = 0;
                this.token = token;
        }

        public void takeTurn(Board board) {
                boolean validInput = false;
                while (!validInput) {
                        Scanner in = new Scanner(System.in);
                        System.out.print("Player " + token + " please choose a box (1-9): ");
                        char input = in.next().charAt(0);
			if(Character.isDigit(input)) {
				int boxno = Character.getNumericValue(input);
                        	if (boxno >=1 && boxno <= 9)
                        	{
                                	boxno = boxno - 1;
                                	if(board.updateBoard(boxno , token)) {
                                		validInput = true;
					}
                        	}
			}
			else {
				System.out.println("Please enter a number between 1-9!");
                        }
                }
        }

        public int getWins() {
                return numberOfWins;
        }
	
	public void winner() {
		numberOfWins++;
	}

        public char getToken() {
                return token;
        }
}


