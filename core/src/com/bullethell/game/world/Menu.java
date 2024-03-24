package com.bullethell.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bullethell.game.utils.Button;
import com.bullethell.game.utils.Constants;

public class Menu {

    private Texture bg;
    private Button playButton;

    public Menu()
    {
        bg = new Texture("test_back.jpg");
        playButton = new Button(new Texture("emptyButton.png"), 140, 70, Constants.GAME_WIDTH /2, Constants.GAME_HEIGHT/2);
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bg, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        batch.end();
        playButton.render(batch);
    }

    public boolean readyToChange()
    {
        return playButton.isClicked();
    }

    public void dispose() {
        bg.dispose();
        playButton.dispose();
    }

}
