package engine.windows.node.background;

import java.awt.*;

public class GameBackground {
    public GameBackground(){

    }
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,800,600);
    }
}
