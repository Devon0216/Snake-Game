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
        this.setTitle("Snake Game") ;
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.pack() ;
        this.setResizable(false);

        int width = 500 ;
        int height = 500 ;
        this.setSize(width, height );

        this.add(new Play()); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
    
    //------------------------------------------------------Main method to trigger the snake constructor
    public static void main(String[] args) throws Exception {
        Snake oneSnake = new Snake() ;
    }
}
