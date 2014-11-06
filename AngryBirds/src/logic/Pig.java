package logic;

public class Pig {
	private int pos;
	private Row currentRow;
	private boolean isHidden;
	
	public Pig(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	public void putPig() {
		int position;
		int seed = 15;
		do{
			position = (int) (Math.random() * seed) + 5;
		}
		while(this.currentRow.getCell(position).hasPig());
		this.currentRow.getCell(position).putPig();
		this.pos = position;
		System.out.println("There is a pig in: " + position);
		isHidden = true;
	}
	

	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	public Row getCurrentRow() {
		return this.currentRow;
	}
	public int getPosition() {
		return pos;
	}
	
	public boolean isHidden() {
		return isHidden;
	}
	
	public void setHidden(boolean state) {
		this.isHidden = state;
	}
	
}
