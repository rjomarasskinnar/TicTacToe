package application;

import is.ru.TicTacToe.HumanPlayer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TicTacToeController {
	@FXML
	Label lbl00;
	@FXML
	Label lbl01;
	@FXML
	Label lbl02;
	@FXML
	Label lbl10;
	@FXML
	Label lbl20;
	@FXML
	Label lbl11;
	@FXML
	Label lbl22;
	@FXML
	Label lbl21;
	@FXML
	Label lbl12;
	@FXML
	Label lblWhoseTurn;

	@FXML
	public void initialize() {
		lblWhoseTurn.setText(String.valueOf(Model.model.game.whoseTurn.get().getToken()));
		
		Model.model.game.whoseTurn.addListener(new ChangeListener<HumanPlayer>(){

			@Override
			public void changed(ObservableValue<? extends HumanPlayer> observable, HumanPlayer oldValue, HumanPlayer newValue) {
				lblWhoseTurn.setText(String.valueOf(newValue.getToken()));
			}
		});
		
		lbl00.textProperty().bind(Model.model.game.getBoard().stringBoard[0]);
		lbl01.textProperty().bind(Model.model.game.getBoard().stringBoard[1]);
		lbl02.textProperty().bind(Model.model.game.getBoard().stringBoard[2]);
		lbl10.textProperty().bind(Model.model.game.getBoard().stringBoard[3]);
		lbl11.textProperty().bind(Model.model.game.getBoard().stringBoard[4]);
		lbl12.textProperty().bind(Model.model.game.getBoard().stringBoard[5]);
		lbl20.textProperty().bind(Model.model.game.getBoard().stringBoard[6]);
		lbl21.textProperty().bind(Model.model.game.getBoard().stringBoard[7]);
		lbl22.textProperty().bind(Model.model.game.getBoard().stringBoard[8]);
	}

	protected void handleTurn(int clickedCell) {
		Model.model.game.takeTurn(clickedCell);
	}

	@FXML
	public void lbl00Clicked() {
		handleTurn(0);
	}

	@FXML
	public void lbl01Clicked() {
		handleTurn(1);
	}

	@FXML
	public void lbl02Clicked() {
		handleTurn(2);
	}

	@FXML
	public void lbl10Clicked() {
		handleTurn(3);
	}
	
	@FXML
	public void lbl11Clicked() {
		handleTurn(4);
	}
	
	@FXML
	public void lbl12Clicked() {
		handleTurn(5);
	}

	@FXML
	public void lbl20Clicked() {
		handleTurn(6);
	}
	
	@FXML
	public void lbl21Clicked() {
		handleTurn(7);
	}

	@FXML
	public void lbl22Clicked() {
		handleTurn(8);
	}
}

