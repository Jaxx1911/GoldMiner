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

import static engine.windows.common.Animation.UPDATE_PER_SECOND;

public class Pig extends UndergroundObject {
    Integer type;
    List<BufferedImage> PigAnimate = new ArrayList<>();
    Animation PigMove;
    Position posTmp;

    double t = 0;
    //2 loại type: 0: Pig, 1: dPig
    public Pig(int type, Position position, Taker taker) {
        super(position, taker);
        this.posTmp = position.clone();
        this.type = type;
        this.initPig();
    }

    public void initPig() {
        mass = 35;
        try {
            if (type == 0) {
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/Pig1.png")));
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/Pig2.png")));
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/Pig3.png")));
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/Pig4.png")));
            } else {
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/dPig1.png")));
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/dPig2.png")));
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/dPig3.png")));
                PigAnimate.add(ImageIO.read(new File("Resources/Pig/dPig4.png")));
            }
            PigMove = new Animation(1000, PigAnimate, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if(!getStatus()){
            t += 10.0/ UPDATE_PER_SECOND;
            this.position.x = posTmp.x + (int) (100* Math.cos(1/Math.PI*t));
        System.out.println(position.x+" "+t);
        image = PigMove.getCurrentImage();}
    }
    public void draw(Graphics g) {
        g.drawImage(image, (int) position.x, (int) position.y, null);
    }
}
