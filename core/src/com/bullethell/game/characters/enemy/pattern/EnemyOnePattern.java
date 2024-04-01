package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.world.Map;
import com.bullethell.game.characters.entity.Entity;

import java.util.List;

public class EnemyOnePattern implements EnemyPattern {

    @Override
    public void addEnemy(List<Entity> entities, Map map) {

        entities.add(characters.createEnemyOne(300, 800, map, 4));
        entities.add(characters.createEnemyOne(100, 800, map, 4));
        entities.add(characters.createEnemyTwo(-200, 600, map));

        
    }

    
}
