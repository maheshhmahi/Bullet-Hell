package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ShootAround implements ShootingAction{

    boolean remove = false;
    float x, y;
    float dx, dy;

    Sprite sprite;
    Rectangle hitbox;

    public ShootAround(float x, float y, float dx, float dy, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy =dy;
        this.sprite = sprite;
        this.hitbox = new Rectangle(x, y, 10, 10);
    }

    @Override
    public void shoot(float deltaTime, int speed) {
        sprite.translateX(speed * dx *  deltaTime);
        sprite.translateY(speed * dy * deltaTime);
        x = sprite.getX();
        y = sprite.getY();
        hitbox.setPosition(x, y);
        sprite.setPosition(x, y);

        if(sprite.getY() > Gdx.graphics.getHeight() || sprite.getX() > Gdx.graphics.getWidth() || sprite.getX() < 0 || sprite.getY() < 0) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }

    @Override
    public Rectangle getHitBox() {
        return hitbox;
    }

}
