package com.bullethell.game.bullet;

import com.badlogic.gdx.graphics.Texture;

public class HeroBullet extends Bullet{

    public HeroBullet() {
        super();
        texture = new Texture("heroBullet.png");
        size.x = size.y = 20;
        hitbox.setSize(size.x, size.y);
        damage = 10;
    }

}
