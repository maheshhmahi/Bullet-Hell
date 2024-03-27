package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootingAction;

import java.util.List;

public class MidBossBBullet extends Bullet {

    public MidBossBBullet(float x, float y, float dx, float dy, int speed, List<ShootingAction> shootingActions) {
        super(x, y);
        this.setSpeed(speed);
        this.setShootingAction(shootingActions);
        setDx(dx);
        setDy(dy);
    }
}
