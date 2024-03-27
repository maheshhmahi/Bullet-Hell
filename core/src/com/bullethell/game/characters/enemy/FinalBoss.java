package com.bullethell.game.characters.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.characters.entity.EntityType;
import com.bullethell.game.world.Map;

import java.util.ArrayList;
import java.util.Random;

public class FinalBoss extends Entity {

    private int direction;
    private float ax, ay;
    private int state;

    public FinalBoss(float x, float y, Map map) {
        super(x, y, EntityType.FINAL_BOSS, map);
        setEntity();
    }
    // Initialize entity properties
    @Override
    protected void setEntity() {

        // Set hitbox position and size
        hitbox.setPosition(getPosX(), getPosY());
        setHitBoxSize(type.getHeight(), type.getWidth());

        // Set initial state and direction
        this.state = 1; // initial
        this.direction = 4; // initial => going down

        // Initialize bullet lists
        bullets = new ArrayList<>();
        bulletsToRemove = new ArrayList<>();
    }

    public void update(float deltaTime) {
        // Update bullets
        for(Bullet bullet: bullets) {
            bullet.update(deltaTime); // call this.shootingAction.shoot(deltaTime, speed)
            if(bullet.remove) {
                bulletsToRemove.add(bullet);
            }
        }
        // Call firing patterns based on direction
        if(!die){
            if(this.direction == 2 || this.direction == 6) // call firing_pattern_1 method
                firing_pattern_1();
            else if(this.direction == 4 || this.direction == 8) // call firing_pattern_2 method
                firing_pattern_2();
            else if(this.direction == 1 || this.direction == 7) // call firing_pattern_3 method
                firing_pattern_3();
        }
        // Move along the boss path
        FinalBoss_path();
        // Move in the specified direction
        moveControl(deltaTime);
        // Update hitbox position
        this.hitbox.setPosition(this.pos.x,this.pos.y);
        // Check for removal conditions
        if(TimeUtils.millis()-this.appearTime > 35000)
            this.remove = true;
        // Check collision with hero
        checkCollision();
        // Clear bullets if noBullet flag is set
        if(map.getNoBullet())
            bullets.clear();
        bullets.removeAll(bulletsToRemove);
    }

    // Check collision with hero
    private void checkCollision() {
        for (Bullet bullet: bullets) {
            if (bullet.collideWith(map.getHero())) {
                bulletsToRemove.add(bullet);
                System.out.println("BossB hit hero");
                map.getHero().getCollision();
                //getCollision();
            }
        }
    }
    // Handle collision
    public void getCollision() {
        //Start deal with collision
        show = false;
        this.lives--;
        if(this.lives<=0)
        {
            this.die = true;
            this.dieTime=TimeUtils.millis();
            this.pos.x = -10000;
            this.pos.y = -10000;
            this.sprite.setPosition(-10000,-10000);

        }
    }
    // Get direction towards hero
    private Vector2 getDirection() {
        float hx, hy, cx, cy, dx, dy;
        hx = map.getHero().getPosX()+13;
        hy = map.getHero().getPosY()+10;
        cx = hx - getPosX();
        cy = hy - getPosY();
        dx = (cx/(float)Math.sqrt(cx * cx + cy * cy));
        dy = (cy/(float)Math.sqrt(cx * cx + cy * cy));
        Vector2 ret = new Vector2(dx,dy);
        return ret;
    }

    private boolean isCorrectShootingInterval() {
        return TimeUtils.millis() - lastFireTime > 50;
    }

    private boolean isInBorder() {
        return this.pos.x > 0 && this.pos.y > 0 && this.pos.x < 480 && this.pos.y < 800;
    }


    // Firing pattern 1
    private void firing_pattern_1(){
        this.lastFireTime = TimeUtils.millis();
        Vector2 direction = getDirection(); // call getDirection method
        Random r = new Random();
        float dx = direction.x;
        float dy = direction.y;
        dx = (float)(Math.sqrt(0.01)*r.nextGaussian()) + dx;
        dy = (float)(Math.sqrt(0.01)*r.nextGaussian()) + dy;
        this.bullets.add(getBulletManager().createMidBossBBullet(getPosX() + 35, getPosY() - 40, dx, dy)); //around
    }


