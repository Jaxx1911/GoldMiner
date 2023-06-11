package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Rope;
import engine.windows.node.Object.Taker;
import engine.windows.node.Object.Underground.Diamond;
import engine.windows.node.background.GameBackground;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GameScene extends Scene{

    GameBackground gameBackground;
    Taker taker;
    int boom;
    KeyListener keyListener;
    Position position = new Position(0,0);
    Rope rope;

    Diamond diamond;
    public GameScene(GameWindows gameWindows) {
        super(gameWindows);
        listGameObject = new ArrayList<>();
        gameBackground = new GameBackground();
        taker = new Taker(new Position(700,150));
        boom = 0;
        diamond = new Diamond(new Position(800,400),taker);

        listGameObject.add(taker);
        listGameObject.add(new Rope(new Position(700,200),taker));
        listGameObject.add(diamond);


        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){

                    case KeyEvent.VK_ENTER:
                        if(taker.isOscillate()) {
                            taker.setOscillate(false);
                            taker.setThrowing(true);
                            position = taker.getPosition();
                        }
                        taker.setThrowingPoint(position);
                        break;
                }
            }
        };
    }

    @Override
    public void draw(Graphics g) {
        gameBackground.draw(g);
        g.setColor(Color.CYAN);
        g.fillRect((int)taker.getOrgPos().x + taker.getImage().getWidth()/2,(int)taker.getOrgPos().y,1,1);
        super.draw(g);
        //System.out.println(taker.isThrowing()+" "+taker.isOscillate()+" "+taker.isPulling()+" "+taker.isTaked());
        System.out.println(taker.getAngle()+" "+taker.isOscillate() +" "+taker.isThrowing()+" "+taker.isPulling());
    }

    @Override
    public void update() {
        super.update();
        checkCollide();
        removeDestroyedGameObjects();
    }

    public KeyListener getKeyListener() {
        return keyListener;
    }

    private void removeDestroyedGameObjects() {
        List<GameObject> destroyedObjects = new ArrayList<>();
        for (GameObject gameObject : listGameObject) {
            if (gameObject.getStatus()) {
                destroyedObjects.add(gameObject);
            }
        }
        listGameObject.removeAll(destroyedObjects);
    }

    void checkCollide() {
        for (int i = 0; i < listGameObject.size(); i++) {
            for (int j = i + 1; j < listGameObject.size(); j++) {
                GameObject gameObjectA = listGameObject.get(i);
                GameObject gameObjectB = listGameObject.get(j);
                if (gameObjectA.isCollide(gameObjectB)) {
                    gameObjectA.collideWith(gameObjectB);
                    gameObjectB.collideWith(gameObjectA);
                }
            }
        }
    }
}
