package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;
 
public class WinLoose {
    
   private JFrame Frame;
   private JFrame Graphics;
   private JLabel headerLabel1;
   private JLabel word;
   private JLabel statusLabel;
   private JPanel information;
   private JPanel emtpyJPanel1;
   private JPanel newGame;
   private JLabel namelabel;
   private static Game game;
   public WinLoose(Game gameEngine){
	   this.game = gameEngine;
	   gui();
   }


   private void gui(){
      Frame = new JFrame("Finish");
      Frame.setSize(650,600);
      Frame.setLayout(new GridLayout(5,1));
      Frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      /**
       * Displaying text with JLabel
       */
  
      headerLabel1 = new JLabel("Bet, you won't win the next round!", JLabel.CENTER);
      headerLabel1.setFont(new Font("Regular", Font.PLAIN, 20));
      word = new JLabel("", JLabel.CENTER);

      /**
       * Setting layouts to JPanels
       */
      information = new JPanel();
      information.setLayout(new GridLayout(1, 1));
      
      
      emtpyJPanel1 = new JPanel();
      emtpyJPanel1.setLayout(new GridLayout(1, 1));
      emtpyJPanel1.add(headerLabel1);
      
      
      newGame = new JPanel();
      newGame.setLayout(new GridLayout(1, 2));
      
      /**
       * Adding JPanels to Frame
       */
      
      Frame.add(information);
      Frame.add(headerLabel1);
      Frame.add(emtpyJPanel1);
      Frame.add(word);
      Frame.add(newGame);
      Frame.setVisible(true);   
      
      /**
       * Checking whether the game was won or lost
       */
      
      if(game.engine.wordGuessed){
    	  JLabel namelabel= new JLabel( "You won! ... this time", JLabel.CENTER);
    	  namelabel.setFont(new Font("Regular", Font.PLAIN, 20));
    	  information.add(namelabel);
      } else {
    	  JLabel namelabel= new JLabel(" You have been hung! " , JLabel.CENTER); 
    	  namelabel.setFont(new Font("Regular", Font.PLAIN, 20));
    	  information.add(namelabel);
      }
       
      headerLabel1.setText("Bet, you won't win the next round!");
      
      /**
       * Creating buttons for new game and exiting the program
       */
   
      
      final JButton newGameButton = new JButton("New Game");
      newGameButton.setFont(new Font("Regular", Font.BOLD, 16));
      newGameButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
             Frame.show(false);
        	 Game.gamePlay();
         }
      }); 

      JButton exitButton = new JButton("Exit");
      exitButton.setFont(new Font("Regular", Font.BOLD, 16));
      exitButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {     
    		  System.exit(0);    
    	  };
      });

      newGame.add(newGameButton);
      newGame.add(exitButton);
      Frame.setVisible(true);
      Frame.setResizable(false);
      Frame.setAlwaysOnTop(true);   
   }
}