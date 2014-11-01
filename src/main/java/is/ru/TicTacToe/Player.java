package is.ru.TicTacToe;
import java.util.Scanner;

public class Player {
        private int numberOfWins;
        private char token;

        public Player(char token) {
                if(token != 'X' && token != 'O'){
                        throw new IllegalArgumentException("Please Insert either X or O");
                }
                this.numberOfWins = 0;
                this.token = token;
        }

        public int getWins() {
                return numberOfWins;
        }

        public char getToken() {
                return token;
        }
}


