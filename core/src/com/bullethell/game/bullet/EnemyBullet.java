// EnemyBullet.java
package com.bullethell.game.bullet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class EnemyBullet {
    private Vector2 position;
    private Vector2 size;
    private Texture texture;
    private Rectangle hitbox;
    private float speed;

    private float speedX;


    public EnemyBullet(float x, float y, float speed) {
        position = new Vector2(x, y);
        size = new Vector2(10, 10); // Adjust size as needed
        texture = new Texture("finalBossFire.png"); // Adjust texture file name
        hitbox = new Rectangle(x, y, size.x, size.y);
        this.speed = speed;
    }

    public void update(float deltaTime) {
        // Update bullet position (e.g., move upwards)
        position.y += speed * deltaTime;
        position.x += speedX * deltaTime; // Update horizontal position
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

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

}
