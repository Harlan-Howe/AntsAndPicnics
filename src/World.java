import java.awt.*;

public class World
{
    public static final int NUM_ROWS_IN_WORLD = 40;
    public static final int NUM_COLS_IN_WORLD = 40;

    private Cell[][] grid;

    public World()
    {
        grid = new Cell[NUM_ROWS_IN_WORLD][NUM_COLS_IN_WORLD];
        for (int r =0; r < NUM_ROWS_IN_WORLD; r++)
            for (int c = 0; c<NUM_COLS_IN_WORLD; c++)
                grid[r][c] = new Cell(r,c);

        // the rest of this method is temporary... to test that the nests, baskets and scents are showing (and fading)
        // TODO: delete the rest of this method and replace it with your own intialization code.
        Nest tempNest = new Nest(2, 2, 0);
        grid[2][2].setNest(tempNest);

        Basket tempBasket = new Basket();
        grid[tempBasket.getRow()][tempBasket.getCol()].setBasket(tempBasket);
        System.out.println(tempBasket.getRow()+","+tempBasket.getCol());

        grid[20][20].markCellWithScent(2);

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

}
