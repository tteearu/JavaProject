package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;
 
public class WinLoose {
    
   private JFrame Frame;
   private JFrame Graphics;
   private JLabel headerLabel1;
   private JLabel headerLabel2;
   private JLabel statusLabel;
   private JPanel winner;
   private JPanel information;
   private JPanel newGame;

   public WinLoose(){
      gui();
   }

   public static void main(){
	   WinLoose  swingControl = new WinLoose();      
      swingControl.textField();
   }

   private void gui(){
      Frame = new JFrame("Finish");
      Frame.setSize(650,500);
      Frame.setLayout(new GridLayout(3, 1));
      Graphics = new JFrame("Bet, you won't win the next round!");
      Graphics.setSize(650,550);
      Graphics.setLayout(new GridLayout(3, 1));
      Frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
         Graphics.addWindowListener(new WindowAdapter() {
        	 public void windowClosing(WindowEvent windowEvent){
        		 System.exit(0);
    	 }    
      });    
      headerLabel1 = new JLabel("", JLabel.CENTER);
      headerLabel2 = new JLabel("", JLabel.CENTER);  
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      information = new JPanel();
      information.setLayout(new GridLayout(1, 1));
      winner = new JPanel();
      winner.setLayout(new GridLayout(1, 1));
      newGame = new JPanel();
      newGame.setLayout(new GridLayout(1, 1));

      Frame.add(headerLabel1);
      Frame.add(headerLabel2);
//    Frame.add(Graphics);
      Frame.add(information);
      Frame.add(winner);
      Frame.add(newGame);
      Frame.add(statusLabel);
      Frame.setVisible(true);   
   }
   

   private void textField(){
      headerLabel1.setText("");
      headerLabel2.setText("");

      JLabel  namelabel= new JLabel("Player name: ", JLabel.RIGHT);
      


      final JButton newGameButton = new JButton("New Game");
      newGameButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
             Frame.show(false);
        	 Game.gamePlay();
         }
      }); 

      JButton exitButton = new JButton("Exit");
      exitButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {     
    		  System.exit(0);    
    	  };
      });

      information.add(namelabel);
      newGame.add(newGameButton);
      newGame.add(exitButton);
      Frame.setVisible(true);
      Frame.setResizable(false);
      Frame.setAlwaysOnTop(true);   
   }
}