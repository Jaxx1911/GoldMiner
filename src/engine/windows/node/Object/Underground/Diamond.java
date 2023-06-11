package engine.windows.node.Object.Underground;

import engine.windows.common.Animation;
import engine.windows.common.Position;
import engine.windows.node.Object.Taker;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Diamond extends UndergroundObject{
    Animation animation;

    List<BufferedImage> imageList;
    public Diamond(Position position, Taker taker) {
        super(position, taker);
    }
}
