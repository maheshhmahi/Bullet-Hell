package com.bullethell.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.characters.enemy.pattern.EnemyPattern;
import com.bullethell.game.characters.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Map {

    protected Entity hero;
    protected List<Entity> entities;
    protected long startTime;

    public Map() {
        startTime = TimeUtils.millis();

    }

    public void render(OrthographicCamera camera, SpriteBatch batch) {
        hero.render(batch);
        for(Entity entity: entities) {
            entity.render(batch);
        }
    }

    public void update(float delta) {
        hero.update(delta);
        List<Entity> entitiesToRemove = new ArrayList<>();
        for(Entity entity: entities) {
            entity.update(delta);
            if(entity.remove) {
                entitiesToRemove.add(entity);
            }
        }
        entities.removeAll(entitiesToRemove);
    }

    public Entity getHero() {
        return this.hero;
    }

    public abstract void dispose();

    public abstract void timePeriod(int begin, int end, EnemyPattern pattern);

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getLayers();

}
