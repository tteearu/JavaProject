package main;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawingHangman extends Applet {

    public Graphics g;
    
    public void paint(Graphics g) {
        this.g = g;

        drawHangman(9);
    }

    public void drawHangman(int frameNr) {
    	if(frameNr == 0){
    		//do nothing
    	}else if(frameNr == 1){
  			g.fillRect (50, 50, 5, 250);	//frame1
  		}else if(frameNr == 2){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  		}else if(frameNr == 3){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  		}else if(frameNr == 4){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  		}else if(frameNr == 5){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  		}else if(frameNr == 6){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  		}else if(frameNr == 7){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  			g.fillRect(145, 145, 45, 3); 	//lArm
  		}else if(frameNr == 8){
  			g.fillRect (50, 50, 5, 250);	//frame1
  			g.fillRect(50, 50, 140, 5); 	//frame2
  			g.fillRect(190, 50, 5, 65); 	//frame3
  			g.fillOval(182, 100, 35, 35); 	//head
  			g.fillRect(190, 100, 3, 110);	//body
  			g.fillRect(190, 145 , 45, 3);	//rArm
  			g.fillRect(145, 145, 45, 3); 	//lArm
  			g.fillRect(190, 207, 40, 3);	//rLeg
  		}else if(frameNr == 9){
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