package com.bullethell.game.characters.enemy.pattern;

import com.bullethell.game.world.Map;
import com.bullethell.game.characters.BulletHellCharacters;
import com.bullethell.game.characters.entity.Entity;

import java.util.List;

public interface EnemyPattern {

    BulletHellCharacters characters = new BulletHellCharacters();

    void addEnemy(List<Entity> entities, Map map);

}
