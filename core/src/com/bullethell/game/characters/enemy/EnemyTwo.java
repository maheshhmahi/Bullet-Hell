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

public class EnemyTwo extends Entity {
    private boolean clock = false;
    private long clock_num = 1;

    public EnemyTwo(float x , float y, Map map)
    {
        super(x, y, EntityType.ENEMY_2, map);
        entityInitialization();
    }

    @Override
    protected void entityInitialization() {
        hitbox.setPosition(this.pos.x,this.pos.y);
        hitbox.setSize(20, 20);
        setHitBoxSize(type.getHeight(), type.getWidth());

        bullets = new ArrayList<>();
        bulletsToRemove = new ArrayList<>();
    }

    private void updateBullet(float deltaTime) {
        for(Bullet bullet: bullets)
        {
            bullet.update(deltaTime);
            if(bullet.remove)
                bulletsToRemove.add(bullet);
        }

        checkCollision();

        bullets.removeAll(bulletsToRemove);		
		if(map.getNoBullet())
			bullets.clear();
    }

    private void moveControl(float deltaTime) {
        if(clock)
        {
            moveX(getSpeed() * deltaTime); // right
            if(getPosX() > 350 && TimeUtils.millis() - appearTime < 15000)
                clock = false;
        }
        else
        {
            moveX(-getSpeed() * deltaTime); // left
            if(getPosX() < 50 && TimeUtils.millis() - appearTime < 15000)
                clock = true;
        }

        clock_num++;
        if(TimeUtils.millis() - appearTime > 25000)
            this.remove = true;

        if(!die&&clock_num % 30 == 0)
        {
            clock_num = 1;
            bullets.add(getBulletManager().createEnemyTwoBullet(getPosX() + 35, getPosY() - 30));
        }
    }

    @Override
    public void update(float deltaTime)
    {
        moveControl(deltaTime);

        updateBullet(deltaTime);

        hitbox.setPosition(getPosX(),getPosY());
    }

    private void checkCollision() {
        for (Bullet bullet: bullets) {
            if (bullet.collideWith(map.getHero())) {
                bulletsToRemove.add(bullet);
                System.out.println("Enemy B hit hero");
                //getCollision();
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
    public void render(SpriteBatch batch)
    {
		if(show)
			sprite.draw(batch);
        if(!die){
			this.show = true;
		}
		for(Bullet bullet: bullets)
        {
            bullet.render(batch);
        }
    }
}
