//package com.bullethell.game.characters.enemy;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//import com.bullethell.game.world.Map;
//import com.bullethell.game.bullet.EnemyBullet;
//import com.bullethell.game.characters.entity.Entity;
//import com.bullethell.game.characters.entity.EntityType;
//import com.bullethell.game.utils.Constants;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GeneralEnemyOne extends Entity implements EnemyCharacter {
//    private Vector2 position;
//    private Vector2 size;
//
//    private Texture texture;
//    private Rectangle hitbox;
//    private int speed;
//
//    private List<EnemyBullet> bullets;
//    private float timeSinceLastBullet;
//
//    public GeneralEnemyOne(float x, float y, Map map) {
//        super(x, y, EntityType.GEN_ENEMY_A, map);
//        position = new Vector2(getPosX() , getPosY());
//        size = new Vector2(40, 40); // Adjust size as needed
//        texture = new Texture("enemyTexture.png"); // Adjust texture file name
//        hitbox = new Rectangle(x, y, size.x, size.y);
//        this.speed = EntityType.GEN_ENEMY_A.getSpeed();
//        bullets = new ArrayList<>();
//        timeSinceLastBullet = 0;
//
//    }
//
////    @Override
//    public void update(float deltaTime) {
//
//        position.x -= speed * deltaTime;
//
//        // Spawn bullets at a certain rate
//        if (MathUtils.randomBoolean(0.1f)) {
//            spawnBullet();
//        }
//
//        // Update bullets
//        for (EnemyBullet bullet : bullets) {
//            bullet.update(deltaTime);
//        }
//
//        // Remove off-screen bullets
//        bullets.removeIf(bullet -> bullet.getPosition().y > Constants.GAME_HEIGHT);
//    }
//
//    public void render(SpriteBatch batch) {
//        batch.draw(texture, position.x, position.y, size.x, size.y);
//
//        // Render bullets
//        for (EnemyBullet bullet : bullets) {
//            bullet.render(batch);
//        }
//    }
//
//    private void spawnBullet() {
//        EnemyBullet bullet = new EnemyBullet(position.x + size.x / 2, position.y, -200); // Adjust speed as needed
//        bullets.add(bullet);
//    }
//}