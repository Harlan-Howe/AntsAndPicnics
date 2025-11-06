public class Cell
{
    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_NEST = 1;
    public static final int TYPE_BASKET = 2;
    public static final int TYPE_ANT = 3;

    private int contentType;
    private int myRow, myCol;
    private Nest myNest = null; // may be null, in which case there isn't a nest here.
    private Basket myBasket = null; // may be null, in which case there isn't a basket here.

    private int[] myScents = {0, 0, 0};

    public Cell(int row, int col)
    {
        myRow = row;
        myCol = col;
        contentType = 0;
    }


    public int getContentType()
    {
        return contentType;
    }

    public Nest getNest()
    {
        if (contentType != TYPE_NEST)
            throw new RuntimeException("You tried to get a nest at ("+myRow+", "+myCol+") but there isn't one there.");
        else
            return myNest;
    }

    public Basket getBasket()
    {
        if (contentType != TYPE_BASKET)
            throw new RuntimeException("You tried to get a basket at ("+myRow+", "+myCol+") but there isn't one there.");
        else
            return myBasket;
    }

}
