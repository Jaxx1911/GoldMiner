package engine.windows.node.Object.Underground;

import engine.windows.common.Animation;
import engine.windows.common.Position;
import engine.windows.node.Object.Taker;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MysteryBag extends UndergroundObject{

    List<Integer> massList;
    int choice;
    public MysteryBag(Position position, Taker taker) {
        super(position, taker);
        this.initMass();
        this.randomChoice();
        try {
            image = ImageIO.read(new File("Resources/Gold/MysteryBag.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void randomChoice() {
        //Math.random()*(max-min+1) + min
        choice = (int) Math.random()*4;
        if(choice == 0) {
            value = (int) Math.random()*(862 - 25 + 1) + 25;
        } else if (choice == 1) {
            //boom
        } else if (choice == 2) {
            //power
        } else if (choice == 3) {
            //thua luon
        }
    }

    public void initMass() {
        Integer[] massTmp = {120, 100, 80, 50, 20, 15, 10};
        List<Integer> massList = Arrays.asList(massTmp);
        mass = massList.get((int) Math.random()*7);
    }
}
