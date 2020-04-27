package Paoo_Game.States;

import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;

import java.awt.*;

public abstract class States {

    protected Handler handler;

    public States(Handler handler)
    {
        this.handler = handler;
    }

    private static States currentState = null;

    public static void setState(States state){

        currentState = state;

    }

    public static States getState()
    {
        return currentState;
    }


    public abstract void update();

    public abstract void render(Graphics g);


}
