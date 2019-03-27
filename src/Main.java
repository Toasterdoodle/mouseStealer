import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael Chen
 */

public class Main {

    public static void main(String[] args) {

        //not sure what this does
        JFrame frame = new JFrame("Try and move your cursor. Go on, try it.");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)(screenSize.getWidth());
        int height = (int)(screenSize.getHeight());
        frame.setPreferredSize(new Dimension(width, height+24));

        //JPanel
        JPanel panel = new GraphicsPanel(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        //Frame
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        //This just makes it fullscreen
        com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(frame,true);
        com.apple.eawt.Application.getApplication().requestToggleFullScreen(frame);

    }//end psvm

}//end class