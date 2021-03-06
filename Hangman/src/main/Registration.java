package main;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
 
public class Registration {
   private JFrame mainFrame;
   private JLabel headerLabel1;
   private JLabel headerLabel2;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Registration(){
      prepareGUI();
   }

   /**
    * @param args
    * Main method that launches the program
    */
   
   public static void main(String[] args){
      Registration  swingControlDemo = new Registration();      
      swingControlDemo.showTextFieldDemo();
   }

   private void prepareGUI(){
	 
	   /**
	   * Creating new JFrame, and setting some attributes to it
	   */
      
	  mainFrame = new JFrame("Hangman");
      mainFrame.setSize(650,600);
      mainFrame.setLayout(new GridLayout(5, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      
      /**
       * Adding some empty JLabels to fill in the blank space
       */
      
      headerLabel1 = new JLabel("", JLabel.CENTER);
      headerLabel2 = new JLabel("", JLabel.CENTER);  
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      /**
       * Adding JLabels to JFrame to organize the layout
       */
      mainFrame.add(headerLabel1);
      mainFrame.add(headerLabel2);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);   
   }
   

   private void showTextFieldDemo(){
	   
      headerLabel1.setText("Welcome! You are the chosen one!");
      headerLabel1.setFont(new Font("Regular", Font.BOLD, 16));
      
      headerLabel2.setText("Enter your name down below, and click Start!");
      headerLabel2.setFont(new Font("Regular", Font.BOLD, 16));

      JLabel  namelabel= new JLabel("Player name: ", JLabel.RIGHT);
      namelabel.setFont(new Font("Regular", Font.BOLD, 14));
      final JTextField userText = new JTextField(6);
      final String userName = userText.getText();
      
      /**
       * Creating new buttons and changing font attributes
       */
     
      JButton exitButton = new JButton("Exit");
      exitButton.setFont(new Font("Regular", Font.BOLD, 15));
      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
        	 System.exit(0);    
         };
      });

      final JButton startButton = new JButton("Start");
      startButton.setFont(new Font("Regular", Font.BOLD, 13));
      startButton.addActionListener(new ActionListener() {      
    	  public  void actionPerformed(ActionEvent e) {     
            String kataloogitee = GameEngine.class.getResource(".").getPath();
            System.out.println(kataloogitee);
      		try {
      		    FileWriter writer = new FileWriter(kataloogitee +"Players.txt", true);
      		    writer.write(userText.getText() + "\n");
      		    writer.close();


      		} catch (IOException k) {
      			System.out.println(k.getMessage());
      			System.exit(-1);
      		}
      		/**
      		 * Changing the visibility of mainFrame
      		 */
            mainFrame.show(false);
            Game.gamePlay();
         }
      }); 
      
      /**
       * Adding labels to JPanel
       */

      controlPanel.add(namelabel);
      controlPanel.add(userText);
      controlPanel.add(startButton);
      mainFrame.setVisible(true);
      mainFrame.setResizable(false);
      mainFrame.setAlwaysOnTop(true);
      mainFrame.add(exitButton, BorderLayout.SOUTH); 
   }
}