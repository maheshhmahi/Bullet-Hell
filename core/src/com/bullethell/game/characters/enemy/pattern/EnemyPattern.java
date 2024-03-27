package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.characters.enemy.EnemyCharacter;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.world.Map;

import java.util.List;

public interface EnemyPattern {

    EnemyCharacter characters = new EnemyCharacter();

    void addEnemy(List<Entity> entities, Map map);

}
