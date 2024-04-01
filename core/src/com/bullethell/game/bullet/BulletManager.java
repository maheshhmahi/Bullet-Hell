package com.bullethell.game.bullet;

import com.bullethell.game.bullet.factory.BulletFactory;
import com.bullethell.game.bullet.factory.FinalBossBulletFactory;
import com.bullethell.game.bullet.factory.HeroBulletFactory;
import com.bullethell.game.bullet.factory.MidbossbBulletFactory;
import com.bullethell.game.bullet.factory.EnemyOneBulletFactory;
import com.bullethell.game.bullet.factory.EnemyTwoBulletFactory;

public class BulletManager {

    private volatile static BulletManager bulletManager;
    private String midBossbStatus;

    private String FinalBossStatus;
    private BulletFactory factory;

    public String getMidBossbStatus() {
        return midBossbStatus;
    }

    private BulletManager() {

    }

    public static BulletManager getInstance() {
        if (bulletManager == null) {
            synchronized (BulletManager.class) {
                if (bulletManager == null) {
                    bulletManager = new BulletManager();
                }
            }
        }
        return bulletManager;
    }

    public Bullet createFinalBossBullet(float x, float y) {
        factory = new FinalBossBulletFactory(x, y);
        factory.setStatus(getFinalBossStatus());
        return factory.createBullet();
    }

    public Bullet createMidBossBBullet(float x, float y, float dx, float dy) {
        factory = new MidbossbBulletFactory(x, y, dx, dy);

        factory.setStatus(getMidBossbStatus());

        return factory.createBullet();
    }

    public Bullet createHeroBullet(float x, float y) {
        factory = new HeroBulletFactory(x, y);
        return factory.createBullet();
    }

    public Bullet createEnemyOneBullet(float x, float y, float dx, float dy) {
        factory = new EnemyOneBulletFactory(x, y, dx, dy);
        return factory.createBullet();
    }

    public Bullet createEnemyTwoBullet(float x, float y) {
        factory = new EnemyTwoBulletFactory(x, y);
        return factory.createBullet();
    }
//    public FinalBossBullet1 createFinalBossBullet(float x, float y, float dx, float dy) {
//        return new FinalBossBullet1(x, y, dx, dy, BulletType.FINAL_BOSS_1.getSpeed(), BulletType.MID_BOSS_B.getImage(), new ShootAround(x, y, dx, dy));
//    }
//
//    public MidBossABullet createMidBossABullet(float x, float y, float dx, float dy) {
//        return new MidBossABullet(x, y, dx, dy, BulletType.MID_BOSS_A.getSpeed(), BulletType.MID_BOSS_A.getImage(), new ShootStraightDown(x, y));
//    }

    public String getFinalBossStatus() {
        return FinalBossStatus;
    }

    public void setFinalBossStatus(String status) {
        this.FinalBossStatus = status;
    }

}

