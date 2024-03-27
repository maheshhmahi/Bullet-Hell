package com.bullethell.game.bullet.factory;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.bullet.actions.ShootingAction;

import java.util.List;

public abstract class BulletFactory {

    protected float x, y;
    protected float dx, dy;
    protected List<ShootingAction> shootingActions;
    protected Rectangle rectangleBullet;
    protected Sprite sprite;

    public abstract Bullet createBullet();

    public abstract void createGraph();

    protected abstract void addShootingAction();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setStatus(String status) {

    }

}

