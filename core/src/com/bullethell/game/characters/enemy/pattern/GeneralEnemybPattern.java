package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.Map;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.utils.Constants;

import java.util.List;

public class GeneralEnemybPattern implements EnemyPattern {

    @Override
    public void addEnemy(List<Entity> entities, Map map) {
        entities.add(characters.createGeneralEnemyTwo(500, 700, map));
        entities.add(characters.createGeneralEnemyTwo(600, 700, map));
        entities.add(characters.createGeneralEnemyTwo(700, 700, map));
        entities.add(characters.createGeneralEnemyTwo(800, 700, map));
    }

}