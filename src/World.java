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

    }
}
