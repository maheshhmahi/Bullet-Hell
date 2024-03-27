package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootingAction;

import java.util.List;

public class EnemyTwoBullet extends Bullet{

    public EnemyTwoBullet(float x, float y, int speed, List<ShootingAction> actions) {
        super(x, y);
        setSpeed(speed);
        setShootingAction(actions);
    }


}

