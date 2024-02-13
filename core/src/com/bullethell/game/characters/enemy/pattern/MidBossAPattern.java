package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.Map;
import com.bullethell.game.characters.entity.Entity;

import java.util.List;

public class MidBossAPattern implements EnemyPattern {

    @Override
    public void addEnemy(List<Entity> entities, Map map) {
        entities.add(characters.createMidEnemyOne(400, 800, map, 1));
    }

}
