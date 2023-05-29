package engine.windows.node.Object;

import engine.windows.common.Position;
import engine.windows.node.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Taker extends GameObject {

    private double w = 2/(2*Math.PI);
    private final int Radius = 28;
    private final int BIG_RADIUS = 30;

    private final int UPDATE_PER_SECOND = 60;
    private double time = 0;

    public double angle = 0;
    private double cst = 10;

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
        this.position.x =  orgPos.x + (int)(Radius*Math.cos(w*time));
        this.position.y =  orgPos.y + (int) Math.pow(BIG_RADIUS*BIG_RADIUS - (position.x-orgPos.x)*(position.x-orgPos.x),0.5);


    }

    public void draw(Graphics g){
        super.draw(g);
        if(position.x - orgPos.x <=0)
            g.drawImage(rotate(image,Math.acos((double) (position.y-orgPos.y)/BIG_RADIUS)),position.x-2, position.y,null);
        else
            g.drawImage(rotate(image,(-1)*Math.acos((double) (position.y-orgPos.y)/BIG_RADIUS)),position.x-2, position.y,null);
        System.out.println(Math.asin((double) (position.y-orgPos.y)/BIG_RADIUS)/Math.PI+ " " + (position.y - orgPos.y));
//        g.drawImage(image, position.x, position.y, null);
    }

    @Override
    public void collideWith(GameObject target) {

    }
    public static BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w+5, h+5, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(angle, w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    public Position getOrgPos() {
        return orgPos;
    }

    public BufferedImage getImage() {
        return image;
    }
}
