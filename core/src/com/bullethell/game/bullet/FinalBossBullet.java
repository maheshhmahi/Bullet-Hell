package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootingAction;

import java.util.List;

public class FinalBossBullet extends Bullet {

    // Constructor
    public FinalBossBullet(float x, float y, int speed, List<ShootingAction> actions) {
        // Call superclass constructor with x and y coordinates
        super(x, y);

        // Set the speed of the bullet
        setSpeed(speed);

        // Set the shooting actions for the bullet
        setShootingAction(actions);
    }
}
