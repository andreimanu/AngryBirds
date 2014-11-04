package logic;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> Cells;
	private int rowNumber;
	private boolean isOuter;
	private int cellValue;
	
	public Row(int rowNumber, boolean isOuter, int NoCells, int cellValue) {
		super();
		Cells = new ArrayList<Cell>();
		int nextPos = 1;
		this.cellValue = cellValue;
		for(int i = 0; i < NoCells; i++) {
			nextPos += i;
			Cell temp = new Cell(nextPos, isOuter);
			Cells.add(temp);
			Cells.get(i).setValue(cellValue);
		}
		this.rowNumber = rowNumber;
		this.isOuter = isOuter;
	}

	public ArrayList<Cell> getCells() {
		return Cells;
	}
	
	public int size() {
		return Cells.size();
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
