package com.bullethell.game.world;

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
    private long lastHitTime = 0;
    private boolean invincible = false;
    private boolean noBullet = false;
    protected boolean isWin;
    protected long winTime;

    public long getWinTime() {
        return winTime;
    }

    public boolean isWin() {
        return isWin;
    }

    public Map() {
        startTime = TimeUtils.millis();

    }

    public void render(OrthographicCamera camera, SpriteBatch batch) {
        hero.render(batch);
        for(Entity entity: entities) {
            entity.render(batch);
        }
    }

    public void setInvincible(boolean invincible)
    {
        this.invincible = invincible;
    }
    public boolean getInvincible()
    {
        return this.invincible;
    }

    public boolean getNoBullet()
    {
        return this.noBullet;
    }
    public void setNoBullet(boolean noBullet)
    {
        this.noBullet = noBullet;
    }



    public void setLastHitTime(long lastHitTime)
    {
        this.lastHitTime = lastHitTime;
    }
    public long getLastHitTime()
    {
        return this.lastHitTime;
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
        if(TimeUtils.nanoTime()-lastHitTime>5000000000L) {
            this.invincible = false;
        }
        if(TimeUtils.nanoTime()-lastHitTime>2000000000L) {
            this.noBullet = false;
        }
        entities.removeAll(entitiesToRemove);

    }

    public Entity getHero()
    {
        return this.hero;
    }

    public abstract void dispose();

    public abstract void timePeriod(int begin, int end, EnemyPattern pattern);

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getLayers();

    public List<Entity> getEntities() {
        return entities;
    }

}
