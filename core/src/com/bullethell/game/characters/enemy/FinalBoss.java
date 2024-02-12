package com.bullethell.game.characters.enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class FinalBoss implements EnemyCharacter{
    private Vector2 position;
    private Vector2 size;
    private Texture texture;
    private Rectangle hitbox;
    private int speed;

    private List<EnemyBullet> bullets;

    public FinalBoss(float x, float y, int speed) {

        // position = new Vector2(x, y); Constants.GAME_WIDTH / 2, 100
        position = new Vector2(Constants.GAME_WIDTH / 2, 550);
        size = new Vector2(60, 60); // Adjust size as needed
        texture = new Texture("finalBoss.png"); // Adjust texture file name
        hitbox = new Rectangle(x, y, size.x, size.y);
        this.speed = speed;
        bullets = new ArrayList<>();
    }

    //    @Override
    public void update(float deltaTime) {
        // Update enemy position (e.g., move towards the player)
        position.x -= speed * deltaTime; // Adjust movement direction and speed as needed
        hitbox.setPosition(position);

        if (MathUtils.randomBoolean(0.02f)) {
            spawnBullet();
        }

        // Update bullets
        for (EnemyBullet bullet : bullets) {
            bullet.update(deltaTime);
        }

        // Remove off-screen bullets
        bullets.removeIf(bullet -> bullet.getPosition().y > Constants.GAME_HEIGHT);

        // Add more logic for enemy behavior (e.g., shooting, AI, etc.)
    }

    //    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, size.x, size.y);

        // Render bullets
        for (EnemyBullet bullet : bullets) {
            bullet.render(batch);
        }
    }
    private void spawnBullet() {
        EnemyBullet bullet = new EnemyBullet(position.x + size.x / 2, position.y, -200); // Adjust speed as needed
        bullets.add(bullet);
    }

    // @Override
    public void dispose() {
        texture.dispose(); // Dispose of the texture when done
    }

}
