package com.bullethell.game.characters;

import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;
import com.bullethell.game.utils.Constants;

public class BulletHellCharacters extends GameCharacters {
    // Implement all abstract methods declared in GameCharacters

    @Override
    public Hero createHero() {
        // Implement this method as needed
        return new Hero();
    }

    @Override
    public GeneralEnemyOne createGeneralEnemyOne() {
        // Implement this method as needed
        return new GeneralEnemyOne(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2, 10);
    }

    @Override
    public GeneralEnemyTwo createGeneralEnemyTwo() {
        // Implement this method as needed
        return new GeneralEnemyTwo(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2, 0);
    }

    @Override
    public EnemyBullet createGeneralBullet() {
        // Implement this method as needed
        return new EnemyBullet(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2, 0);
    }

    @Override
    public MidEnemyOne createMidEnemyOne() {
        // Implement this method as needed
        return new MidEnemyOne();
    }

    @Override
    public MidEnemyTwo createMidEnemyTwo() {
        // Implement this method as needed
        return new MidEnemyTwo();
    }

    @Override
    public FinalBoss createFinalBoss() {
        // Implement this method as needed
        return new FinalBoss();
    }
}