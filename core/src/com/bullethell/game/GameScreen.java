package com.bullethell.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private Camera camera;
    private Viewport viewport;
    private SpriteBatch spriteBatch;
//    private Texture background;
    private Texture[] backgrounds;

//    private int backGroundOffset;

    private float[] backGroundOffsets = {0,0,0,0};
    private float backgroundMaxScrollingSpeed;
    private final int WIDTH = 72;
    private final int HEIGHT = 128;

    GameScreen() {

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WIDTH, HEIGHT, camera);
//        background = new Texture("background.png");
//        backGroundOffset = 0;
        backgrounds = new Texture[4];
        backgrounds[0] = new Texture("background.png");
        backgrounds[1] = new Texture("background1.png");
        backgrounds[2] = new Texture("background2.png");
        backgrounds[3] = new Texture("background4.png");

        backgroundMaxScrollingSpeed = (float) (HEIGHT / 4);

        spriteBatch = new SpriteBatch();

    }

    @Override
    public void render(float deltaTime) {
        spriteBatch.begin();

        //scrolling background
        renderBackground(deltaTime);
        spriteBatch.end();
    }

    private void renderBackground(float detlaTime) {

        backGroundOffsets[0] += detlaTime + backgroundMaxScrollingSpeed / 64;
        backGroundOffsets[1] += detlaTime + backgroundMaxScrollingSpeed / 60;
        backGroundOffsets[2] += detlaTime + backgroundMaxScrollingSpeed / 58;
        backGroundOffsets[3] += detlaTime + backgroundMaxScrollingSpeed / 50;

        for (int i=0; i<backgrounds.length; i++) {
            if(backGroundOffsets[i] > HEIGHT) {
                backGroundOffsets[i] = 0;
            }
            spriteBatch.draw(backgrounds[i], 0, -backGroundOffsets[i], WIDTH, HEIGHT);
            spriteBatch.draw(backgrounds[i], 0, -backGroundOffsets[i] + HEIGHT, WIDTH, HEIGHT);
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
