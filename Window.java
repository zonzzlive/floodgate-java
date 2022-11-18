import javax.swing.JFrame;

public class Window extends JFrame{
    
    public Window (int width, int height){

        setTitle("Simulation d'une ecluse");                               //nom de ma fenêtre
        setSize(width, height);                                                  //taille de ma fenêtre
        setVisible(true);                                                     //la fenêtre est visible

        River[] riverArray;
        riverArray = new River[3];

        riverArray[0] = new River(1, height, width);
        riverArray[1] = new River(2, height, width);
        riverArray[2] = new River(3, height, width);
    
        TrafficLight[] trafficLights;
        trafficLights = new TrafficLight[2];

        trafficLights[0] = new TrafficLight(0, height, width);
        trafficLights[1] = new TrafficLight(1, height, width);

        Valve[] valves;
        valves = new Valve[2];

        valves[0] = new Valve(0, height, width);
        valves[1] = new Valve(1, height, width);

        Boat boat = new Boat(-1, height, width);

        Door door1 = new Door(0, height, width);
        Door door2 = new Door(1, height, width);

        PaintC paintC = new PaintC(width, height, riverArray, trafficLights, valves, boat, door1, door2);
        new Thread(paintC).start();
        add(paintC);
    }
}
