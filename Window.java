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


public class Window extends JFrame{

    int statusBtn;

    //-----------------------------SPINNER PART-----------------------------

    SpinnerModel spinnerBoatAmontM = new SpinnerNumberModel(50, 1, 100, 1);     
    JSpinner spinnerBoatAmont = new JSpinner(spinnerBoatAmontM);

    SpinnerModel spinnerBoatAvalM = new SpinnerNumberModel(50, 1, 100, 1);        
    JSpinner spinnerBoatAval = new JSpinner(spinnerBoatAvalM);

        
    SpinnerModel spinnerDoorAmontM = new SpinnerNumberModel(50, 1, 100, 1);  
    JSpinner spinnerDoorAmont = new JSpinner(spinnerDoorAmontM);      

    SpinnerModel spinnerDoorAvalM = new SpinnerNumberModel(50, 1, 100, 1);
    JSpinner spinnerDoorAval = new JSpinner(spinnerDoorAvalM);

        
    SpinnerModel spinnerValveAmontM = new SpinnerNumberModel(50, 1, 100, 1);  
    JSpinner spinnerValveAmont = new JSpinner(spinnerValveAmontM);
        
    SpinnerModel spinnerValveAvalM = new SpinnerNumberModel(50, 1, 100, 1);       
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

        JPanel panelBoatAmont = new JPanel();
        panelBoatAmont.setBounds(0,0,50,30); 
        panelBoatAmont.setLayout(new BoxLayout(panelBoatAmont, BoxLayout.Y_AXIS));

        JPanel panelBoatAval = new JPanel();
        panelBoatAval.setBounds(0,0,50,30); 
        panelBoatAval.setLayout(new BoxLayout(panelBoatAval, BoxLayout.Y_AXIS));


        JPanel panelDoorAmont = new JPanel();
        panelDoorAmont.setBounds(0,0,50,30); 
        panelDoorAmont.setLayout(new BoxLayout(panelDoorAmont, BoxLayout.Y_AXIS));

        JPanel panelDoorAval = new JPanel();
        panelDoorAval.setBounds(0,0,50,30); 
        panelDoorAval.setLayout(new BoxLayout(panelDoorAval, BoxLayout.Y_AXIS));


        JPanel panelValveAmont = new JPanel();
        panelValveAmont.setBounds(0,0,50,30);
        panelValveAmont.setLayout(new BoxLayout(panelValveAmont, BoxLayout.Y_AXIS)); 
        
        JPanel panelValveAval = new JPanel();
        panelValveAval.setBounds(0,0,50,30); 
        panelValveAval.setLayout(new BoxLayout(panelValveAval, BoxLayout.Y_AXIS));

        //-----------------------------JPANEL INDICATOR PART-----------------------------

        JPanel panelDoorAmontStatus = new JPanel();
        panelDoorAmontStatus.setBounds(0,0,50,30);
        panelDoorAmontStatus.setBackground(Color.red);

        JPanel panelDoorAvalStatus = new JPanel();
        panelDoorAvalStatus.setBounds(0,0,50,30);
        panelDoorAvalStatus.setBackground(Color.red);


        JPanel panelValveAmontStatus = new JPanel();
        panelValveAmontStatus.setBounds(0,0,50,30);
        panelValveAmontStatus.setBackground(Color.red);

        JPanel panelValveAvalStatus = new JPanel();
        panelValveAvalStatus.setBounds(0,0,50,30);
        panelValveAvalStatus.setBackground(Color.red);


        JPanel panelModeStatus = new JPanel();
        panelModeStatus.setBounds(0,0,50,30);
        panelModeStatus.setBackground(Color.orange);

        //-----------------------------JBUTTON PART-----------------------------

        JButton btnAuto = new JButton("Automatique");
        btnAuto.setBounds(0,100,50,30);
        //btnAuto.setAlignmentX(panelAuto.CENTER_ALIGNMENT);
        JButton btnSaveSpeed = new JButton("Sauvegarder vitesse");
        btnSaveSpeed.setBounds(0,100,50,30);
        //btnSaveSpeed.setAlignmentX(panelAuto.CENTER_ALIGNMENT);

        JButton btnAmontBoat = new JButton("Ajout bateau");
        btnAmontBoat.setBounds(0,100,50,30);
        JButton btnAvalBoat = new JButton("Ajout bateau");
        btnAvalBoat.setBounds(width,100,50,30);

            
        JButton btnAmontDoor = new JButton("Ouvrir la porte");
        btnAmontDoor.setBounds(0,100,50,30);
        JButton btnAvalDoor = new JButton("Ouvrir la porte");
        btnAvalDoor.setBounds(0,100,50,30);

        
        JButton btnAmontValve = new JButton("Ouvrir la vanne");
        btnAmontValve.setBounds(width,100,50,30);
        JButton btnAvalValve = new JButton("Ouvrir la vanne");
        btnAvalValve.setBounds(width,100,50,30);

