package com.bullethell.game.characters.enemy.factory;

import com.bullethell.game.characters.enemy.EnemyOne;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

public class EnemyOneFactory extends EnemyFactory {


    public EnemyOneFactory(int posX, int posY, Map map, int direction) {
        this.setPosX(posX);
        this.setPosY(posY);
        this.setMap(map);
        this.setDirection(direction);
    }


    @Override
    public Entity createEnemy() {
        return new EnemyOne(getPosX(), getPosY(), getMap(), getDirection());
    }
}
