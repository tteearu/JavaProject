package main;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
 
public class Game implements ActionListener {
    
   static JFrame frame;
   private JFrame graphics;
   private JLabel header1;
   private JLabel kriipsud;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel alphabet;
   private JPanel stickSam;
   private JLabel kriipsuJuku;
   GameEngine engine;
   private DrawingHangman hangman;
   private JLabel fail;
   public int failCounter;
   private KeyListener keyListener;
   String[] initline;
   
   
   public Game(){
      engine = new GameEngine(null);
      keyListener = new KeyListener(this);
      gui();
   }

   public static void gamePlay(){
      Game  swingControl = new Game();      
      swingControl.textField();
   }
   
   private void gui(){
      frame = new JFrame("Hangman");
      frame.setSize(650,600);
      frame.setLayout(new GridLayout(3, 1));
      graphics = new JFrame("Think hard about your next move!");
      graphics.setSize(650,600);
      graphics.setLayout(new GridLayout(3, 9));
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
         graphics.addWindowListener(new WindowAdapter() {
        	 public void windowClosing(WindowEvent windowEvent){
        		 System.exit(0);
    	 }    
      });    
      header1 = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
    
      statusLabel.setSize(600,60);
      
      stickSam = new JPanel();
      stickSam.setLayout(new GridLayout(1, 1));
      hangman = new DrawingHangman(this);
//      stickSam.draw(hangman.drawHangman(failCounter));
      controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(2, 1));
      controlPanel.setMinimumSize(new Dimension(650, 300));
      alphabet = new JPanel();
      alphabet.setLayout(new GridLayout(3, 12));

      controlPanel.add(header1);
      frame.add(controlPanel);
      frame.add(stickSam);
//      Ring ring = new Ring();
//      ring.drawHangman(5);
//      controlPanel.add(ring.g);
		frame.add(alphabet);
		frame.setVisible(true);
		kriipsud = new JLabel("", JLabel.CENTER);
		String status = Arrays.toString(engine.letters);
		kriipsud.setText(status);
		fail = new JLabel("", JLabel.CENTER);
		String failCounter = String.valueOf(engine.failCounter);
		fail.setText("Failed :: " + failCounter + "/9 times");
		controlPanel.add(kriipsud);
		controlPanel.add(fail);
	//KATSETUS
//		stickSam = new JPanel();
//	    img hangman.paint();
	    kriipsuJuku = new JLabel("testinsadasdasffk",JLabel.CENTER);

	    int failed = engine.failCounter;
	    hangman.drawHangman(failed);
	    stickSam.add(kriipsuJuku);
	//KATSETUS
		controlPanel.add(fail);
   
	   String letters[] = {"A", "B","C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "Z", "T", "U", "V", "W", "X", "Y"};
	// String letters[] = {"Q", "W","E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
	 for(String letter: letters){
	  final JButton letterButton = new JButton(letter);
	  letterButton.addKeyListener(keyListener);
     letterButton.addActionListener(this);
     alphabet.add(letterButton, BorderLayout.SOUTH);
    
 }
 
 JButton testingButton = new JButton("TesT");
 testingButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {     
   	 frame.show(false);
   	 WinLoose.main();    
    };
 });
 
 alphabet.add(testingButton, BorderLayout.SOUTH);
 frame.setVisible(true);
 frame.setResizable(false);
 frame.setAlwaysOnTop(true);   
}
//   public void showArr(String[] args){
//	   System.out.println("Kriipsud");
//   }

   private void textField(){
      header1.setText("Guess the word by clicking the letters!");

      JButton exitButton = new JButton("EXIT");
      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
        	 System.exit(0);    
         };
      });
   	}
      
 
//      final String word2B = engine.word2B;
   
      public void actionPerformed(ActionEvent e) {  
    	JButton letterButton = (JButton) e.getSource();
      	letterButton.setVisible(false);

      	onScreenAction(letterButton.getText());
      	
      }
      public void onScreenAction(String letterKey ) {  

        	engine.letterCheck(letterKey);
        	System.out.println(letterKey);
        	System.out.println(Arrays.toString(engine.initWord));
  			System.out.println(engine.prevWord);
  		    
  			String status = Arrays.toString(engine.letters);
  		    kriipsud.setText(status);
  		    controlPanel.add(kriipsud);
  		    
  		    int failCounter = engine.failCounter;
  		    fail.setText(String.valueOf(failCounter));
  			System.out.println(failCounter);
  		    controlPanel.add(fail);
  		    /**
  		     * DRAWING HANGMAN
  		     */
  		    failCounter = engine.failCounter;
  		    int failed = engine.failCounter;
//  		    DrawingHangman.drawHangman(failCounter);
  		    /**
  		     * END OF DRAWING HANGMAN
  		     */
  		    boolean gOver = engine.gOver;
  		    if(gOver){
  		    	frame.show(false);
  		    }
        }
}