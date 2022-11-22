public class Boat{
    
    int posX;
    int posY;

    int pos;                                                                                                        //dimension y de la fenêtre
    
    int maxHeight;
    int maxWidth;

    int height;
    int width;

    public Boat(int pos, int maxHeight, int maxWidth){
        this.pos = pos;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;                                                                                     //déclare la cible comme étant visible

        height = 25;
        width = 50;

        if(pos == -1){
            posX = 10;
            posY = maxHeight - 250;
        } else if(pos == 1){
            posX = maxWidth - 75;
            posY = maxHeight - 250;
        }
    }

    public void moveBoatX(int speed){
        if(pos == -1){
            posX += speed;
        } else {
            posX -= speed;
        }
    }

    public void moveBoatY(int speed, String upOrDown){
        if(upOrDown == "Up"){
            posY += speed;
        } else if (upOrDown == "Down"){
            posY -= speed;
        }
    }

    public void respawnBoat(int posT){
        if (posT == -1){
            pos = posT;
            posX = -width;
        } else {
            pos = posT;
            posX = maxWidth;
        }
    }
}