        //-----------------------------LABEL PART-----------------------------

        JLabel labelSpeedBoatAmont = new JLabel("Vitesse du bateau :", JLabel.LEFT);
        JLabel labelSpeedBoatAval = new JLabel("Vitesse du bateau :", JLabel.LEFT);
        
        JLabel labelSpeedDoorAmont = new JLabel("Vitesse de la porte :", JLabel.LEFT);
        JLabel labelSpeedDoorAval = new JLabel("Vitesse de la porte :", JLabel.LEFT);
        
        JLabel labelSpeedValveAmont = new JLabel("Vitesse de la valve :", JLabel.LEFT);
        JLabel labelSpeedValveAval = new JLabel("Vitesse de la valve :", JLabel.LEFT);

        JLabel labelStatusDoorAmont = new JLabel("Fermé", JLabel.LEFT);
        JLabel labelStatusDoorAval = new JLabel("Fermé", JLabel.LEFT);

        JLabel labelStatusValveAmont = new JLabel("Fermé", JLabel.LEFT);
        JLabel labelStatusValveAval = new JLabel("Fermé", JLabel.LEFT);

        JLabel labelStatusMode = new JLabel("Manuel", JLabel.LEFT);

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

        Valve[] valves;
        valves = new Valve[2];

        valves[0] = new Valve(0, height, width);
        valves[1] = new Valve(1, height, width);

        Boat boat = new Boat(-1, height, width);

        Door door1 = new Door(0, height, width);
        Door door2 = new Door(1, height, width);

        PaintC paintC = new PaintC(width, height, riverArray, trafficLights, valves, boat, door1, door2);
        sendSpeed(paintC);
        new Thread(paintC).start();

        //-----------------------------PANEL ADD PART-----------------------------

            //-----------------------------AMONT PART-----------------------------

        panelBoatAmont.add(labelSpeedBoatAmont);
        panelBoatAmont.add(spinnerBoatAmont);
        panelBoatAmont.add(btnAmontBoat);

        panelDoorAmontStatus.add(labelStatusDoorAmont);
        
        panelDoorAmont.add(panelDoorAmontStatus);
        panelDoorAmont.add(labelSpeedDoorAmont);
        panelDoorAmont.add(spinnerDoorAmont);
        panelDoorAmont.add(btnAmontDoor);
        
        panelValveAmontStatus.add(labelStatusValveAmont);
        
        panelValveAmont.add(panelValveAmontStatus);
        panelValveAmont.add(labelSpeedValveAmont);
        panelValveAmont.add(spinnerValveAmont);
        panelValveAmont.add(btnAmontValve);

        panelAmont.add(panelBoatAmont);
        panelAmont.add(panelDoorAmont);
        panelAmont.add(panelValveAmont);

            //-----------------------------AUTO PART-----------------------------

        panelModeStatus.add(labelStatusMode);
        
        panelAuto.add(panelModeStatus);
        panelAuto.add(btnSaveSpeed);
        panelAuto.add(btnAuto);

            //-----------------------------AVAL PART-----------------------------

        panelBoatAval.add(labelSpeedBoatAval);
        panelBoatAval.add(spinnerBoatAval);
        panelBoatAval.add(btnAvalBoat);

        panelDoorAvalStatus.add(labelStatusDoorAval);
        
        panelDoorAval.add(panelDoorAvalStatus);
        panelDoorAval.add(labelSpeedDoorAval);
        panelDoorAval.add(spinnerDoorAval);
        panelDoorAval.add(btnAvalDoor);

        panelValveAvalStatus.add(labelStatusValveAval);
        
        panelValveAval.add(panelValveAvalStatus);
        panelValveAval.add(labelSpeedValveAval);
        panelValveAval.add(spinnerValveAval);
        panelValveAval.add(btnAvalValve);

        panelAval.add(panelBoatAval);
        panelAval.add(panelDoorAval);
        panelAval.add(panelValveAval);

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

        getContentPane().add(paintC, "Center");
        getContentPane().add(panelButton, "South");
    }

    public void changeStatusBtn(JButton button, String type, JPanel panelStatus, JLabel labelStatus){                                       //status = 1, ouvert; status = 2, fermé

        String txt = "";

        if(button.getText().charAt(0) == 'O'){
            txt = "Fermer la ";
            panelStatus.setBackground(Color.green);
            labelStatus.setText("Ouvert");
            statusBtn = 1;
        } else {
            txt = "Ouvrir la ";
            panelStatus.setBackground(Color.red);
            labelStatus.setText("Fermée");
            statusBtn = 0;
        }

        if(type == "door"){
            txt += "porte";
        } else {
            txt += "vanne";
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

}