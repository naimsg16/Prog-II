import acm.program.GraphicsProgram;
import acm.graphics.GOval;
import java.awt.Color;
import acm.util.RandomGenerator;

public class Turtle_Race extends GraphicsProgram {
    public int NUM_TURTLES = 5;
    public double PADDING = 0.5;
    public double TIMEOUT = 20.0;


    public void run(){
        GOval[] turtlesList = new GOval[NUM_TURTLES];
        addTurtles(turtlesList);
        startRace(turtlesList);


    }
    public int rollDie() {

        RandomGenerator rgen = RandomGenerator.getInstance();

        return rgen.nextInt(1, 6);

    }
    public void addTurtles(GOval[] turtleList){
        double TRACK = (getHeight() / (double) NUM_TURTLES);
        double y =(TRACK * (PADDING/2));
        double turtleHeight = TRACK * (1.0 - PADDING );
        double turtleWidth = TRACK / 2;
        for (int i=0; i<NUM_TURTLES; i++){
                turtleList[i] = new GOval(0.0, y, turtleWidth, turtleHeight);
                turtleList[i].setColor(Color.ORANGE);
                turtleList[i].setFilled(true);
                turtleList[i].setFillColor(Color.GREEN);
                add(turtleList[i]);
                y += TRACK;
        }
    }
    public void startRace (GOval[] turtleList){
        waitForClick();

        while (!end(turtleList)){
            moveTurtles(turtleList);
            pause(TIMEOUT);
        }
    }
    public boolean end(GOval[] turtleList){
        for (int i=0; i < NUM_TURTLES; i++){
            if (turtleList[i].getX() + turtleList[i].getWidth() >= getWidth() ){
                turtleList[i].setFillColor(Color.RED);
                return true;
            }
        }
        return false;
    }
    public void moveTurtles(GOval[] turtleList){
        for (int i=0; i < NUM_TURTLES; i++){
            turtleList[i].move(rollDie(),0.0);
        }
    }
    public static void main(String[] args) {
        new Turtle_Race().start(args);
    }

}
