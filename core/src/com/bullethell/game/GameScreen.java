package com.bullethell.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bullethell.game.characters.BulletHellCharacters;
import com.bullethell.game.characters.GameCharacters;
import com.bullethell.game.characters.hero.HeroCharacter;
import com.bullethell.game.utils.Constants;

public class GameScreen implements Screen {

    private Camera camera;
    private Viewport viewport;
    private SpriteBatch spriteBatch;
    private Texture[] backgrounds;

    private float[] backGroundOffsets = {0,0,0,0};
    private float backgroundMaxScrollingSpeed;

    GameCharacters gameCharacters;

    HeroCharacter heroCharacter;

    GameScreen() {

        camera = new OrthographicCamera();
        viewport = new StretchViewport(Constants.GAME_WIDTH, Constants.GAME_HEIGHT, camera);

        backgrounds = new Texture[4];
        backgrounds[0] = new Texture("background.png");
        backgrounds[1] = new Texture("background1.png");
        backgrounds[2] = new Texture("background2.png");
        backgrounds[3] = new Texture("background4.png");

        backgroundMaxScrollingSpeed = (float) (Constants.GAME_HEIGHT / 4);

        spriteBatch = new SpriteBatch();
        gameCharacters = new BulletHellCharacters();
        heroCharacter = gameCharacters.createHero();
    }

    @Override
    public void render(float deltaTime) {
        spriteBatch.begin();

        //scrolling background
        renderBackground(deltaTime);
        //render hero
        heroCharacter.render(spriteBatch);
        heroCharacter.update(deltaTime);
        spriteBatch.end();
    }

    private void renderBackground(float detlaTime) {

        backGroundOffsets[0] += detlaTime + backgroundMaxScrollingSpeed / 64;
        backGroundOffsets[1] += detlaTime + backgroundMaxScrollingSpeed / 60;
        backGroundOffsets[2] += detlaTime + backgroundMaxScrollingSpeed / 58;
        backGroundOffsets[3] += detlaTime + backgroundMaxScrollingSpeed / 50;

        for (int i=0; i<backgrounds.length; i++) {
            if(backGroundOffsets[i] > Constants.GAME_HEIGHT) {
                backGroundOffsets[i] = 0;
            }
            spriteBatch.draw(backgrounds[i], 0, -backGroundOffsets[i], Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
            spriteBatch.draw(backgrounds[i], 0, -backGroundOffsets[i] + Constants.GAME_HEIGHT, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        }

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }
}
