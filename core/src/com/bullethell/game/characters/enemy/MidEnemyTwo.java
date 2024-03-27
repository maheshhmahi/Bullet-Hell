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

public class MidEnemyTwo extends Entity {

    private int direction;

    public MidEnemyTwo(float x, float y, Map map) {
        super(x, y, EntityType.MID_BOSS_B, map);
        setEntity();
    }

    @Override
    protected void setEntity() {

        this.direction=4;

        hitbox.setPosition(getPosX(), getPosY());
        setHitBoxSize(type.getHeight(), type.getWidth());

        bullets = new ArrayList<>();
        bulletsToRemove = new ArrayList<>();
    }

    private Vector2 getDirection()
    {
        float hx, hy, cx, cy, dx, dy;
        hx = map.getHero().getPosX()+13;
        hy = map.getHero().getPosY()+10;
        cx = hx - getPosX();
        cy = hy - getPosY();
        double sqrt = Math.sqrt(cx * cx + cy * cy);
        dx = (cx/(float) sqrt);
        dy= (cy/(float) sqrt);
        Vector2 ret = new Vector2(dx,dy);
        return ret;
    }

    private boolean isInBorder() {
        return getPosX()>0 && getPosY()>0 && getPosX()<480 && getPosY()<800;
    }

    private boolean isCorrectShootingInterval() {
        return TimeUtils.nanoTime() - lastFireTime > 50;
    }

    private boolean canBeRemove() {
        return TimeUtils.millis() - appearTime>25000;
    }


    private void moveControl(float deltaTime) {
        if(getPosY() < 600 && this.direction == 4)
            direction = 1;
        if(getPosX() > 480*2/3-50)
            direction=1;
        if(getPosX() < 480/3-50)
            direction=2;
        if(direction == 1)
            moveX(-getSpeed() * deltaTime);
        if(direction == 2)
            moveX(getSpeed() * deltaTime);
        if(direction == 3)
            moveY(getSpeed() * deltaTime);
        if(direction == 4)
            moveY(-getSpeed() * deltaTime);
    }

    private void updateBullet(float deltaTime) {
        for(Bullet bullet: bullets) {
            bullet.update(deltaTime);
            if(bullet.remove) {
                bulletsToRemove.add(bullet);
            }
        }
        if(!die&&isCorrectShootingInterval() && isInBorder() && lives>0)
        {
            lastFireTime = TimeUtils.millis();
            Vector2 direction = getDirection();
            Random r = new Random();
            float dx = direction.x;
            float dy = direction.y;
            dx = (float)(Math.sqrt(0.01)*r.nextGaussian())+dx;
            dy = (float)(Math.sqrt(0.01)*r.nextGaussian())+dy;
            this.bullets.add(getBulletManager().createMidBossBBullet(getPosX()+40, getPosY(), dx, dy));
        }

        if(TimeUtils.millis() - appearTime>15000)
        {
            this.direction=3;
        }

        if(canBeRemove())
        {
            remove = true;
        }

        checkCollision();
        if(map.getNoBullet())
            bullets.clear();
        bullets.removeAll(bulletsToRemove);
    }

    private void checkCollision() {
        for (Bullet bullet: bullets) {
            if (bullet.collideWith(map.getHero())) {
                bulletsToRemove.add(bullet);
                System.out.println("Mid boss B hit hero");
                map.getHero().getCollision();
            }
        }
    }

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

    @Override
    public void update(float deltaTime)
    {
        updateBullet(deltaTime);

        moveControl(deltaTime);

        hitbox.setPosition(this.pos.x,this.pos.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        //batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
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
