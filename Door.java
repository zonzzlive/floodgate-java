public class Door {
    
    int posX;
    int posY;

    int pos;
    
    int maxHeight;
    int maxWidth;

    int height;
    int width;

    public Door(int pos, int maxHeight, int maxWidth){
        this.pos = pos;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        height = 175;
        width = 10;
        posY = 200;

        if(pos == 0){
            posX = (int)(maxWidth * 0.4);
        } else if (pos == 1){
            posX = (int)(maxWidth * 0.6);
        }

    }

    public void moveDoorY(int speed){
        posY += speed;
    }
}
