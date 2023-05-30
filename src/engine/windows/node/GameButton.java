package engine.windows.node;

import engine.windows.Tool;
import engine.windows.common.Position;
import engine.windows.node.listeners.MouseClickListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GameButton extends GameObject {
    private MouseListener mouseListener;

    boolean zoom;

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
                clickPosition = new Position(e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(clickPosition.x>=position.x&&clickPosition.x<= position.x+image.getWidth()&&clickPosition.y>=position.y&&clickPosition.y<= position.y+image.getHeight())
                    Clicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

    }
    abstract public void Clicked();
    @Override
    public void collideWith(GameObject target) {
    }
    public MouseListener getMouseListener() {
        return mouseListener;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void draw(Graphics g){
        g.drawImage(image,position.x,position.y,null);
    }



}
