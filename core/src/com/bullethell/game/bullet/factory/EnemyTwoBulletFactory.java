package com.bullethell.game.bullet.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.bullet.BulletType;
import com.bullethell.game.bullet.EnemyTwoBullet;
import com.bullethell.game.bullet.actions.ShootStraightDown;


import java.util.ArrayList;

public class EnemyTwoBulletFactory extends BulletFactory{
    public EnemyTwoBulletFactory(float x, float y) {
        this.setX(x);
        this.setY(y);
        this.shootingActions = new ArrayList<>();
        createGraph();
    }

    @Override
    protected void addShootingAction() {
        shootingActions.add(new ShootStraightDown(getX(), getY(), getSprite()));
    }

    @Override
    public Bullet createBullet() {
        addShootingAction();
        return new EnemyTwoBullet(getX(), getY(), BulletType.ENEMY_2.getSpeed(), shootingActions);
    }

    @Override
    public void createGraph() {
        sprite = new Sprite(new Texture(BulletType.ENEMY_2.getImage()));
        sprite.setPosition(x, y);
        sprite.setSize(25, 25);
    }


}
