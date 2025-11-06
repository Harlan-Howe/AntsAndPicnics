import javax.swing.*;
import java.awt.*;

public class PicnicPanel extends JPanel
{
    private World myWorld;

    public PicnicPanel(World w)
    {
        super();
        myWorld = w;
    }

    public void paintComponent(Graphics g)
    {
        myWorld.drawSelf(g);
    }
}
