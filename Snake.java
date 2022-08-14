import javax.swing.JFrame ;
import javax.swing.* ;

import java.awt.Button ;
import java.awt.BorderLayout ;

import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.EventQueue ;


//------------------------------------------------------Snake class
public class Snake extends JFrame{

    private Button startButton ;
    private Button EndButton ;
    private Button helpButton ;
    private JPanel buttonPanel ;

    private boolean started = false ;
    
    //------------------------------------------------------Constructor
    public Snake(){
        setSnakeFrame() ;
    }

    //------------------------------------------------------Set up the main interface
    private void setSnakeFrame(){
        //------------------------------------------------------------------Set up basic buttons
        /*startButton = new Button("Start") ;
        startButton.setLocation(50,400);
        startButton.setSize(100,100);
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                started = true ;
                Play playTheGame = new Play() ;
            }
        });

        EndButton = new Button("End Game") ;
        EndButton.setLocation(200,400);
        EndButton.setSize(100,100);
        EndButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                started = false ;
            }
        });

        helpButton = new Button("Help!") ;
        helpButton.setLocation(350,400);
        helpButton.setSize(100,100);

        buttonPanel = new JPanel() ;

        //this.setPreferredSize( new Dimension(500,500) ) ;
        buttonPanel.add(startButton, BorderLayout.SOUTH) ;
        buttonPanel.add(EndButton, BorderLayout.SOUTH) ;
        buttonPanel.add(helpButton, BorderLayout.SOUTH) ;
        this.add(buttonPanel) ;
*/

        this.setTitle("Snake Game") ;
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        

        this.add(new Play()); 
        this.setResizable(false);
        this.pack() ;

        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
    
    //------------------------------------------------------Main method to trigger the snake constructor
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(() -> {
            JFrame snake = new Snake();
            //snake.setVisible(true);
        });
    }
}
