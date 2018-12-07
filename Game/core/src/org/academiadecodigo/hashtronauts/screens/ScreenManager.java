package org.academiadecodigo.hashtronauts.screens;

import org.academiadecodigo.hashtronauts.DeltaGame;

import java.util.HashMap;

public class ScreenManager {

    protected final DeltaGame game;

    private HashMap<STATE, AbstractScreen> screens;

    public enum STATE{
        PLATFORM1,
        PLATFORM2
    }

    public ScreenManager(final DeltaGame game){
        this.game = game;

        initScreen();
        setScreen(STATE.PLATFORM1);
    }

    public void initScreen(){
        this.screens = new HashMap<STATE, AbstractScreen>();
        this.screens.put(STATE.PLATFORM1, new Level1(game));
    }

    public void setScreen(STATE nextScreen){
        game.setScreen(screens.get(nextScreen));
    }

    public void dispose(){
        for (AbstractScreen screen : screens.values()){
            if (screen!=null){
                screen.dispose();
            }
        }
    }
}
