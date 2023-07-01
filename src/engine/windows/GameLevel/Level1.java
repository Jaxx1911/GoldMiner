package engine.windows.GameLevel;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.GameObject;
import engine.windows.node.Object.Taker;
import engine.windows.node.Object.Underground.Diamond;
import engine.windows.node.Object.Underground.Gold;
import javafx.util.Pair;
import sun.net.www.content.text.Generic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Level1 extends Level{
    Diamond diamond;
    Gold gold;
    Taker taker;
    ArrayList<Pair<Integer, Integer>> pos = new ArrayList<Pair<Integer, Integer>>();
    public Level1(Taker taker) {
        super();
        this.taker = taker;
        this.initGold();
    }

    public void initGold() {
        this.matrixPosition();
        int n = 5;
        while (n != 0){
            int length = this.pos.size();
            int flag = (int) (Math.random() * length);
            int x = this.pos.get(flag).getKey();
            int y = this.pos.get(flag).getValue();
            gold = new Gold("small", new Position(x, y), taker);
            listUObject.add(gold);
            n-=1;
            this.pos.remove(flag);
        }
    }
    public void matrixPosition() {
        for(Integer i = 0; i < 1440; i += 36) {
            for(Integer j = 300; j < 764; j += 32) {
                Pair<Integer, Integer> tmp = new Pair<>(i, j);
                pos.add(tmp);
            }
        }
    }
}
