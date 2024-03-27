package com.bullethell.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

public class GameStates {

    private static GameStates _instance;
    private Map playState;
    private Menu beginState;
    private EndGame endState;
    private int stateNum; //1 = beginState, 2= playState, 3 = endState
    private Music music;
    private long playStateEnd;

    protected GameStates()
    {
        beginState = new Menu();
        stateNum = 1;
        setMusic("menuMusic.mp3", true, 0.5f);
        music.play();
        playStateEnd = 0;
    }

    private void setMusic(String musicPath, boolean looping, float volume)
    {
        music = Gdx.audio.newMusic(Gdx.files.internal(musicPath));
        music.setLooping(looping);
        music.setVolume(volume);
    }

    public static GameStates getInstance()
    {
        if (_instance == null)
        {
            _instance = new GameStates();
        }
        return _instance;
    }

    //update state number when triggered
    public void checkIfMovingState()
    {
        switch (stateNum)
        {
            case 1: //the game is at state 1

                if (beginStateIsTriggered()) { // if state 1 is triggered to move to next state
                    playState = new BeginGameMap();
                    beginState.dispose();
                    stateNum += 1;
                    playStateEnd = 0;
                    changeMusic("playMusic.mp3", true, 0.5f);
                }
                break;
            case 2:
                if (playStateIsTriggered() && playStateEnd==0)//just win/lose
                {
                    playStateEnd = TimeUtils.nanoTime();
                }

                if (playStateIsTriggered() && TimeUtils.nanoTime() - playStateEnd > 3000000000L) {
                    System.out.println("----------");
                    endState = new EndGame();
                    playState.dispose();
                    stateNum += 1;
                    changeMusic("menuMusic.mp3", true, 0.1f);
                }
                break;
            case 3:
                if (endStateIsTriggered()) {
                    beginState = new Menu();
                    endState.dispose();
                    stateNum = 1; //loop back to beginning state
                }
                break;
        }
    }

    public void changeMusic(String newMusicPath, boolean newLooping, float newVolume)
    {
        music.stop();
        setMusic(newMusicPath, newLooping, newVolume);
        music.play();
    }

    //the beginning state is triggered to move to next state
    private boolean beginStateIsTriggered()
    {
        return beginState.readyToChange();
    }

    //the end state is triggered to move to next state
    private boolean endStateIsTriggered()
    {
        return endState.readyToChange();
    }

    //the play state is triggered to move to next state
    private boolean playStateIsTriggered()
    {
        return (playState.getHero().isDie() ||
                playState.isWin());
    }

    //render a state depending on the state number
    public void render(OrthographicCamera camera, SpriteBatch batch)
    {
        switch (stateNum)
        {
            case 1: //if updated state number is 1, move to state 1: beginningState
                beginState.render(batch);
                break;
            case 2:
                playState.update(Gdx.graphics.getDeltaTime());
                playState.render(camera, batch);
                break;
            case 3:
                endState.update(Gdx.graphics.getDeltaTime());
                endState.render(batch);
                break;
        }
    }

}
