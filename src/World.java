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

    /**
     * copies the 3x3 grid of cells in the immediate surroundings of this ant, so that the cell at (row, col) in the
     * main grid will become item (1, 1) in this mini subgrid. If (row, col) is on an edge or corner of grid, any spaces
     * that correspond to "out of bounds" locations should be left as null.
     * For example, if grid is a 4 x 5 array:
     *   01234
     *  +-----
     * 0|ABCDE
     * 1|FGHIJ
     * 2|KLMNO
     * 3|PQRST
     *
     * then getNeighborhood(1,2) would return:
     *    012
     *   +---
     *  0|BCD
     *  1|GHI
     *  2|LMN
     *  and getNeighborhood(2, 0) would return:
     *    012
     *   +---
     *  0|.FG
     *  1|.KL
     *  2|.PQ
     *  ... where the "." values represent null.
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

}
