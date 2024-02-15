package com.bullethell.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class BulletHellGame extends ApplicationAdapter {

    int stage;

    OrthographicCamera camera;
    SpriteBatch batch;
    Texture img;

    Map map;
    @Override
    public void create () {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);
        camera.update();
        map = new GameMap();

    }

    @Override
    public void render () {
        //Gdx.gl.glClearColor(1, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        map.update(Gdx.graphics.getDeltaTime());

        map.render(camera, batch);

    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }

}
