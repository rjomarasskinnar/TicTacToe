package application;

import is.ru.TicTacToe.Game;

public class Model {
	public static Model model = new Model();
	
	public Game game;
		
	public Model() {
		game = new Game();
	}
}

