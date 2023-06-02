package engine.windows.node.Object;

import engine.windows.Tool;
import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Underground.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Taker extends GameObject {

    private double w = 2/(2*Math.PI);
    private final int Radius = 46;
    private final int BIG_RADIUS = 50;

    private int price;

    private final static int THROWING_SPEED = 800;
    private final static int UPDATE_PER_SECOND = 60;
    private double time = 0;

    public double angle = 0;
    private double cst = 10;

    Position orgPos = new Position(300,200);

    boolean oscillate = true;
    boolean throwing = false;
    boolean pulling = false;
    boolean taked = false;

    int xD = 0;

    public void setOscillate(boolean oscillate) {
        this.oscillate = oscillate;
    }

    public void setThrowing(boolean throwing) {
        this.throwing = throwing;
    }

    public void setPulling(boolean pulling) {
        this.pulling = pulling;
    }

    public void setTaked(boolean taked) {
        this.taked = taked;
    }

    Position ThrowingPoint = new Position(0,0);
    BufferedImage image;
    public Taker(Position position) {
        super(position);
        try {
            image = ImageIO.read(new File("Resources/GameSceneObject/Taker.png"));
            image = Tool.rotateByAnchor(image, angle, image.getWidth()/2, image.getHeight()/2 - 10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        super.update();
        int xDirection = (position.x - orgPos.x <=0) ? 1 : - 1;
        if(isOscillate()) {
            angle = xDirection * Math.acos((double) (position.y - orgPos.y) / BIG_RADIUS);
            time += cst / UPDATE_PER_SECOND;
            this.position.x = orgPos.x + (int) (Radius * Math.cos(w * time));
            this.position.y = orgPos.y + (int) Math.pow(BIG_RADIUS * BIG_RADIUS - (position.x - orgPos.x) * (position.x - orgPos.x), 0.5);
        }
        if(isThrowing()){
            position.x += THROWING_SPEED*xDirection*(-1)*Math.abs(Math.sin(angle))/UPDATE_PER_SECOND;
            position.y += THROWING_SPEED*Math.abs(Math.cos(angle))/UPDATE_PER_SECOND;
        }
        if(position.x>=1440||position.x<=0||position.y>=800){
            pulling = true;
            throwing = false;
        }
        if(isPulling()){
            position.x -= THROWING_SPEED*xDirection*(-1)*Math.abs(Math.sin(angle))/UPDATE_PER_SECOND;
            position.y -= THROWING_SPEED*Math.abs(Math.cos(angle))/UPDATE_PER_SECOND;
        }
        if(position.y <=350 - image.getHeight() && pulling == true){
            pulling = false;
            taked = true;
            //ThrowingPoint = new Position(0,0);
        }
        if(isTaked() == true){
            taked = false;
            oscillate =true;

        }

    }

    public void draw(Graphics g){
        super.draw(g);
        BufferedImage rotated = Tool.rotateCenter(image, angle);
        g.drawImage(rotated, position.x , position.y, null);
        //g.drawImage(image, position.x, position.y, null);
    }

    @Override
    public void collideWith(GameObject target) {
        if(target instanceof Gold){
        }
        if(target instanceof Rock){}
        if(target instanceof Diamond){}
        if(target instanceof Mouse){}
        if(target instanceof MysteryBag){}
        if(target instanceof Bone){}

        pulling = true;
        throwing = false;
    }

    public Position getOrgPos() {
        return orgPos;
    }

    public BufferedImage getImage() {
        return image;
    }

    public double getAngle() {
        return angle;
    }

    public boolean isOscillate() {
        return oscillate;
    }

    public boolean isThrowing() {
        return throwing;
    }

    public boolean isPulling() {
        return pulling;
    }

    public boolean isTaked() {
        return taked;
    }

    public void setThrowingPoint(Position throwingPoint) {
        ThrowingPoint = throwingPoint;
    }

    public Position getThrowingPoint() {
        return ThrowingPoint;
    }
}
