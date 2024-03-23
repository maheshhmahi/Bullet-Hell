package com.bullethell.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.Map;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.characters.entity.EntityType;
import com.bullethell.game.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class Hero {
//    private Vector2 position;
//    private Vector2 size;
//    private Texture texture;
//    private int currentSpeed;
//    private Rectangle boxHit;
//    private int acceleration;
//    private static int normalSpeed = Constants.HERO_NORMAL_SPEED;
//    private static int slowSpeed = Constants.HERO_SLOW_SPEED;
//
//    public static int leftKey = Input.Keys.LEFT;
//    public static int rightKey = Input.Keys.RIGHT;
//    public static int upKey = Input.Keys.UP;
//    public static int downKey = Input.Keys.DOWN;
//    public static int slowSpeedKey = Input.Keys.SHIFT_LEFT;
//
//    public Hero(float x, float y, Map map) {
//        super(x, y, EntityType.HERO, map);
//        position = new Vector2(Constants.GAME_WIDTH / 2, 100);
//        size = new Vector2(60,60);
//        texture = new Texture("playerShip1_red.png");
//        currentSpeed = Constants.HERO_CURRENT_SPEED;
//        boxHit = new Rectangle(position.x + size.x/2, position.y+size.y/2, size.x/60, size.y/60);
//        //hero inputKeyManager todo
//        acceleration = 100;
//
//        this.setImage(type.getImage());
//        this.setHitBoxSize(type.getHeight()-40, type.getWidth()-40);
//        this.setLives(type.getLive());
//        this.getHitbox().setPosition(this.getPosX(), this.getPosY());
//    }
//
//    public Vector2 getPosition() {
//        return position;
//    }
//    public void setPosition(float x, float y) {
//        position.x = x;
//        position.y = y;
//        boxHit.setPosition(position.x + size.x/2, position.y + size.y/2);
//    }
//
//    public Vector2 getSize() {
//        return size;
//    }
//
//    public void setSize(Vector2 size) {
//        this.size = size;
//    }
//
//    public Texture getTexture() {
//        return texture;
//    }
//
//    public void setTexture(Texture texture) {
//        this.texture = texture;
//    }
//
//    public int getCurrentSpeed() {
//        return currentSpeed;
//    }
//
//    public void setCurrentSpeed(int currentSpeed) {
//        this.currentSpeed = currentSpeed;
//    }
//
//    public Rectangle getBoxHit() {
//        return boxHit;
//    }
//
//    public void setBoxHit(Rectangle boxHit) {
//        this.boxHit = boxHit;
//    }
//
//    public int getAcceleration() {
//        return acceleration;
//    }
//
//    public void setAcceleration(int acceleration) {
//        this.acceleration = acceleration;
//    }
//
//    public static int getNormalSpeed() {
//        return normalSpeed;
//    }
//
//    public static void setNormalSpeed(int normalSpeed) {
//        Hero.normalSpeed = normalSpeed;
//    }
//
//    public static int getSlowSpeed() {
//        return slowSpeed;
//    }
//
//    public static void setSlowSpeed(int slowSpeed) {
//        Hero.slowSpeed = slowSpeed;
//    }
//
//    private void controlBorder() {
//        if(position.x < 0)
//            setPosition(0, position.y);
//        if(position.x > Constants.GAME_WIDTH - size.x)
//            setPosition(Constants.GAME_WIDTH - size.x, position.y);
//        if(position.y < 0)
//            setPosition(position.x, 0);
//        if(position.y > Constants.GAME_HEIGHT - size.y)
//            setPosition(position.x, Constants.GAME_HEIGHT - size.y);
//    }
//
//    @Override
//    public void render(SpriteBatch spriteBatch) {
//        spriteBatch.draw(texture, position.x, position.y, size.x, size.y);
//    }
//
//    private void handleInputs(float deltaTime) {
//
//        if(Gdx.input.isKeyPressed(leftKey))
//            setPosition(getPosition().x - getCurrentSpeed() * deltaTime, getPosition().y);
//
//        if(Gdx.input.isKeyPressed(rightKey))
//            setPosition(getPosition().x + getCurrentSpeed() * deltaTime, getPosition().y);
//
//        if(Gdx.input.isKeyPressed(upKey))
//            setPosition(getPosition().x, getPosition().y + getCurrentSpeed() * deltaTime);
//
//        if(Gdx.input.isKeyPressed(downKey))
//            setPosition(getPosition().x, getPosition().y - getCurrentSpeed() * deltaTime);
//
//        if(Gdx.input.isKeyPressed(slowSpeedKey))
//            setCurrentSpeed(Constants.HERO_SLOW_SPEED);
//        else
//            setCurrentSpeed(Constants.HERO_NORMAL_SPEED);
//    }
//    @Override
//    public void update(float deltaTime) {
//        handleInputs(deltaTime);
//        controlBorder();
//    }

    private static Hero _instance;
    private Vector2 pos;
    private Vector2 size;
    private Texture texture;
    private Texture bomb;
    private boolean pressBomb;
    private int currentSpeed;
    private Rectangle hitbox;
    private InputKeyManager inputKeyManager;
    private int acceleration;
    private boolean invincible;
    private int lives;
    private int curHealth;
    private int totalHeath;
    private long invincibleDuration;
    private long bornTime;
    private long count;
    private Texture hitboxT; //del
    private BulletManager bulletsManager;
    private static int normalSpeed = Constants.HERO_NORMAL_SPEED;
    private static int slowSpeed = Constants.HERO_SLOW_SPEED;
    public static boolean cheat = false;


    private Hero() {
        pos = new Vector2(Constants.GAME_WIDTH / 2, 100);
        texture = new Texture("Hero.png");
        bomb = new Texture("bomb.png");
        pressBomb=false;
        size = new Vector2(60, 60);
        hitbox = new Rectangle(pos.x+size.x/2, pos.y+size.y/2, size.x/60, size.y/60);
        inputKeyManager = InputKeyManager.getInstance(this);
        acceleration = 100;
        invincible = false;
        lives = 3;
        invincibleDuration = 5000;
        totalHeath = 25;
        curHealth = totalHeath;
        bornTime = 0;
        count = 0;
        hitboxT = new Texture("bulletSource.png");
        bulletsManager = new BulletManager();
    }

    public static Hero getInstance() {
        if (_instance == null) {
            _instance = new Hero();
        }
        return _instance;
    }

    public void reInitialize()
    {
        pos = new Vector2(Constants.GAME_WIDTH / 2, 100);
        currentSpeed = Constants.HERO_NORMAL_SPEED;
        hitbox = new Rectangle(pos.x+size.x/2, pos.y+size.y/2, size.x/60, size.y/60);
        invincible = false;
        lives = 3;
        bornTime = 0;
        curHealth = totalHeath;
    }

    public void setPressBomb(boolean pressBomb)
    {
        this.pressBomb=pressBomb;
    }

    public boolean getPressBomb()
    {
        return this.pressBomb;
    }
    public Vector2 getPos() {
        return pos;
    }

    public Vector2 getSize() {
        return size;
    }

    public void render(SpriteBatch batch) {
        if (invincible)
            renderHeroBlinking(batch);
        else
            batch.draw(texture, pos.x, pos.y, size.x, size.y);

        bulletsManager.render(batch);

        if (currentSpeed <= slowSpeed)
            batch.draw(hitboxT,hitbox.x, hitbox.y, hitbox.width, hitbox.height);

        count++;
    }

    private void renderHeroBlinking(SpriteBatch batch)
    {
        if (count % 2 == 0) //give blinking effect
            batch.draw(texture, pos.x, pos.y, size.x, size.y);
    }

    public void renderBomb(SpriteBatch batch)
    {
        batch.draw(bomb,0,200,500,600);
    }

    public void update(float delta) {
        inputKeyManager.executeInputCommand(delta);

        updateInvincible();

        borderControl();

        bulletsManager.updateBullets(delta);
    }

    private void updateInvincible()
    {
        if (TimeUtils.millis() - bornTime > invincibleDuration)
            invincible = false;
        else
            invincible = true;
    }

    public void addBullet() {
        Vector2 posx = new Vector2();
        posx.y=pos.y;
        posx.x=pos.x-10;
        bulletsManager.addBullet(posx, size);
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }



    public void setPosition(float x, float y) {
        pos.x = x;
        pos.y = y;
        hitbox.setPosition(pos.x+size.x/2, pos.y+size.y/2);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public List<Bullet> getBullets() {
        return bulletsManager.getBullets();
    }

    public int getAcceleration() {
        return acceleration;
    }

    private void borderControl() {
        if (pos.x < 0)
            setPosition(0, pos.y);
        if (pos.x > Constants.GAME_WIDTH - size.x)
            setPosition(Constants.GAME_WIDTH - size.x, pos.y);
        if (pos.y < 0)
            setPosition(pos.x, 0);
        if (pos.y > (Constants.GAME_HEIGHT - size.y))
            setPosition(pos.x, Constants.GAME_HEIGHT - size.y);
    }

    public void die() {
        this.lives--;
        this.pos.x = Constants.GAME_WIDTH / 2;
        this.pos.y = 100;
        curHealth = totalHeath;
        invincible = true;
        bornTime = TimeUtils.millis();
    }

    public int getLives()
    {
        return lives;
    }

    public void takeDamage(int damage)
    {
        if (!invincible&&!cheat)
            curHealth -= damage;
    }

    public boolean heathRunOut()
    {
        if (curHealth <= 0)
            return true;
        return false;
    }

    public int getCurHealth()
    {
        return curHealth;
    }

    public void setHitbox(Rectangle rec)
    {
        this.hitbox = rec;
    }

    public boolean getInvincible()
    {
        return invincible;
    }

    public void dispose()
    {
        texture.dispose();
        hitboxT.dispose();
        bulletsManager.dispose();
    }

    public int getTotalHeath()
    {
        return totalHeath;
    }

    public int getNormalSpeed()
    {
        return normalSpeed;
    }

    public int getSlowSpeed()
    {
        return slowSpeed;
    }
}
