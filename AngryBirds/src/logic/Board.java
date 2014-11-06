package logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Board {
	
	private Row row;
	private int diceNumber;
	private Player currentPlayer;
	private int cellNumber;
	private int multiplier;
	private int maxNumber;
	private int maxCells;
	private Pig[] pigs;
	
	public Board(int multiplier, int birdsNumber,int numOfCells, int pigNumber) {
		row = new Row(numOfCells, multiplier);
		setCellNumber(numOfCells);
		this.multiplier = multiplier;
		pigs = new Pig[pigNumber];
		initialize(multiplier, birdsNumber, pigNumber);
		this.maxNumber = 6;
		this.maxCells = 25;
	}
		
	public Board(int multiplier, int birdsNumber, int numOfCells, int pigNumber, int maxDice) {
		this(multiplier, birdsNumber, numOfCells, pigNumber);
		this.maxNumber = maxDice;
	}
	
	public Pig[] getPigs() {
		return pigs;
	}
	public Row getRow() {
		return row;
	}
	public int getCellNumber() {
		return this.cellNumber;
	}
	private void setCellNumber(int numOfCells) {
		this.cellNumber = numOfCells;
	}

	public void initialize(int multiplier, int birdsNumber, int pigsNumber) {
		this.multiplier = multiplier;
		currentPlayer = new Player(birdsNumber, this);
		diceNumber = 0;
		currentPlayer.setPoints(0);
		for(int i = 0; i < pigs.length; i++) {
			pigs[i] = new Pig(getRow());
			pigs[i].putPig();
		}
	}
	
	
	public Player getPlayer() {
		return this.currentPlayer;
	}
	public void throwDice() {
		diceNumber = Dice.throwDice(maxNumber);
	}
	
	public boolean validPlay(int i) {
		boolean result = false;
		try {
			result = ((currentPlayer.getActiveBird().getPosition() + diceNumber == i) && (diceNumber != 0) && (!row.getCell(i).hasBird()));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select a bird first!", "Whoops!", JOptionPane.PLAIN_MESSAGE);
		}
		return result;
	}
	
	public boolean checkPlay() {
		boolean isPossible = false;
		ArrayList<Bird> birds = currentPlayer.getBirds();
		for(Bird b : birds) {
			if(!b.isLocked() && ((b.getPosition() + diceNumber) < maxCells)) {
				if(!row.getCell(b.getPosition()+diceNumber).hasBird())
					isPossible = true;
			}
		}
		return isPossible;
	} 
	
	public void makePlays() {
		int pos = currentPlayer.getActiveBird().getPosition() + diceNumber;
		row.getCell(currentPlayer.getActiveBird().getPosition()).removeBird();
		if ( row.getCell(pos).hasPig() ) {
			currentPlayer.getActiveBird().kill();
			for(Pig p : pigs) {
				if ( p.getPosition() == pos )
					p.setHidden(false);
			}
		}
		else {
			currentPlayer.getActiveBird().setPosition(pos);
			row.getCell(pos).putBird();
			currentPlayer.incrementPoints(row.getCell(pos).getValue());
		}
		
	}
	public boolean isOver() {
		boolean isOver = true;
		for(Bird b : currentPlayer.getBirds()) {
			if(!b.isLocked())
				isOver = false;
		}
		return isOver;
	}
	
	public int getDice() {
		return this.diceNumber;
	}
}
