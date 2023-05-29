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
    public Gold(Position position, Taker taker) {
        super(position, taker);
        imageList = new ArrayList<>();
        try {
            for(int i = 0 ; i<8;i++){
                String filename = "Resources/Gold/Gold"+(i+1)+".png";
                imageList.add(ImageIO.read(new File(filename)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        animation = new Animation(3,imageList,true);
    }

}


