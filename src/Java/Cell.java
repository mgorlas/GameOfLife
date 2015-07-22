package Java;

public class Cell {

	private int column;
	private int row;

	
	public Cell(int row, int column) {
		this.column = column;
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String toString() {
		return "(" +row + ", " + column + ")\n";
	}
	
	public boolean isTheSameCell(int row, int column){
		return this.row == row && this.column == column;
	}
}
