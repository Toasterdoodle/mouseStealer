import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class GraphicsPanel extends JPanel{

    //instance fields
    private Timer timer;
    private int width, height;
    Robot terminator;
//    String[] cmd = {"osascript", "-e","set volume 15"};

    //constructor
    public GraphicsPanel(int width, int height){

        //----------

        //music
        try{
            // open the sound file as a Java input stream
            String hop = "res/music1.wav";
            InputStream in = new FileInputStream(hop);
            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);
            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);
        } //end try
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error loading sound file.");
        }//end catch

        //----------

        //music timer
        Timer music = new Timer(201000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    // open the sound file as a Java input stream
                    String hop = "res/music1.wav";
                    InputStream in = new FileInputStream(hop);
                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);
                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                } //end try
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error loading sound file.");
                }//end catch
            }});//end timer

        music.start();

        //----------

        setSize(width, height);

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                repaint();
            }//end actionPerformed
        });//end timer

        this.width = width;
        this.height = height;

        //----------

        //makes robot
        try{
            terminator = new Robot();
        }//end try
        catch (AWTException e){
            e.printStackTrace();
        }//end catch

        //----------

        timer.start();

    }//end GraphicsPanel

    //stuff in here gets done when repaint(); is called
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        //----------

        terminator.mouseMove(width/2, height/2);
        terminator.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        terminator.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        terminator.keyPress(KeyEvent.VK_F12);
        terminator.keyRelease(KeyEvent.VK_F12);

        //----------

        g2.setColor(new Color(0, 0, 0));
        g2.setFont(new Font("Arial", Font.BOLD, 32));
        g2.drawString("We have taken your cursor hostage.", 200, 150);
        g2.drawString("Do not resist.", 200, 220);

        //----------

//        Runtime.getRuntime().exec(cmd);

    }//end paintComponent

}//end class