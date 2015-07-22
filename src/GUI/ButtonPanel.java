package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Enum.Model;
import Enum.Tempo;
import Java.Generation;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Generation generation;
	private JButton buttonStart;
	private JButton buttonStop;
	private Timer timer;
	private GamePanel gamePanel;
	private JButton buttonClear;
	private JComboBox<String> tempoList;
	private JComboBox<String> modelsList;
	private JTextField numberRow;
	private JTextField numberColumn;
	private JButton buttonSetSize;

	public ButtonPanel(Generation generation, GamePanel gamePanel, Timer timer) {
		this.gamePanel = gamePanel;
		this.timer = timer;
		this.generation = generation;

		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("100px:grow"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		createButtonsStart();
		createButtonsNext();
		createButtonsStop();
		createButtonsClear();
		createListTempo();
		createListModel();
		createSizePanel();
	}

	public void createButtonsStart() {
		buttonStart = new JButton("Start");
		buttonStart.setPreferredSize(new Dimension(90, 30));
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		add(buttonStart, "2, 2, left, top");
	}

	public void createButtonsNext() {
		buttonStart = new JButton("Next step");
		buttonStart.setPreferredSize(new Dimension(90, 30));
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startNextStep();
			}
		});
		add(buttonStart, "2, 4, left, top");
	}

	public void createButtonsStop() {
		buttonStop = new JButton("Stop");
		buttonStop.setPreferredSize(new Dimension(90, 30));
		buttonStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stopGame();
			}
		});
		add(buttonStop, "2, 6, left, top");
	}

	public void createButtonsClear() {
		buttonClear = new JButton("Clear");
		buttonClear.setPreferredSize(new Dimension(90, 30));
		buttonClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearPanel();
			}
		});
		add(buttonClear, "2, 8, left, top");
	}

	public void createListTempo() {

		JLabel lblTempo = new JLabel("Tempo");
		add(lblTempo, "2, 10");

		String[] tempoNames = { "Slow", "Medium", "Fast" };
		tempoList = new JComboBox<String>(tempoNames);
		tempoList.setSelectedIndex(0);
		tempoList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameTempo = (String) ((JComboBox<String>) e.getSource())
						.getSelectedItem();
				switch (nameTempo) {
				case "Slow":
					WindowGame.setTempoForTimer(Tempo.Slow);
					break;
				case "Medium":
					WindowGame.setTempoForTimer(Tempo.Medium);
					break;
				case "Fast":
					WindowGame.setTempoForTimer(Tempo.Fast);
					break;
				}
			}
		});

		add(tempoList, "2, 12, fill, default");
	}

	public void createListModel() {

		JLabel lblModel = new JLabel("Model");
		add(lblModel, "2, 14");

		String[] models = { "Gun", "Crocodile", "Flower", "Fountain", "Glider" };
		modelsList = new JComboBox<String>(models);
		modelsList.setSelectedIndex(-1);
		modelsList.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameModel = (String) ((JComboBox<String>) e.getSource())
						.getSelectedItem();
				switch (nameModel) {
				case "Gun":
					generation = Model.Gun.getGeneration();
					gamePanel.setSelectGeneration(generation);
					break;
				case "Crocodile":
					generation = Model.Crocodile.getGeneration();
					gamePanel.setSelectGeneration(generation);
					break;
				case "Flower":
					generation = Model.Flower.getGeneration();
					gamePanel.setSelectGeneration(generation);
					break;
				case "Fountain":
					generation = Model.Fountain.getGeneration();
					gamePanel.setSelectGeneration(generation);
					break;
				case "Glider":
					generation = Model.Glider.getGeneration();
					gamePanel.setSelectGeneration(generation);
					break;
				}
			}
		});

		add(modelsList, "2, 16, fill, default");
	}

	
	public void createSizePanel(){
		JLabel lblSize = new JLabel("Size");
		add(lblSize, "2, 18");
		
		JPanel sizePanel = new JPanel();
		add(sizePanel, "2, 20, fill, fill");
		sizePanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		numberRow = new JTextField();
		sizePanel.add(numberRow);
		numberRow.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizePanel.add(lblNewLabel);
		
		numberColumn = new JTextField();
		sizePanel.add(numberColumn);
		numberColumn.setColumns(10);
		
		buttonSetSize = new JButton("Set size");
		buttonSetSize.setPreferredSize(new Dimension(90, 30));
	
		buttonSetSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String row = numberRow.getText();
				String column = numberColumn.getText();
				if(row.length() != 0 && column.length() != 0){
					try {
						generation.setNumberOfColumn(Integer.parseInt(row));
						generation.setNumberOfRow(Integer.parseInt(column));
						gamePanel.setNewSize(Integer.parseInt(row), Integer.parseInt(column));
					} catch (NumberFormatException s) {	}
					
				}
			}
		});
		add(buttonSetSize, "2, 22, left, top");
	}
	
	public void startGame() {
		timer.start();
	}

	public void startNextStep() {
		gamePanel.nextStep();
	}

	public void clearPanel() {
		for (GameLabel label : gamePanel.getListCell()) {
			label.setDead();
		}
		generation.clearList();
	}

	public void stopGame() {
		timer.stop();
	}
}
