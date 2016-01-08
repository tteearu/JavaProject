package main;

import javax.swing.*;
import java.awt.*;

public class HangmanCanvas extends Canvas {
	int failCounter;
	
	/**
	 * Setting failCounter a new value if it changes,
	 * repainting if the value changes
	 * @param setFailCounter
	 */

	public void setFailCounter(int failCounter) {
		this.failCounter = failCounter;
		System.out.println(failCounter);
		this.repaint();
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		switch (this.failCounter) {
		case 9:
			g.fillRect(177, 125, 23, 3); // lLeg
		case 8:
			g.fillRect(200, 125, 23, 3); // rLeg
		case 7:
			g.fillRect(177, 75, 23, 3); // lArm
		case 6:
			g.fillRect(200, 75, 23, 3); // rArm
		case 5:
			g.fillRect(200, 60, 3, 65); // body
		case 4:
			g.fillOval(198, 45, 22, 22); // head
		case 3:
			g.fillRect(200, 20, 4, 30); // frame3
		case 2:
			g.fillRect(130, 20, 70, 4); // frame2
		case 1:
			g.fillRect(130, 20, 4, 150); // frame1
		default:
			break;
		}
	}
}
