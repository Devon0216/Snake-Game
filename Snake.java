import javax.swing.JFrame;
import javax.swing.*;

import java.awt.Button ;
import java.awt.BorderLayout;


//------------------------------------------------------Snake class
public class Snake extends JFrame{
    
    //------------------------------------------------------Constructor
    public Snake(){
        setSnakeFrame() ;
    }

    //------------------------------------------------------Set up the main interface
    private void setSnakeFrame(){
        JFrame mainFrame = new JFrame("Snake Game") ;
        JPanel mainPanel = new JPanel(null) ;
        JPanel buttonPanel = new JPanel(null) ;

        Button startButton = new Button("Start") ;
        startButton.setLocation(50,400);
        startButton.setSize(100,100);

        Button EndButton = new Button("End Game") ;
        EndButton.setLocation(200,400);
        EndButton.setSize(100,100);

        Button helpButton = new Button("Help!") ;
        helpButton.setLocation(350,400);
        helpButton.setSize(100,100);

        buttonPanel.add(startButton, BorderLayout.SOUTH) ;
        buttonPanel.add(EndButton, BorderLayout.SOUTH) ;
        buttonPanel.add(helpButton, BorderLayout.SOUTH) ;

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

        int width = 500 ;
        int height = 500 ;
        mainFrame.setSize(width, height );

        mainFrame.setContentPane(mainPanel);
        mainFrame.setContentPane(buttonPanel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);


    }
    
    //------------------------------------------------------Main method to trigger the snake constructor
    public static void main(String[] args) throws Exception {
        Snake oneSnake = new Snake() ;
    }
}
