import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class NewRect extends GraphicsProgram {
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
        double movement = 1;
        waitForClick();
        while (true) {
            rect.move(movement, movement);
            if (rect.getX() >= (getWidth() - rect.getWidth()) || rect.getY() >= (getHeight() - rect.getHeight())){
                movement = -(SPEED);
            } else if (rect.getX() <= 0.0 || rect.getY() <= 0.0) {
                movement = SPEED;
            }
            pause(TIMEOUT);
            movement = - SPEED;
        }
    }
        public static void main(String[] args) {
            new NewRect().start(args);
        }

}