import javax.swing.*;
import java.awt.*;

public class PicnicWindow extends JFrame
{
    private World myWorld;
    private PicnicPanel myPanel;

    public PicnicWindow()
    {
        super("Picnic");
        setSize(Cell.CELL_SIZE * World.NUM_COLS_IN_WORLD, Cell.CELL_SIZE * World.NUM_ROWS_IN_WORLD + 32);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(1,1));
        myWorld = new World();
        myPanel = new PicnicPanel(myWorld);
        this.getContentPane().add(myPanel);
        setResizable(false);
        setVisible(true);
    }


    public void run()
    {
        // start animation loop.
    }
}
