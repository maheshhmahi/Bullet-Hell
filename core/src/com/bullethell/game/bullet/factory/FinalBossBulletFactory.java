package com.bullethell.game.bullet.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.bullet.BulletType;
import com.bullethell.game.bullet.FinalBossBullet;
import com.bullethell.game.bullet.actions.*;

import java.util.ArrayList;

public class FinalBossBulletFactory extends BulletFactory {
    private String status;

    // Constructor to initialize the factory with coordinates
    public FinalBossBulletFactory(float x, float y) {
        this.setX(x);
        this.setY(y);
        createGraph(); // Initialize the sprite
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Method to add a shooting action to the list
    protected void addShootingAction(ShootingAction action) {
        shootingActions.add(action);
    }

    // Method to create a bullet
    @Override
    public Bullet createBullet() {
        this.shootingActions = new ArrayList<>();
        switch (status) {
            case "down":
                addShootingAction(new ShootStraightDown(x, y, getSprite()));
                break;
            case "up":
                addShootingAction(new ShootStraightUp(x, y, getSprite()));
                break;
            case "right":
                addShootingAction(new ShootStraightRight(x, y, getSprite()));
                break;
            case "left":
                addShootingAction(new ShootStraightLeft(x, y, getSprite()));
                break;
        }
        return new FinalBossBullet(getX(), getY(), BulletType.FINAL_BOSS.getSpeed(), shootingActions);
    }

    // Method to create a sprite
    @Override
    public void createGraph() {
        sprite = new Sprite(new Texture(BulletType.FINAL_BOSS.getImage()));
        sprite.setPosition(x, y);
        sprite.setSize(25, 25);
    }

    // This method seems unnecessary and can be removed
    @Override
    protected void addShootingAction() {
        // This method does nothing, consider removing it
    }
}
