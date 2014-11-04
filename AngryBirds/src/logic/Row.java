package logic;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> Cells;
	private int rowNumber;
	private boolean isOuter;
	private int cellValue;
	
	public Row(int rowNumber, boolean isOuter, int NoCells, int cellValue) {
		super();
		int nextPos = 0;
		for(int i = 0; i < NoCells; i++) {
			nextPos += 1;
			Cells.add(new Cell(nextPos, isOuter));
			Cells.get(i).setValue(cellValue);
		}
		this.rowNumber = rowNumber;
		this.isOuter = isOuter;
	}

	public ArrayList<Cell> getCells() {
		return Cells;
	}
	
	public Cell currentCell(int pos) {
		return Cells.get(pos);
		
	}
	
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public boolean isOuter() {
		return isOuter;
	}
	public void setOuter(boolean isOuter) {
		this.isOuter = isOuter;
	}
	
	
}
