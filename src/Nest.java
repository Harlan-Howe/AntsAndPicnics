public class Nest
{
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
}
