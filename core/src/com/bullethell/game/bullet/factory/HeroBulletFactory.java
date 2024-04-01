package com.bullethell.game.bullet.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.bullet.BulletType;
import com.bullethell.game.bullet.HeroBullet;
import com.bullethell.game.bullet.actions.ShootStraightUp;

import java.util.ArrayList;


public class HeroBulletFactory extends BulletFactory{

    public HeroBulletFactory(float x, float y) {
        this.setX(x);
        this.setY(y);
        this.shootingActions = new ArrayList<>();
        this.rectangleBullet = new Rectangle(x, y, 20, 20);
        createGraph();
    }

    public void createGraph() {
        sprite = new Sprite(new Texture(BulletType.HERO.getImage()));
        sprite.setPosition(x, y);
        sprite.setSize(12, 12);
    }

    @Override
    protected void addShootingAction() {
        shootingActions.add(new ShootStraightUp(getX(), getY(), getSprite()));
    }

    @Override
    public Bullet createBullet() {
        addShootingAction();
        return new HeroBullet(getX(), getY(), BulletType.HERO.getSpeed(), shootingActions, rectangleBullet);
    }


}
