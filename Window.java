import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Color;

public class Window extends JFrame{

    
    JButton btnAmontDoor = new JButton("Ouvrir la porte");
    JButton btnAvalDoor = new JButton("Ouvrir la porte");

    JButton btnAmontValve = new JButton("Ouvrir la vanne");
    JButton btnAvalValve = new JButton("Ouvrir la vanne");

    int statusBtn;

    public Window (int width, int height){

        JPanel panelButton = new JPanel();
        panelButton.setBounds(width,height,width,height); 

        JPanel panelAmont = new JPanel();
        panelAmont.setBounds(width/2,height,width/2,height);
        panelAmont.setBackground(Color.gray);

        JPanel panelAuto = new JPanel();
        panelAuto.setBounds(width/2,height,width/2,height);
        panelAuto.setBackground(Color.gray);

        JPanel panelAval = new JPanel();
        panelAval.setBounds(width/2,height,width/2,height);
        panelAval.setBackground(Color.gray);

        JButton btnAuto = new JButton("Automatique");
        btnAuto.setBounds(0,100,50,30);

        JButton btnAmontBoat = new JButton("Ajout bateau");
        btnAmontBoat.setBounds(0,100,50,30);
        JButton btnAvalBoat = new JButton("Ajout bateau");
        btnAvalBoat.setBounds(width,100,50,30);

        btnAmontBoat.setBounds(0,100,50,30);
        btnAmontBoat.setBounds(0,100,50,30);

        btnAmontValve.setBounds(width,100,50,30);
        btnAvalValve.setBounds(width,100,50,30);

        setTitle("Simulation d'une ecluse");                               //nom de ma fenêtre
        setSize(width, height);                                                  //taille de ma fenêtre
        setVisible(true);                                                     //la fenêtre est visible
        setResizable(false);                                          //impossible de redimenssionner la fenêtre

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

        panelAmont.add(btnAmontBoat);
        panelAmont.add(btnAmontDoor);
        panelAmont.add(btnAmontValve);

        panelAuto.add(btnAuto);

        panelAval.add(btnAvalBoat);
        panelAval.add(btnAvalDoor);
        panelAval.add(btnAvalValve);

        panelButton.add(panelAmont);
        panelButton.add(panelAuto);
        panelButton.add(panelAval);
        
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
                    paintC.statusAuto = "MANUAL";
                } else {
                    btnAuto.setText("Manuel");
                    paintC.statusAuto = "AUTO";
                }
            }
        });

        btnAmontDoor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAmontDoor, "door");
                paintC.statusBtnManual[0] = statusBtn;
            }
        });

        btnAvalDoor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAvalDoor, "door");
                paintC.statusBtnManual[1] = statusBtn;
            }
        });

        btnAmontValve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAmontValve, "valve");
                paintC.statusBtnManual[2] = statusBtn;
            }
        });

        btnAvalValve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStatusBtn(btnAvalValve, "valve");
                paintC.statusBtnManual[3] = statusBtn;
            }
        });

        getContentPane().add(paintC, "Center");
        getContentPane().add(panelButton, "South");
    }

    public void changeStatusBtn(JButton button, String type){                                       //status = 1, ouvert; status = 2, fermé

        String txt = "";

        if(button.getText().charAt(0) == 'O'){
            txt = "Fermer la ";
            statusBtn = 1;
        } else {
            txt = "Ouvrir la ";
            statusBtn = 0;
        }

        if(type == "door"){
            txt += "porte";
        } else {
            txt += "vanne";
        }

        button.setText(txt);

    }
}