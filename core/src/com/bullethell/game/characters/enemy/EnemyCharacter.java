package com.bullethell.game.characters.enemy;

import com.bullethell.game.characters.enemy.factory.EnemyFactory;
import com.bullethell.game.characters.enemy.factory.MidBossbFactory;
import com.bullethell.game.characters.enemy.factory.EnemyOneFactory;
import com.bullethell.game.characters.enemy.factory.EnemyTwoFactory;
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

    public Entity createEnemyOne(int posX, int posY, Map map, int direction) {
        factory = new EnemyOneFactory(posX, posY, map, direction);
        return factory.createEnemy();
    }

    public Entity createEnemyTwo(int posX, int posY, Map map) {
        factory = new EnemyTwoFactory(posX, posY, map);
        return factory.createEnemy();
    }

    public Entity createMidBossB(int posX, int posY, Map map) {
        factory = new MidBossbFactory(posX, posY, map);
        return factory.createEnemy();
    }

}
