package engine.windows.node.background;

import engine.windows.Tool;
import engine.windows.common.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class MenuBackground {

    Tool tool = new Tool();
    BufferedImage human;
    Animation goldAnimation;
    BufferedImage light;
    BufferedImage instructionBoard;

    BufferedImage control1,control2;

    public MenuBackground(){
        try {
            List<BufferedImage> Gold = new ArrayList<>();
            human = ImageIO.read(new File("Resources/Menu/Human.png"));
            for(int i = 0 ;i<8;i++){
                String filename = "Resources/BigGold/Gold"+(i+1)+".png";
                Gold.add(ImageIO.read(new File(filename)));
            }
            goldAnimation = new Animation(2000,Gold,true);
            light = ImageIO.read(new File("Resources/Menu/Light.png"));
            instructionBoard = ImageIO.read(new File("Resources/Menu/instruction.png"));
            control1 = ImageIO.read(new File("Resources/Menu/BackButton.png"));
            control2 = ImageIO.read(new File("Resources/Menu/BackButton.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,600);
        g.drawImage(light,100,50,null);
        g.drawImage(goldAnimation.getCurrentImage(),100+light.getWidth()/2-goldAnimation.getCurrentImage().getWidth()/2,50+ light.getHeight()/2-goldAnimation.getCurrentImage().getHeight()/2,null);
        g.drawImage(human,800-human.getWidth(),600-human.getHeight(),null);
    }
}
