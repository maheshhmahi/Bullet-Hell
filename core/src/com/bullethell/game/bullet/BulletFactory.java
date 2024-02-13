package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootAround;

public class BulletFactory {

    public MidBossBBullet createMidBossBBullet(float x, float y, float dx, float dy) {
        return new MidBossBBullet(x, y, dx, dy, BulletType.MID_BOSS_B.getSpeed(), BulletType.MID_BOSS_B.getImage(), new ShootAround(x, y, dx, dy));
    }

    public FinalBossBullet1 createFinalBossBullet1(float x, float y, float dx, float dy) {
        return new FinalBossBullet1(x, y, dx, dy, BulletType.FINAL_BOSS_1.getSpeed(), BulletType.MID_BOSS_B.getImage(), new ShootAround(x, y, dx, dy));
    }
}
