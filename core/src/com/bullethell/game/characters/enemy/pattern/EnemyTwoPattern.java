package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.world.Map;
import com.bullethell.game.characters.entity.Entity;

import java.util.List;

public class EnemyTwoPattern implements EnemyPattern {


    //@Override
    // public void addEnemy(List<Entity> entities, Map map) {
    //     entities.add(characters.createEnemyTwo(200, 800, map));
    // }
    @Override
    public void addEnemy(List<Entity> entities, Map map) {

        entities.add(characters.createEnemyOne(300, 820, map, 4));
        entities.add(characters.createEnemyOne(100, 820, map, 4));

        entities.add(characters.createEnemyOne(480, 600, map, 1));
        entities.add(characters.createEnemyOne(-100, 500, map, 2));

        entities.add(characters.createEnemyTwo(-200, 600, map));
        entities.add(characters.createEnemyTwo(680, 500, map));
    }

    
}
