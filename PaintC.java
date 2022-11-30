import java.awt.*;

public class PaintC extends Component implements Runnable{

    enum statusErreur {
        OKB1,                                           //
        OKB2,                                           //
        COLLISIOND1,                                    //
        COLLISIOND2,                                    //
        RIVERHEIGHTV1,                                  //
        RIVERHEIGHTV2,                                  //
    }

    String statusAuto = "MANUAL";

    int[] statusBtnManual;
    int[] speedElement;

    int[] statusBtnPanne;

    int maxHeight;
    int maxWidth;

    River[] riverArray;
    TrafficLight[] trafficLights;
    Valve[] valves;

    Boat boat;

    Door door1;
    Door door2;

    public PaintC(int maxWidth, int maxHeight, River[] riverArray, TrafficLight[] trafficLights, Valve[] valves, Boat boat, Door door1, Door door2){
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        
        this.riverArray = riverArray;
        this.trafficLights = trafficLights;
        this.valves = valves;

        this.boat = boat;
        this.door1 = door1;
        this.door2 = door2;

        statusBtnManual = new int[4];
        statusBtnManual[0] = 0;                                                                       //porte 1;  = 0, fermé; = 1, ouvert
        statusBtnManual[1] = 0;                                                                       //porte 2;  = 0, fermé; = 1, ouvert
        statusBtnManual[2] = 0;                                                                       //vanne 1;  = 0, fermé; = 1, ouvert
        statusBtnManual[3] = 0;                                                                       //vanne 2;  = 0, fermé; = 1, ouvert

        statusBtnPanne = new int[8];
        statusBtnPanne[0] = 1;                                                                        //moteur boat 1;  = 0, panne; = 1, pas de panne
        statusBtnPanne[1] = 1;                                                                        //moteur boat 2;  = 0, panne; = 1, pas de panne
        statusBtnPanne[2] = 1;                                                                        //capteur boat 1;  = 0, panne; = 1, pas de panne
        statusBtnPanne[3] = 1;                                                                        //capteur boat 2;  = 0, panne; = 1, pas de panne
        statusBtnPanne[4] = 1;                                                                        //moteur door 1;  = 0, panne; = 1, pas de panne
        statusBtnPanne[5] = 1;                                                                        //moteur door 2;  = 0, panne; = 1, pas de panne
        statusBtnPanne[6] = 1;                                                                        //moteur valve 1;  = 0, panne; = 1, pas de panne
        statusBtnPanne[7] = 1;                                                                        //moteur valve 2;  = 0, panne; = 1, pas de panne

        speedElement = new int[6];
    

        if(boat.pos == 1){
            boat.posY = riverArray[2].posY - 20;
        } else {
            boat.posY = riverArray[0].posY - 20;
        }

    }

//--------------------------------------------------------------------------------PAINT PART----------------------------------------------------------------------------------------------


    @Override
    public void paint(Graphics gc)                                                                                  //fonction en charge de "dessiner" la cible
    {
        //System.out.println("test paint");
        super.paint(gc);
        Graphics g2 = (Graphics) gc;

        g2.setColor(Color.lightGray);

        g2.fillRect(0, 0, maxWidth, maxHeight);

        g2.setColor(Color.blue);

        for(River river : riverArray){
            g2.fillRect(river.posX, river.posY, river.width, river.height);
        }

        g2.setColor(Color.red);
        g2.fillRect(boat.posX, boat.posY, boat.width, boat.height);

        g2.setColor(Color.GRAY);
        g2.fillRect(door1.posX, door1.posY, door1.width, door1.height);
        g2.fillRect(door2.posX, door2.posY, door2.width, door2.height);   

        for(TrafficLight trafficLight : trafficLights){
            changeTrafficLight(g2, trafficLight);
            g2.fillOval(trafficLight.posX, trafficLight.posY, trafficLight.width, trafficLight.height);
        }

        g2.setColor(Color.black);
        for (Valve valve : valves){
            g2.fillRect(valve.posX, valve.posY, valve.width, valve.height);
        }
     
    }

//--------------------------------------------------------------------------------RUN PART----------------------------------------------------------------------------------------------

    statusErreur status;

