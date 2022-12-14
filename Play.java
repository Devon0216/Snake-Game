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
import java.awt.Color;
import java.awt.Dimension;

//------------------------------------------------------Play class

public class Play extends JPanel implements ActionListener {

    private Image snakeHead ;
    private Image snakeBody ;
    private Image Food ;
    private Timer timer;


    private final int frameLength = 490 ;
    private final int frameWidth = 490 ;
    private final int totalDots = frameLength*frameWidth ;
    private final int oneDot = 10;

    private final int x[] = new int[totalDots];
    private final int y[] = new int[totalDots];
    private int foodX = 0;
    private int foodY = 0;

    private boolean started = false ;
    private int bodyLength = 0 ;

    private boolean left = false ;
    private boolean right = true ;
    private boolean up = false ;
    private boolean down = false ;
    
    //------------------------------------------------------Constructor 
    public Play(){
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(500, 500));

        gameSet() ;
        Start() ;
        //System.out.println("started") ;
    }

    //------------------------------------------------------gameSet method to set the game interface
    public void gameSet(){

        ImageIcon imageIcon = new ImageIcon("Pictures/snakeHead.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        snakeHead = imageIcon.getImage() ;
        
        imageIcon = new ImageIcon("Pictures/snakeBody.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);       
        snakeBody = imageIcon.getImage() ;

        imageIcon = new ImageIcon("Pictures/Food.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg); 
        Food = imageIcon.getImage() ;
        
    }

    //------------------------------------------------------Method to spawn the snake
    public void spawnSnake(){
        bodyLength = 2;

        x[0] = (int) (Math.random() * (frameLength/10) )* oneDot  ;
        y[0] = (int) (Math.random() * (frameWidth/10) )* oneDot  ;
        for (int i = 1; i< bodyLength; i++) {
            x[i] = x[i-1]-10  ;
            y[i] = y[i-1]  ;

            //System.out.println("x: " + x[i] ) ;
            //System.out.println("y: " + y[i] ) ;
        }
    }

    //------------------------------------------------------Method to spawn the food
    public void spawnFood(){
        //System.out.println("new food spawned") ;
        int x = (int) (Math.random() * (frameLength/10))  ;
        foodX = (x * oneDot) ;
 

        int y = (int) (Math.random() * (frameWidth/10))  ;
        foodY = (y * oneDot) ;
    }









    //------------------------------------------------------End method to end the game
    public void Start(){
        
        //doDrawing(g);
        started = true ;
        spawnSnake() ;
        spawnFood() ;

        timer = new Timer(150, this);
        timer.start();

        //repaint() ;
        
    }
    
    //------------------------------------------------------End method to end the game
    public void End(){
        started = false ;

        timer.stop();
        setBackground(Color.white);
    }








    //------------------------------------------------------Method to move the snake
    public void move(){
        //System.out.println("in move") ;
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
        //System.out.println("check food collision") ;
        if ( (x[0] == foodX)  && (y[0] == foodY) ){
            bodyLength++ ;
            spawnFood() ;
        }
    }

    //------------------------------------------------------Method to check if the snake hits the boundary
    public void CheckCollision(){
        //System.out.println("check collision") ;
        if ( x[0] < 0){
            End() ;
        }

        if ( x[0] > frameLength ){
            End() ;
        }

        if ( y[0] < 0){
            End() ;
        }

        if ( y[0] > frameWidth ){
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
        //System.out.println("draw snake") ;
        if (started) {

            g.drawImage(Food, foodX, foodY, this);

             
            for (int i = 0; i < bodyLength; i++) {
                if (i == 0) {
                    g.drawImage(snakeHead, x[i], y[i], this);
                    //System.out.println("x: " + x[i] ) ;
                    //System.out.println("y: " + y[i] ) ;
                } else {
                    g.drawImage(snakeBody, x[i], y[i], this);
                    //System.out.println("x: " + x[i] ) ;
                    //System.out.println("y: " + y[i] ) ;
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
        //System.out.println("action performed") ;
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

            if ((key == KeyEvent.VK_LEFT)  && (!right)) {
                left = true;
                //right = false ;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                //left = false;
                right = true ;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down)) {
                left = false;
                right = false ;
                up = true;
                //down = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up)) {
                left = false;
                right = false ;
                //up = false;
                down = true;
            }
        }
    }

}
