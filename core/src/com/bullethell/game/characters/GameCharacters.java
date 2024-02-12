package com.bullethell.game.characters;

import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;
import com.bullethell.game.characters.enemy.GeneralEnemyOne;

public abstract class GameCharacters {

    public abstract Hero createHero();
    public abstract GeneralEnemyOne createGeneralEnemyOne();
    public abstract GeneralEnemyTwo createGeneralEnemyTwo();

    public abstract EnemyBullet createGeneralBullet();

    public abstract MidEnemyOne createMidEnemyOne();
    public abstract MidEnemyTwo createMidEnemyTwo();
    public abstract FinalBoss createFinalBoss();

}
