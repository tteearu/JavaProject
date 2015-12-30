package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class Game implements ActionListener {

	static JFrame frame;
	private JFrame graphics;

	private JLabel kriipsud;
	private JPanel controlPanel;
	private JPanel alphabet;
	private JPanel stickSam;
	GameEngine engine;
	private HangmanCanvas hangman;
	private JLabel fail;
	public int failCounter;
	private KeyListener keyListener;
	String[] initline;
	public int failed;

	public Game() {
		engine = new GameEngine(null);
		keyListener = new KeyListener(this);
		hangman = new HangmanCanvas();
		hangman.setSize(400, 300);
//		hangman.setBackground(Color.BLACK);
		gui();
	}

	public static void gamePlay() {
		Game swingControl = new Game();
		// swingControl.textField();
	}

	private void gui() {
		frame = new JFrame("Guess the word by clicking the letters!");
		frame.setSize(650, 600);
		frame.setLayout(new GridLayout(3, 1));

		graphics = new JFrame("Think hard about your next move!");
		graphics.setSize(650, 600);
		graphics.setLayout(new GridLayout(3, 9));

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		graphics.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		stickSam = new JPanel();
		stickSam.setSize(650, 50);
		// stickSam.setLayout(new GridLayout(1, 1));

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 2));
//		controlPanel.setBackground(Color.BLUE);

		alphabet = new JPanel();
		alphabet.setLayout(new GridLayout(3, 12));
		alphabet.setSize(650, 50);

		frame.add(stickSam);
		frame.add(controlPanel);
		frame.add(alphabet);
		frame.setVisible(true);
		kriipsud = new JLabel("", JLabel.CENTER);
		String status = Arrays.toString(engine.letters);
		kriipsud.setText(status);
		kriipsud.setFont(new Font("Regular", Font.PLAIN, 20));
		kriipsud.setSize(300, 60);
		fail = new JLabel("", JLabel.CENTER);
		String failCounter = String.valueOf(engine.failCounter);
		fail.setText("Failed :: " + failCounter + "/9 times");
		fail.setFont(new Font("Regular", Font.PLAIN, 20));
		fail.setSize(300, 60);

		controlPanel.add(kriipsud);
		controlPanel.add(fail);
		stickSam.add(hangman);

		String[] letters= { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "Z", "T", "U",
				"V", "W", "X", "Y" };
		// String[] letters = {"Q", "W","E", "R", "T", "Y", "U", "I", "O", "P",
		// "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B",
		// "N", "M"};

		for (String letter : letters) {
			final JButton letterButton = new JButton(letter);
			letterButton.addKeyListener(keyListener);
			letterButton.addActionListener(this);
			alphabet.add(letterButton, BorderLayout.SOUTH);
		}

		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			};
		});

		alphabet.add(exitButton, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
	}

	// private void textField() {
	// header1.setText("Guess the word by clicking the letters!");
	// }

	public void actionPerformed(ActionEvent e) {

		JButton letterButton = (JButton) e.getSource();
		letterButton.setVisible(false);
		onScreenAction(letterButton.getText());
	}

	public void onScreenAction(String letterKey) {

		engine.letterCheck(letterKey);
		System.out.println(letterKey);
		System.out.println(Arrays.toString(engine.initWord));
		System.out.println(engine.prevWord);

		String status = Arrays.toString(engine.letters);
		kriipsud.setText(status);
		kriipsud.setFont(new Font("Regular", Font.PLAIN, 20));
		controlPanel.add(kriipsud);

		fail.setText("Failed :: " + String.valueOf(engine.failCounter)
				+ "/9 times");
		fail.setFont(new Font("Regular", Font.PLAIN, 20));
		hangman.setFailCounter(engine.failCounter);

		controlPanel.add(fail);

		if (!engine.linesExist) {
			engine.wordGuessed = true;
			new WinLoose(this);
			frame.show(false);

		}
		if (engine.failCounter >= 9) {
			engine.wordGuessed = false;
			new WinLoose(this);
			frame.show(false);
		}
	}
}