package com.bullethell.game.characters.enemy.factory;

import com.bullethell.game.characters.enemy.FinalBoss;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

public class FinalBossFactory extends EnemyFactory{


    public FinalBossFactory(int posX, int posY, Map map) {
        this.setPosX(posX);
        this.setPosY(posY);
        this.setMap(map);
    }

    @Override
    public Entity createEnemy() {
        return new FinalBoss(getPosX(), getPosY(), getMap());
    }
}
