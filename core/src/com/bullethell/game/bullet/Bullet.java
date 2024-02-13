package com.bullethell.game.bullet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.bullet.actions.ShootingAction;

public abstract class Bullet {
    protected Rectangle bulletx;
    protected int speed;
    protected static int DEFAULT_Y = 40;
    protected Texture texture;
    public boolean remove = false;
    float x, y;
    float dx, dy;
    ShootingAction shootingAction;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setTexture(String imgPath) {
        this.texture = new Texture(imgPath);
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
        this.shootingAction.shoot(deltaTime, speed);
    }

    public void setShootingAction(ShootingAction shootingAction) {
        this.shootingAction = shootingAction;
    }

    public void render(SpriteBatch batch) {
        this.shootingAction.render(batch, texture);
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }
}
