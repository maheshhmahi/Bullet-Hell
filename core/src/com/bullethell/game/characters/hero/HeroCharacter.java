package com.bullethell.game.characters.hero;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface HeroCharacter {

    void render(SpriteBatch spriteBatch);

    void update(float deltaTime);

}
