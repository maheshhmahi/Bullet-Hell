package com.bullethell.game.characters.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bullethell.game.Map;
import com.bullethell.game.bullet.BulletFactory;

public abstract class Entity {

    protected Vector2 pos;
    protected EntityType type;
    protected Map map;
    protected Rectangle hitbox;
    protected Texture image;
    protected Texture hitboxImage;
    protected int lives;
    protected int speed;
    protected BulletFactory bulletFactory;
    public boolean remove = false;

    public Entity(float x, float y, EntityType type, Map map) {
        this.pos = new Vector2(x, y);
        this.map = map;
        this.type = type;
        this.hitbox = new Rectangle();
        bulletFactory = new BulletFactory();
    }

    public void update(float deltaTime) {
        this.pos.y = (float) Math.floor(pos.y);
    }

    public abstract void render(SpriteBatch batch);

    protected void moveX(float amount) {
        this.pos.x += amount;
    }

    protected void moveY(float amount) {
        this.pos.y += amount;
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

    public void setHitBoxSize(float width, float height) {
        this.hitbox.width = width;
        this.hitbox.height = height;
    }

    public void setHitboxImage(String image) {
        this.hitboxImage = new Texture(image);
    }

    public void setImage(String image) {
        this.image = new Texture(image);
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setBulletFactory(BulletFactory bulletFactory) {
        this.bulletFactory = bulletFactory;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
