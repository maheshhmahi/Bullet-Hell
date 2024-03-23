package com.bullethell.game.bullet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.bullet.actions.ShootingAction;
import com.bullethell.game.utils.Constants;

public abstract class Bullet {
//    protected Rectangle bulletx;
//    protected int speed;
//    protected static int DEFAULT_Y = 40;
//    protected Texture texture;
//    public boolean remove = false;
//    float x, y;
//    float dx, dy;
//    ShootingAction shootingAction;
//
//    public Bullet(float x, float y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public void setTexture(String imgPath) {
//        this.texture = new Texture(imgPath);
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setRemove(boolean remove) {
//        this.remove = remove;
//    }
//
//    public void update(float deltaTime) {
//        this.shootingAction.shoot(deltaTime, speed);
//    }
//
//    public void setShootingAction(ShootingAction shootingAction) {
//        this.shootingAction = shootingAction;
//    }
//
//    public void render(SpriteBatch batch) {
//        this.shootingAction.render(batch, texture);
//    }
//
//    public void setDx(float dx) {
//        this.dx = dx;
//    }
//
//    public void setDy(float dy) {
//        this.dy = dy;
//    }
protected Texture texture;
    protected Vector2 size;
    protected Vector2 pos;
    protected long initTime;
    protected Rectangle hitbox;
    protected int damage;

    public Bullet()
    {
        pos = new Vector2();
        size = new Vector2();
        initTime = TimeUtils.millis();
        hitbox = new Rectangle();
        damage = 5;
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y, size.x, size.y);
    }

    public void setPos(float x, float y)
    {
        this.pos.x = x;
        this.pos.y = y;
        hitbox.setPosition(x,y);
    }

    public Vector2 getPos()
    {
        return pos;
    }

    public void dispose()
    {
        texture.dispose();
    }

    public boolean outOfBorder(int pixels)
    {
        return (pos.x+size.x < -pixels || pos.y+size.y < -pixels ||
                pos.x > Constants.GAME_WIDTH + pixels ||
                pos.y > Constants.GAME_HEIGHT + pixels);
    }

    public long getInitTime()
    {
        return initTime;
    }

    public Rectangle getHitbox()
    {
        return hitbox;
    }

    public int getDamage()
    {
        return damage;
    }
}

