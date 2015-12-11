package main;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class Game {
    
   private JFrame Frame;
   private JFrame Graphics;
   private JLabel header1;
   private JLabel kriipsud;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel alphabet;
   private JPanel stickSam;

   public Game(){
      prepareGUI();
   }

   public static void gamePlay(){
      Game  swingControlDemo = new Game();      
      swingControlDemo.textField();
   }
   
   private void prepareGUI(){
      Frame = new JFrame("Hangman");
      Frame.setSize(650,600);
      Frame.setLayout(new GridLayout(3, 1));
      Graphics = new JFrame("Think hard about your next move!");
      Graphics.setSize(650,600);
      Graphics.setLayout(new GridLayout(3, 9));
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
      header1 = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
    

      statusLabel.setSize(600,60);
      
      stickSam = new JPanel();
      stickSam.setLayout(new GridLayout(1, 1));

      controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(2, 1));
      controlPanel.setMinimumSize(new Dimension(650, 300));
      alphabet = new JPanel();
      alphabet.setLayout(new GridLayout(3, 12));

      controlPanel.add(header1);
      controlPanel.add(kriipsud);
      Frame.add(controlPanel);
      Frame.add(stickSam);
//      Ring ring = new Ring();
//      ring.drawHangman(5);
//      controlPanel.add(ring.g);
      Frame.add(alphabet);
//      Frame.add(statusLabel);
      Frame.setVisible(true);   
   }
   public void showArr(String[] args){
	   kriipsud = new JLabel(args.toString(), JLabel.CENTER);
   }

   private void textField(){
      header1.setText("Guess the word by clicking the letters!");

      JButton exitButton = new JButton("EXIT");
      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
        	 System.exit(0);    
         };
      });
 
      final String[] word2B = GameEngine.Engine();
//      final String[] initline = GameEngine.kriips(word2B);
      
      
      
// 	 ((JButton)e.getSource()).disable();

      String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "Z", "T", "U", "V", "W", "X", "Y"};
      for(String letter: letters){
    	  final JButton letterButton = new JButton(letter);
          letterButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {     
            	String[] initline = GameEngine.kriips(word2B);
            	letterButton.setVisible(false);
            	String[] wordStatus = GameEngine.letterCheck(letterButton.toString(), word2B, initline);
            	initline = wordStatus;
            	 kriipsud = new JLabel(wordStatus.toString(), JLabel.CENTER);             };
          });
          alphabet.add(letterButton, BorderLayout.SOUTH);
         
      }
      final JButton testingButton = new JButton("TST");
      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 System.exit(0);
         };
      });
      alphabet.add(testingButton, BorderLayout.SOUTH);
      Frame.setVisible(true);
      Frame.setResizable(false);
      Frame.setAlwaysOnTop(true);   
   }
}