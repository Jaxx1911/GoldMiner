package engine.windows.node.scenes;

import engine.windows.GameLevel.Level;
import engine.windows.GameLevel.Level1;
import engine.windows.GameWindows;
import engine.windows.Score;
import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Human;
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

    Human human;
    int boom;
    KeyListener keyListener;
    Position position = new Position(0,0);
    Rope rope;
    Level1 level1;
    ArrayList listDiamond = new ArrayList<>();



    int time = 60;
    int tick = 0;
    int moneyRaise = 0;
    int money = 0;
    Score moneyScore, timeScore,bombNum;

    public GameScene(GameWindows gameWindows) {
        super(gameWindows);
        this.initTaker();
        this.initLevel(this.taker);
        this.initBackground();
        this.initGameObj();
        this.addKeyListener();
        this.initScore();
    }
    public void initScore(){
        timeScore = new Score(time,new Position(1300,65));
        moneyScore = new Score(money, new Position(1300,115));
        bombNum = new Score(boom,new Position(955,100));
    }

    public void initLevel(Taker taker) {
        level1 = new Level1(taker);
    }

    public void initBackground() {
        gameBackground = new GameBackground();
        human = new Human(taker);
    }

    public void initTaker() {
        taker = new Taker(new Position(700,150));
        rope = new Rope(new Position(700, 200), taker);
        boom = 5;
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
                    case KeyEvent.VK_UP:
                        if(taker.isPulling()==true&& boom > 0&&taker.isTaken()==true){
                            boom--;
                            bombNum.setN(boom);
                            taker.setPrice(0);
                            taker.reset();
                        }
                        break;
                }
            }
        };
    }

    @Override
    public void draw(Graphics g) {
        gameBackground.draw(g);
        human.draw(g);
        super.draw(g);
        drawNum(g);
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
        tickRaise();
        timeCount();
        isTaken();
    }
    //------Bộ đếm thời gian------//
    public void timeCount(){
        if(tick%60==0){
            this.timeScore.addNumber(-1);
            this.time -=1;
        }
    }
    public void tickRaise(){
        this.tick +=1;
    }
    //-------Kiểm tra đã gắp thành công------//
    public void isTaken(){
        if(taker.isOscillate()){
            this.money+=taker.getPrice();
            this.moneyScore.setN(money);
            taker.setPrice(0);
        }
    }
    public void drawNum(Graphics g){
        moneyScore.draw(g);
        timeScore.draw(g);
        bombNum.draw(g);
    }
}
