package com.bullethell.game.characters.enemy.factory;

import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

public abstract class EnemyFactory {
    protected int posX;
    protected int posY;
    protected Map map;
    protected int direction;

    public abstract Entity createEnemy();

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Map getMap() {
        return map;
    }

    public int getDirection() {
        return direction;
    }
}
