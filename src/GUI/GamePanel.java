package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Java.Cell;
import Java.Generation;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Generation generation;
	private ArrayList<GameLabel> labelCell;
	private int row;
	private int column;

	public GamePanel(Generation generation, int row, int column) {
		this.generation = generation;
		this.column = column;
		this.row = row;
		labelCell = new ArrayList<>();
		setBackground(new Color(204, 204, 204));
		setLayout(new GridLayout(row, column));
		createCell();
	}

	public void createCell() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				GameLabel jl = new GameLabel(i, j, generation);
				add(jl);
				labelCell.add(jl);
			}
		}
	}

	public void updatePanel() {
		generation.createNextGeneration();
	}

	public void paintComponent() {
		for (GameLabel jLabel : labelCell) {
			boolean flag = false;
			for (Cell cell : generation.getListAliveCell()) {
				if (cell.getColumn() == jLabel.getColumn()
						&& cell.getRow() == jLabel.getRow()) {
					flag = true;
				}
			}
			if (flag)
				jLabel.setAlive();
			else
				jLabel.setDead();
		}
	}

	public void setSelectGeneration(Generation generation) {
		this.generation = generation;
		generation.setNumberOfColumn(column);
		generation.setNumberOfRow(row);
		paintComponent();
		repaint();
		for (GameLabel jLabel : labelCell) {
			jLabel.setSelectGeneration(generation);
		}
	}

	public ArrayList<GameLabel> getListCell() {
		return labelCell;
	}

	public void nextStep() {
		updatePanel();
		paintComponent();
		repaint();
	}

	public void setNewSize(int row, int column) {
		setLayout(new GridLayout(row, column));
		this.row = row;
		this.column = column;
		for (GameLabel gameLabel : labelCell) {
			remove(gameLabel);
		}
		labelCell.clear();
		createCell();
		revalidate();
		repaint();
	}
}
