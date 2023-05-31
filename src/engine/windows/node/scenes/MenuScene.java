package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.Tool;
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

    double scaleButton = 0.9;
    double time = 0;

    public MenuScene(GameWindows gameWindows) {
        super(gameWindows);
        menuBackground = new MenuBackground();
        start = new GameButton(menuBackground.getStartPos(),true) {
            @Override
            public void Clicked() {
                gameWindows.getSceneStack().push(new GameScene(gameWindows));
            }
        };
        try {
            start.setImage(ImageIO.read(new File("Resources/Menu/start.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameWindows.getMouseListenerStack().push(start.getMouseListener());
    }



    public void draw(Graphics g) {
        menuBackground.draw(g);
        g.drawImage(Tool.ScaleImage(start.getImage(),scaleButton),menuBackground.getStartPos().x - Tool.ScaleImage(start.getImage(),scaleButton).getWidth()/2,menuBackground.getStartPos().y - Tool.ScaleImage(start.getImage(),scaleButton).getHeight()/2,null);
        super.draw(g);
    }

    @Override
    public void update() {
        menuBackground.update();
        time += 0.05;
        scaleButton = 0.9 + 0.05*Math.cos(2*Math.PI/3*time);
        super.update();
    }
}
