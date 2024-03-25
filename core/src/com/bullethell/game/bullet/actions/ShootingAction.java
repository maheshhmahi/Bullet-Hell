package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface ShootingAction {

    void shoot(float deltaTime, int speed);

    void render(SpriteBatch batch);

    Rectangle getHitBox();
}
