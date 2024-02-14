package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.Map;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.utils.Constants;

import java.util.List;

public class GeneralEnemyaPattern implements EnemyPattern {

    @Override
    public void addEnemy(List<Entity> entities, Map map) {
        entities.add(characters.createGeneralEnemyOne(800, 700, map));
        entities.add(characters.createGeneralEnemyOne(700, 600, map));
        entities.add(characters.createGeneralEnemyOne(600, 500, map));
        entities.add(characters.createGeneralEnemyOne(500, 400, map));
    }

}
