public class Floodgate {

    public static void main (String args[]){
        Window window = new Window(1920, 750);                      //création de notre fenêtre
        new Thread(window).start();
    }

}
