import javax.swing.*;
import java.awt.*;

public class PicnicPanel extends JPanel implements Runnable
{

    public static final Color[] NEST_AND_ANT_COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private static final int DELAY = 200;

    private World myWorld;

    private volatile boolean running;
    private Thread animationThread;

    public PicnicPanel(World w)
    {
        super();
        myWorld = w;
        setBackground(Color.lightGray);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        myWorld.drawSelf(g);
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

            // Request a repaint
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
     * the step of the animation that happens every DELAY ms. Attempts to move the snake's head by one,
     * potentially eating an apple or crashing the snake in the process.
     */
    private void updateAnimation()
    {
        // TODO: This is the primary method you will be working in.
        System.out.println("Animating.");
    }
}
