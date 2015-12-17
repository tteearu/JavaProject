package main;

import java.awt.event.KeyEvent;
import java.awt.event.*;

public class KeyListener extends KeyAdapter {
	private Game game;

	public KeyListener(Game game) {
		this.game = game;
	}

	public void escape(KeyEvent event) {
		int keyCode = event.getKeyCode();
		if (keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String[] keys = { "VK_A", "VK_B", "VK_C", "VK_D", "VK_E", "VK_F",
				"VK_G", "VK_H", "VK_I", "VK_J", "VK_K", "VK_L", "VK_M", "VK_N",
				"VK_O", "VK_P", "VK_Q", "VK_R", "VK_S", "VK_Z", "VK_T", "VK_U",
				"VK_V", "VK_W", "VK_X", "VK_Y", "VK_ESCAPE" };
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