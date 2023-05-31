package engine.windows.node.background;

import engine.windows.GameWindows;
import engine.windows.Tool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBackground {

    BufferedImage bgtile1,bgtile2,bgtile3;

    BufferedImage purpletile;

    BufferedImage groundtile;

    BufferedImage gametopbg;

    public GameBackground(){
        try {
            bgtile1 = ImageIO.read(new File("Resources/GameBackGround/bgtile1.png"));   bgtile2 = ImageIO.read(new File("Resources/GameBackGround/bgtile2.png"));   bgtile3  = ImageIO.read(new File("Resources/GameBackGround/bgtile3.png"));
            purpletile = ImageIO.read(new File("Resources/GameBackGround/purpletile.png"));
            groundtile = ImageIO.read(new File("Resources/GameBackGround/groundtile.png"));
            gametopbg = ImageIO.read(new File("Resources/GameBackGround/gametopbg.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.getHSBColor(18,57,10));
        g.fillRect(0,0,1440, 800);
        for(int i = 0;i<=1440;i+=purpletile.getWidth()){
            g.drawImage(purpletile,i,0,null);
            g.drawImage(purpletile,i,purpletile.getHeight(),null);
        }
    }
}
