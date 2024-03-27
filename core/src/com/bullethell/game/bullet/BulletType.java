package com.bullethell.game.bullet;

public enum BulletType {
    MID_BOSS_B("midBossbBullet.png", 300),
    FINAL_BOSS("FinalBossFire.png", 300),
    MID_BOSS_A("midBossABullet.png", 200),
    HERO("midBossbBullet.png", 300);

    private String image;
    private int speed;

    BulletType(String image, int speed) {
        this.image = image;
        this.speed = speed;
    }

    public String getImage() {
        return image;
    }

    public int getSpeed() {
        return speed;
    }
}
