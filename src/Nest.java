import java.awt.*;

public class Nest
{
    // CONSTANTS
    // this font will be set up once (final) and shared by all the nests (static).
    private static final Font COUNTER_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 6);

    private int myRow, myCol;
    private int myColor;  // 0 = red, 1 = green, 2 = blue
    private int myTotalCollectedFood;


    public Nest(int row, int column, int color)
    {
        myRow = row;
        myCol = column;
        myColor = color;
        myTotalCollectedFood = 0;
    }

    /**
     * The ant has delivered some food to this nest, so the nests' food source should increase.
     * @param food - the amount of food delivered by the ant
     * precondition: food should be positive.
     */
    public void receiveFood(int food)
    {
        myTotalCollectedFood += food;
    }

    public int getMyColor()
    {
        return myColor;
    }

    public int getRow()
    {
        return myRow;
    }

    public int getCol()
    {
        return myCol;
    }

    /**
     * draws this nest in its cell
     * @param g - the "Graphics" object that has the drawing tools and canvas in which to draw.
     */
    public void drawSelf(Graphics g)
    {
        int centerX = Cell.LEFT_MARGIN + myCol*Cell.CELL_SIZE + Cell.CELL_SIZE/2;
        int centerY = Cell.TOP_MARGIN + myRow*Cell.CELL_SIZE + Cell.CELL_SIZE/2;

        // build the polygon for the triangle that represents the anthill
        int[] x_poly = {centerX-Cell.CELL_SIZE/3, centerX, centerX+Cell.CELL_SIZE/3};
        int[] y_poly = {centerY, centerY - 4*Cell.CELL_SIZE/10, centerY};

        g.setColor(PicnicPanel.NEST_AND_ANT_COLORS[myColor]);
        g.fillPolygon(x_poly, y_poly, 3);

        // draw the text with the contents of this anthill.
        g.setFont(COUNTER_FONT);
        String amount = ""+myTotalCollectedFood;
        int numberWidth = g.getFontMetrics().stringWidth(amount);
        g.setColor(Color.BLACK);
        g.drawString(amount,centerX-numberWidth/2+1, centerY+4*Cell.CELL_SIZE/10+1);
        g.setColor(Color.WHITE);
        g.drawString(amount,centerX-numberWidth/2, centerY+4*Cell.CELL_SIZE/10);

    }
}
