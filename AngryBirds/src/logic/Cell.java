package logic;

public class Cell {
	private boolean hasPig;
	private int coord;
	private int value;
	private boolean hasPowerUp;
	private boolean hasBird;
	
	public Cell(int coord, int value) {
		this.coord = coord;
		hasPig = false;
		hasBird = false;
		this.value = value;
	}
	
	public void setPowerUp(boolean val) {
		hasPowerUp = val;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean hasPowerUp() {
		return hasPowerUp;
	}
	public void putBird() {
		this.hasBird = true;
	}
	public void removeBird() {
		this.hasBird = false;
	}
	public int getValue() {
		return value;
	}
	public boolean hasPig() {
		return hasPig;
	}
	public void putPig() {
		this.hasPig = true;
	}
	public int getCoord() {
		return coord;
	}
	public void setCoord(int xCoord) {
		this.coord = xCoord;
	}

	public boolean hasBird() {
		return hasBird;
	}
	
}
