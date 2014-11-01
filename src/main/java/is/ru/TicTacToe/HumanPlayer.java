package is.ru.TicTacToe;
import java.util.Scanner;

public class HumanPlayer extends Player {
        private int numberOfWins;
        private char token;

        public HumanPlayer(char token) {
                if(token != 'X' && token != 'O'){
                        throw new IllegalArgumentException("Please Insert either X or O");
                }
                this.numberOfWins = 0;
                this.token = token;
        }

        public void takeTurn(Board board, HumanPlayer p) {
                boolean validInput = false;
                while (!validInput) {
                        Scanner in = new Scanner(System.in);
                        System.out.println("Player " + p.getToken() + " please choose a box (1-9): ");
                        int boxno = in.nextInt();
                        if (boxno <=1 && boxno <= 9)
                        {
                                boxno = boxno - 1;
                                board.updateBoard(boxno , p);
                                validInput = true;
                        }

                }
        }

        public int getWins() {
                return numberOfWins;
        }

        public char getToken() {
                return token;
        }
}


