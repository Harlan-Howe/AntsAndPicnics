import java.awt.*;

public class Ant
{
    // TODO: you'll need to create variables for this class!

    public int getRow()
    {
        return -1; // TODO: fix this, once you have variables.
    }

    public int getCol()
    {
        return -1; // TODO: fix this, once you have variables.
    }

    public int getColor()
    {
        return -1; // TODO: fix this, once you have variables.
    }

    /**
     * draws this ant in the current cell.
     * @param g - the "Graphics" object that has the drawing tools and the canvas in which to draw.
     */
    public void drawSelf(Graphics g)
    {
        int centerX = Cell.LEFT_MARGIN + Cell.CELL_SIZE*getCol() + Cell.CELL_SIZE/2;
        int centerY = Cell.TOP_MARGIN + Cell.CELL_SIZE*getRow() + Cell.CELL_SIZE/2;

        g.setColor(PicnicPanel.NEST_AND_ANT_COLORS[getColor()]);

        // draws the ant as a dot, for now.
        g.drawOval(centerX - 4*Cell.CELL_SIZE/10, centerY - 4*Cell.CELL_SIZE/10, 4*Cell.CELL_SIZE/5, 4*Cell.CELL_SIZE/5);
    }
}
