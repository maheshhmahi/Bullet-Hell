package com.bullethell.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bullethell.game.Map;
import com.bullethell.game.characters.entity.Entity;
import com.bullethell.game.characters.entity.EntityType;
import com.bullethell.game.utils.Constants;

import java.util.ArrayList;

public class Hero extends Entity implements HeroCharacter{
    private Vector2 position;
    private Vector2 size;
    private Texture texture;
    private int currentSpeed;
    private Rectangle boxHit;
    private int acceleration;
    private static int normalSpeed = Constants.HERO_NORMAL_SPEED;
    private static int slowSpeed = Constants.HERO_SLOW_SPEED;

    public static int leftKey = Input.Keys.LEFT;
    public static int rightKey = Input.Keys.RIGHT;
    public static int upKey = Input.Keys.UP;
    public static int downKey = Input.Keys.DOWN;
    public static int slowSpeedKey = Input.Keys.SHIFT_LEFT;

    public Hero(float x, float y, Map map) {
        super(x, y, EntityType.HERO, map);
        position = new Vector2(Constants.GAME_WIDTH / 2, 100);
        size = new Vector2(60,60);
        texture = new Texture("playerShip1_red.png");
        currentSpeed = Constants.HERO_CURRENT_SPEED;
        boxHit = new Rectangle(position.x + size.x/2, position.y+size.y/2, size.x/60, size.y/60);
        //hero inputKeyManager todo
        acceleration = 100;

        this.setImage(type.getImage());
//        this.setHitboxImage("hitbox.png");
        this.setHitBoxSize(type.getHeight()-40, type.getWidth()-40);
//        SPEED = type.getSpeed();
        this.setLives(type.getLive());
        this.getHitbox().setPosition(this.getPosX(), this.getPosY());
    }

    public Vector2 getPosition() {
        return position;
    }
    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
        boxHit.setPosition(position.x + size.x/2, position.y + size.y/2);
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Rectangle getBoxHit() {
        return boxHit;
    }

    public void setBoxHit(Rectangle boxHit) {
        this.boxHit = boxHit;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public static int getNormalSpeed() {
        return normalSpeed;
    }

    public static void setNormalSpeed(int normalSpeed) {
        Hero.normalSpeed = normalSpeed;
    }

    public static int getSlowSpeed() {
        return slowSpeed;
    }

    public static void setSlowSpeed(int slowSpeed) {
        Hero.slowSpeed = slowSpeed;
    }

    private void controlBorder() {
        if(position.x < 0)
            setPosition(0, position.y);
        if(position.x > Constants.GAME_WIDTH - size.x)
            setPosition(Constants.GAME_WIDTH - size.x, position.y);
        if(position.y < 0)
            setPosition(position.x, 0);
        if(position.y > Constants.GAME_HEIGHT - size.y)
            setPosition(position.x, Constants.GAME_HEIGHT - size.y);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, position.x, position.y, size.x, size.y);
    }

    private void handleInputs(float deltaTime) {

        if(Gdx.input.isKeyPressed(leftKey))
            setPosition(getPosition().x - getCurrentSpeed() * deltaTime, getPosition().y);

        if(Gdx.input.isKeyPressed(rightKey))
            setPosition(getPosition().x + getCurrentSpeed() * deltaTime, getPosition().y);

        if(Gdx.input.isKeyPressed(upKey))
            setPosition(getPosition().x, getPosition().y + getCurrentSpeed() * deltaTime);

        if(Gdx.input.isKeyPressed(downKey))
            setPosition(getPosition().x, getPosition().y - getCurrentSpeed() * deltaTime);

        if(Gdx.input.isKeyPressed(slowSpeedKey))
            setCurrentSpeed(Constants.HERO_SLOW_SPEED);
        else
            setCurrentSpeed(Constants.HERO_NORMAL_SPEED);
    }
    @Override
    public void update(float deltaTime) {
        handleInputs(deltaTime);
        controlBorder();
    }

}
