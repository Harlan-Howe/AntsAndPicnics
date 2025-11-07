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

    public static final int MAX_SCENT = 50;

    private int contentType;
    private int myRow, myCol;
    private Nest myNest = null; // may be null, in which case there isn't a nest here.
    private Basket myBasket = null; // may be null, in which case there isn't a basket here.
    private Ant myAnt = null; // may be null, in which case there isn't an ant here.

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

    /**
     * gets the nest stored in this cell. If there isn't one, throws an exception, so you should have checked getContentType() first.
     * @return the nest object stored in this cell.
     */
    public Nest getNest()
    {
        if (contentType != TYPE_NEST)
            throw new RuntimeException("You tried to get a nest at (" + myRow + ", " + myCol + ") but there isn't one there.");
        else
            return myNest;
    }

    /**
     * attempts to put a nest (or null) into this cell. If adding a nest, this cell must be empty and the nest's row,
     * col must match this cell. If setting to null, this cell must have a nest to remove.
     * @param n - the nest to add, or null.
     */
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
        {
            if (contentType != TYPE_NEST)
                throw new RuntimeException("You attemtped to clear a nest from (" + myRow + ", " + myCol +
                        ") but there wasn't one there.");
            contentType = TYPE_EMPTY;
        }

        myNest = n;
    }

    /**
     * gets the basket stored in this cell. If there isn't one, throws an exception, so you should have checked getContentType() first.
     * @return the basket stored in this cell.
     */
    public Basket getBasket()
    {
        if (contentType != TYPE_BASKET)
            throw new RuntimeException("You tried to get a basket at (" + myRow + ", " + myCol + ") but there isn't one there.");
        else
            return myBasket;
    }

    /**
     * attempts to put a basket (or null) into this cell. If adding a basket, this cell must be empty and the basket's row,
     * col must match this cell. If setting to null, this cell must have a basket to remove.
     * @param b - the basket to add, or null.
     */
    public void setBasket(Basket b)
    {
        if (b != null)
        {
            if (contentType != TYPE_EMPTY)
                throw new RuntimeException("You tried to put a basket into a cell at (" + myRow + ", " + myCol + ") but it wasn't empty.");
            if (myRow != b.getRow() || myCol != b.getCol())
                throw new RuntimeException("Call at ("+myRow+", "+myCol+") should not get basket that thinks it is at ("+
                        b.getRow()+", "+b.getCol()+").");
            contentType = TYPE_BASKET;
        }
        else
        {
            if (contentType != TYPE_BASKET)
                System.out.println("Warning: you are attempting to clear the basket from a Cell that does not have one. (" + myRow + "," + myCol + ").");
            contentType = TYPE_EMPTY;
        }
        myBasket = b;
    }

    /**
     * a convenience method, properly removes the basket from this cell, if there is one. Throws an exception if there isn't!
     */
    public void clearBasket()
    {
        setBasket(null);
    }
    /**
     * gets the ant stored in this cell. If there isn't one, throws an exception, so you should have checked getContentType() first.
     * @return the ant stored in this cell.
     */
    public Ant getAnt()
    {
        if (contentType != TYPE_ANT)
            throw new RuntimeException("You tried to get an ant at (" + myRow + ", " + myCol + ") but there isn't one there.");
        else
            return myAnt;

    }
    /**
     * attempts to put an ant (or null) into this cell. If adding a ant, this cell must be empty and the ant's row,
     * col must match this cell. If setting to null, this cell must have an ant to remove.
     * @param a - the ant to add, or null.
     */
    public void setAnt(Ant a)
    {
        {
            if (a != null)
            {
                if (contentType != TYPE_EMPTY)
                    throw new RuntimeException("You tried to put a ant into a cell at (" + myRow + ", " + myCol + ") but it wasn't empty.");
                if (myRow != a.getRow() || myCol != a.getCol())
                    throw new RuntimeException("Call at ("+myRow+", "+myCol+") should not get ant that thinks it is at ("+
                            a.getRow()+", "+a.getCol()+").");
                contentType = TYPE_BASKET;
            }
            else
            {
                if (contentType != TYPE_ANT)
                    System.out.println("Warning: you are attempting to clear the ant from a Cell that does not have one. (" + myRow + "," + myCol + ").");
                contentType = TYPE_EMPTY;
            }
            myAnt = a;
        }
    }

    /**
     *  a convenience method for removing an ant from a cell. Throws an exception if there isn't an ant there.
     */
    public void clearAnt()
    {
        setAnt(null);
    }

    /**
     * sets the red, green or blue channel of scent to full strength.
     * @param whichColor - 0 = red, 1 = green, 2 = blue
     */
    public void markCellWithScent(int whichColor)
    {
        myScents[whichColor] = MAX_SCENT;
    }

    /**
     * decreases all three scents in this cell by one, if they are positive.
     */
    public void fadeScents()
    {
        for (int i=0; i<3; i++)
        {
            myScents[i] = Math.max(0, myScents[i] -1);
        }
    }

    /**
     * returns the scent level for this cell for the color requested.
     * @param whichColor - 0 = red; 1 = green; 2 = blue
     * @return - the level of the corresponding scent on this cell.
     */
    public int getScentForColor(int whichColor)
    {
        return myScents[whichColor];
    }

    /**
     * draws this cell, its scent profile, and any contents it has.
     * @param g - the "Graphics' object that has the drawing tools and the canvas in which to draw.
     */
    public void drawSelf(Graphics g)
    {
        g.setColor(new Color(255-3*(MAX_SCENT-myScents[0]),
                             255-3*(MAX_SCENT-myScents[1]),
                             255-3*(MAX_SCENT-myScents[2])));
        g.fillRect(LEFT_MARGIN+myCol*CELL_SIZE, TOP_MARGIN+myRow*CELL_SIZE, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.darkGray);
        g.drawRect(LEFT_MARGIN+myCol*CELL_SIZE, TOP_MARGIN+myRow*CELL_SIZE, CELL_SIZE, CELL_SIZE);

        if (contentType == TYPE_NEST)
            myNest.drawSelf(g);

        if (contentType == TYPE_BASKET)
            myBasket.drawSelf(g);

        if (contentType == TYPE_ANT)
            myAnt.drawSelf(g);
    }
}