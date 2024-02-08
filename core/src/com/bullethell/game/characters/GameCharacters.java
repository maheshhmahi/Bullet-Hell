package com.bullethell.game.characters;

import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;

public abstract class GameCharacters {

    protected abstract Hero createHero();
    protected abstract GeneralEnemyOne createGeneralEnemyOne();
    protected abstract GeneralEnemyTwo createGeneralEnemyTwo();
    protected abstract MidEnemyOne createMidEnemyOne();
    protected abstract MidEnemyTwo createMidEnemyTwo();
    protected abstract FinalBoss createFinalBoss();

}
