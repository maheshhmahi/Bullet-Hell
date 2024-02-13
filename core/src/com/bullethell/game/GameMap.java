package com.bullethell.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.characters.enemy.pattern.EnemyPattern;
import com.bullethell.game.characters.enemy.pattern.MidBossAPattern;
import com.bullethell.game.characters.enemy.pattern.MidBossbPattern;
import com.bullethell.game.characters.enemy.pattern.GeneralEnemyaPattern;
import com.bullethell.game.characters.hero.Hero;

import java.util.ArrayList;

public class GameMap extends Map {

    int stage;

    OrthographicCamera camera;
    SpriteBatch batch;
    Texture img;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;


    public GameMap() {
        tiledMap = new TmxMapLoader().load("map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        entities = new ArrayList<>();
        this.hero = new Hero(200, 100, this);
    }

    @Override
    public void dispose() {
        tiledMapRenderer.dispose();
    }

    @Override
    public void timePeriod(int begin, int end, EnemyPattern pattern) {
        if(TimeUtils.millis()-startTime >= begin && TimeUtils.millis()-startTime < end)
        {
            pattern.addEnemy(entities, this);
        }
    }

    @Override
    public void render(OrthographicCamera camera, SpriteBatch batch) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        super.render(camera, batch);
        batch.end();

    }


    @Override
    public void update(float delta) {

        timePeriod(1000, 1020, new GeneralEnemyaPattern());

        timePeriod(20000, 20020, new MidBossbPattern());

        timePeriod(40000, 40020, new MidBossAPattern());

        super.update(delta);
    }

    @Override
    public int getWidth() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }

    @Override
    public int getHeight() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }

    @Override
    public int getLayers() {
        return tiledMap.getLayers().getCount();
    }
}
