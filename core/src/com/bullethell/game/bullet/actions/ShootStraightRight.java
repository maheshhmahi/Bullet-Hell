package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ShootStraightRight implements ShootingAction{

    boolean remove = false;
    float x, y;
    Sprite sprite;
    Rectangle hitbox;

    public ShootStraightRight(float x, float y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.hitbox = new Rectangle(x, y, 10, 10);
    }

    @Override
    public void shoot(float deltaTime, int speed) {
        sprite.translateX(speed * deltaTime * (int)(Math.random()*25));
        sprite.translateY(-speed * deltaTime * (int)(Math.random()*5));
        x = sprite.getX();
        y = sprite.getY();
        hitbox.setPosition(x, y);
        sprite.setPosition(x, y);

        if(sprite.getX() > Gdx.graphics.getWidth()) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public Rectangle getHitBox() {
        return hitbox;
    }
}
