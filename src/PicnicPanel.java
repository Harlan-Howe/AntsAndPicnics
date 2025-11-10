import javax.swing.*;
import java.awt.*;

public class PicnicPanel extends JPanel implements Runnable
{
    // CONSTANTS
    public static final Color[] NEST_AND_ANT_COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private static final int DELAY = 1000; // milliseconds between animations steps, so 500 -> 1/2 second. Must be ≥ 1.

    // MEMBER VARIABLES
    private World myWorld;
    private int stepCount;

    // stuff for animation... probably more than we need; I borrowed code from another project that could start/stop.
    private volatile boolean running;
    private Thread animationThread;

    public PicnicPanel(World w)
    {
        super();
        myWorld = w;
        stepCount = 0;
        setBackground(Color.lightGray);
    }

    /**
     * This is the method called periodically to repaint the contents of the panel, (which in this case comprises the
     * total working area of the window.
     * @param g the <code>Graphics</code> object used to draw this content, both the tools and where to draw them.
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        myWorld.drawSelf(g);
        g.setColor(NEST_AND_ANT_COLORS[((stepCount)/100+2)%3]);
        g.fillRect(0,0,getWidth(),Cell.TOP_MARGIN);

        g.setColor(NEST_AND_ANT_COLORS[(stepCount/100)%3]);
        g.fillRect(0,0,(stepCount%100+1)*getWidth()/100, Cell.TOP_MARGIN);
    }

    /**
     * begin the multithreaded execution of the animation loop.
     */
    public void startAnimation() {
        if (animationThread == null || !running) {
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    /**
     * stop the current execution of the animation loop.
     * (We might not use this in this program.)
     */
    public void stopAnimation() {
        running = false;
        if (animationThread != null) {
            try {
                animationThread.join(); // this stops the thread and brings its execution back to this one.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
    /**
     * the code that is executed when we start the thread; in this case, it calls the updateAnimation() method over and
     * over again and tells the screen to refresh when it can, with a delay between executions.
     */
    @Override
    public void run()
    {
        requestFocusInWindow();
        while (running)
        {
            // Update animation state
            updateAnimation();

            // Request a repaint - when the computer next gets around to it (probably while this thread is sleeping,
            //   which it's about to).
            repaint();

            // Sleep for the specified delay
            try
            {
                Thread.sleep(DELAY);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * the step of the animation that happens every DELAY ms. This will be where the ants move
     * around and we check on things like making the scents fade or checking whether the baskets need to move.
     */
    private void updateAnimation()
    {
//        System.out.println("Animating.");
        myWorld.fadeAllScents();
        myWorld.moveAllAnts();
        myWorld.updateBaskets();
        stepCount++;
    }
}
