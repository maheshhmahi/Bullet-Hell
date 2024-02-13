package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ShootingAction {

    void shoot(float deltaTime, int speed);

    void render(SpriteBatch batch, Texture image);
}
