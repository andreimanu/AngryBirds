package logic;

public class Cell {
	public boolean hasPig;
	private int coord;
	private boolean isOuter;
	private int value;
	private boolean hasPowerUp;
	
	public Cell(int coord, boolean isOuter) {
		this.coord = coord;
		this.isOuter = isOuter;
		hasPig = false;
		value = 0;
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
	
	public int getValue() {
		return value;
	}
	public boolean isHasPig() {
		return hasPig;
	}
	public void setHasPig(boolean hasPig) {
		this.hasPig = hasPig;
	}
	public int getCoord() {
		return coord;
	}
	public void setCoord(int xCoord) {
		this.coord = xCoord;
	}
	public boolean isOuter() {
		return isOuter;
	}
	public void setOuter(boolean isOuter) {
		this.isOuter = isOuter;
	}
	
}
