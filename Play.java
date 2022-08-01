import java.awt.Image ;
//import java.awt.image.BufferedImage;
//import java.awt.Button ;
//import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Dimension;
import java.awt.Graphics;

//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;



import javax.swing.JPanel;
//import javax.swing.JLabel ;
import javax.swing.ImageIcon ;

//------------------------------------------------------Play class

public class Play extends JPanel implements ActionListener {

    private Image snakeHead ;
    private Image snakeBody ;
    private Image Food ;



    private final int totalDots = 2500 ;
    private final int oneDot = 10;

    private final int x[] = new int[totalDots];
    private final int y[] = new int[totalDots];
    private int foodX = 0;
    private int foodY = 0;

    private boolean started = false ;
    private int bodyLength = 0 ;
    
    //------------------------------------------------------Constructor 
    public Play(){
        gameSet() ;
    }

    //------------------------------------------------------gameSet method to set the game interface
    public void gameSet(){
        //------------------------------------------------------------------Drawing images
        ImageIcon iish = new ImageIcon("Pictures/Snake.png");
        snakeHead = null ;
        snakeHead = iish.getImage() ;

        ImageIcon iisb = new ImageIcon("Pictures/Snake.png");
        snakeBody = null ;
        snakeBody = iisb.getImage() ;

        ImageIcon iif = new ImageIcon("Pictures/Snake.png");
        Food = null ;
        Food = iif.getImage() ;

        repaint() ;
        
    }

    //------------------------------------------------------Method to spawn the snake
    public void spawnSnake(){
        bodyLength = 2;
        /* 
        for (int i = 0; i< bodyLength; i++) {
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
        */
        for (int i = 0; i< bodyLength; i++) {
            x[i] = (int) (Math.random() * totalDots) + oneDot; ;
            y[i] = (int) (Math.random() * totalDots) + oneDot ;
        }
    }

    //------------------------------------------------------Method to spawn the food
    public void spawnFood(){

        int x = (int) (Math.random() * totalDots) + oneDot ;
        foodX = (x * oneDot) ;

        int y = (int) (Math.random() * totalDots) + oneDot ;
        foodY = (y * oneDot) ;
    }

    //------------------------------------------------------End method to end the game
    public void Start(Graphics g){
        
        //doDrawing(g);

        
    }
    
    //------------------------------------------------------End method to end the game
    public void End(Graphics g){

    }

    //------------------------------------------------------Method to check if the snake eats the food
    public void CheckFoodCollision(){
        if ( (x[0] == foodX)  && (y[0] == foodY) ){
            bodyLength++ ;
            spawnFood() ;
        }
    }

    //------------------------------------------------------Method to check if the snake hits the boundary
    public void CheckCollision(){

    }

    //------------------------------------------------------override methods from graphics
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawSnake(g);
    }

    private void drawSnake(Graphics g) {
        
        if (started) {

            g.drawImage(Food, foodX, foodY, this);

             
            for (int i = 0; i < bodyLength; i++) {
                if (i == 0) {
                    g.drawImage(snakeHead, x[i], y[i], this);
                } else {
                    g.drawImage(snakeBody, x[i], y[i], this);
                }
            
            /* 
            Toolkit.getDefaultToolkit().sync();
            */
            }//for loop

        } 
        else {

            End(g);
        }        
    }

    //------------------------------------------------------override methods from actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint() ;
    }

    
}
