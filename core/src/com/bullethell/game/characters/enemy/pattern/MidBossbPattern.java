package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.Map;
import com.bullethell.game.characters.entity.Entity;

import java.util.List;

public class MidBossbPattern implements EnemyPattern {

    @Override
    public void addEnemy(List<Entity> entities, Map map) {
        entities.add(characters.createMidEnemyTwo(200, 800, map));
        entities.add(characters.createFinalBoss(200, 800, map));
    }

}
