import java.awt.*;

public class Basket
{
    // CONSTANTS
    // set once (final) and shared with all the baskets (static)
    private static final int MAX_FOOD_LEVEL = 100;
    private static final int MIN_STARTING_FOOD_LEVEL = 50;
    private static final Color BROWN = new Color(64, 32, 0);
    private static final Font FOOD_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 6);

    private int myFoodLevel;
    private int myRow, myCol;

    public Basket()
    {
        pickRandomLocation();
        pickStartingFoodLevel();
    }

    public int getFoodLevel() { return myFoodLevel;}
    public boolean isEmpty() {return myFoodLevel == 0;}
    public int getRow() { return myRow;}
    public int getCol() { return myCol;}

    /**
     * attempts to remove the given amount of food from this basket. If the basket doesn't have at least this amount of
     * food, will throw an exception.
     * @param amount - the amount of food to remove, which must be positive.
     */
    public void takeFood(int amount)
    {
        if (amount < 1)
            throw new RuntimeException("You just tried to remove a non-positive amount of food from the basket at ("+
                    myRow+", "+myCol+").");
        if (amount > myFoodLevel)
            throw new RuntimeException("You just tried to take more food from the basket at ("+myRow+", "+myCol+
                    ") than it had. Food available is: "+myFoodLevel+" and requested was "+amount+".");
        myFoodLevel -= amount;
    }

    /**
     * resets this basket's position to a random location in the grid, WHICH MAY NOT BE EMPTY.
     */
    public void pickRandomLocation()
    {
        myRow = (int)(World.NUM_ROWS_IN_WORLD*Math.random());
        myCol = (int)(World.NUM_COLS_IN_WORLD*Math.random());
    }

    /**
     * refills this basket with a random amount of food.
     */
    public void pickStartingFoodLevel()
    {
        myFoodLevel = MIN_STARTING_FOOD_LEVEL + (int)((MAX_FOOD_LEVEL-MIN_STARTING_FOOD_LEVEL+1)*Math.random());
    }

    /**
     * drawst this basket in the cell
     * @param g - the "Graphics" object that has the drawing tools and the canvas in which to draw.
     */
    public void drawSelf(Graphics g)
    {
        int centerX = Cell.LEFT_MARGIN + Cell.CELL_SIZE*myCol + Cell.CELL_SIZE/2;
        int centerY = Cell.TOP_MARGIN + Cell.CELL_SIZE*myRow + Cell.CELL_SIZE/2;

        g.setColor(BROWN);

        // set up the quadrilateral that represents the body of the basket.
        int[] xPoints = {centerX-4*Cell.CELL_SIZE/10, centerX+4*Cell.CELL_SIZE/10, centerX+Cell.CELL_SIZE/5, centerX-Cell.CELL_SIZE/5};
        int[] yPoints = {centerY-Cell.CELL_SIZE/5, centerY-Cell.CELL_SIZE/5, centerY+4*Cell.CELL_SIZE/10, centerY+4*Cell.CELL_SIZE/10};
        // draw the quadrilateral
        g.fillPolygon(xPoints, yPoints, 4);
        // draw the handle
        g.fillRect(centerX-Cell.CELL_SIZE/10, centerY-4*Cell.CELL_SIZE/10, Cell.CELL_SIZE/5, Cell.CELL_SIZE/2);

        // draw the amount of remaining food.
        String amount = ""+myFoodLevel;
        g.setFont(FOOD_FONT);
        int stringWidth = g.getFontMetrics().stringWidth(amount);
        // we're drawing the number in black on a shifted white "shadow."
        g.setColor(Color.WHITE);
        g.drawString(amount, centerX-stringWidth/2+1, centerY+Cell.CELL_SIZE/5+1);
        g.setColor(Color.BLACK);
        g.drawString(amount, centerX-stringWidth/2, centerY+Cell.CELL_SIZE/5);
    }

    public String toString()
    {
        return "Basket at ("+myRow+", "+myCol+") with "+myFoodLevel+" remaining.";
    }
}
