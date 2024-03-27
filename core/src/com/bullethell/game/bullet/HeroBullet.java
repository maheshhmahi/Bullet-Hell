package com.bullethell.game.bullet;


import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.bullet.actions.ShootingAction;

import java.util.List;

public class HeroBullet extends Bullet {
    public HeroBullet(float x, float y, int speed, List<ShootingAction> actions, Rectangle hitbox) {
        super(x,y);
        setSpeed(speed);
        setShootingAction(actions);
        setHitbox(hitbox);
    }

}