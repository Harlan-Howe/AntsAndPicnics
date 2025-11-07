import javax.swing.*;
import java.awt.*;

public class PicnicWindow extends JFrame
{
    private World myWorld;
    private PicnicPanel myPanel;

    public PicnicWindow()
    {
        super("Picnic");
        setSize(Cell.CELL_SIZE * World.NUM_COLS_IN_WORLD+Cell.LEFT_MARGIN*2,
                Cell.CELL_SIZE * World.NUM_ROWS_IN_WORLD + Cell.TOP_MARGIN* 2 + 32);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quits program when window is closed.

        // make a panel that fills the window.
        this.getContentPane().setLayout(new GridLayout(1,1));
        myWorld = new World();
        myPanel = new PicnicPanel(myWorld);
        this.getContentPane().add(myPanel);

        setResizable(false);
        setVisible(true);
    }


    public void run()
    {
        myPanel.startAnimation();
    }
}
