package is.ru.TicTacToe;
import java.util.Scanner;

public class HumanPlayer extends Player {
        private int numberOfWins;
        private char token;


        public HumanPlayer(char token) {
                if(token != 'X' && token != 'O'){
                        throw new IllegalArgumentException("Please insert either X or O");
                }
                this.numberOfWins = 0;
                this.token = token;
        }

        public void takeTurn(Board board) {
                boolean validInput = false;
                while (!validInput) {
                        Scanner in = new Scanner(System.in);
<<<<<<< HEAD
                        System.out.println("Player " + token + " please choose a box (1-9): ");
=======
                        System.out.print("Player " + token + " please choose a box (1-9): ");
>>>>>>> master
                        int boxno = in.nextInt();
                        if (boxno >=1 && boxno <= 9)
                        {
                                boxno = boxno - 1;
<<<<<<< HEAD
                                board.updateBoard(boxno , token);
                                validInput = true;
=======
                                if(board.updateBoard(boxno , token)) {
                                	validInput = true;
				}
>>>>>>> master
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



