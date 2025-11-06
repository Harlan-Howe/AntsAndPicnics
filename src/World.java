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

        Nest tempNest = new Nest(2, 2, 0);
        grid[2][2].setNest(tempNest);

        Basket tempBasket = new Basket();
        grid[tempBasket.getRow()][tempBasket.getCol()].setBasket(tempBasket);
        System.out.println(tempBasket.getRow()+","+tempBasket.getCol());

        grid[20][20].markCellWithScent(2);

    }

    public void drawSelf(Graphics g)
    {
        for (int r =0; r < NUM_ROWS_IN_WORLD; r++)
            for (int c = 0; c<NUM_COLS_IN_WORLD; c++)
                grid[r][c].drawSelf(g);
    }

    public void fadeAllScents()
    {
        for (int r =0; r < NUM_ROWS_IN_WORLD; r++)
            for (int c = 0; c<NUM_COLS_IN_WORLD; c++)
                grid[r][c].fadeScents();
    }

}
