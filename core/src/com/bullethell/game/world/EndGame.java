package com.bullethell.game.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bullethell.game.utils.Button;
import com.bullethell.game.utils.Constants;

public class EndGame {

    private Texture bg;
//    private NameTextInput getName;
    private Button menuButton;
    private boolean enableMenuButton;

    public EndGame()
    {
        bg = new Texture("test_back.jpg");
//        getName = new NameTextInput();
        menuButton = new Button(new Texture("emptyButton.png"), 140, 70, Constants.GAME_WIDTH /2, Constants.GAME_HEIGHT/2);
        enableMenuButton = false; //at first, does not let change to main Menu (until enter name)
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bg, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        batch.end();
        menuButton.render(batch);
    }


    public void update(float delta) {
        /*if (getName.isClicked())
            enableMenuButton = true;*/
    }

    public boolean readyToChange()
    {
        if (enableMenuButton == true)
            return menuButton.isClicked();
        return false;
    }


    public void dispose() {
        bg.dispose();
        menuButton.dispose();
    }

}
