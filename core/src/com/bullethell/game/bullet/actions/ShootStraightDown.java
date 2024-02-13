package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShootStraightDown implements ShootingAction{

    boolean remove = false;
    float x, y;

    public ShootStraightDown(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void shoot(float deltaTime, int speed) {
        y -= speed * deltaTime;
        if(this.y < Gdx.graphics.getHeight()) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch, Texture image) {
        batch.draw(image, this.x, this.y);
    }
}
