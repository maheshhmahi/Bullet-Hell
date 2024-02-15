package com.bullethell.game.bullet;

public enum BulletType {
    MID_BOSS_B("midBossbBullet.png", 300),
    FINAL_BOSS_1("FinalBossFire.png", 300),
    MID_BOSS_A("midBossABullet.png", 200);

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
