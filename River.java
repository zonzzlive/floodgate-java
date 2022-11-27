public class River{

    int posX;                                                                                                        //coordonnées x de la cible
    int posY;

    int pos;                                                                                                        //dimension y de la fenêtre
    
    int maxHeight;
    int maxWidth;

    int height;
    int width;

    public River(int pos, int maxHeight, int maxWidth){
        this.pos = pos;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        height = 250;

        if(pos == 1){
            posY = 250;
            posX = 0;
            width = (int)(maxWidth * 0.4);
        } else if(pos == 2){
            posY = 300;
            posX = (int)(maxWidth * 0.4);
            width = (int)(maxWidth * 0.2);
        } else {
            posY = 300;
            posX = (int)(maxWidth * 0.6);
            width = (int)(maxWidth * 0.4);
        }
    }

    public void moveRiverY(int speed){
        System.out.println(this.posY);
        System.out.println(speed);
        System.out.println("-----------------------");
        if((this.posY <= 300 && speed == -1 && this.posY > 250) || (this.posY >= 250 && speed == 1 && this.posY < 300)){
            System.out.println("oui");
            posY += speed;
        }
        
    }

}
