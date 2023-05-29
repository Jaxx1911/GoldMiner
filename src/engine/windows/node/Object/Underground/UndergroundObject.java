package engine.windows.node.Object.Underground;

import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Taker;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UndergroundObject extends GameObject {

    int mass;

    Taker taker;

    Boolean taked;

    Position objectCenter;

    public UndergroundObject(Position position,Taker taker) {
        super(position);
        this.taker = taker;
        objectCenter = new Position((position.x+image.getWidth())/2,(position.y+ image.getHeight())/2);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void collideWith(GameObject target) {
        if(target instanceof Taker)
            taked = true;
    }
}
