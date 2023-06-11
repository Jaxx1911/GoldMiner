package engine.windows.node.Object.Underground;

import engine.windows.common.Position;
import engine.windows.node.Object.Taker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rock extends UndergroundObject{

    String type;

    public Rock(Position position,String type, Taker taker) {
        super(position, taker);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void update() {
        super.update();
    }
}
