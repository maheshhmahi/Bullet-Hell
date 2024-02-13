package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShootAround implements ShootingAction{

    boolean remove = false;
    float x, y;
    float dx, dy;

    public ShootAround(float x, float y, float dx, float dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy =dy;
    }

    @Override
    public void shoot(float deltaTime, int speed) {
        this.x += speed * dx *  deltaTime;
        this.y += speed * dy * deltaTime;
        if(y > Gdx.graphics.getHeight() || x > Gdx.graphics.getWidth() || x < 0 || y < 0) {
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch, Texture image) {
        batch.draw(image, this.x, this.y);
    }
}
