package com.bullethell.game.characters.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.Map;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.characters.entity.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MidEnemyTwo extends Entity implements EnemyCharacter{

    private long lastFireTime;
    private long appearTime;

    private int direction;

    List<Bullet> bullets;

    public MidEnemyTwo(float x, float y, Map map) {
        super(x, y, EntityType.MID_BOSS_B, map);
        this.setImage(type.getImage());
        this.setLives(type.getLive());
        this.setSpeed(type.getSpeed());
        this.bullets = new ArrayList<>();
        this.hitbox.setPosition(this.pos.x,this.pos.y);
        this.setHitBoxSize(type.getHeight(), type.getWidth());
        this.lastFireTime = TimeUtils.millis();
        this.appearTime = TimeUtils.millis();
        this.direction=4;
    }

    private Vector2 getDirection()
    {
        float hx, hy, cx, cy, dx, dy;
        hx = map.getHero().getPosX()+13;
        hy = map.getHero().getPosY()+10;
        cx = hx - getPosX();
        cy = hy - getPosY();
        dx = (cx/(float)Math.sqrt(cx * cx + cy * cy));
        dy= (cy/(float)Math.sqrt(cx * cx + cy * cy));
        Vector2 ret = new Vector2(dx,dy);
        return ret;
    }

    private boolean isInBorder() {
        return this.pos.x>0 && this.pos.y>0 && this.pos.x<480 && this.pos.y<800;
    }

    private boolean isCorrectShootingInterval() {
        return TimeUtils.nanoTime() - lastFireTime > 50;
    }

    private boolean canBeRemove() {
        return TimeUtils.millis()-this.appearTime>25000;
    }

    private void moveControl(float deltaTime) {
        if(getPosY() < 600 && this.direction == 4)
            direction = 1;
        if(getPosX() > 480*2/3-50)
            direction=1;
        if(getPosX() < 480/3-50)
            direction=2;
        if(direction == 1)
            this.pos.x -= getSpeed() * deltaTime;
        if(direction == 2)
            this.pos.x += getSpeed() * deltaTime;
        if(direction == 3)
            this.pos.y += getSpeed() * deltaTime;
        if(direction == 4)
            this.pos.y -= getSpeed() * deltaTime;
    }

    private void updateBullet(float deltaTime) {
        for(Bullet bullet: bullets) {
            bullet.update(deltaTime);
        }
        if(isCorrectShootingInterval() && isInBorder() && lives>0)
        {
            this.lastFireTime = TimeUtils.millis();
            Vector2 direction = getDirection();
            Random r = new Random();
            float dx = direction.x;
            float dy = direction.y;
            dx = (float)(Math.sqrt(0.01)*r.nextGaussian())+dx;
            dy = (float)(Math.sqrt(0.01)*r.nextGaussian())+dy;
            this.bullets.add(bulletFactory.createMidBossBBullet(getPosX()+40, getPosY(), dx, dy));
        }

        if(TimeUtils.millis()-this.appearTime>15000)
        {
            this.direction=3;
        }

        if(canBeRemove())
        {
            remove=true;
        }
    }

    public void update(float deltaTime)
    {
        updateBullet(deltaTime);

        moveControl(deltaTime);

        this.hitbox.setPosition(this.pos.x,this.pos.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for(Bullet bullet: bullets) {
            bullet.render(batch);
        }
    }

}
