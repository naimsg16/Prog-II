import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;

public class Rect extends GraphicsProgram {
    public double TIMEOUT = 20.0;
    public double FIGURE_WIDTH = 150.0;
    public double FIGURE_HEIGHT = 100.0;
    public double SPEED = 5.0;

    public void run (){
        double x = (getWidth() - FIGURE_WIDTH) / 2.0;
        double y = (getHeight() - FIGURE_HEIGHT) / 2.0;
        GRect rect = new GRect (x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
        addRect(rect);
        squareMovement(rect);
    }
    public void addRect (GRect rect){
        rect.setFilled(true);
        rect.setColor(Color.RED);
        add(rect);
    }
    public void squareMovement(GRect rect){
        double movement = SPEED;
        waitForClick();
        while (true) {
            rect.move(movement, 0.0);
            if (rect.getX() >= (getWidth() - rect.getWidth())){
                movement = -SPEED;
            } else if (rect.getX() <= 0.0) {
                movement = SPEED;
            }
            pause(TIMEOUT);
        }
    }

}