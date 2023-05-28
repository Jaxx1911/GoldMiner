package engine.windows.node;

import engine.windows.common.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameButton extends GameObject{

    private MouseListener mouseListener;

    BufferedImage image;

    Position clickPosition;

    public GameButton(Position position) {
        super(position);
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                clickPosition = new Position(getPosition().x,getPosition().y);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(clickPosition.x>=position.x&&clickPosition.x<= position.x+image.getWidth()&&clickPosition.y>=position.y&&clickPosition.y<= position.y+image.getHeight())
                    System.out.println("dit me may");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

    }

    public void triggerClick(){

    }
    @Override
    public void collideWith(GameObject target) {
    }
    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void draw(Graphics g){
        g.drawImage(image,position.x,position.y,null);
    }

}
