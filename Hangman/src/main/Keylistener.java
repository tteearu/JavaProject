package main;
 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Keylistener {

	public static void main(String[] argv) throws Exception {
			JTextField textField = new JTextField();
			textField.addKeyListener(new keyboardListener());
			
			JFrame jframe = new JFrame();
			
			jframe.add(textField);
			
			jframe.setSize(400, 350);
			jframe.setVisible(true);

     }
}


class keyboardListener extends KeyAdapter {

   @Override
  public void keyPressed(KeyEvent event) {
	   int keyCode = event.getKeyCode();
	   if (keyCode == KeyEvent.VK_ESCAPE){
		   System.exit(0);
	   }else if(keyCode == KeyEvent.VK_ESCAPE){
		   
	   }else if(keyCode == KeyEvent.VK_A){
		   
	   }else if(keyCode == KeyEvent.VK_B){
		   
	   }else if(keyCode == KeyEvent.VK_C){
		   
	   }else if(keyCode == KeyEvent.VK_D){
		   
	   }else if(keyCode == KeyEvent.VK_E){
		   
	   }else if(keyCode == KeyEvent.VK_F){
		   
	   }else if(keyCode == KeyEvent.VK_G){
		   
	   }else if(keyCode == KeyEvent.VK_H){
		   
	   }else if(keyCode == KeyEvent.VK_I){
		   
	   }else if(keyCode == KeyEvent.VK_J){
		   
	   }else if(keyCode == KeyEvent.VK_K){
		   
	   }else if(keyCode == KeyEvent.VK_L){
		   
	   }else if(keyCode == KeyEvent.VK_M){
		   
	   }else if(keyCode == KeyEvent.VK_N){
		   
	   }else if(keyCode == KeyEvent.VK_O){
		   
	   }else if(keyCode == KeyEvent.VK_P){
		   
	   }else if(keyCode == KeyEvent.VK_Q){
		   
	   }else if(keyCode == KeyEvent.VK_R){
		   
	   }else if(keyCode == KeyEvent.VK_S){
		   
	   }else if(keyCode == KeyEvent.VK_Z){
		   
	   }else if(keyCode == KeyEvent.VK_T){
		   
	   }else if(keyCode == KeyEvent.VK_U){
		   
	   }else if(keyCode == KeyEvent.VK_V){
		   
	   }else if(keyCode == KeyEvent.VK_W){
		   		   
	   }else if(keyCode == KeyEvent.VK_X){
		   
	   }else if(keyCode == KeyEvent.VK_Y){
		   
	   }
    }
}
