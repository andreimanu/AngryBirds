package logic;

import java.util.ArrayList;

public class Player {
	private int points;
	private int pos;
	private Row currentRow;
	private boolean canMove;
	private ArrayList<Birds> birds;
	public Player(int birdsNumber) {
		super();
		for(int i = 0; i < birdsNumber; i++) {
			birds.add(new Birds());
		}
		canMove = true;
		setPoints(0);
	}
	public boolean getMove() {
		return canMove;
	}
	
	public void setMove(boolean move) {
		this.canMove = move;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPosition() {
		return pos;
	}
	public void setPosition(int xPos) {
		this.pos = xPos;
	}
	public Row getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	public void incrementPoints(int pts) {
		setPoints(getPoints() + pts);
	}
	
}
