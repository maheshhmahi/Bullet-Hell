package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

import java.util.List;

import java.util.List;

public class FinalBossPattern implements EnemyPattern {

    // Implementation of the addEnemy method
    @Override
    public void addEnemy(List<Entity> entities, Map map) {
        // Create a FinalBoss entity and add it to the list of entities
        // The parameters 200, 800 represent the initial position of the FinalBoss
        // The 'characters' object is assumed to be accessible and capable of creating a FinalBoss entity
        entities.add(characters.createFinalBoss(200, 800, map));
    }
}
