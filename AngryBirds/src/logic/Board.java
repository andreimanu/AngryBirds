package logic;

import java.util.ArrayList;


public class Board {
	
	private ArrayList<Row> rows;
	private int dim;
	private int diceNumber;
	private Player currentPlayer;
	private int rowNumber;
	private int cellNumber;
	private int[] values = {20, 40, 80};
	private int multiplier;
	private int maxNumber;
	private int maxCells;
	
	public Board(int multiplier, int birdsNumber) {
		initialize(multiplier, birdsNumber);
	}
	
	public void initialize(int multiplier, int birdsNumber) {
		this.multiplier = multiplier;
		currentPlayer = new Player(birdsNumber);
		currentPlayer.setPosition(0);
		for(int i = 1; i < rowNumber - 1; i++) {
			rows.add(new Row(i, false, cellNumber, values[i-1]*multiplier));
		}
		diceNumber = 0;
	}
	
	private void throwDice() {
		diceNumber = Dice.throwDice(maxNumber);
	}
	
	private boolean validPlay(int i) {
		return ((currentPlayer.getPosition() + diceNumber == i) && (diceNumber != 0));
	}
	
	public boolean checkPlay() {
		boolean isPosible = false;
		if (currentPlayer.getPosition() + diceNumber < maxCells )
			isPosible = true;
		else {
			diceNumber = 0;
			nextTurn();
		}
		return isPosible;
	}
	
	public void nextTurn() {
		diceNumber = 0;
	}
	
	public void makePlays() {
		currentPlayer.setPosition(currentPlayer.getPosition() + diceNumber);
		currentPlayer.incrementPoints(currentPlayer.getCurrentRow().getCells().get(currentPlayer.getPosition()).getValue());
	}
}
