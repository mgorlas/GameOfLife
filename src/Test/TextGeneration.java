package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Enum.CellState;
import Java.Cell;
import Java.Generation;

public class TextGeneration {

	
	@Test
	public void shouldReturnDeadForDeadCellAnd2AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2,0), new Cell(3,1), new Cell(1,1))), 7, 7);
		assertEquals(CellState.DEAD, gen.getNewCellState(3,2));
	}
	@Test
	public void shouldReturnAliveForDeadCellAnd3AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2), new Cell(2,0), new Cell(3,1), new Cell(1,1))), 7, 7);
		assertEquals(CellState.ALIVE, gen.getNewCellState(3,2));
	}
	@Test
	public void shouldReturnDeadForAliveCellAnd4AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2), new Cell(2,0), new Cell(3,1), new Cell(1,1))), 7, 7);
		assertEquals(CellState.DEAD, gen.getNewCellState(2,1));
	}
	@Test
	public void shouldReturnDeadForAliveCellAnd1AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2))), 7, 7);
		assertEquals(CellState.DEAD, gen.getNewCellState(2,1));
	}
	@Test
	public void shouldReturnAliveForAliveCellAnd2AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2),	new Cell(1,1))), 7, 7);
		assertEquals(CellState.ALIVE, gen.getNewCellState(2,1));
	}
	
	@Test
	public void shouldReturnAliveForAliveCellAnd3AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2), new Cell(1,1), new Cell(2,0))), 7, 7);
		assertEquals(CellState.ALIVE, gen.getNewCellState(2,1));
	}

	@Test
	public void shouldReturn3ForAliveCellAnd3AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2), new Cell(1,1), new Cell(2,0))), 7, 7);
		assertEquals(3, gen.checkNeighbors(2,1));
	}
	
	@Test
	public void shouldReturn2ForAliveCellAnd2AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2), new Cell(1,1))), 7, 7);
		assertEquals(2, gen.checkNeighbors(2,1));
	}
	@Test
	public void shouldReturn2ForDeadCellAnd2AliveNeighbors() {
		Generation gen = new Generation(
				new ArrayList<Cell>(Arrays.asList(
						new Cell(2, 1), new Cell(2, 2), new Cell(1,1))), 7, 7);
		assertEquals(2, gen.checkNeighbors(3,2));
	}
	
}
