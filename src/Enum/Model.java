package Enum;

import java.util.ArrayList;
import java.util.Arrays;

import Java.Cell;
import Java.Generation;

public enum Model {

	Crocodile(
		  new ArrayList<Cell>(Arrays.asList(new Cell(2, 4), new Cell(3, 3),
							new Cell(3, 4), new Cell(4, 2), new Cell(4, 3), 
							new Cell(4,	4), new Cell(5, 3), new Cell(5, 4), 
							new Cell(6, 4),	new Cell(2, 11),new Cell(3, 11),
							new Cell(3, 12),new Cell(4, 11),new Cell(4, 12), 
							new Cell(4, 13),new Cell(5, 11),new Cell(5, 12), 
							new Cell(6, 11))), 9, 16),

	Flower (
		  new ArrayList<Cell>(Arrays.asList( new Cell(2, 4),  new Cell(2, 5), new Cell(2, 6), 
				  			new Cell(2, 10), new Cell(2, 11), new Cell(14, 10),
				  			new Cell(2, 12), new Cell(7, 4),  new Cell(7, 5), 
				  			new Cell(7, 6),  new Cell(7, 10), new Cell(7, 11), 
				  			new Cell(7, 12), new Cell(9, 4),  new Cell(9, 5), 
				  			new Cell(9, 6),  new Cell(9, 10), new Cell(9, 11), 
				  			new Cell(9, 12), new Cell(14, 4), new Cell(14, 5), 
				  			new Cell(14, 6), new Cell(4, 2),  new Cell(4, 7),  
				  			new Cell(4, 9),  new Cell(4, 14), new Cell(5, 9),  
				  			new Cell(14, 12),new Cell(5, 2),  new Cell(5, 7), 
				  			new Cell(5, 14), new Cell(6, 2),  new Cell(6, 7),  
				  			new Cell(6, 9),  new Cell(6, 14), new Cell(10, 2),
				  			new Cell(10, 7), new Cell(10, 9), new Cell(10, 14),
				  			new Cell(11, 2), new Cell(11, 7), new Cell(11, 9),
				  			new Cell(12, 2), new Cell(14, 11),new Cell(12, 7), 
				  			new Cell(12, 9), new Cell(12, 14),new Cell(11, 14) )), 17, 17),

	Fountain (
			new ArrayList<Cell>(Arrays.asList(new Cell(2, 2), new Cell(2, 3), new Cell(7, 7),
			  				  new Cell(2, 7), new Cell(2, 8), new Cell(3, 1), new Cell(3, 2),
			  				  new Cell(3, 4), new Cell(3, 6), new Cell(3, 8), new Cell(3, 9),
			  				  new Cell(4, 4), new Cell(4, 6), new Cell(5, 4), new Cell(5, 6),
			  				  new Cell(7, 3), new Cell(7, 4), new Cell(7, 6) )) ,9, 11),

	Gun (
		    new ArrayList<Cell>(Arrays.asList(new Cell(5, 1), new Cell(5, 2), new Cell(4, 35),
		    			   new Cell(6, 1),  new Cell(6, 2),  new Cell(5, 11), new Cell(6, 11),
		    			   new Cell(7, 11), new Cell(3, 13), new Cell(3, 14), new Cell(4, 12),
		    			   new Cell(4, 16), new Cell(5, 17), new Cell(6, 15), new Cell(6, 17),
		    			   new Cell(6, 18), new Cell(7, 17), new Cell(8, 16), new Cell(8, 12),
		    			   new Cell(9, 13), new Cell(9, 14), new Cell(1, 25), new Cell(2, 23),
		    			   new Cell(2, 25), new Cell(3, 21), new Cell(3, 22), new Cell(4, 21),
		    			   new Cell(4, 22), new Cell(5, 21), new Cell(5, 22), new Cell(6, 23),
		    			   new Cell(6, 25), new Cell(7, 25), new Cell(3, 35), new Cell(3, 36),
		    			   new Cell(4, 36))), 15, 38),

	Glider(new ArrayList<Cell>(Arrays.asList(new Cell(2, 1), new Cell(2, 2),
			new Cell(2, 3), new Cell(1, 3), new Cell(0, 2))), 7, 7);

	private ArrayList<Cell> cellsAlive;
	private int numberOfRow;
	private int numberOfColumn;

	private Model(ArrayList<Cell> cellsAlive, int numberOfRow,
			int numberOfColumn) {
		this.cellsAlive = cellsAlive;
		this.numberOfRow = numberOfRow;
		this.numberOfColumn = numberOfColumn;
	}

	public int getNumberOfRow() {
		return numberOfRow;
	}

	public int getNumberOfColumn() {
		return numberOfColumn;
	}

	public ArrayList<Cell> getAliveCell() {
		return cellsAlive;
	}

	public Generation getGeneration() {
		return new Generation(cellsAlive, numberOfRow, numberOfColumn);
	}

}
