package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import Enum.Tempo;
import Java.Generation;

public class WindowGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Timer timer;
	private Tempo tempo;
	private Generation generation;
	private ButtonPanel buttonPanel;
	private GamePanel gamePanel;
	private int row;
	private int column;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new WindowGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public WindowGame() {
		super("Game of Life");
		setResizable(false);
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		firstSettings();
		createTimer();
		setBounds(100, 100, 900, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gamePanel = new GamePanel(generation, row, column);
		getContentPane().add(gamePanel, BorderLayout.CENTER);

		buttonPanel = new ButtonPanel(generation, gamePanel, timer);
		getContentPane().add(buttonPanel, BorderLayout.WEST);
		
	}

	public void firstSettings() {
		this.row = 50;
		this.column = 50;
		generation = new Generation(row, column);
		tempo = Tempo.Slow;
	}

	public void createTimer() {
		timer = new Timer(tempo.getTempo(), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.nextStep();
			}
		});
	}
	
	public static void setTempoForTimer(Tempo tempo) {
		timer.setDelay(tempo.getTempo());
	}
}
