package com.bullethell.game.bullet;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.bullet.actions.ShootingAction;
import com.bullethell.game.characters.entity.Entity;

import java.util.List;

public abstract class Bullet {

    protected Rectangle hitbox;
    protected Sprite sprite;
    protected int speed;
    public boolean remove = false;
    float x, y;
    float dx, dy;
    List<ShootingAction> shootingActions;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }


    public void update(float deltaTime) {

        for (ShootingAction action: shootingActions) {
            action.shoot(deltaTime, speed);
        }
    }

    public void setShootingAction(List<ShootingAction> shootingActions) {
        this.shootingActions = shootingActions;
    }

    public void render(SpriteBatch batch) {
        for (ShootingAction action: shootingActions) {
            action.render(batch);
        }
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public Rectangle getArea() {
        for (ShootingAction action: shootingActions) {
            return action.getHitBox();
        }
        return null;
    }


    //reorganized
    public boolean collideWith(Entity entity) {
        Rectangle rect1 = getArea();
        Rectangle rect2 = entity.getArea();
        return rect1.overlaps(rect2);
    }

}
