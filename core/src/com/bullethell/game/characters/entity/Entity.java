package com.bullethell.game.characters.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.bullet.BulletManager;
import com.bullethell.game.world.Map;

import java.util.List;

public abstract class Entity {

    public int score;
    protected Vector2 pos;
    protected EntityType type;
    protected Map map;
    protected Rectangle hitbox;
    protected int lives;
    protected int speed;
    public boolean hit, remove;
    protected Sprite sprite;
    protected List<Bullet> bullets;
    protected List<Bullet> bulletsToRemove;
    protected long lastFireTime;
    protected long appearTime;
    protected boolean show = true;
    protected boolean die = false;
    protected long dieTime;

    public Entity(float x, float y, EntityType type, Map map) {
        this.pos = new Vector2(x, y);
        this.map = map;
        this.type = type;
        this.hitbox = new Rectangle();
        this.hit = false;
        this.remove = false;
        this.lastFireTime = TimeUtils.millis();
        this.appearTime = TimeUtils.millis();
        this.setLives(type.getLive());
        this.setSpeed(type.getSpeed());
        createGraph(x, y);
    }

    private void createGraph(float x, float y) {
        this.sprite = new Sprite(new Texture(type.getImage()));
        this.sprite.setPosition(x, y);
        this.sprite.setSize(type.getWidth(), type.getHeight());
    }

    public void update(float deltaTime) {
        this.pos.y = (float) Math.floor(pos.y);
    }

    public abstract void render(SpriteBatch batch);

    public void moveX(float amount) {
        sprite.translateX(amount);
        setPosX(sprite.getX());
    }

    public void moveY(float amount) {
        sprite.translateY(amount);
        setPosY(sprite.getY());
    }

    public Vector2 getPos() {
        return pos;
    }

    public EntityType getType() {
        return type;
    }

    public float getPosX() {
        return pos.x;
    }

    public void setPosX(float x) {
        pos.x = x;
    }

    public float getPosY() {
        return pos.y;
    }

    public void setPosY(float y) {
        pos.y = y;
    }

    public int getHeight() {
        return type.getHeight();
    }

    public int getWidth() {
        return type.getWidth();
    }

    public Rectangle getHitbox() {
        return hitbox;
    }


    public boolean isRemove() {
        return remove;
    }

    public void setHitBoxSize(float width, float height) {
        this.hitbox.width = width;
        this.hitbox.height = height;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BulletManager getBulletManager() {
        return BulletManager.getInstance();
    }

    public Rectangle getArea() {
        return hitbox;
    }

    public abstract void getCollision();

    protected abstract void setEntity();

    public boolean isDie() {
        return die;
    }

    public int getLives() {
        return lives;
    }

    public boolean collideWith(Entity entity) {
        Rectangle rect1 = getArea();
        Rectangle rect2 = entity.getArea();
        return rect1.overlaps(rect2);
    }

}
