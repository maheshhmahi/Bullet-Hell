package com.bullethell.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.bullethell.game.characters.enemy.pattern.EnemyPattern;
import com.bullethell.game.characters.enemy.pattern.MidBossbPattern;
import com.bullethell.game.characters.hero.Hero;
import com.bullethell.game.utils.Constants;

import java.util.ArrayList;

public class BeginGameMap extends Map {

    private Texture background1, background2;
    private int bgYOffset1, bgYOffset2;
    private BitmapFont font;


    public BeginGameMap() {
        entities = new ArrayList<>();
        this.hero = new Hero(200, 100, this);

        background1 = new Texture("background.png");
        background2 = new Texture("background.png");
        bgYOffset1 = 0;
        bgYOffset2 = Constants.GAME_HEIGHT;
        font = new BitmapFont();
    }

    @Override
    public void dispose() {
        background1.dispose();
        background2.dispose();
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
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background1, 0, bgYOffset1, (int) (Constants.GAME_WIDTH), (int) (Constants.GAME_HEIGHT));
        batch.draw(background2, 0, bgYOffset2, (int) (Constants.GAME_WIDTH), (int) (Constants.GAME_HEIGHT));
        super.render(camera, batch);

        font.getData().setScale(1.1f);
        font.draw(batch, "Lives: " + hero.getLives(), Constants.GAME_WIDTH-100, Constants.GAME_HEIGHT-20);
        font.draw(batch, "Score: " + hero.score, Constants.GAME_WIDTH-100, Constants.GAME_HEIGHT-50);

        font.getData().setScale(1.5f);
        if (hero.isDie())
        {
            font.draw(batch, "Game Over!", Constants.GAME_WIDTH/2-40, Constants.GAME_HEIGHT/2);
        }
        else if (isWin)
        {
            font.draw(batch, "WIN!", Constants.GAME_WIDTH/2-30, Constants.GAME_HEIGHT/2);
        }
        batch.end();
    }


    @Override
    public void update(float delta) {

//        timePeriod(1000, 1020, new GeneralEnemyaPattern());
//        timePeriod(22000, 22020, new GeneralEnemybPattern());
//        timePeriod(45000, 45020, new MidBossAPattern());
//        timePeriod(1000, 1020, new GeneralEnemyaPattern()); // Adjusted timing for the second MidBossbPattern
//        timePeriod(2000, 2020, new GeneralEnemyaPattern()); // Adjusted timing for the second MidBossbPattern
        timePeriod(1000, 1020, new MidBossbPattern()); // Adjusted timing for the second MidBossbPattern
//        timePeriod(10000, 10020, new MidBossbPattern()); // Adjusted timing for the second MidBossbPattern
//        timePeriod(50000, 50020, new FinalBossPattern()); // Adjusted timing for the FinalBossPattern

        super.update(delta);

        //running background
        bgYOffset1 -=1;
        if ( bgYOffset1*(-1) >= Constants.GAME_HEIGHT) {
            bgYOffset1 = Constants.GAME_HEIGHT;
        }
        bgYOffset2 -=1;
        if ( bgYOffset2*(-1) >= Constants.GAME_HEIGHT) {
            bgYOffset2 = Constants.GAME_HEIGHT;
        }

        updateWinning();
    }

    private void updateWinning()
    {
        isWin = this.entities.size() > 0 &&
                this.entities.get(this.entities.size() - 1).isDie();
        if (isWin)
            winTime = TimeUtils.nanoTime();
    }

    @Override
    public int getWidth(){ return  0;}
    @Override
    public int getHeight(){ return 0;}
    @Override
    public int getLayers(){return 0;}
}