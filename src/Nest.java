import java.awt.*;

public class Nest
{
    private int myRow, myCol;
    private int myColor;  // 0 = red, 1 = green, 2 = blue
    private int myTotalCollectedFood;
    private static final Font COUNTER_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 6);

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

    public void drawSelf(Graphics g)
    {
        g.setColor(PicnicPanel.NEST_AND_ANT_COLORS[myColor]);
        int centerX = Cell.LEFT_MARGIN + myCol*Cell.CELL_SIZE + Cell.CELL_SIZE/2;
        int centerY = Cell.TOP_MARGIN + myRow*Cell.CELL_SIZE + Cell.CELL_SIZE/2;

        int[] x_poly = {centerX-Cell.CELL_SIZE/3, centerX, centerX+Cell.CELL_SIZE/3};
        int[] y_poly = {centerY, centerY - 4*Cell.CELL_SIZE/10, centerY};

        g.fillPolygon(x_poly, y_poly, 3);

        g.setFont(COUNTER_FONT);
        String amount = ""+myTotalCollectedFood;
        int numberWidth = g.getFontMetrics().stringWidth(amount);
        g.drawString(amount,centerX-numberWidth/2, centerY+4*Cell.CELL_SIZE/10);

    }
}