    @Override
    public void run(){
        int sleepTime;

        checkBoatStatus();

        while(true){
            try {
                if((collisionDetection() != -1)){                                                                               //si il y'a une collision
                    if(riverArray[checkRiverBoat()].posY != riverArray[checkRiverBoat() + (- boat.pos)].posY){                  //vérifie la height de la rivière sur laquelle se trouve le boat
                        checkValveStatus();
                        if(checkCloseDoor() != 0){                                                                              //les deux portes ne sont pas fermées
                            if(checkCloseDoor() == 1){  
                                status = statusErreur.COLLISIOND1;                                                              //la porte 1 est ouverte
                                moveDoorYR(door1, statusBtnPanne[4]);
                            } else if (checkCloseDoor() == 2){                                                                  //la porte 2 est ouverte
                                status = statusErreur.COLLISIOND2;
                                moveDoorYR(door2, statusBtnPanne[5]);
                            }
                        } else {                                                                                                //les deux portes sont fermées
                            moveRiver();
                        }    
                    } else {
                        if((collisionDetection() == 1) && !checkDoorHeight(door1)){                                             //si collision sur la porte 1
                            moveDoorYR(door1, -statusBtnPanne[4]);
                            status = statusErreur.COLLISIOND1;
                        } else if ((collisionDetection() == 2) && !checkDoorHeight(door2)){                                     //si collision sur la porte 2
                            moveDoorYR(door2, -statusBtnPanne[5]);
                            status = statusErreur.COLLISIOND2;
                        } else {
                            checkBoatStatus();
                        }
                    }
                } 

                if(floatBoat() && ((status == statusErreur.OKB1) || (status == statusErreur.OKB2))){                            //si le boat a une bonne posY et qu'il n'y a pas de problème
                    if(boat.pos == -1){
                        if(boat.posX <= maxWidth + 30){
                            boat.moveBoatX(statusBtnPanne[0]);
                        }
                    } else if (boat.pos == 1){
                        if(boat.posX > -50){
                            boat.moveBoatX(statusBtnPanne[1]);
                        }
                    }
                
                }
                sleepTime = sleepTime(status);
                Thread.sleep(sleepTime);                                                                                        //met en pause le thread
                repaint();
                checkBoatStatus();
            } catch (Exception e) {

            }
        }
    }

    public int sleepTime(statusErreur status){
        
        switch(status){
            case OKB1:
                return 101 - speedElement[0];

            case OKB2:
                return 101 - speedElement[1];

            case COLLISIOND1:
                return 101 - speedElement[2];

            case COLLISIOND2:
                return 101 - speedElement[3];

            case RIVERHEIGHTV1:
                return 101 - speedElement[4];
                
            case RIVERHEIGHTV2:
                return 101 - speedElement[5];
        }
        
        return 0;
    }

//--------------------------------------------------------------------------------BOAT PART----------------------------------------------------------------------------------------------

    public int checkRiverBoat(){
        int riverNbBoat = -1;
        if(boat.posX < maxWidth * 0.4){
            riverNbBoat = 0;
        } else if (boat.posX < (maxWidth * 0.6)){
            riverNbBoat = 1;
        } else if (boat.posX >= (maxWidth * 0.6)){
            riverNbBoat = 2;
        }
        return riverNbBoat;
    }

    public boolean floatBoat(){
        boolean floatB = true;
        floatB = checkYBoat(riverArray[checkRiverBoat()]);
        return floatB;
    }

    public boolean checkYBoat(River riverBoat){                                                                 //return true si le boat a les mêmes coodonnées Y que la river sur laquelle il se trouve      
        boolean goodYBoat = false;
        int aimPosBoatY = boat.posY + 20;   
        if(aimPosBoatY == riverBoat.posY){
            goodYBoat = true;
        } else {
            if(aimPosBoatY < riverBoat.posY){
                boat.moveBoatY(1, "Up");
                goodYBoat = false;
            } else if (aimPosBoatY > riverBoat.posY){
                boat.moveBoatY(1, "Down");
                goodYBoat = false;
            }
        }
        return goodYBoat;
    }

    public int collisionDetection(){                                                                        //return -1 si pas de collision, 1 si collision avec porte 1, 2 si collision avec porte 2
        int collisionNb = -1;

        int modifier;

        if (boat.pos == -1){
            modifier = 60;
            if(statusBtnPanne[2] == 0){
                modifier = 40;
            }
        } else{
            modifier = 20;
            if(statusBtnPanne[3] == 0){
                modifier = 0;
            }
        }

        int editedPosX = boat.posX - (boat.pos * modifier);

        if(editedPosX == maxWidth * 0.4){                                            //collision avec la porte 1
            collisionNb = 1;
        } else if (editedPosX == maxWidth * 0.6){                                    //collision avec la porte 2
            collisionNb = 2;
        }

        //System.out.println(boat.posX);

        if(collisionNb == 1){
            if(checkCloseDoor() != 1){
                if(boat.posX == 728){                                               //boat.pos == -1
                    boat.pos = 0;                                                           //boat.posX = maxWidth + 31;
                } else if(boat.posX == 768){                                        //boat.pos == 1
                    boat.pos = 0;                                                           //boat.posX = maxWidth + 31;
                }
            }
        } else if(collisionNb == 2){
            if(checkCloseDoor() != 2){
                if(boat.posX == 1112){                                              //boat.pos == -1
                    boat.pos = 0;                                                           //boat.posX = maxWidth + 31;
                } else if(boat.posX == 1152){                                       //boat.pos == 1
                    boat.pos = 0;                                                           //boat.posX = -81;
                }
            }
        }

        return collisionNb;
    }

    public void checkBoatStatus(){
        if(boat.pos == -1){
            status = statusErreur.OKB1;
        } else {
            status = statusErreur.OKB2;
        }
    }

//--------------------------------------------------------------------------------DOOR PART----------------------------------------------------------------------------------------------

