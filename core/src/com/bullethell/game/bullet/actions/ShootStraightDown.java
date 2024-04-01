package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ShootStraightDown implements ShootingAction{

    boolean remove = false;
    float x, y;

    Sprite sprite;
    Rectangle hitbox;


    public ShootStraightDown(float x, float y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.hitbox = new Rectangle(x, y, 10, 10);
    }

    @Override
    public void shoot(float deltaTime, int speed) {
        sprite.translateY(-speed * deltaTime);
        y = sprite.getY();
        hitbox.setPosition(x, y);
        sprite.setPosition(x, y);

        if(sprite.getY() < Gdx.graphics.getHeight()) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }

    public Rectangle getHitBox() {
        return hitbox;
    }
}
