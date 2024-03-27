package com.bullethell.game.characters.enemy;

import com.bullethell.game.characters.enemy.factory.EnemyAFactory;
import com.bullethell.game.characters.enemy.factory.EnemyFactory;
import com.bullethell.game.characters.enemy.factory.MidBossbFactory;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

public class EnemyCharacter {

    EnemyFactory factory;
    private volatile static EnemyCharacter enemyCharacter = null;

    public EnemyCharacter() {

    }

    public static EnemyCharacter getInstance() {
        if (enemyCharacter == null) {
            synchronized (EnemyCharacter.class) {
                if (enemyCharacter == null) {
                    enemyCharacter = new EnemyCharacter();
                }
            }
        }
        return enemyCharacter;
    }

    public Entity createMidBossB(int posX, int posY, Map map) {
        factory = new MidBossbFactory(posX, posY, map);
        return factory.createEnemy();
    }

    public Entity createEnemyA(int posX, int posY, Map map, int direction) {
        factory = new EnemyAFactory(posX, posY, map, direction);
        return factory.createEnemy();
    }

}
