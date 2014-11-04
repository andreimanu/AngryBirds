package logic;

public class Bird {
	private boolean isActive;
	private int pos;
	private int currentRowId;
	private Row currentRow;
	
	public Bird(int pos, Row currentRow) {
		this.pos = pos;
		currentRowId = 0;
		this.currentRow = currentRow;
	}
	
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	public Row getCurrentRow() {
		return this.currentRow;
	}
	
	public void setCurrentRowID(int currentRow) {
		this.currentRowId = currentRow;
	}
	
	public int getCurrentRowID() {
		return currentRowId;
	}
	
	public void setPosition(int pos) {
		this.pos = pos;
	}
	
	public int getPosition() {
		return pos;
	}
	
	public void setActive(boolean active) {
		isActive = active;
	}
	
	public boolean isActive() {
		return isActive;
	}
}
