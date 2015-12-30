package main;
import java.awt.*;
import java.awt.event.*;
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

   public static void main(String[] args){
      Registration  swingControlDemo = new Registration();      
      swingControlDemo.showTextFieldDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Hangman");
      mainFrame.setSize(650,600);
      mainFrame.setLayout(new GridLayout(5, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel1 = new JLabel("", JLabel.CENTER);
      headerLabel2 = new JLabel("", JLabel.CENTER);  
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

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
      final JTextField userText = new JTextField(6);
      final String userName = userText.getText();
      

      JButton exitButton = new JButton("Exit");
      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
        	 System.exit(0);    
         };
      });

      final JButton startButton = new JButton("Start");
      startButton.addActionListener(new ActionListener() {
         
    	  public  void actionPerformed(ActionEvent e) {     
            String name = "Player name:" + userText.getText();
            statusLabel.setText(name);
            controlPanel.show(false);
            mainFrame.show(false);
            Game.gamePlay();
         }
      }); 

      controlPanel.add(namelabel);
      controlPanel.add(userText);
      controlPanel.add(startButton);
      mainFrame.setVisible(true);
      mainFrame.setResizable(false);
      mainFrame.setAlwaysOnTop(true);
      mainFrame.add(exitButton, BorderLayout.SOUTH); 
   }
}