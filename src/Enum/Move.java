package Enum;

public enum Move {

	UpAndLeft  (-1, -1),
	Up (-1, 0),  
	UpAndRight (-1, 1),
	Right (0, 1),
	DownAndRight (1, 1),
	Down (1, 0),
	DownAndLeft (1, -1),
	Left (0, -1);

	private int row;
	private int column;

	private Move(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
