import java.awt.*;

public class Cell
{
    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_NEST = 1;
    public static final int TYPE_BASKET = 2;
    public static final int TYPE_ANT = 3;

    public static final int LEFT_MARGIN = 10;
    public static final int TOP_MARGIN = 10;
    public static final int CELL_SIZE = 20;

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
            throw new RuntimeException("You tried to get a nest at (" + myRow + ", " + myCol + ") but there isn't one there.");
        else
            return myNest;
    }

    public void setNest(Nest n)
    {


        if (n != null)
        {
            if (contentType != TYPE_EMPTY)
                throw new RuntimeException("You tried to put a nest into a cell at (" + myRow + ", " + myCol + ") but it wasn't empty.");
            if (myRow != n.getRow() || myCol != n.getCol())
                throw new RuntimeException("Call at ("+myRow+", "+myCol+") should not get nest that thinks it is at ("+
                        n.getRow()+", "+n.getCol()+").");
            contentType = TYPE_NEST;
        }
        else
            contentType = TYPE_EMPTY;

        myNest = n;

    }

    public Basket getBasket()
    {
        if (contentType != TYPE_BASKET)
            throw new RuntimeException("You tried to get a basket at (" + myRow + ", " + myCol + ") but there isn't one there.");
        else
            return myBasket;
    }

    public void drawSelf(Graphics g)
    {
        g.setColor(new Color(myScents[0], myScents[1], myScents[2]));
        g.fillRect(LEFT_MARGIN+myCol*CELL_SIZE, TOP_MARGIN+myRow*CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.darkGray);
        g.drawRect(LEFT_MARGIN+myCol*CELL_SIZE, TOP_MARGIN+myRow*CELL_SIZE, CELL_SIZE, CELL_SIZE);

        if (contentType == TYPE_NEST)
            myNest.drawSelf(g);
    }
}