import java.awt.Image ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;




import javax.swing.JPanel;
import javax.swing.ImageIcon ;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

//------------------------------------------------------Play class

public class Play extends JPanel implements ActionListener {

    private Image snakeHead ;
    private Image snakeBody ;
    private Image Food ;
    private Timer timer;



    private final int totalDots = 2500 ;
    private final int oneDot = 10;

    private final int x[] = new int[totalDots];
    private final int y[] = new int[totalDots];
    private int foodX = 0;
    private int foodY = 0;

    private boolean started = false ;
    private int bodyLength = 0 ;

    private boolean left = true ;
    private boolean right = false ;
    private boolean up = false ;
    private boolean down = false ;
    
    //------------------------------------------------------Constructor 
    public Play(){
        addKeyListener(new TAdapter());
        gameSet() ;
        Start() ;
    }

    //------------------------------------------------------gameSet method to set the game interface
    public void gameSet(){
        ImageIcon iish = new ImageIcon("Pictures/Snake.png");
        snakeHead = null ;
        snakeHead = iish.getImage() ;

        ImageIcon iisb = new ImageIcon("Pictures/Snake.png");
        snakeBody = null ;
        snakeBody = iisb.getImage() ;

        ImageIcon iif = new ImageIcon("Pictures/Snake.png");
        Food = null ;
        Food = iif.getImage() ;
        
    }

    //------------------------------------------------------Method to spawn the snake
    public void spawnSnake(){
        bodyLength = 2;

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
    public void Start(){
        
        //doDrawing(g);
        started = true ;
        spawnSnake() ;
        spawnFood() ;

        timer = new Timer(100, this);
        timer.start();

        
    }
    
    //------------------------------------------------------End method to end the game
    public void End(){
        started = false ;

        timer.stop();
    }








    //------------------------------------------------------Method to move the snake
    public void move(){
        for (int i = bodyLength; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if (left) {
            x[0] -= oneDot;
        }

        if (right) {
            x[0] += oneDot;
        }

        if (up) {
            y[0] -= oneDot;
        }

        if (down) {
            y[0] += oneDot;
        }
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
        if ( x[0] < 0){
            End() ;
        }

        if ( x[0] > 500){
            End() ;
        }

        if ( y[0] < 0){
            End() ;
        }

        if ( y[0] > 500){
            End() ;
        }

        for (int i = bodyLength; i > 0; i--) {

            if ( (x[0] == x[i]) && (y[0] == y[i]) ){
                End() ;
            }
        }

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
            }//for loop

            Toolkit.getDefaultToolkit().sync();

        } 
        else {

            End();
        }        
    }

    //------------------------------------------------------override methods from actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (started) {

            CheckFoodCollision();
            CheckCollision();
            move();
        }

        repaint();
    }

    //------------------------------------------------------Make a ketadapter class to controll the key press functions
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) ) {
                left = true;
                right = false ;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) ) {
                left = false;
                right = true ;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) ) {
                left = false;
                right = false ;
                up = true;
                down = false;
            }

            if ((key == KeyEvent.VK_DOWN) ) {
                left = false;
                right = false ;
                up = false;
                down = true;
            }
        }
    }

}
