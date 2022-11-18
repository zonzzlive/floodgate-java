public class TrafficLight {
    
    int posX;
    int posY;

    int pos;                                                                                                        //dimension y de la fenêtre
    
    int maxHeight;
    int maxWidth;

    int height;
    int width;

    int status;                                                                                                     //status = 1, le feu est vert; status = 2, le feu est rouge

    public TrafficLight(int pos, int maxHeight, int maxWidth){
        this.pos = pos;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;

        height = 20;
        width = 20;

        posY = 150;
        
        if(pos == 0){
            posX = (int)((maxWidth * 0.4) - 30);
        } else if (pos == 1){
            posX = (int)((maxWidth * 0.6) + 30);
        }
    }

}
