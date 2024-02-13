package com.bullethell.game.characters;

import com.bullethell.game.bullet.EnemyBullet;
import com.bullethell.game.Map;
import com.bullethell.game.characters.enemy.*;
import com.bullethell.game.characters.hero.Hero;
import com.bullethell.game.utils.Constants;

public class BulletHellCharacters extends GameCharacters {
    // Implement all abstract methods declared in GameCharacters

    @Override
    public Hero createHero(float x, float y, Map map) {
        // Implement this method as needed
        return new Hero(x, y, map);
    }

    @Override
    public GeneralEnemyOne createGeneralEnemyOne(int posX, int posY, Map map) {
        // Implement this method as needed
        return new GeneralEnemyOne(posX, posY, map);
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
    public MidEnemyOne createMidEnemyOne(int posX, int posY, Map map, int direction) {
        // Implement this method as needed
        return new MidEnemyOne(posX, posY, map, direction);
    }

    @Override
    public MidEnemyTwo createMidEnemyTwo(int posX, int posY, Map map) {
        // Implement this method as needed
        return new MidEnemyTwo(posX, posY, map);
    }

    @Override
    public FinalBoss createFinalBoss() {
        return new FinalBoss(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2, 0);
    }
}
