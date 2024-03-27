package com.bullethell.game.characters.enemy.factory;

import com.bullethell.game.characters.enemy.MidEnemyTwo;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

public class MidBossbFactory extends EnemyFactory {

    public MidBossbFactory(int posX, int posY, Map map) {
        this.setPosX(posX);
        this.setPosY(posY);
        this.setMap(map);
    }

    @Override
    public Entity createEnemy() {
        return new MidEnemyTwo(getPosX(), getPosY(), getMap());
    }
}
