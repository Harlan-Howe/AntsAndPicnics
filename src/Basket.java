public class Basket
{
    private static final int MAX_FOOD_LEVEL = 100;
    private static final int MIN_STARTING_FOOD_LEVEL = 50;

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
}
