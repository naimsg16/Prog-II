import acm.program.GraphicsProgram;
import acm.graphics.GOval;
import java.awt.Color;
import acm.util.RandomGenerator;

public class Problema2 extends GraphicsProgram {

    int NUM_TURTLES = 3;
    double SIZE = 100.0 / ((double) NUM_TURTLES - 1);
    double TIMEOUT = 20.0;

    public void run() {
        GOval[] turtles = new GOval[NUM_TURTLES];
        setTurtles(turtles);
        startRace(turtles);
    }

    public void setTurtles(GOval[] turtles){
        double y = getHeight() / (double)NUM_TURTLES;
        for(int i = 0; i < NUM_TURTLES; i++) {
            turtles[i] = new GOval(0.0, i * y + y / 2.0, SIZE, SIZE);
            turtles[i].setFilled(true);
            turtles[i].setColor(Color.GREEN);
            turtles[i].setFillColor(Color.GREEN);
            add(turtles[i]);
        }
    }

    public void startRace(GOval[] turtles){
        while(!touchingEdge(turtles)){
            moveTurtles(turtles);
        }
    }
    public void moveTurtles(GOval[] turtles){
        for(int i = 0; i < NUM_TURTLES; i++){
            turtles[i].move(rollDie(),0.0);
        }
        pause(TIMEOUT);
    }

    public boolean touchingEdge(GOval[] turtles){
        boolean finish = false;

        for(int i = 0; i < NUM_TURTLES && !finish; i++){
            if(getWidth() < turtles[i].getX() + SIZE){
                finish = true;
                turtles[i].setColor(Color.RED);
                turtles[i].setFillColor(Color.RED);
            }
        }
        return finish;
    }
    public int rollDie(){
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1,6);
    }
}
