import java.awt.*;

public class Basket
{
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

    public int getFoodLevel()
    {
        return myFoodLevel;
    }

    public int getRow() { return myRow;}
    public int getCol() { return myCol;}

    public void takeFood(int amount)
    {
        if (amount > myFoodLevel)
            throw new RuntimeException("You just tried to take more food from the basket at ("+myRow+", "+myCol+
                    ") than it had. Food available is: "+myFoodLevel+" and requested was "+amount+".");
        myFoodLevel -= amount;
    }

    public void pickRandomLocation()
    {
        myRow = (int)(World.NUM_ROWS_IN_WORLD*Math.random());
        myCol = (int)(World.NUM_COLS_IN_WORLD*Math.random());
    }

    public void pickStartingFoodLevel()
    {
        myFoodLevel = MIN_STARTING_FOOD_LEVEL + (int)((MAX_FOOD_LEVEL-MIN_STARTING_FOOD_LEVEL+1)*Math.random());
    }

    public void drawSelf(Graphics g)
    {
        int centerX = Cell.LEFT_MARGIN + Cell.CELL_SIZE*myCol + Cell.CELL_SIZE/2;
        int centerY = Cell.TOP_MARGIN + Cell.CELL_SIZE*myRow + Cell.CELL_SIZE/2;

        g.setColor(BROWN);

        int[] xPoints = {centerX-4*Cell.CELL_SIZE/10, centerX+4*Cell.CELL_SIZE/10, centerX+Cell.CELL_SIZE/5, centerX-Cell.CELL_SIZE/5};
        int[] yPoints = {centerY-Cell.CELL_SIZE/5, centerY-Cell.CELL_SIZE/5, centerY+4*Cell.CELL_SIZE/10, centerY+4*Cell.CELL_SIZE/10};

        g.fillPolygon(xPoints, yPoints, 4);

        g.fillRect(centerX-Cell.CELL_SIZE/10, centerY-4*Cell.CELL_SIZE/10, Cell.CELL_SIZE/5, Cell.CELL_SIZE/2);

        String amount = ""+myFoodLevel;
        g.setFont(FOOD_FONT);
        int stringWidth = g.getFontMetrics().stringWidth(amount);
        g.setColor(Color.WHITE);
        g.drawString(amount, centerX-stringWidth/2+1, centerY+Cell.CELL_SIZE/5+1);
        g.setColor(Color.BLACK);
        g.drawString(amount, centerX-stringWidth/2, centerY+Cell.CELL_SIZE/5);
    }
}
