package com.bullethell.game.characters;

import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;

public class BulletHellCharacters extends GameCharacters{

    @Override
    protected Hero createHero() {
        return new Hero();
    }

    @Override
    protected GeneralEnemyOne createGeneralEnemyOne() {
        return new GeneralEnemyOne();
    }

    @Override
    protected GeneralEnemyTwo createGeneralEnemyTwo() {
        return new GeneralEnemyTwo();
    }

    @Override
    protected MidEnemyOne createMidEnemyOne() {
        return new MidEnemyOne();
    }

    @Override
    protected MidEnemyTwo createMidEnemyTwo() {
        return new MidEnemyTwo();
    }

    @Override
    protected FinalBoss createFinalBoss() {
        return new FinalBoss();
    }
}
