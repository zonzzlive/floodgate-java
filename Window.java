import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;


public class Window extends JFrame implements Runnable{

    int statusBtn;
    PaintC paintT;

    Valve[] valves;
    Door[] doors;

    JPanel panelDoorAmontStatus = new JPanel();
    JPanel panelDoorAvalStatus = new JPanel();
    JPanel panelValveAmontStatus = new JPanel();
    JPanel panelValveAvalStatus = new JPanel();

    JLabel labelStatusDoorAmont = new JLabel("Fermé", JLabel.LEFT);
    JLabel labelStatusDoorAval = new JLabel("Fermé", JLabel.LEFT);
    JLabel labelStatusValveAmont = new JLabel("Fermé", JLabel.LEFT);
    JLabel labelStatusValveAval = new JLabel("Fermé", JLabel.LEFT);

        //--------------------------MODE--------------------------------

        JLabel labelStatusMode = new JLabel("Manuel", JLabel.LEFT);

    //--------------------------GENERAL--------------------------------

    JPanel panelGeneralIssueStatus = new JPanel();
    JLabel labelGeneralIssue = new JLabel("Pas de panne générale", JLabel.LEFT);

    //-----------------------------SPINNER PART-----------------------------

    SpinnerModel spinnerBoatAmontM = new SpinnerNumberModel(100, 1, 100, 1);     
    JSpinner spinnerBoatAmont = new JSpinner(spinnerBoatAmontM);

    SpinnerModel spinnerBoatAvalM = new SpinnerNumberModel(100, 1, 100, 1);        
    JSpinner spinnerBoatAval = new JSpinner(spinnerBoatAvalM);

        
    SpinnerModel spinnerDoorAmontM = new SpinnerNumberModel(85, 1, 100, 1);  
    JSpinner spinnerDoorAmont = new JSpinner(spinnerDoorAmontM);      

    SpinnerModel spinnerDoorAvalM = new SpinnerNumberModel(85, 1, 100, 1);
    JSpinner spinnerDoorAval = new JSpinner(spinnerDoorAvalM);

        
    SpinnerModel spinnerValveAmontM = new SpinnerNumberModel(85, 1, 100, 1);  
    JSpinner spinnerValveAmont = new JSpinner(spinnerValveAmontM);
        
    SpinnerModel spinnerValveAvalM = new SpinnerNumberModel(85, 1, 100, 1);       
    JSpinner spinnerValveAval = new JSpinner(spinnerValveAvalM);

