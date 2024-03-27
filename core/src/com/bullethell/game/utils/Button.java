package com.bullethell.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button {

    private Texture texture;
    private int width;
    private int height;
    private int middleX; //where the center of the button is in the frame MyGdxGame
    private int middleY; //where the center of the button is in the frame MyGdxGame

    public Button(Texture texture, int width, int height, int middleX, int middleY)
    {
        this.texture = texture;
        this.height = height;
        this.width = width;
        this.middleX = middleX;
        this.middleY = middleY;
    }

    public void render(SpriteBatch batch)
    {
        batch.begin();
        batch.draw(texture, middleX - width/2, middleY - height/2, width, height);
        batch.end();
    }

    public boolean isClicked()
    {
        if (Gdx.input.justTouched())
        {
            //System.out.println("touch " +  Gdx.input.getX() + " " + Gdx.input.getY());
            //if the touch is within the button area
            if ((Gdx.input.getX() >= middleX - width/2 &&
                    Gdx.input.getX() <= middleX + width/2) &&
                    (Gdx.input.getY() >= Constants.GAME_HEIGHT-(middleY + height/2) &&
                            Gdx.input.getY() <= Constants.GAME_HEIGHT-(middleY - height/2)))
            {
                //System.out.println("inside");
                return true;
            }
        }
        return false;
    }

    public void dispose() {
        texture.dispose();
    }

}
