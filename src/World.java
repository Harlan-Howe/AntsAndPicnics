import java.awt.*;

public class World
{
    public static final int NUM_ROWS_IN_WORLD = 40;
    public static final int NUM_COLS_IN_WORLD = 40;

    private Cell[][] grid;
    private Basket[] basket_list;
    private Nest[] nest_list;
    private Ant[] ant_list;


    public World()
    {
        grid = new Cell[NUM_ROWS_IN_WORLD][NUM_COLS_IN_WORLD];
        for (int r =0; r < NUM_ROWS_IN_WORLD; r++)
            for (int c = 0; c<NUM_COLS_IN_WORLD; c++)
                grid[r][c] = new Cell(r,c);

        basket_list = new Basket[6];
        nest_list = new Nest[3];
        ant_list = new Ant[3];

        placeNests();
        placeBaskets();
        placeAnts();
    }

    /**
     * tells all the cells to draw themselves.
     * @param g - the "Graphics" object that has the drawing tools and the canvas for them to draw on.
     */
    public void drawSelf(Graphics g)
    {
        for (int r =0; r < NUM_ROWS_IN_WORLD; r++)
            for (int c = 0; c<NUM_COLS_IN_WORLD; c++)
                grid[r][c].drawSelf(g);
    }

    /**
     * decreases the scent for all cells.
     */
    public void fadeAllScents()
    {
        for (int r =0; r < NUM_ROWS_IN_WORLD; r++)
            for (int c = 0; c<NUM_COLS_IN_WORLD; c++)
                grid[r][c].fadeScents();
    }

    /**
     * put the 3 nests in random, empty locations.
     */
    public void placeNests()
    {
        for (int i = 0; i < 3; i++)
        {
            int r, c;
            do // do the contents of the {  } at least once.
            {
                r = (int)(Math.random()*NUM_ROWS_IN_WORLD);
                c = (int)(Math.random()*NUM_COLS_IN_WORLD);
            } while (grid[r][c].getContentType() != Cell.TYPE_EMPTY);
            nest_list[i] =new Nest(r, c, i);
            grid[r][c].setNest(nest_list[i]);
        }
    }

    /**
     * place all the baskets into random, empty locations.
     */
    public void placeBaskets()
    {
        for (int i = 0; i<basket_list.length; i++)
        {
            basket_list[i] = new Basket();
            while (grid[basket_list[i].getRow()][basket_list[i].getCol()].getContentType() != Cell.TYPE_EMPTY)
                basket_list[i].pickRandomLocation();
            grid[basket_list[i].getRow()][basket_list[i].getCol()].setBasket(basket_list[i]);
        }
    }

    /**
     * place all the ants into random, empty locations
     */
    public void placeAnts()
    {
        // TODO: use the previous two methods as a guide to create three ants, pick random locations for them and
        //       continue to do so until you find an empty cell. Then a) make sure the ant_list has that ant,
        //       b) set the ant for that cell to be the ant you just created, and c) tell the ant about its color and
        //       nest.

    }

    /**
     * copies the 3x3 grid of cells in the immediate surroundings of this ant, so that the cell at (row, col) in the
     * main grid will become item (1, 1) in this mini subgrid. If (row, col) is on an edge or corner of grid, any spaces
     * that correspond to "out of bounds" locations should be left as null.
     * For example, if grid is a 4 x 5 array (and we are representing Cells by letters):
     *   0 1 2 3 4
     *  +---------
     * 0|A B C D E
     * 1|F G H I J
     * 2|K L M N O
     * 3|P Q R S T
     *
     * then getNeighborhood(1,2) would return:
     *    0 1 2
     *   +-----
     *  0|B C D
     *  1|G H I
     *  2|L M N
     *  getNeighborhood(2, 0) would return:
     *    0 1 2
     *   +-----
     *  0|ø F G
     *  1|ø K L
     *  2|ø P Q
     *  ... where the "ø" values represent null.
     *
     *  ..and getNeighborhood(3,4) would return:
     *    0 1 2
     *   +-----
     *  0|N O ø
     *  1|S T ø
     *  2|ø ø ø
     *  ... where the "ø" values represent null.
     * @param row
     * @param col
     * @return a 3 x 3 array of cells (and/or nulls) that describe the environment around (row, col) in grid.
     */
    public Cell[][] getNeighborhood(int row, int col)
    {
        Cell[][] result = new Cell[3][3];
        // TODO: you write this!


        return result;
    }

    /**
     * search through all the baskets. If any of them is empty, refill it and place it in a new, random location.
     */
    public void updateBaskets()
    {
        for (Basket b: basket_list)
            if (b.isEmpty())
            {
                grid[b.getRow()][b.getCol()].clearBasket(); // remove the basket from its current cell.
                do // do contents of the { } at least once.
                {
                    b.pickRandomLocation();
                } while (grid[b.getRow()][b.getCol()].getContentType() != Cell.TYPE_EMPTY);
                grid[b.getRow()][b.getCol()].setBasket(b); // put basket into new cell.

                b.pickStartingFoodLevel(); // refill the basket.
            }
    }

    public void moveAllAnts()
    {

        for (Ant a: ant_list)
        {
            if (a == null) // safety check in case we haven't run placeAnts yet.
                continue;

            // find the area around this ant.
            Cell[][] neighborhood = getNeighborhood(a.getRow(), a.getCol());

            // ask the ant what it wants to do
            int[] response = a.pickMove(neighborhood);

            // move the ant, according to its wishes.
            // TODO: You write this. "response" is telling you how the ant wants to move (or not).
            //  Read the documentation for Ant.pickMove()! - you'll need to write that first.

            // Note: if the Ant wants to move, you will want to remove it from the cell at its current location and then
            //       put it into the cell at its new location. (This will also work if it hasn't moved.) Take a look at
            //       the updateBaskets() method above for something similar.
        }
    }

}
