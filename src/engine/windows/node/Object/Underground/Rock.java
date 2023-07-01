package engine.windows.node.Object.Underground;

import engine.windows.common.Position;
import engine.windows.node.Object.Taker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rock extends UndergroundObject{

    String type;

    public Rock(String type, Position position, Taker taker) {
        super(position, taker);
        this.type = type;
        this.initRock();
    }
    public void initRock() {
        try {
            if (type == "big") {
                image = ImageIO.read(new File("Resources/GameSceneObject/BigRock.png"));
            } else if (type == "small") {
                image = ImageIO.read(new File("Resources/GameSceneObject/Rock.png"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
