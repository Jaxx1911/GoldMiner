package engine.windows.GameLevel;

import engine.windows.GameWindows;
import engine.windows.node.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {
//    List<GameObject> listDiamond = new ArrayList<>();
//    List<GameObject> listGold = new ArrayList<>();
//    List<GameObject> listPig = new ArrayList<>();
//    List<GameObject> listBag = new ArrayList<>();
    List<GameObject> listUObject;
    GameWindows gameWindows;
    public Level() {
        listUObject = new ArrayList<>();
    }
    public void draw(Graphics g) {
        for(GameObject gameObject: listUObject) {
            gameObject.draw(g);
        }
    }

    public List<GameObject> getListUObject() {
        return listUObject;
    }

    public void update() {
        for(GameObject gameObject: listUObject) {
            gameObject.update();
        }
    }
}
