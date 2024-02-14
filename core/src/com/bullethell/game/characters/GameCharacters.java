package com.bullethell.game.characters;

import com.bullethell.game.Map;
import com.bullethell.game.bullet.EnemyBullet;
import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;
import com.bullethell.game.characters.enemy.GeneralEnemyOne;

public abstract class GameCharacters {

    public abstract Hero createHero(float x, float y, Map map);
    public abstract GeneralEnemyOne createGeneralEnemyOne(int posX, int posY, Map map);
    public abstract GeneralEnemyTwo createGeneralEnemyTwo();

    public abstract EnemyBullet createGeneralBullet();

    public abstract MidEnemyOne createMidEnemyOne(int posX, int posY, Map map, int direction);
    public abstract MidEnemyTwo createMidEnemyTwo(int posX, int posY, Map map);
    public abstract FinalBoss createFinalBoss(int posX, int posY, Map map);

}
