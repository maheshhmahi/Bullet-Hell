package com.bullethell.game.characters.enemy.factory;

import com.bullethell.game.characters.enemy.EnemyTwo;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

public class EnemyTwoFactory extends EnemyFactory{

    public EnemyTwoFactory(int posX, int posY, Map map) {
        this.setPosX(posX);
        this.setPosY(posY);
        this.setMap(map);
    }


    @Override
    public Entity createEnemy() {
        return new EnemyTwo(getPosX(), getPosY(), getMap());
    }
}

