package main;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingHangman extends JPanel{
//	private failCounter = Game.failCounter;
	private Game game;
	public Graphics g;
	
	public DrawingHangman(Game game)  {
		this.game = game;	
	}

	
    public void paint() {
        this.g = g;
        int failed = game.failCounter;
        drawHangman(failed);
    }

    public void drawHangman(int failCounter) {
    	if(failCounter == 0){
    		//do nothing
    	}else if(failCounter == 1){
  			g.fillRect (50, 50, 5, 250);	//frame1
  		}else if(failCounter == 2){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  		}else if(failCounter == 3){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  		}else if(failCounter == 4){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  		}else if(failCounter == 5){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  		}else if(failCounter == 6){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  		}else if(failCounter == 7){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  			g.fillRect(145, 145, 45, 3); 	//lArm
  		}else if(failCounter == 8){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  			g.fillRect(145, 145, 45, 3); 	//lArm
  			g.fillRect(190, 207, 40, 3);	//rLeg
  		}else if(failCounter == 9){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  			g.fillRect(145, 145, 45, 3); 	//lArm
  			g.fillRect(190, 207, 40, 3);	//rLeg
  			g.fillRect(150, 207, 40, 3);	//lLeg
  		}
  	  }
}