package engine.windows.node.Object;

import engine.windows.common.Position;
import engine.windows.node.GameObject;

import java.awt.*;

public class Rope extends GameObject {
    Taker taker;
    public Rope(Position position,Taker taker) {
        super(position);
        this.taker = taker;
    }

    @Override
    public void update() {
        super.update();
    }

    public void draw(Graphics g){
        super.draw(g);
        g.drawLine(position.x,position.y,taker.getPosition().x,taker.getPosition().y);
    }

    @Override
    public void collideWith(GameObject target) {

    }
}