    // Firing pattern 2
    private void firing_pattern_2(){
        getBulletManager().setFinalBossStatus("down");
        this.bullets.add(getBulletManager().createFinalBossBullet(getPosX()+45, getPosY()-40)); //down
        this.bullets.add(getBulletManager().createFinalBossBullet(getPosX()+35, getPosY()-40)); //down
        getBulletManager().setFinalBossStatus("right");
        this.bullets.add(getBulletManager().createFinalBossBullet(getPosX()+100, getPosY()+50)); //right
        getBulletManager().setFinalBossStatus("left");
        this.bullets.add(getBulletManager().createFinalBossBullet(getPosX()-30, getPosY()+50)); //left
        getBulletManager().setFinalBossStatus("up");
        this.bullets.add(getBulletManager().createFinalBossBullet(getPosX()+45, getPosY()+100)); //up
        this.bullets.add(getBulletManager().createFinalBossBullet(getPosX()+35, getPosY()+100)); //up
    }
    // Firing pattern 3
    private void firing_pattern_3(){
        if(state == 1) {
            ax = (int) (Math.random() * 10) + 1;
            ay = (int) (Math.random() * 10) + 1;
            state = 2;
        } else if(state == 2) {
            ax = (int) (Math.random() * 10) + 1;
            ay = (int) (Math.random() * -10) - 1;
            state = 3;
        } else if(state == 3) {
            ax = (int) (Math.random() * -10) - 1;
            ay = (int) (Math.random() * -10) - 1;
            state = 4;
        } else if(state == 4) {
            ax = (int) (Math.random() * -10) - 1;
            ay = (int) (Math.random() * 10) + 1;
            state = 1;
        }
        this.bullets.add(getBulletManager().createMidBossBBullet(getPosX()+35, getPosY()-40, ax, ay));
    }
    // FinalBoss path movement
    private void FinalBoss_path(){
        if(this.pos.y < 450 && this.direction == 4)
            this.direction = 5; //move Top Right
        else if(this.pos.x > 360 && this.direction == 5)
            this.direction = 1; //move left
        else if(this.pos.x < 10 && this.direction == 1)
            this.direction = 6; //move Bottom Right
        else if(this.pos.x > 350 && this.direction == 6)
            this.direction = 8; //move Bottom Left
        else if(this.pos.x < 10 && this.direction == 8)
            this.direction = 2; //move right
        else if(this.pos.x > 320 && this.direction == 2)
            this.direction = 7; //move Top Left
        else if(this.pos.x < 200 && this.direction == 7)
            this.direction = 3; //move up
    }
    // Move in the specified direction
    private void moveControl(float deltaTime) {
        if(direction == 1) // move left
            moveX(-getSpeed() * deltaTime);
        else if(direction == 2) // move right
            moveX(getSpeed() * deltaTime * 2);
        else if(direction == 3) // move up
            moveY(getSpeed() * deltaTime);
        else if(direction == 4) // move down
            moveY(-getSpeed() * deltaTime);
        else if(direction == 5) { // move Top Right
            moveX(getSpeed() * deltaTime);
            moveY(getSpeed() * deltaTime);
        }
        else if(direction == 6) { // move Bottom Right
            moveX(getSpeed() * deltaTime * 5);
            moveY(-getSpeed() * deltaTime);
        }
        else if(direction == 7) { // move Top Left
            moveX(-getSpeed() * deltaTime);
            moveY(getSpeed() * deltaTime * 2);
        }
        else if(direction == 8) { // move Bottom Left
            moveX(-getSpeed() * deltaTime * 3);
            moveY(-getSpeed() * deltaTime);
        }
    }

    // Render method
    @Override
    public void render(SpriteBatch batch) {
        if(show)
            sprite.draw(batch);
        if(!die){
            this.show = true;
        }
        for(Bullet bullet: bullets) {
            bullet.render(batch);
        }
    }
}
