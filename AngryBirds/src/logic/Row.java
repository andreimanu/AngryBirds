package logic;

public class Row {
	private Cell[] Cells;
	private int[] values = {20, 40, 80};
	public Row(int noCells, int multiplier) {
		Cells = new Cell[noCells];
		int tempValue;
		int nextPos = 0;
		for(int i = 0; i < noCells; i++) {
			tempValue = 0;
			nextPos += i;
			if(i >= 20)
				tempValue = 300;
			else if ( i >= 15 )
				tempValue = values[2];
			else if ( i >= 10 )
				tempValue = values[1];
			else if ( i >= 5)
				tempValue = values[0];
			Cell temp = new Cell(nextPos, tempValue * multiplier);
			Cells[i] = temp;
		}
	}

	public Cell[] getCells() {
		return Cells;
	}
	
	public Cell getCell(int pos) {
		if(pos < size() && pos >= 0)
			return Cells[pos];
		return null;
	}
	
	public int size() {
		return Cells.length;
	}
	public Cell currentCell(int pos) {
		return Cells[pos];
		
	}
	
}
