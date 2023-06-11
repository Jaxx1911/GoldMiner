package engine.windows.node.Object;

import engine.windows.Tool;
import engine.windows.common.Position;
import engine.windows.node.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rope extends GameObject {
    BufferedImage image;
    Taker taker;

    Position connectPosition;
    double angle;
    public Rope(Position position,Taker taker) {
        super(position);
        this.taker = taker;
        try {
            image = ImageIO.read(new File("Resources/GameSceneObject/ropetile.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        connectPosition = new Position(taker.getPosition().x+taker.image.getWidth()/2,taker.getPosition().y + taker.image.getHeight() / 2);
    }

    @Override
    public void update() {
        super.update();
    }

    public void draw(Graphics g){
        super.draw(g);

        g.drawLine(position.x+taker.image.getWidth()/2,position.y,taker.getPosition().x+taker.image.getWidth()/2,taker.getPosition().y + taker.image.getHeight() / 2);
    }

    @Override
    public void collideWith(GameObject target) {
    }
}
