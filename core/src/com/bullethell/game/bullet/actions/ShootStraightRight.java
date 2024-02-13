package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShootStraightRight implements ShootingAction{

    boolean remove = false;
    float x, y;
    float dx, dy;

    public ShootStraightRight(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void shoot(float deltaTime, int speed) {
        this.x += speed * deltaTime * (int)(Math.random()*25);
        this.y -= speed * deltaTime * (int)(Math.random()*5);
        if(x > Gdx.graphics.getWidth()) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch, Texture image) {
        batch.draw(image, this.x, this.y);
    }
}
