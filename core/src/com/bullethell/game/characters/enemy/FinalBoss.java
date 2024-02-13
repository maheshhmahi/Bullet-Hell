package com.bullethell.game.characters.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.Map;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.characters.entity.EntityType;
import com.bullethell.game.bullet.BulletFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinalBoss extends Entity implements EnemyCharacter {

    private long lastFireTime;
    private long appearTime;
    private int direction;
    private List<Bullet> bullets;

    private BulletFactory bulletFactory;

    public FinalBoss(float x, float y, Map map) {
        super(x, y, EntityType.FINAL_BOSS_1, map);
        this.setImage(type.getImage());
        this.setLives(type.getLive());
        this.setSpeed(type.getSpeed());
        this.bullets = new ArrayList<>();
        this.hitbox.setPosition(this.pos.x, this.pos.y);
        this.setHitBoxSize(type.getHeight(), type.getWidth());
        this.lastFireTime = TimeUtils.millis();
        this.appearTime = TimeUtils.millis();
        this.direction = 4;
        this.bulletFactory = new BulletFactory();
    }

    private Vector2 getDirection() {
        float hx, hy, cx, cy, dx, dy;
        hx = map.getHero().getPosX() + 13;
        hy = map.getHero().getPosY() + 10;
        cx = hx - getPosX();
        cy = hy - getPosY();
        dx = (cx / (float) Math.sqrt(cx * cx + cy * cy));
        dy = (cy / (float) Math.sqrt(cx * cx + cy * cy));
        return new Vector2(dx, dy);
    }

    private boolean isInBorder() {
        return this.pos.x > 0 && this.pos.y > 0 && this.pos.x < 480 && this.pos.y < 800;
    }

    private boolean isCorrectShootingInterval() {
        return TimeUtils.millis() - lastFireTime > 50;
    }

    private boolean canBeRemove() {
        return TimeUtils.millis() - appearTime > 25000;
    }

    private void moveControl(float deltaTime) {
        if (getPosY() < 600 && this.direction == 4)
            direction = 1;
        if (getPosX() > 480 * 2 / 3 - 50)
            direction = 1;
        if (getPosX() < 480 / 3 - 50)
            direction = 2;
        if (direction == 1)
            this.pos.x -= getSpeed() * deltaTime;
        if (direction == 2)
            this.pos.x += getSpeed() * deltaTime;
        if (direction == 3)
            this.pos.y += getSpeed() * deltaTime;
        if (direction == 4)
            this.pos.y -= getSpeed() * deltaTime;
    }

    private void updateBullet(float deltaTime) {
        for (Bullet bullet : bullets) {
            bullet.update(deltaTime);
        }

        long elapsedTime = TimeUtils.millis() - appearTime;

        // Level 1: Same as the current firing pattern, but with more bullets
        if (elapsedTime <= 20000) {
            if (isCorrectShootingInterval() && isInBorder() && lives > 0) {
                this.lastFireTime = TimeUtils.millis();
                Vector2 direction = getDirection();
                Random r = new Random();

                // Spawn more bullets
                for (int i = 0; i < 5; i++) { // Adjust the number of bullets as needed
                    float dx = direction.x;
                    float dy = direction.y;
                    dx = (float) (Math.sqrt(0.01) * r.nextGaussian()) + dx;
                    dy = (float) (Math.sqrt(0.01) * r.nextGaussian()) + dy;
                    this.bullets.add(bulletFactory.createMidBossBBullet(getPosX() + 40, getPosY(), dx, dy));
                }
            }
        }

        // Level 2: Circular firing pattern downwards covering 180 degrees
        else if (elapsedTime <= 60000) {
            if (isCorrectShootingInterval() && isInBorder() && lives > 0) {
                this.lastFireTime = TimeUtils.millis();
                float startX = getPosX() + EntityType.FINAL_BOSS_1.getWidth() / 2; // Starting X position of the bullets
                float startY = getPosY() + EntityType.FINAL_BOSS_1.getHeight() / 2; // Starting Y position of the bullets
                int numBullets = 30; // Number of bullets in the circular pattern
                float radius = 100; // Radius of the circular pattern
                float startAngle = 180; // Starting angle for firing

                for (int i = 0; i < numBullets; i++) {
                    // Calculate angle for each bullet in the circular pattern
                    float angle = startAngle + i * 180f / numBullets;
                    // Convert angle to radians
                    double radians = Math.toRadians(angle);
                    // Calculate bullet direction
                    float dx = (float) Math.cos(radians);
                    float dy = (float) Math.sin(radians);
                    // Set bullet speed and adjust starting position based on radius
                    float bulletX = startX + radius * dx;
                    float bulletY = startY + radius * dy;
                    this.bullets.add(bulletFactory.createFinalBossBullet1(bulletX, bulletY, dx, dy));
                }
            }
        }


        // Levels 3 and 4: Implement firing patterns for these levels
        else {
            // Implement firing patterns for levels 3 and 4
        }
        if (canBeRemove()) {
            remove = true;
        }
    }


    @Override
    public void update(float deltaTime) {
        updateBullet(deltaTime);
        moveControl(deltaTime);
        this.hitbox.setPosition(this.pos.x, this.pos.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for (Bullet bullet : bullets) {
            bullet.render(batch);
        }
    }
}
