package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Java.Generation;

public class GameLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private int row;
	private int column;
	private boolean flag;
	private Generation generation;

	public GameLabel(int row, int column, Generation generation){
		this.row = row;
		this.column = column;
		this.generation = generation;
		flag = false;
		
		setBorder(new LineBorder(new Color(153,153,153)));
		setBackground(new Color(204, 204, 204));
		addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(!flag){
		    		setAlive();
		    	}
		    	else {
		    		setDead();
		    	}
		    }  
		}); 
	}

	public void setAlive() {
		setBackground(Color.blue);
		setOpaque(true);
		addCell();
		flag = true;
	}
	public void setDead() {
		setBackground(new Color(204, 204, 204));
		setOpaque(true);
		removeCell();
		flag = false;
	}

	public void removeCell() {
		generation.removeCell(row, column);
	}

	public void addCell() {
		generation.addCell(row, column);
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
	public void setSelectGeneration(Generation generation){
		this.generation = generation;
	}
}
