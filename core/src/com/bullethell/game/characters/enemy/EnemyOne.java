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

public class EnemyOne extends Entity {

	private int direction;		//1-left,2-right,3-up,4-down

	public EnemyOne(float x, float y, Map map, int direction) {
		super(x, y, EntityType.ENEMY_1, map);
		this.direction = direction;
		entityInitialization();
	}

	@Override
	protected void entityInitialization() {
        this.direction=4;
		hitbox.setPosition(getPosX(), getPosY());
        setHitBoxSize(type.getHeight(), type.getWidth());

        bullets = new ArrayList<>();
        bulletsToRemove = new ArrayList<>();
	}

	private Vector2 getDirection()
	{
		float hx,hy,cx,cy,dx,dy;
		hx = map.getHero().getPosX()+13;
		hy = map.getHero().getPosY()+10;
		cx = hx - getPosX();
		cy = hy - getPosY();
		dx = (cx/(float)Math.sqrt(cx*cx+cy*cy));
		dy= (cy/(float)Math.sqrt(cx*cx+cy*cy));
		Vector2 ret = new Vector2(dx,dy);
		return ret;
	}

	public void moveControl(float deltaTime) {
		if(direction==1)
			moveX(-getSpeed() * deltaTime);
		if(direction==2)
			moveX(getSpeed() * deltaTime);
		if(direction==3)
			moveY(getSpeed() * deltaTime);
		if(direction==4)
			moveY(-getSpeed() * deltaTime);
	}

	private void updateBullet(float deltaTime) {
		for(Bullet bullet: bullets) {
			bullet.update(deltaTime);
			if(bullet.remove) {
				bulletsToRemove.add(bullet);
			}
		}

		if(!die&&TimeUtils.millis() - lastFireTime>200 && isInBorder() && lives>0)
		{
			lastFireTime = TimeUtils.millis();
			Vector2 direction = getDirection();
			float dx = direction.x;
			float dy = direction.y;
			bullets.add(getBulletManager().createEnemyOneBullet(getPosX(), getPosY(), dx, dy));
		}

		if(TimeUtils.millis()-this.appearTime > 20000)
		{
			remove = true;
		}

		checkCollision();
		if(map.getNoBullet())
			bullets.removeAll(bullets);
		bullets.removeAll(bulletsToRemove);
	}

	private void checkCollision() {
		for (Bullet bullet: bullets) {
			if (bullet.collideWith(map.getHero())) {
				bulletsToRemove.add(bullet);
				System.out.println("EnemyOne hit hero");
				map.getHero().getCollision();
			}
		}
	}

	public void getCollision() {
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

	private boolean isInBorder() {
		return getPosX()>0 && getPosY()>0 && getPosX()<480 && getPosY()<800;
	}

	@Override
	public void update(float deltaTime)
	{
		moveControl(deltaTime);

		updateBullet(deltaTime);

		this.hitbox.setPosition(getPosX(), getPosY());
	}

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