package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootingAction;

import java.util.List;

public class EnemyOneBullet extends Bullet {
    public EnemyOneBullet(float x, float y, float dx, float dy, int speed, List<ShootingAction> actions) {
        super(x, y);
        setSpeed(speed);
        setShootingAction(actions);
        setDx(dx);
        setDy(dy);
    }


}
