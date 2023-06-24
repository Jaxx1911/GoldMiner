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

public class Pig extends UndergroundObject {
    String type;
    List<BufferedImage> PigAnimate = new ArrayList<>();
    BufferedImage PigImage, image;
    Animation PigMove;
    //2 loại type: Pig, dPig
    public Pig(String type, Position position, Taker taker) {
        super(position, taker);
        this.type = type;
        try {
            if (type == "Pig") {
                PigImage = ImageIO.read(new File("Resources/Pig/pig.png"));
            } else {
                PigImage = ImageIO.read(new File("Resources/Pig/dPig.png"));
            }
            for (int i = 0; i < 128; i += 64) {
                for (int j = 0; j < 96; j += 48) {
                    BufferedImage index = PigImage.getSubimage(i, j, 64, 48);
                    PigAnimate.add(index);
                }
            }
            PigMove = new Animation(1000, PigAnimate, true);
            image = PigAnimate.get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void update() {
        image = PigMove.getCurrentImage();
    }
}
