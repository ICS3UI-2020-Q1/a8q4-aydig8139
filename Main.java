import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  
  JPanel mainPanel;
  
  JLabel nLabel;
  JLabel factorialLabel;

  JTextField input;
  JTextField output;

  JButton calcButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize the main JPanel
    mainPanel = new JPanel();

    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the labels
    nLabel = new JLabel("n");
    factorialLabel = new JLabel("factorial(n)");

    //layout the labels by setting the coordinate and size 
    nLabel.setBounds(20,20,20,20);
    factorialLabel.setBounds(120,20,80,20);

    //initialize the input text fields
    input = new JTextField();
    output = new JTextField();

    //set the location and size 
    input.setBounds(50, 20, 50, 20);
    output.setBounds(210, 20, 100, 20);

    //initialize the button
    calcButton = new JButton("CALC");

    //set the size and location of the button
    calcButton.setBounds(320, 20, 80, 20);

    //add an action listener to the buttons
    calcButton.addActionListener(this);

    //set the action command on the buttons
    calcButton.setActionCommand("CALC");

    //add the button to the panel
    mainPanel.add(calcButton);

    //add the text fields to the panel
    mainPanel.add(input);
    mainPanel.add(output);

    //add the labels to the main panel 
    mainPanel.add(nLabel);
    mainPanel.add(factorialLabel);

    //add the panel to the window
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("CALC")){

      //get text from input and change it into an integer
      String inputText = input.getText();
      int inputInt = Integer.parseInt(inputText);
      
      //declare variable to store the product of the numbers multiplied
      int product = 1;

      //create for loop and declare variable to decrease the multiple number one by one
      for(int multiply = inputInt; multiply >= 1; multiply--){
      
      product = product*multiply;
    }

    //print result on screen
    output.setText("" + product);

  }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
