//package com.bullethell.game.characters.enemy;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//import com.bullethell.game.world.Map;
//import com.bullethell.game.bullet.GeneralEnemyTwoBullet;
//import com.bullethell.game.characters.entity.Entity;
//import com.bullethell.game.characters.entity.EntityType;
//import com.bullethell.game.utils.Constants;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GeneralEnemyTwo extends Entity implements EnemyCharacter {
//    private Vector2 position;
//    private Vector2 size;
//
//    private Texture texture;
//    private Rectangle hitbox;
//    private int speed;
//
//    private List<GeneralEnemyTwoBullet> bullets;
//    private float timeSinceLastBullet;
//
//    public GeneralEnemyTwo(float x, float y, Map map) {
//        super(x, y, EntityType.GEN_ENEMY_B, map);
//        position = new Vector2(x, y); // Set initial position for all enemies
//        size = new Vector2(60, 60); // Adjust size as needed
//        texture = new Texture("enemy2.png"); // Adjust texture file name
//        hitbox = new Rectangle(x, y, size.x, size.y);
//        this.speed = EntityType.GEN_ENEMY_B.getSpeed();
//        bullets = new ArrayList<>();
//        timeSinceLastBullet = 0;
//    }
//
//    public void update(float deltaTime) {
//        position.x += speed * deltaTime;
//
//        // Spawn bullets at a certain rate with random directions
//        if (MathUtils.randomBoolean(0.1f)) {
//            spawnBullet();
//        }
//
//        // Update bullets
//        for (GeneralEnemyTwoBullet bullet : bullets) {
//            bullet.update(deltaTime);
//        }
//
//     // Remove off-screen bullets
//        bullets.removeIf(bullet -> {
//            bullet.update(deltaTime);
//            return bullet.isOffScreen(Constants.GAME_HEIGHT);
//        });
//    }
//
//    public void render(SpriteBatch batch) {
//        batch.draw(texture, position.x, position.y, size.x, size.y);
//
//        // Render bullets
//        for (GeneralEnemyTwoBullet bullet : bullets) {
//            bullet.render(batch);
//        }
//    }
//
//    private void spawnBullet() {
//        float bulletSpeed = 200; // Adjust speed as needed
//        float bulletDirection = MathUtils.random(360); // Random direction in degrees
//        float speedX = bulletSpeed * MathUtils.cosDeg(bulletDirection);
//        float speedY = bulletSpeed * MathUtils.sinDeg(bulletDirection);
//
//        GeneralEnemyTwoBullet bullet = new GeneralEnemyTwoBullet(position.x + size.x / 2, position.y, speedX, speedY);
//        bullets.add(bullet);
//    }
//}
