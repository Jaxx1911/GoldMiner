package engine.windows.node.Object;

import engine.windows.common.Position;
import engine.windows.node.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Taker extends GameObject {

    private double w = 3.0/(2*Math.PI);
    private final int Radius = 10;
    private final int BIG_RADIUS = 20;

    private final int UPDATE_PER_SECOND = 60;
    private double time = 0;

    public double angle = 0;
    private double cst = 30;

    Position orgPos = new Position(300,200);

    boolean oscillate;
    boolean taking;
    boolean pulling;
    boolean taked;



    Position connectPoint;
    BufferedImage image;
    public Taker(Position position) {
        super(position);
        try {
            image = ImageIO.read(new File("Resources/Taker.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        super.update();
        time += cst/UPDATE_PER_SECOND;
        position.x =  orgPos.x + (int)(Radius*Math.cos(w*time));
        position.y =  orgPos.y + (int) Math.pow(BIG_RADIUS*BIG_RADIUS - (position.x-orgPos.x)*(position.x-orgPos.x),0.5);
        angle = Math.acos((double) position.y/Radius);

    }

    public void draw(Graphics g){
        super.draw(g);
        g.drawImage(image,position.x, position.y,null);
        System.out.println(position.x + " " + position.y + " "+ time);
    }

    @Override
    public void collideWith(GameObject target) {

    }
    public static BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }
}
