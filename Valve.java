public class Valve {
    int posX;
    int posY;

    int pos;                                                                                                        //dimension y de la fenêtre
    
    int maxHeight;
    int maxWidth;

    int height;
    int width;

    int status;                                                                                                     //status = 1, la vanne est ouverte; status = 2, la vanne est fermée

    public Valve(int pos, int maxHeight, int maxWidth){
        this.pos = pos;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        height = 15;
        width = 30;

        posY = 325;
        
        if(pos == 0){
            posX = (int)((maxWidth * 0.4) - 10);
        } else if (pos == 1){
            posX = (int)((maxWidth * 0.6) -10);
        }
    }
}
