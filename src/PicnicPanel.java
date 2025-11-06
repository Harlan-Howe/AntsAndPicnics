import javax.swing.*;
import java.awt.*;

public class PicnicPanel extends JPanel
{

    public static final Color[] NEST_AND_ANT_COLORS = {Color.RED, Color.GREEN, Color.BLUE};

    private World myWorld;

    public PicnicPanel(World w)
    {
        super();
        myWorld = w;
        setBackground(Color.lightGray);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        myWorld.drawSelf(g);
    }
}
