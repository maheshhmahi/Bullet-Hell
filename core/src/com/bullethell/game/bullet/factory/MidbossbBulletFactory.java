package com.bullethell.game.bullet.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bullethell.game.bullet.Bullet;
import com.bullethell.game.bullet.BulletType;
import com.bullethell.game.bullet.MidBossBBullet;
import com.bullethell.game.bullet.actions.ShootAround;

import java.util.ArrayList;

public class MidbossbBulletFactory extends BulletFactory {

    public MidbossbBulletFactory(float x, float y, float dx, float dy) {
        this.setX(x);
        this.setY(y);
        this.setDx(dx);
        this.setDy(dy);
        this.shootingActions = new ArrayList<>();
        createGraph();

    }

    @Override
    protected void addShootingAction() {
        shootingActions.add(new ShootAround(getX(), getY(), getDx(), getDy(), getSprite()));
    }

    @Override
    public Bullet createBullet() {
        addShootingAction();
        return new MidBossBBullet(
                getX(),
                getY(),
                getDx(),
                getDy(),
                BulletType.MID_BOSS_B.getSpeed(),
                shootingActions);
    }

    @Override
    public void createGraph() {
        sprite = new Sprite(new Texture(BulletType.MID_BOSS_B.getImage()));
        sprite.setPosition(x, y);
        sprite.setSize(25, 25);
    }
}
