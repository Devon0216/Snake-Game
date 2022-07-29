import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.Button ;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

//------------------------------------------------------Play class

public class Play extends JPanel implements ActionListener {

    private BufferedImage snake ;
    private BufferedImage food ;

    private Button startButton ;
    private Button EndButton ;
    private Button helpButton ;
    
    //------------------------------------------------------Constructor 
    public Play(){
        gameSet() ;
    }

    //------------------------------------------------------gameSet method to set the game interface
    public void gameSet(){

        

        startButton = new Button("Start") ;
        startButton.setLocation(50,400);
        startButton.setSize(100,100);

        EndButton = new Button("End Game") ;
        EndButton.setLocation(200,400);
        EndButton.setSize(100,100);

        helpButton = new Button("Help!") ;
        helpButton.setLocation(350,400);
        helpButton.setSize(100,100);

        this.setPreferredSize( new Dimension(500,500) ) ;
        this.add(startButton, BorderLayout.SOUTH) ;
        this.add(EndButton, BorderLayout.SOUTH) ;
        this.add(helpButton, BorderLayout.SOUTH) ;


        //snake = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB) ;
        snake = null ;
        try{
            snake = ImageIO.read(new File("Pictures/Snake.png"));
        }
        catch(IOException e){
            System.out.println("The image cannot be loaded.");
        }
        

        //food = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB) ;
        food = null ;
        try{
            food = ImageIO.read(new File("Pictures/Food.png"));
        }
        catch(IOException e){
            System.out.println("The image cannot be loaded.");
        }
        
    }

    //------------------------------------------------------End method to end the game
    public void End(){

    }

    //------------------------------------------------------override methods from actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
