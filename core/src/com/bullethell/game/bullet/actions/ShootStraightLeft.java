package com.bullethell.game.bullet.actions;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ShootStraightLeft implements ShootingAction {

    // Instance variables
    private boolean remove = false;
    private float x, y;
    private Sprite sprite;
    private Rectangle hitbox;

    // Constructor
    public ShootStraightLeft(float x, float y, Sprite sprite) {
        // Initialize coordinates and sprite
        this.x = x;
        this.y = y;
        this.sprite = sprite;

        // Initialize hitbox
        this.hitbox = new Rectangle(x, y, 10, 10);
    }
    // Shoot method implementation
    @Override
    public void shoot(float deltaTime, int speed) {
        // Calculate random displacement
        float randomX = -speed * deltaTime * (int)(Math.random() * 25);
        float randomY = -speed * deltaTime * (int)(Math.random() * 5);
        // Translate sprite
        sprite.translate(randomX, randomY);

        // Update position variables
        x = sprite.getX();
        y = sprite.getY();// Update hitbox position to match sprite
        hitbox.setPosition(x, y);

        // Set remove flag if sprite goes off-screen
        if (sprite.getX() < 0) {
            remove = true;
        }
    }

    // Render method implementation
    @Override
    public void render(SpriteBatch batch) {
        // Set sprite position and draw it
        sprite.setPosition(x, y);
        sprite.draw(batch);
    }

    // Getter method for hitbox
    public Rectangle getHitBox() {
        return hitbox;
    }
}