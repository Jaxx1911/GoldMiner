package engine.windows.node.background;

import engine.windows.Tool;
import engine.windows.common.Animation;
import engine.windows.common.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class MenuBackground {

    BufferedImage human;
    Animation goldAnimation;
    BufferedImage light;
    BufferedImage instructionBoard;

    BufferedImage control1,control2;

    String c1 = "Controls";
    String button1 = "Drop";
    String button2 = "TNT";
    Position windowPosition;
    Position goldPosition;
    Position boardPosition;
    double time = 0;
    double LightScaleChange = 2.2;

    double GoldScale = 1.2;
    double HumanScale = 1.3;

    public MenuBackground(){
        try {
            List<BufferedImage> Gold = new ArrayList<>();
            human = ImageIO.read(new File("Resources/Menu/Human.png"));
            for(int i = 0 ;i<8;i++){
                String filename = "Resources/BigGold/Gold"+(i+1)+".png";
                Gold.add(ImageIO.read(new File(filename)));
            }
            goldAnimation = new Animation(500,Gold,true);
            light = ImageIO.read(new File("Resources/Menu/Light.png"));
            instructionBoard = ImageIO.read(new File("Resources/Menu/instruction.png"));
            control1 = ImageIO.read(new File("Resources/Menu/BackButton.png"));
            control2 = ImageIO.read(new File("Resources/Menu/BackButton.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        windowPosition = new Position(800,600);
        goldPosition = new Position(200,200);
        boardPosition = new Position(10 ,windowPosition.y-10 - instructionBoard.getHeight());
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,windowPosition.x, windowPosition.y);
        g.drawImage(Tool.ScaleImage(light,LightScaleChange), goldPosition.x -Tool.ScaleImage(light,LightScaleChange).getWidth()/2,goldPosition.y - Tool.ScaleImage(light,LightScaleChange).getHeight()/2,null);
        g.drawImage(Tool.ScaleImage(goldAnimation.getCurrentImage(),GoldScale), goldPosition.x- Tool.ScaleImage(goldAnimation.getCurrentImage(),GoldScale).getWidth()/2, goldPosition.y - Tool.ScaleImage(goldAnimation.getCurrentImage(),GoldScale).getHeight()/2,null);
        g.drawImage(Tool.ScaleImage(human,HumanScale), windowPosition.x - Tool.ScaleImage(human,HumanScale).getWidth(), windowPosition.y - Tool.ScaleImage(human,HumanScale).getHeight(),null);
        g.drawImage(instructionBoard,10 , windowPosition.y-10 - instructionBoard.getHeight(),null);
        g.drawString(c1, boardPosition.x, boardPosition.y);
    }

    public void update(){
        time +=0.3;
        LightScaleChange = 2.2 + 0.4*Math.cos(Math.PI*time/10);
    }

    public Position getGoldPosition() {
        return goldPosition;
    }
}
