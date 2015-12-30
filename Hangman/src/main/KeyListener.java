package main;

import java.awt.event.KeyEvent;
import java.awt.event.*;

public class KeyListener extends KeyAdapter {
	private Game game;

	public KeyListener(Game game) {
		this.game = game;
	}
	/**
	 * Listening to keyboard, when letter checked act as graphic letter was clicked,
	 * escape kills the program
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		e.getKeyChar();		
		String letter = String.valueOf(e.getKeyChar());
		System.out.println(String.valueOf(e.getKeyChar()));
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else {
			letter = letter.toUpperCase();
			System.out.println(e.getKeyChar());
			game.onScreenAction(letter);
		}
	}
}