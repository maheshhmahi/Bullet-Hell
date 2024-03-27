package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bullethell.game.utils.Constants;
import com.bullethell.game.world.GameStates;

public class BulletHellGame extends ApplicationAdapter {

    public static final int WIDTH = Constants.GAME_WIDTH;
    public static final int HEIGHT = Constants.GAME_HEIGHT;

    public static final String TITLE = "Bullet Hell";

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private GameStates gameStates;

    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        camera.update();
        gameStates = gameStates.getInstance();
    }

    @Override
    public void render () {

        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        gameStates.checkIfMovingState();
        gameStates.render(camera, batch);
    }

    @Override
    public void dispose () {
        batch.dispose();
    }

}
