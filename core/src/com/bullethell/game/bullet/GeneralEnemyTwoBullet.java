package com.bullethell.game.bullet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bullethell.game.utils.Constants;

public class GeneralEnemyTwoBullet {
    private Vector2 position;
    private Vector2 size;
    private Texture texture;
    private Rectangle hitbox;
    private float speedX;
    private float speedY;

    public GeneralEnemyTwoBullet(float x, float y, float speedX, float speedY) {
        position = new Vector2(x, y);
        size = new Vector2(10, 10); // Adjust size as needed
        texture = new Texture("finalBossFire.png"); // Adjust texture file name
        hitbox = new Rectangle(x, y, size.x, size.y);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public boolean isOffScreen(float screenHeight) {
        return position.y > screenHeight || position.y < 0 || position.x < 0 || position.x > Constants.GAME_WIDTH;
    }

    public void update(float deltaTime) {
        position.y += speedY * deltaTime;
        position.x += speedX * deltaTime;
        hitbox.setPosition(position);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, size.x, size.y);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Vector2 getPosition() {
        return position;
    }
}
