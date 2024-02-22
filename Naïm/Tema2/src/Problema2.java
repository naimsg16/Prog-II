import acm.program.GraphicsProgram;
import acm.graphics.GOval;
import java.awt.Color;
import acm.util.RandomGenerator;

//NOTA: FES-HO AMB UNA ARRAY D'OBJECTES!!!
public class Problema2 extends GraphicsProgram {

    double SIZE = 50.0;
    double NUM_TURTLES = 3.0;
    double TIMEOUT = 20.0;

    public void run() {
        double y = getHeight() / NUM_TURTLES;
        GOval turtle1 = new GOval(0.0,y/2.0,SIZE,SIZE);
        GOval turtle2 = new GOval(0.0,y + y/2.0,SIZE,SIZE);
        GOval turtle3 = new GOval(0.0,2*y + y/2.0,SIZE,SIZE);
        setTurtle(turtle1);
        setTurtle(turtle2);
        setTurtle(turtle3);
        startRace(turtle1,turtle2,turtle3);

    }

    public void setTurtle(GOval turtle){
        turtle.setFilled(true);
        turtle.setColor(Color.GREEN);
        turtle.setFillColor(Color.GREEN);
        add(turtle);

    }

    public void startRace(GOval turtle1, GOval turtle2, GOval turtle3){

        while(!touchingEdge(turtle1,turtle2,turtle3)){
            moveTurtles(turtle1,turtle2,turtle3);
        }


    }
    public void moveTurtles(GOval turtle1, GOval turtle2, GOval turtle3){
        turtle1.move(rollDie(),0.0);
        turtle2.move(rollDie(),0.0);
        turtle3.move(rollDie(),0.0);
        pause(TIMEOUT);
    }
    public int winnerTurtle(GOval turtle1, GOval turtle2, GOval turtle3){

        if(getWidth() < turtle1.getX() + SIZE){
            turtle1.setColor(Color.RED);
            turtle1.setFillColor(Color.RED);
            return 1;
        }
        if(getWidth() < turtle2.getX() + SIZE){
            turtle2.setColor(Color.RED);
            turtle2.setFillColor(Color.RED);
            return 2;
        }
        if(getWidth() < turtle3.getX() + SIZE ){
            turtle3.setColor(Color.RED);
            turtle3.setFillColor(Color.RED);
            return 3;
        }

        return 0;
    }

    public boolean touchingEdge(GOval turtle1, GOval turtle2, GOval turtle3){
        return winnerTurtle(turtle1, turtle2, turtle3) != 0;
    }

    public int rollDie(){
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1,6);
    }











}
