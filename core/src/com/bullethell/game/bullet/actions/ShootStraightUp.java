package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ShootStraightUp implements ShootingAction{

    boolean remove = false;
    float x, y;
    Rectangle hitbox;
    Sprite sprite;

    public ShootStraightUp(float x, float y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.hitbox = new Rectangle(x, y, 10, 10);
        this.sprite = sprite;
    }

    @Override
    public void shoot(float deltaTime, int speed) {

        sprite.translateY(speed * deltaTime);
        y = sprite.getY();
        hitbox.setPosition(x, y);
        sprite.setPosition(x, y);

        if(sprite.getY() > Gdx.graphics.getHeight()) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public Rectangle getHitBox() {
        return hitbox;
    }
}