    public boolean checkDoorHeight(Door door){                                                          //return false, si la porte est ouverte; return true si la porte est fermée
        if(door.posY != 25){
            return false;
        } else {
            return true;
        }
    }

    public int checkCloseDoor(){                                                                        //return 0, les portes sont fermées; return 1, la porte 1 est ouverte; return 2, la porte 2 est ouverte
        if(door1.posY != 200){
            if(door1.posY != 25){
                
            }
            return 1;
        } 
        if(door2.posY != 200){
            return 2;
        }
        return 0;
    }

    public void moveDoorYR (Door door, int speed){
        int checkStatus = statusBtnManual[door.pos] + speed;
        if(statusAuto == "AUTO"){
            door.moveDoorY(speed);
        } else {
            if((checkStatus == 0) || (checkStatus == 1)){
                door.moveDoorY(speed);
            } else {
                if(door.posY < 200 && door.posY > 25)
                door.moveDoorY(-speed);
            }
        }
    }



//--------------------------------------------------------------------------------TRAFFIC LIGHT PART----------------------------------------------------------------------------------------------

    public void changeTrafficLight(Graphics g2, TrafficLight trafficLight){
        if(trafficLight.pos == 0){
            if(checkDoorHeight(door1)){
                g2.setColor(Color.green);
            } else {
                g2.setColor(Color.red);
            }
        } else {
            if(checkDoorHeight(door2)){
                g2.setColor(Color.green);
            } else {
                g2.setColor(Color.red);
            }
        }
    }

//--------------------------------------------------------------------------------RIVER/VALVE PART----------------------------------------------------------------------------------------------

    public void moveRiver (){

        if(statusAuto == "AUTO"){
            if(checkRiverBoat() == 1){                                                                  //boat sur la rivière centrale
                riverArray[1].moveRiverY(moveRiverSpeed(0));
            } else if(checkRiverBoat() == 0){                                                           //boat sur la rivière de gauche
                riverArray[1].moveRiverY(moveRiverSpeed(3021));
            } else if(checkRiverBoat() == 2){                                                           //boat sur la rivière de droite
                riverArray[1].moveRiverY(moveRiverSpeed(3120));
            }
        } else {
            if(checkRiverBoat() == 1){
                checkBtnRiver(-1);
            } else {
                checkBtnRiver(1);
            }
        }
    }

    public void checkBtnRiver(int i){
        if(boat.pos == 1){
            if((statusBtnManual[3] == 1) && (statusBtnManual[2] == 0)){                          //valve 1 fermée, valve 2 ouverte
                riverArray[1].moveRiverY(i * moveRiverSpeed(3120));
            } else if((statusBtnManual[3] == 0) && (statusBtnManual[2] == 1)){                   //valve 1 ouverte, valve 2 fermée
                riverArray[1].moveRiverY(i * -moveRiverSpeed(3021));
            }
        } else if (boat.pos == -1){
            if((statusBtnManual[2] == 1) && (statusBtnManual[3] == 0)){                         //valve 1 ouverte, valve 2 fermée
                riverArray[1].moveRiverY(i * moveRiverSpeed(3021));
            } else if((statusBtnManual[2] == 0) && (statusBtnManual[3] == 1)){                  //valve 1 fermée, valve 2 ouverte
                riverArray[1].moveRiverY(i * -moveRiverSpeed(3120));
            }
        }
    }

    public int moveRiverSpeed(int valveCombinaison){
        if(checkRiverBoat() == -1){
            return -boat.pos;
        } else if(checkRiverBoat() == 0){
            return -valveIssueGestion(valveCombinaison);
        } else if (checkRiverBoat() == 2){
            return -valveIssueGestion(valveCombinaison);
        } else if(checkRiverBoat() == 1){
            if(valveCombinaison != 0){
                return valveIssueGestion(valveCombinaison);
            } else{
                if(collisionDetection() == 1){
                    return valveIssueGestion(3021);
                } else if (collisionDetection() == 2){
                    return valveIssueGestion(3120);
                }
            }
        }
        return 0;
    }

    public int valveIssueGestion(int valveCombinaison){
        if(collisionDetection() == 1){
            if(valveCombinaison == 3021){
                return -boat.pos * statusBtnPanne[6];
            } else if (valveCombinaison == 3120){
                return -boat.pos * statusBtnPanne[7];
            }
        } else if (collisionDetection() == 2){
            if(valveCombinaison == 3021){
                return -boat.pos * statusBtnPanne[6];
            } else if (valveCombinaison == 3120){
                return -boat.pos * statusBtnPanne[7];
            }
        }
        return 0;
    }

    public void checkValveStatus(){
        if(collisionDetection() == 1){
            status = statusErreur.RIVERHEIGHTV1;
        } else if(collisionDetection() == 2){
            status = statusErreur.RIVERHEIGHTV2;
        }
    }

}