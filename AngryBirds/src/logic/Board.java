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
	
	public Board(int multiplier, int birdsNumber, int numOfRows, int numOfCells) {
		rows = new ArrayList<Row>();
		setRowNumber(numOfRows);
		setCellNumber(numOfCells);
		initialize(multiplier, birdsNumber);
	}
	
	public Board(int multiplier, int birdsNumber, int numOfRows, int numOfCells, int dim) {
		this(multiplier, birdsNumber, numOfRows,numOfCells);
		this.dim = dim;
	}
	
	public ArrayList<Row> getRows() {
		return rows;
	}
	public int getCellNumber() {
		return this.cellNumber;
	}
	private void setCellNumber(int numOfCells) {
		this.cellNumber = numOfCells;
	}

	private void setRowNumber(int numOfRows) {
		this.rowNumber = numOfRows;	
	}

	public void initialize(int multiplier, int birdsNumber) {
		this.multiplier = multiplier;
		for(int i = 1; i < rowNumber - 1; i++) {
			rows.add(new Row(i, false, cellNumber, values[i-1]*multiplier));
		}
		currentPlayer = new Player(birdsNumber, this);
		diceNumber = 0;
	}
	
	public Player getPlayer() {
		return this.currentPlayer;
	}
	public void throwDice() {
		diceNumber = Dice.throwDice(maxNumber);
	}
	
	public boolean validPlay(int i) {
		return ((currentPlayer.getActiveBird().getPosition() + diceNumber == i) && (diceNumber != 0));
	}
	
	public boolean checkPlay() {
		boolean isPosible = false;
		if (currentPlayer.getActiveBird().getPosition() + diceNumber < maxCells )
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
		currentPlayer.getActiveBird().setPosition(currentPlayer.getActiveBird().getPosition() + diceNumber);
		currentPlayer.incrementPoints(currentPlayer.getActiveBird().getCurrentRow().getCells().get(currentPlayer.getActiveBird().getPosition()).getValue());
	}
}
