package Paoo_Game.Main;

import Paoo_Game.Graphics.Camera;
import Paoo_Game.Input.Keyboard;
import Paoo_Game.Input.Mouse;
import Worlds.World;

import java.net.CacheRequest;

public class Handler {
    private Game game;
    private World world;
    public Handler(Game game)
    { this.game = game ;}

    public Camera getCamera()
    {
        return game.getCamera();
    }

    public Keyboard getKey()
    {
        return game.getKey();
    }

    public Mouse getMouse()
    {
        return game.getMouse();
    }

    public int getWidth()
    {
        return game.getWidth();
    }


    public int getHeigth()
    {
        return game.getHeight();
    }



    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
