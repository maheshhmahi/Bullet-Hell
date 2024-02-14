package com.bullethell.game.bullet;

import com.bullethell.game.bullet.actions.ShootAround;
import com.bullethell.game.bullet.actions.ShootStraightDown;

public class BulletFactory {

    public MidBossBBullet createMidBossBBullet(float x, float y, float dx, float dy) {
        return new MidBossBBullet(x, y, dx, dy, BulletType.MID_BOSS_B.getSpeed(), BulletType.MID_BOSS_B.getImage(), new ShootAround(x, y, dx, dy));
    }

    public FinalBossBullet1 createFinalBossBullet(float x, float y, float dx, float dy) {
        return new FinalBossBullet1(x, y, dx, dy, BulletType.FINAL_BOSS_1.getSpeed(), BulletType.MID_BOSS_B.getImage(), new ShootAround(x, y, dx, dy));
    public MidBossABullet createMidBossABullet(float x, float y, float dx, float dy) {
        return new MidBossABullet(x, y, dx, dy, BulletType.MID_BOSS_A.getSpeed(), BulletType.MID_BOSS_A.getImage(), new ShootStraightDown(x, y));
    }
}
