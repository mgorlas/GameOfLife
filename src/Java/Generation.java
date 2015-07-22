package Java;

import java.util.ArrayList;

import Enum.CellState;
import Enum.Move;

public class Generation {

	private ArrayList<Cell> cellsAlive;
	private ArrayList<Cell> cellsAliveTemp;
	private int numberOfRow;
	private int numberOfColumn;

	public Generation(ArrayList<Cell> cells, int numberOfRow, int numberOfColumn) {
		this.cellsAlive = cells;
		this.numberOfRow = numberOfRow;
		this.numberOfColumn = numberOfColumn;
		this.cellsAliveTemp = new ArrayList<Cell>();
	}

	public Generation(int numberOfRow, int numberOfColumn) {
		this.cellsAlive = new ArrayList<Cell>();
		this.cellsAliveTemp = new ArrayList<Cell>();
		this.numberOfRow = numberOfRow;
		this.numberOfColumn = numberOfColumn;
	}

	public void createNextGeneration() {
		for (int i = 0; i < numberOfRow; i++) {
			for (int j = 0; j < numberOfColumn; j++) {
				if (getNewCellState(i, j) == CellState.ALIVE) {
					addToListTemp(i, j);
				}
			}
		}
		copyList();
		clearListTemp();
	}

	public CellState getNewCellState(int row, int column) {
		int neighbors = checkNeighbors(row, column);
		CellState isAliveOrDead = isAliveOrDead(row, column);
		if (((neighbors > 1 && neighbors < 4) && isAliveOrDead == CellState.ALIVE)
				|| (neighbors == 3 && isAliveOrDead == CellState.DEAD)) {
			return CellState.ALIVE;
		}
		return CellState.DEAD;
	}

	public int checkNeighbors(int row, int column) {
		int aliveNeighbors = 0;
		for (Move move : Move.values()) {
			int newRow = row + move.getRow();
			int newColumn = column + move.getColumn();
			if (isInTheRange(newRow, newColumn)	&& isAliveOrDead(newRow, newColumn) == CellState.ALIVE)
				aliveNeighbors++;
		}
		return aliveNeighbors;
	}
	
	public boolean isInTheRange(int row, int column){
		return row >= 0 && column >= 0 && row <= numberOfRow && column <= numberOfColumn;
	}

	public CellState isAliveOrDead(int row, int column) {
		for (int i = 0; i < cellsAlive.size(); i++) {
			if (getCellAlive(i).isTheSameCell(row, column)) {
				return CellState.ALIVE;
			}
		}
		return CellState.DEAD;
	}

	public Cell getCellAlive(int index) {
		return cellsAlive.get(index);
	}

	public int getNumberOfRow() {
		return numberOfRow;
	}

	public int getNumberOfColumn() {
		return numberOfColumn;
	}

	public void setNumberOfRow(int numberOfRow) {
		this.numberOfRow = numberOfRow;
	}

	public void setNumberOfColumn(int numberOfColumn) {
		this.numberOfColumn = numberOfColumn;
	}
	
	public ArrayList<Cell> getListAliveCell() {
		return cellsAlive;
	}

	public void clearListTemp() {
		cellsAliveTemp.clear();
	}

	public void clearList() {
		cellsAlive.clear();
	}

	
	public void copyList() {
		clearList();
		for (Cell cell : cellsAliveTemp) {
			cellsAlive.add(cell);
		}
	}

	
	public void addToListTemp(int row, int column) {
		cellsAliveTemp.add(new Cell(row, column));
	}

	public void removeCell(int row, int column) {
		for (int i = 0; i < cellsAlive.size(); i++) {
			if (cellsAlive.get(i).isTheSameCell(row, column)) {
				cellsAlive.remove(i);
				i++;
			}
		}
	}

	public void addCell(int row, int column) {
		cellsAlive.add(new Cell(row, column));
	}
}