    public Window (int width, int height){

        //-----------------------------BIG JPANEL PART-----------------------------

        JPanel panelButton = new JPanel();
        panelButton.setBounds(0,0,50,30); 

        JPanel panelAmont = new JPanel();
        panelAmont.setBounds(width/2,height,width/2,height);
        panelAmont.setBackground(Color.gray);

        JPanel panelAuto = new JPanel();
        panelAuto.setBounds(width/2,height,width/2,height);
        panelAuto.setBackground(Color.gray);
        panelAuto.setLayout(new BoxLayout(panelAuto, BoxLayout.Y_AXIS));

        JPanel panelAval = new JPanel();
        panelAval.setBounds(width/2,height,width/2,height);
        panelAval.setBackground(Color.gray);

        //-----------------------------JPANEL PART-----------------------------

            //--------------------------BOAT--------------------------------

        JPanel panelBoatAmont = new JPanel();
        panelBoatAmont.setBounds(0,0,50,30); 
        panelBoatAmont.setLayout(new BoxLayout(panelBoatAmont, BoxLayout.Y_AXIS));

        JPanel panelBoatAval = new JPanel();
        panelBoatAval.setBounds(0,0,50,30); 
        panelBoatAval.setLayout(new BoxLayout(panelBoatAval, BoxLayout.Y_AXIS));

            //--------------------------DOOR--------------------------------

        JPanel panelDoorAmont = new JPanel();
        panelDoorAmont.setBounds(0,0,50,30); 
        panelDoorAmont.setLayout(new BoxLayout(panelDoorAmont, BoxLayout.Y_AXIS));

        JPanel panelDoorAval = new JPanel();
        panelDoorAval.setBounds(0,0,50,30); 
        panelDoorAval.setLayout(new BoxLayout(panelDoorAval, BoxLayout.Y_AXIS));

            //--------------------------VALVE--------------------------------

        JPanel panelValveAmont = new JPanel();
        panelValveAmont.setBounds(0,0,50,30);
        panelValveAmont.setLayout(new BoxLayout(panelValveAmont, BoxLayout.Y_AXIS)); 
        
        JPanel panelValveAval = new JPanel();
        panelValveAval.setBounds(0,0,50,30); 
        panelValveAval.setLayout(new BoxLayout(panelValveAval, BoxLayout.Y_AXIS));


        //-----------------------------JPANEL INDICATOR PART-----------------------------

            //--------------------------GENERAL--------------------------------

        panelGeneralIssueStatus.setBounds(0,0,50,30);
        panelGeneralIssueStatus.setBackground(Color.green);

            //--------------------------BOAT--------------------------------

        JPanel panelBoatAmontIssueStatus = new JPanel();
        panelBoatAmontIssueStatus.setBounds(0,0,50,30);
        panelBoatAmontIssueStatus.setBackground(Color.green);

        JPanel panelBoatAvalIssueStatus = new JPanel();
        panelBoatAvalIssueStatus.setBounds(0,0,50,30);
        panelBoatAvalIssueStatus.setBackground(Color.green);

        JPanel panelBoatAmontCaptorIssueStatus = new JPanel();
        panelBoatAmontCaptorIssueStatus.setBounds(0,0,50,30);
        panelBoatAmontCaptorIssueStatus.setBackground(Color.green);

        JPanel panelBoatAvalCaptorIssueStatus = new JPanel();
        panelBoatAvalCaptorIssueStatus.setBounds(0,0,50,30);
        panelBoatAvalCaptorIssueStatus.setBackground(Color.green);

            //--------------------------DOOR--------------------------------

        panelDoorAmontStatus.setBounds(0,0,50,30);
        panelDoorAmontStatus.setBackground(Color.red);

        panelDoorAvalStatus.setBounds(0,0,50,30);
        panelDoorAvalStatus.setBackground(Color.red);

        JPanel panelDoorAmontIssueStatus = new JPanel();
        panelDoorAmontIssueStatus.setBounds(0,0,50,30);
        panelDoorAmontIssueStatus.setBackground(Color.green);

        JPanel panelDoorAvalIssueStatus = new JPanel();
        panelDoorAvalIssueStatus.setBounds(0,0,50,30);
        panelDoorAvalIssueStatus.setBackground(Color.green);

            //--------------------------VALVE--------------------------------

        panelValveAmontStatus.setBounds(0,0,50,30);
        panelValveAmontStatus.setBackground(Color.red);

        panelValveAvalStatus.setBounds(0,0,50,30);
        panelValveAvalStatus.setBackground(Color.red);

        JPanel panelValveAmontIssueStatus = new JPanel();
        panelValveAmontIssueStatus.setBounds(0,0,50,30);
        panelValveAmontIssueStatus.setBackground(Color.green);

        JPanel panelValveAvalIssueStatus = new JPanel();
        panelValveAvalIssueStatus.setBounds(0,0,50,30);
        panelValveAvalIssueStatus.setBackground(Color.green);

            //--------------------------MODE--------------------------------

        JPanel panelModeStatus = new JPanel();
        panelModeStatus.setBounds(0,0,50,30);
        panelModeStatus.setBackground(Color.orange);


        //-----------------------------JBUTTON PART-----------------------------

        JButton btnAuto = new JButton("Automatique");
        btnAuto.setBounds(0,0,50,30);
        JButton btnSaveSpeed = new JButton("Sauvegarder vitesse");
        btnSaveSpeed.setBounds(0,0,50,30);

            //--------------------------BOAT--------------------------------

        JButton btnAmontBoat = new JButton("Ajout bateau");
        btnAmontBoat.setBounds(0,0,50,30);
        JButton btnAmontBoatIssue = new JButton("Activer panne moteur");
        btnAmontBoatIssue.setBounds(0,0,50,30);
        JButton btnAmontBoatCaptorIssue = new JButton("Activer panne capteur de collision");
        btnAmontBoatCaptorIssue.setBounds(0,0,50,30);

        JButton btnAvalBoat = new JButton("Ajout bateau");
        btnAvalBoat.setBounds(width,0,50,30);
        JButton btnAvalBoatIssue = new JButton("Activer panne moteur");
        btnAvalBoatIssue.setBounds(0,0,50,30);
        JButton btnAvalBoatCaptorIssue = new JButton("Activer panne capteur de collision");
        btnAvalBoatCaptorIssue.setBounds(0,0,50,30);

            //--------------------------DOOR--------------------------------    

        JButton btnAmontDoor = new JButton("Ouvrir la porte");
        btnAmontDoor.setBounds(0,0,50,30);
        JButton btnAmontDoorIssue = new JButton("Activer panne moteur");
        btnAmontDoorIssue.setBounds(0,0,50,30);

        JButton btnAvalDoor = new JButton("Ouvrir la porte");
        btnAvalDoor.setBounds(0,0,50,30);
        JButton btnAvalDoorIssue = new JButton("Activer panne moteur");
        btnAvalDoorIssue.setBounds(0,0,50,30);

            //--------------------------VALVE--------------------------------
        
        JButton btnAmontValve = new JButton("Ouvrir la vanne");
        btnAmontValve.setBounds(width,0,50,30);
        JButton btnAmontValveIssue = new JButton("Activer panne moteur");
        btnAmontDoorIssue.setBounds(0,0,50,30);

        JButton btnAvalValve = new JButton("Ouvrir la vanne");
        btnAvalValve.setBounds(width,0,50,30);
        JButton btnAvalValveIssue = new JButton("Activer panne moteur");
        btnAmontDoorIssue.setBounds(0,0,50,30);

        //-----------------------------LABEL PART-----------------------------

            //--------------------------BOAT--------------------------------

        JLabel labelIssueBoatAmont = new JLabel("Panne désactivée", JLabel.LEFT);
        JLabel labelIssueBoatAval = new JLabel("Panne désactivée", JLabel.LEFT);
        
        JLabel labelCaptorIssueBoatAmont = new JLabel("Panne désactivée", JLabel.LEFT);
        JLabel labelCaptorIssueBoatAval = new JLabel("Panne désactivée", JLabel.LEFT);

        JLabel labelSpeedBoatAmont = new JLabel("Vitesse du bateau :", JLabel.LEFT);
        JLabel labelSpeedBoatAval = new JLabel("Vitesse du bateau :", JLabel.LEFT);
        
            //--------------------------DOOR--------------------------------

        JLabel labelIssueDoorAmont = new JLabel("Panne désactivée", JLabel.LEFT);
        JLabel labelIssueDoorAval = new JLabel("Panne désactivée", JLabel.LEFT);

        JLabel labelSpeedDoorAmont = new JLabel("Vitesse de la porte :", JLabel.LEFT);
        JLabel labelSpeedDoorAval = new JLabel("Vitesse de la porte :", JLabel.LEFT);

            //--------------------------VALVE--------------------------------
        
        JLabel labelIssueValveAmont = new JLabel("Panne désactivée", JLabel.LEFT);
        JLabel labelIssueValveAval = new JLabel("Panne désactivée", JLabel.LEFT);

        JLabel labelSpeedValveAmont = new JLabel("Vitesse de la valve :", JLabel.LEFT);
        JLabel labelSpeedValveAval = new JLabel("Vitesse de la valve :", JLabel.LEFT);

        //-----------------------------FRAME PART-----------------------------
        
        setTitle("Simulation d'une ecluse");                               //nom de ma fenêtre
        setSize(width, height);                                                  //taille de ma fenêtre
        setVisible(true);                                                     //la fenêtre est visible
        setResizable(false);                                          //impossible de redimenssionner la fenêtre

        //-----------------------------VAR PART-----------------------------        

        River[] riverArray;
        riverArray = new River[3];

        riverArray[0] = new River(1, height, width);
        riverArray[1] = new River(2, height, width);
        riverArray[2] = new River(3, height, width);

        TrafficLight[] trafficLights;
        trafficLights = new TrafficLight[2];

        trafficLights[0] = new TrafficLight(0, height, width);
        trafficLights[1] = new TrafficLight(1, height, width);

        valves = new Valve[2];

        valves[0] = new Valve(0, height, width);
        valves[1] = new Valve(1, height, width);

        Boat boat = new Boat(-1, height, width);

        doors = new Door[2];

        Door door1 = new Door(0, height, width);
        Door door2 = new Door(1, height, width);
        doors[0] = door1;
        doors[1] = door2;

        PaintC paintC = new PaintC(width, height, riverArray, trafficLights, valves, boat, door1, door2);
        paintT = paintC;
        sendSpeed(paintC);

        getContentPane().add(paintC, "Center");
        getContentPane().add(panelButton, "South");

        //-----------------------------PANEL ADD PART-----------------------------

            //-----------------------------AMONT PART-----------------------------

            //--------------------------BOAT--------------------------------

        panelBoatAmontIssueStatus.add(labelIssueBoatAmont);
        panelBoatAmontCaptorIssueStatus.add(labelCaptorIssueBoatAmont);

        panelBoatAmont.add(panelBoatAmontCaptorIssueStatus);
        panelBoatAmont.add(btnAmontBoatCaptorIssue);
        panelBoatAmont.add(panelBoatAmontIssueStatus);
        panelBoatAmont.add(btnAmontBoatIssue);
        panelBoatAmont.add(labelSpeedBoatAmont);
        panelBoatAmont.add(spinnerBoatAmont);
        panelBoatAmont.add(btnAmontBoat);
        
            //--------------------------DOOR--------------------------------

        panelDoorAmontStatus.add(labelStatusDoorAmont);
        panelDoorAmontIssueStatus.add(labelIssueDoorAmont);
        
        panelDoorAmont.add(panelDoorAmontIssueStatus);
        panelDoorAmont.add(btnAmontDoorIssue);
        panelDoorAmont.add(panelDoorAmontStatus);
        panelDoorAmont.add(labelSpeedDoorAmont);
        panelDoorAmont.add(spinnerDoorAmont);
        panelDoorAmont.add(btnAmontDoor);
        
            //--------------------------VALVE--------------------------------

        panelValveAmontStatus.add(labelStatusValveAmont);
        panelValveAmontIssueStatus.add(labelIssueValveAmont);
        
        panelValveAmont.add(panelValveAmontIssueStatus);
        panelValveAmont.add(btnAmontValveIssue);
        panelValveAmont.add(panelValveAmontStatus);
        panelValveAmont.add(labelSpeedValveAmont);
        panelValveAmont.add(spinnerValveAmont);
        panelValveAmont.add(btnAmontValve);

        panelAmont.add(panelBoatAmont);
        panelAmont.add(panelDoorAmont);
        panelAmont.add(panelValveAmont);

            //-----------------------------AUTO PART-----------------------------

        panelModeStatus.add(labelStatusMode);
        panelGeneralIssueStatus.add(labelGeneralIssue);
        
        panelAuto.add(panelGeneralIssueStatus);
        panelAuto.add(panelModeStatus);
        panelAuto.add(btnSaveSpeed);
        panelAuto.add(btnAuto);

            //-----------------------------AVAL PART-----------------------------

            //--------------------------BOAT--------------------------------

        panelBoatAvalIssueStatus.add(labelIssueBoatAval);
        panelBoatAvalCaptorIssueStatus.add(labelCaptorIssueBoatAval);

        panelBoatAval.add(panelBoatAvalCaptorIssueStatus);
        panelBoatAval.add(btnAvalBoatCaptorIssue);
        panelBoatAval.add(panelBoatAvalIssueStatus);
        panelBoatAval.add(btnAvalBoatIssue);
        panelBoatAval.add(labelSpeedBoatAval);
        panelBoatAval.add(spinnerBoatAval);
        panelBoatAval.add(btnAvalBoat);

            //--------------------------DOOR--------------------------------

        panelDoorAvalStatus.add(labelStatusDoorAval);
        panelDoorAvalIssueStatus.add(labelIssueDoorAval);
        
        panelDoorAval.add(panelDoorAvalIssueStatus);
        panelDoorAval.add(btnAvalDoorIssue);
        panelDoorAval.add(panelDoorAvalStatus);
        panelDoorAval.add(labelSpeedDoorAval);
        panelDoorAval.add(spinnerDoorAval);
        panelDoorAval.add(btnAvalDoor);

            //--------------------------VALVE--------------------------------

        panelValveAvalStatus.add(labelStatusValveAval);
        panelValveAvalIssueStatus.add(labelIssueValveAval);
        
        panelValveAval.add(panelValveAvalIssueStatus);
        panelValveAval.add(btnAvalValveIssue);
        panelValveAval.add(panelValveAvalStatus);
        panelValveAval.add(labelSpeedValveAval);
        panelValveAval.add(spinnerValveAval);
        panelValveAval.add(btnAvalValve);

        panelAval.add(panelBoatAval);
        panelAval.add(panelDoorAval);
        panelAval.add(panelValveAval);

            //--------------------------ASSEMBLE--------------------------------

        panelButton.add(panelAmont);
        panelButton.add(panelAuto);
        panelButton.add(panelAval);
        
        //-----------------------------ACTION LISTENER PART-----------------------------

        btnAmontBoat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boat.respawnBoat(-1);
            }
        });

        btnAvalBoat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boat.respawnBoat(1);
            }
        });

        btnAuto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(paintC.statusAuto == "AUTO"){
                    btnAuto.setText("Automatique");
                    panelModeStatus.setBackground(Color.ORANGE);
                    labelStatusMode.setText("Manuel");
                    paintC.statusAuto = "MANUAL";
                } else {
                    btnAuto.setText("Manuel");
                    panelModeStatus.setBackground(Color.green);
                    labelStatusMode.setText("Automatique");
                    paintC.statusAuto = "AUTO";
                }
            }
        });

        btnSaveSpeed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sendSpeed(paintC);
            }
        });

        btnAmontDoor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAmontDoor, "door", panelDoorAmontStatus, labelStatusDoorAmont);
                paintC.statusBtnManual[0] = statusBtn;
            }
        });

        btnAvalDoor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAvalDoor, "door", panelDoorAvalStatus, labelStatusDoorAval);
                paintC.statusBtnManual[1] = statusBtn;
            }
        });

        btnAmontValve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAmontValve, "valve",panelValveAmontStatus, labelStatusValveAmont);
                paintC.statusBtnManual[2] = statusBtn;
            }
        });

        btnAvalValve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAvalValve, "valve", panelValveAvalStatus, labelStatusValveAval);
                paintC.statusBtnManual[3] = statusBtn;
            }
        });

        btnAmontBoatIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAmontBoatIssue, "Engine", panelBoatAmontIssueStatus, labelIssueBoatAmont);
                paintC.statusBtnPanne[0] = statusBtn;
            }
        });

        btnAvalBoatIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAvalBoatIssue, "Engine", panelBoatAvalIssueStatus, labelIssueBoatAval);
                paintC.statusBtnPanne[1] = statusBtn;
            }
        });

        btnAmontBoatCaptorIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAmontBoatCaptorIssue, "CollisionCaptor", panelBoatAmontCaptorIssueStatus, labelCaptorIssueBoatAmont);
                paintC.statusBtnPanne[2] = statusBtn;
            }
        });

        btnAvalBoatCaptorIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAvalBoatCaptorIssue, "CollisionCaptor", panelBoatAvalCaptorIssueStatus, labelCaptorIssueBoatAval);
                paintC.statusBtnPanne[3] = statusBtn;
            }
        });

        btnAmontDoorIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAmontDoorIssue, "Engine", panelDoorAmontIssueStatus, labelIssueDoorAmont);
                paintC.statusBtnPanne[4] = statusBtn;
            }
        });

        btnAvalDoorIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAvalDoorIssue, "Engine", panelDoorAvalIssueStatus, labelIssueDoorAval);
                paintC.statusBtnPanne[5] = statusBtn;
            }
        });

        btnAmontValveIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAmontValveIssue, "Engine", panelValveAmontIssueStatus, labelIssueValveAmont);
                paintC.statusBtnPanne[6] = statusBtn;
            }
        });

        btnAvalValveIssue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                changeStatusBtn(btnAvalValveIssue, "Engine", panelValveAvalIssueStatus, labelIssueValveAval);
                paintC.statusBtnPanne[7] = statusBtn;
            }
        });
        
        new Thread(paintC).start();

    }

    public void componentStatus(){
        for(Door d: doors){
            checkDoorStatus(d);
        }
        for(Valve v: valves){
            checkValveStatus(v);
        }
    }

    public void checkDoorStatus(Door d){
        if(d.pos == 0){
            if(d.status == "Fermée"){
                panelDoorAmontStatus.setBackground(Color.red);
            } else if (d.status == "Ouverture" || d.status == "Fermeture"){
                panelDoorAmontStatus.setBackground(Color.orange);
            } else if (d.status == "Ouverte"){
                panelDoorAmontStatus.setBackground(Color.green);
            }
            labelStatusDoorAmont.setText(d.status);
        } else if (d.pos == 1){
            if(d.status == "Fermée"){
                panelDoorAvalStatus.setBackground(Color.red);
            } else if (d.status == "Ouverture" || d.status == "Fermeture"){
                panelDoorAvalStatus.setBackground(Color.orange);
            } else if (d.status == "Ouverte"){
                panelDoorAvalStatus.setBackground(Color.green);
            }
            labelStatusDoorAval.setText(d.status);
        }
    }

    public void checkValveStatus(Valve v){
        if(labelStatusMode.getText().charAt(0) == 'A'){
            if(v.pos == 0){
                if(v.status == "Fermée"){
                    panelValveAmontStatus.setBackground(Color.red);
                } else if (v.status == "Ouverte"){
                    panelValveAmontStatus.setBackground(Color.green);
                }
                labelStatusValveAmont.setText(v.status);
            } else if (v.pos == 1){
                if(v.status == "Fermée"){
                    panelValveAvalStatus.setBackground(Color.red);
                } else if (v.status == "Ouverte"){
                    panelValveAvalStatus.setBackground(Color.green);
                }
                labelStatusValveAval.setText(v.status);
            }
        }
        
    }

    public void changeStatusBtn(JButton button, String type, JPanel panelStatus, JLabel labelStatus){                                       //status = 1, ouvert; status = 2, fermé

        String txt = "";

        if(button.getText().charAt(0) == 'O'){
            txt = "Fermer la ";
            panelStatus.setBackground(Color.green);
            labelStatus.setText("Ouvert");
            statusBtn = 1;
        } else if(button.getText().charAt(0) == 'F'){
            txt = "Ouvrir la ";
            panelStatus.setBackground(Color.red);
            labelStatus.setText("Fermée");
            statusBtn = 0;
        } else if(button.getText().charAt(0) == 'A'){
            txt = "Désactiver panne ";
            panelStatus.setBackground(Color.red);
            labelStatus.setText("Panne activée");
            statusBtn = 0;
        } else if (button.getText().charAt(0) == 'D'){
            txt = "Activer panne ";
            panelStatus.setBackground(Color.green);
            labelStatus.setText("Panne desactivée");
            statusBtn = 1;
        }

        if(type == "door"){
            txt += "porte";
        } else if(type == "valve") {
            txt += "vanne";
        } else if (type == "Engine") {
            txt += "moteur";
        } else if (type == "CollisionCaptor") {
            txt += "capteur de collision";
        }

        button.setText(txt);
    }

    public void sendSpeed(PaintC paint){
        paint.speedElement[0] = (int)spinnerBoatAmont.getValue();
        paint.speedElement[1] = (int)spinnerBoatAval.getValue();
        paint.speedElement[2] = (int)spinnerDoorAmont.getValue();
        paint.speedElement[3] = (int)spinnerDoorAval.getValue();
        paint.speedElement[4] = (int)spinnerValveAmont.getValue();
        paint.speedElement[5] = (int)spinnerValveAval.getValue();
    }

    @Override
    public void run(){ 
        while(true){
            if(paintT.boat.pos == 0){
                panelGeneralIssueStatus.setBackground(Color.red);
                labelGeneralIssue.setText("Panne générale, bateau dans une porte");
            } else {
                panelGeneralIssueStatus.setBackground(Color.green);
                labelGeneralIssue.setText("Pas de panne générale");
            }
            componentStatus();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }

}