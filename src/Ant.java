import java.awt.*;

public class Ant
{
    // TODO: you'll need to create variables for this class!

    public int getRow()
    {
        return -1; // TODO: fix this, once you have variables.
    }

    public int getCol()
    {
        return -1; // TODO: fix this, once you have variables.
    }

    public int getColor()
    {
        return -1; // TODO: fix this, once you have variables.
    }

    public void setNestLocation(int r, int c)
    {
        // TODO: you write this.
    }

    /**
     * given a (3 x 3) array of the cells in the immediate area of this ant, the ant should decide which location to go
     * to next. The ant's current location corresponds to neighborhood[1][1]. Any out-of-bounds locations (e.g., if the
     * ant is on an edge or corner) will show up as null values in neighborhood.
     * Note: in conducting your search of the neighborhood, you might find nests or baskets, and you may interact with
     * them, as needed. (e.g., asking for the nest color, or taking or delivering food.)
     * @param neighborhood a (3 x 3) array of cells, copied from the overall grid.
     * @return a pair of numbers, indicating what move the ant should take. See to-do, below.
     * // TODO - you should decide what these correspond to. You don't have to write code here, but you should update
     *           the return comment two lines up to reflect your choice.
     *           Four options I can think of are
     *             a) the new coordinates of the ant (e.g., if current loc is [18, 22] return [17, 23])
     *             b) the coordinates on the neighborhood grid you received (e.g., [0, 2])
     *             c) the relative amount to move (-1, 0, +1) in row and column (e.g., [-1, +1])
     *             d) change this method to return a single integer (instead of an array of 2 integers), corresponding
     *              to a direction heading (e.g., 7, meaning NE).
     *         You should make sure your decision corresponds to what happens in the animateStep() method in World,
     *         which is the one calling this method and receiving this response.
     *         Note: No wrong answer. These are ALL valid choices.
     */
    public int[] pickMove(Cell[][] neighborhood)
    {
        int[] nextPos = new int[2]; // this will be the destination (row, col) you are picking.
        // TODO: you write this.


        return nextPos;
    }

    /**
     * draws this ant in the current cell.
     * @param g - the "Graphics" object that has the drawing tools and the canvas in which to draw.
     */
    public void drawSelf(Graphics g)
    {
        int centerX = Cell.LEFT_MARGIN + Cell.CELL_SIZE*getCol() + Cell.CELL_SIZE/2;
        int centerY = Cell.TOP_MARGIN + Cell.CELL_SIZE*getRow() + Cell.CELL_SIZE/2;

        g.setColor(PicnicPanel.NEST_AND_ANT_COLORS[getColor()]);

        // draws the ant as a dot, for now.
        g.drawOval(centerX - 4*Cell.CELL_SIZE/10, centerY - 4*Cell.CELL_SIZE/10, 4*Cell.CELL_SIZE/5, 4*Cell.CELL_SIZE/5);
    }
}
