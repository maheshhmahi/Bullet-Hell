package com.bullethell.game.characters;

import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;
import com.bullethell.game.utils.Constants;

public class BulletHellCharacters extends GameCharacters{

    @Override
    public Hero createHero() {
        return new Hero();
    }

    @Override
    public GeneralEnemyOne createGeneralEnemyOne() {
        return new GeneralEnemyOne();
    }

    @Override
    public GeneralEnemyTwo createGeneralEnemyTwo() {
        return new GeneralEnemyTwo();
    }

    @Override
    public MidEnemyOne createMidEnemyOne() {
        return new MidEnemyOne();
    }

    @Override
    public MidEnemyTwo createMidEnemyTwo() {
        return new MidEnemyTwo();
    }

    @Override
    public FinalBoss createFinalBoss() {
        return new FinalBoss(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2, 0);
    }
}
