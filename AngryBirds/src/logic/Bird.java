package logic;

public class Bird {
	private boolean isActive;
	private int pos;
	private int currentRowId;
	private Row currentRow;
	
	public Bird(int numOfBirds, Row currentRow) {
		this.currentRow = currentRow;
		int pos = 0;
		int seed = currentRow.size();
		do{
			pos = (int) (Math.random() * seed);
			this.currentRow.getCells().get(pos).putBird();
			System.out.println("There is a bird in: " + pos);
		}
		while(!this.currentRow.getCells().get(pos).hasBird());
		currentRowId = 0;
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
