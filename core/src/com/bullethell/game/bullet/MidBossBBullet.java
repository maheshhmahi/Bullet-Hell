package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootingAction;

public class MidBossBBullet extends Bullet{

    public MidBossBBullet(float x, float y,float dx, float dy, int speed, String image, ShootingAction action) {
        super(x, y);
        this.setSpeed(speed);
        this.setTexture(image);
        this.setShootingAction(action);
        this.setDx(dx);
        this.setDy(dy);
    }
}
