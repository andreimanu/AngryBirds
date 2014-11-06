package logic;

public class Bird {
	private boolean isActive;
	private int pos;
	private int currentRowId;
	private Row currentRow;
	private boolean isLocked;
	private boolean isDead;
	
	public Bird(Row currentRow) {
		this.currentRow = currentRow;
		currentRowId = 0;
		putBirds();
	}
	
	private void putBirds() {
		int position;
		int seed = 5;
		do{
			position = (int) (Math.random() * seed);
		}
		while(this.currentRow.getCell(position).hasBird());
		this.currentRow.getCell(position).putBird();
		this.pos = position;
		System.out.println("There is a bird in: " + position);
		isLocked = false;
		isDead = false;
	}
	//To kill a mockingbird
	public void kill() {
		isLocked = true;
		isDead = true;
		setPosition(-1);
	}
	
	public boolean isDead() {
		return isDead;
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
		if(pos >= 20) {
			this.isLocked = true;
		}
		this.pos = pos;
	}
	
	public int getPosition() {
		return pos;
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	public void setActive(boolean active) {
		if(!isLocked)
			isActive = active;
		else {
			isActive = false;
		}
	}
	
	public boolean isActive() {
		return isActive;
	}
}
