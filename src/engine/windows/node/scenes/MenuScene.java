package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.GameButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuScene extends Scene {
    GameButton start;

    public MenuScene(GameWindows gameWindows) {
        super(gameWindows);
        start = new GameButton(new Position(200,400));
        try {
            start.setImage(ImageIO.read(new File("Resources/Start.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameWindows.addMouseListener(start.getMouseListener());
    }



    public void draw(Graphics g) {
        super.draw(g);
        start.draw(g);
    }
}
