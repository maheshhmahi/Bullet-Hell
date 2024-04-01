package com.bullethell.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.world.Map;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.characters.entity.EntityType;

import java.util.ArrayList;

public class Hero extends Entity {
    private BitmapFont font;
    private static long lastFireTime = 0;
    private InputManager inputManager;
    private boolean flag = true;
    private Sound shootSound;
    private Sound collisionSound;
    private SpriteBatch batch;


    public Hero(float x, float y, Map map) {
        super(x, y, EntityType.HERO, map);
        entityInitialization();
        batch = new SpriteBatch();
        shootSound = Gdx.audio.newSound(Gdx.files.internal("playerShoot.mp3"));
        collisionSound = Gdx.audio.newSound(Gdx.files.internal("explode.mp3"));
    }

    @Override
    protected void entityInitialization() {
        hitbox.setPosition(this.getPosX()-15, this.getPosY());
        hitbox.setSize(10, 10);
        inputManager = new InputManager(this);
        bullets = new ArrayList<>();
        bulletsToRemove = new ArrayList<>();
        font = new BitmapFont();
        score = 0;
    }

    public void moveSetting() {
        inputManager.setLeftKey(Input.Keys.LEFT);
        inputManager.setRightKey(Input.Keys.RIGHT);
        inputManager.setUpKey(Input.Keys.UP);
        inputManager.setDownKey(Input.Keys.DOWN);
        inputManager.setAddSpeedKey(Input.Keys.SHIFT_LEFT);
        inputManager.setSpeed(300);
        inputManager.setAc_speed(150);
        inputManager.setShootKey(Input.Keys.SPACE);
    }

    protected void moveControl(float deltaTime) {
        moveSetting();

        inputManager.move(deltaTime);
    }


    private void borderControl() {
        if(getPosX() < 0)
            sprite.setX(0);
        if(getPosX() > 480-48)
            sprite.setX(480-48);
        if(getPosY() < 0)
            sprite.setY(0);
        if(getPosY() > 800-48)
            sprite.setY(800-48);
    }

    private boolean isCorrectTimeInterval() {
        return TimeUtils.nanoTime() - lastFireTime > 100000000;
    }

    private void updateBullet(float deltaTime) {

        if(Gdx.input.isKeyPressed(inputManager.getShootKey())&&!die) {
            if(isCorrectTimeInterval()) {
                shootSound.play();
                bullets.add(getBulletManager().createHeroBullet(getPosX()+11, getPosY()+20));
                lastFireTime = TimeUtils.nanoTime();
            }
        }

        for(Bullet bullet: bullets) {
            bullet.update(deltaTime);
            if(bullet.remove) {
                bulletsToRemove.add(bullet);
            }
        }
        checkCollision();

        bullets.removeAll(bulletsToRemove);
    }

    private void checkCollision() {
        for (Bullet bullet: bullets) {
            for (Entity enemy: map.getEntities()) {
                if (bullet.collideWith(enemy)) {
                    bulletsToRemove.add(bullet);
                    updateScore(enemy.getType());
                    enemy.getCollision();
                }
            }
        }
    }

    private void updateScore(EntityType enemyType)
    {
        switch (enemyType)
        {
            case MID_BOSS_B:
                score += 40;
                break;
            case ENEMY_1:
                score += 5;
                break;
            case ENEMY_2:
                score += 7;
                break;
            case MID_BOSS_A:
                score += 10;
                break;
        }
    }

    public void getCollision() {
        System.out.println("Start deal with hero's collision");
        if(!map.getInvincible())
        {
            //collision effect
            collisionSound.play();
            this.lives--;
            if(lives != 0){
                this.pos.x = 200;
                this.pos.y = 100;
                this.sprite.setPosition(200,100);
            }
            map.setInvincible(true);
            map.setLastHitTime(TimeUtils.nanoTime());
            map.setNoBullet(true);
            if(lives<=0) {
                System.out.println("Die");
                die = true;
            }
        }
    }

    @Override
    public void update(float deltaTime) {

        moveControl(deltaTime);

        borderControl();

        hitbox.setPosition(getPosX() + 20, getPosY() + 24);

        updateBullet(deltaTime);
        checkEntityCollision();

        if(die)
        {
            map.setInvincible(true);
            if(flag){
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
            }
            this.pos.x = 200;
            this.pos.y = -100;
            this.sprite.setPosition(200,-100);
        }
        if(map.getInvincible())
            this.show = !this.show;
        if(!map.getInvincible())
            this.show = true;

    }

    @Override
    public void render(SpriteBatch batch) {
        if(this.show && !this.die)
            sprite.draw(batch);
        for(Bullet bullet: bullets) {
            bullet.render(batch);
        }
        if (this.die)
        {
            Texture texture = new Texture("Herodie.png");
            batch.draw(texture, this.getPosX(), this.getPosY());
        }
    }

    private void checkEntityCollision() {
        for (Entity enemy : map.getEntities()) {
            if (enemy.collideWith(this)) {
                getCollision();
            }
        }
    }

}
