package engine.windows.node.scenes;

import engine.windows.GameLevel.Level;
import engine.windows.GameWindows;
import engine.windows.Score;
import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Rope;
import engine.windows.node.Object.Taker;
import engine.windows.node.background.GameBackground;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class GameScene extends Scene{

    GameBackground gameBackground;
    Taker taker;
    int boom;
    KeyListener keyListener;
    Position position = new Position(0,0);
    Rope rope;
    Level level1;
    ArrayList listDiamond = new ArrayList<>();

    int time = 60;
    int tick = 0;
    int moneyRaise = 0;
    int money = 0;
    Score moneyScore, timeScore;

    public GameScene(GameWindows gameWindows) {
        super(gameWindows);
        this.initLevel(this.taker);
        this.initBackground();
        this.initTaker();
        this.initGameObj();
        this.addKeyListener();
        this.initScore();
    }
    public void initScore(){
        timeScore = new Score(time,new Position(1300,65));
        moneyScore = new Score(money, new Position(1300,115));
    }

    public void initLevel(Taker taker) {
        level1 = new Level(taker, 1, 0, 2, 0, 3, 5, 2 ,2, 1);
    }

    public void initBackground() {
        gameBackground = new GameBackground();
    }

    public void initTaker() {
        taker = new Taker(new Position(700,150));
        rope = new Rope(new Position(700, 200), taker);
        boom = 0;
    }

    public void initGameObj() {
        listGameObject = new ArrayList<>();
        listGameObject.add(taker);
        listGameObject.add(rope);
        for(GameObject gameObject: level1.getListUObject()) {
            listGameObject.add(gameObject);
        }
    }

    public void addKeyListener() {
        keyListener = new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }
            public void keyPressed(KeyEvent e) {

            }
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){

                    case KeyEvent.VK_DOWN:
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
      //  System.out.println(taker.getAngle()+" "+taker.isOscillate() +" "+taker.isThrowing()+" "+taker.isPulling());
        moneyScore.draw(g);
        timeScore.draw(g);
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

    public void update() {
        super.update();
        checkCollide();
        removeDestroyedGameObjects();
        tick++;
        if(tick%60==0){
            timeScore.addNumber(-1);
            time -=1;
        }
        money+=taker.getPrice();
        moneyScore.setN(money);
        taker.setPrice(0);
    }
}
