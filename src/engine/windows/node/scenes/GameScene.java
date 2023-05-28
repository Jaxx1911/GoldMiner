package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Rope;
import engine.windows.node.Object.Taker;
import engine.windows.node.background.GameBackground;

import java.awt.*;
import java.util.ArrayList;

public class GameScene extends Scene{

    GameBackground gameBackground;
    Taker taker;

    Rope rope;
    public GameScene(GameWindows gameWindows) {
        super(gameWindows);
        listGameObject = new ArrayList<>();
        gameBackground = new GameBackground();
        taker = new Taker(new Position(300,200));
        listGameObject.add(taker);
        listGameObject.add(new Rope(new Position(300,195),taker));
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void update() {
        super.update();
    }
}
