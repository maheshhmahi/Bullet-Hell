package com.bullethell.game.Algorithms.EnemyMovePattern;

import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.characters.enemy.EnemyOne;

public abstract class EnemyMovePattern {
    protected long initTime;
    protected  long dTimeToRetrieve;

    public EnemyMovePattern(int attackingDuration)
    {
        initTime = TimeUtils.millis();
        dTimeToRetrieve = attackingDuration;
    }

    public abstract void applyMovePattern(EnemyOne entity);
    
}
