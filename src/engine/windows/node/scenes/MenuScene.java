package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.GameButton;
import engine.windows.node.background.MenuBackground;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuScene extends Scene {
    GameButton start;
    MenuBackground menuBackground;

    public MenuScene(GameWindows gameWindows) {
        super(gameWindows);
        menuBackground = new MenuBackground();
        start = new GameButton(new Position(200, 400)) {
            @Override
            public void Clicked() {
                gameWindows.getSceneStack().push(new GameScene(gameWindows));
            }
        };
        try {
            start.setImage(ImageIO.read(new File("Resources/Start.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        listGameObject.add(start);
        gameWindows.getMouseListenerStack().push(start.getMouseListener());
    }



    public void draw(Graphics g) {
        menuBackground.draw(g);
        super.draw(g);
    }

}
