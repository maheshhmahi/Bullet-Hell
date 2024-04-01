package com.bullethell.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.bullethell.game.bullet.Bullet;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    private int leftKey;
    private int rightKey;
    private int upKey;
    private int downKey;
    private int shootKey;
    private int addSpeedKey;
    private int speed;
    private int ac_speed;
    private Hero hero;
    private List<Bullet> bullets;

    public InputManager(Hero hero) {
        this.hero = hero;
        this.bullets = new ArrayList<>();
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public void setShootKey(int shootKey) {
        this.shootKey = shootKey;
    }

    public void setAddSpeedKey(int addSpeedKey) {
        this.addSpeedKey = addSpeedKey;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAc_speed(int ac_speed) {
        this.ac_speed = ac_speed;
    }

    public int getShootKey() {
        return shootKey;
    }


    public void move(float deltaTime) {
        if(Gdx.input.isKeyPressed(leftKey)) {
            hero.setSpeed(speed);
            if(Gdx.input.isKeyPressed(addSpeedKey) && hero.getSpeed() >= 300) {
                int speed = hero.getSpeed();
                speed -= ac_speed;
                hero.setSpeed(speed);
            }

            hero.moveX(-hero.getSpeed() * deltaTime);
        }

        if(Gdx.input.isKeyPressed(rightKey)) {
            hero.setSpeed(speed);
            if(Gdx.input.isKeyPressed(addSpeedKey) && hero.getSpeed() >= 300) {
                int speed = hero.getSpeed();
                speed -= ac_speed;
                hero.setSpeed(speed);
            }

            hero.moveX(hero.getSpeed() * deltaTime);
        }

        if(Gdx.input.isKeyPressed(upKey)) {
            hero.setSpeed(speed);
            if(Gdx.input.isKeyPressed(addSpeedKey) && hero.getSpeed() >= 300) {
                int speed = hero.getSpeed();
                speed -= ac_speed;
                hero.setSpeed(speed);
            }
            hero.moveY(hero.getSpeed() * deltaTime);
        }

        if(Gdx.input.isKeyPressed(downKey)) {
            hero.setSpeed(speed);
            if(Gdx.input.isKeyPressed(addSpeedKey) && hero.getSpeed() >= 300) {
                int speed = hero.getSpeed();
                speed -= ac_speed;
                hero.setSpeed(speed);
            }
            hero.moveY(-hero.getSpeed() * deltaTime);
        }
    }

}
