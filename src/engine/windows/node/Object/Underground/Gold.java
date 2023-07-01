package engine.windows.node.Object.Underground;

import engine.windows.common.Animation;
import engine.windows.common.Position;
import engine.windows.node.Object.Taker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gold extends UndergroundObject {
    Animation animation;

    List<BufferedImage> imageList;
    String type;
    public Gold(String type, Position position, Taker taker) {
        super(position, taker);
        this.type = type;
        this.initGold();
    }

    public void initGold() {
        try {
            if (type == "big") {
                image = ImageIO.read(new File("Resources/Gold/big.png"));
            } else if (type == "medium") {
                image = ImageIO.read(new File("Resources/Gold/medium.png"));
            } else if (type == "small") {
                image = ImageIO.read(new File("Resources/Gold/small.png"));
            } else {
                image = ImageIO.read(new File("Resources/Gold/square.png"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}


