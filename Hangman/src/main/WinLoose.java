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
  
      headerLabel1 = new JLabel("Bet, you won't win the next round!", JLabel.CENTER);
      headerLabel1.setFont(new Font("Regular", Font.PLAIN, 20));
      word = new JLabel("", JLabel.CENTER);

      information = new JPanel();
      information.setLayout(new GridLayout(1, 1));
      
      
      emtpyJPanel1 = new JPanel();
      emtpyJPanel1.setLayout(new GridLayout(1, 1));
      emtpyJPanel1.add(headerLabel1);
      
      
      newGame = new JPanel();
      newGame.setLayout(new GridLayout(1, 2));
      
      Frame.add(headerLabel1);
      Frame.add(information);
      Frame.add(emtpyJPanel1);
      Frame.add(word);
      Frame.add(newGame);
//      Frame.add(statusLabel);
      Frame.setVisible(true);   
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
//      String tekst = game.engine.word2B;
//      System.out.println(tekst);
//      word.setText(tekst);
   
      
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

      newGame.add(newGameButton);
      newGame.add(exitButton);
      Frame.setVisible(true);
      Frame.setResizable(false);
      Frame.setAlwaysOnTop(true);   
   }
}