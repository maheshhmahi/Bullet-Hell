//package com.bullethell.game.characters.enemy;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.TimeUtils;
//import com.bullethell.game.world.Map;
//import com.bullethell.game.bullet.factory.BulletFactory;
//import com.bullethell.game.characters.entity.Entity;
//import com.bullethell.game.characters.entity.EntityType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MidEnemyOne extends Entity implements EnemyCharacter{
//    private long lastFireTime;
//    private long appearTime;
//
//    private int direction;
//
//    List<BulletFactory> bullets;
//
//    public MidEnemyOne(float x, float y, Map map, int direction) {
//        super(x, y, EntityType.MID_BOSS_A, map);
//        this.setImage(type.getImage());
//        this.direction = 4;
//        this.setLives(type.getLive());
//        this.setSpeed(type.getSpeed());
//        this.bullets = new ArrayList<>();
//        this.hitbox.setPosition(this.pos.x,this.pos.y);
//        this.setHitBoxSize(type.getHeight(), type.getWidth());
//        this.lastFireTime = TimeUtils.millis();
//        this.appearTime = TimeUtils.millis();
//    }
//
//    private Vector2 getDirection()
//    {
//        float hx, hy, cx, cy, dx, dy;
//        hx = map.getHero().getPosX()+13;
//        hy = map.getHero().getPosY()+10;
//        cx = hx - getPosX();
//        cy = hy - getPosY();
//        dx = (cx/(float)Math.sqrt(cx * cx + cy * cy));
//        dy= (cy/(float)Math.sqrt(cx * cx + cy * cy));
//        Vector2 ret = new Vector2(dx,dy);
//        return ret;
//    }
//
//    private boolean isInBorder() {
//        return this.pos.x>0 && this.pos.y>0 && this.pos.x<480 && this.pos.y<800;
//    }
//
//    private boolean isCorrectShootingInterval() {
//        return TimeUtils.nanoTime() - lastFireTime > 50;
//    }
//
//    private boolean canBeRemove() {
//        return TimeUtils.millis()-this.appearTime>25020;
//    }
//
//    private void moveControl(float deltaTime) {
//        if(direction == 1)
//            this.pos.x -= getSpeed() * deltaTime;
//        if(direction == 2)
//            this.pos.x += getSpeed() * deltaTime;
//        if(direction == 3)
//            this.pos.y += getSpeed() * deltaTime;
//        if(direction == 4)
//            this.pos.y -= getSpeed() * deltaTime;
//    }
//
//    private void updateBullet(float deltaTime) {
//        for(BulletFactory bullet: bullets) {
//            bullet.update(deltaTime);
//        }
//        if(TimeUtils.millis()-this.lastFireTime>400 && isInBorder() && lives>0)
//        {
//            this.lastFireTime = TimeUtils.millis();
//            Vector2 direction = getDirection();
//            float dx = direction.x;
//            float dy = direction.y;
//            this.bullets.add(bulletFactory.createMidBossABullet(getPosX()+40, getPosY(), dx, dy));
//        }
//
//        if(TimeUtils.millis()-this.appearTime>5120)
//        {
//            this.direction=2;
//        }
//
//        if(canBeRemove())
//        {
//            remove=true;
//        }
//    }
//
//    public void update(float deltaTime)
//    {
//        updateBullet(deltaTime);
//
//        moveControl(deltaTime);
//
//        this.hitbox.setPosition(this.pos.x,this.pos.y);
//    }
//
//    @Override
//    public void render(SpriteBatch batch) {
//        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
//        for(BulletFactory bullet: bullets) {
//            bullet.render(batch);
//        }
//    }
//}
