package Paoo_Game.States;

import Paoo_Game.Entity.Player;
import Paoo_Game.Graphics.Camera;
import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;
import Paoo_Game.Tiles.Tile;
import Static.Cactus;
import Worlds.World;

import java.awt.*;

public class GameStates  extends States{

    //private Player player;
    private World world;
    //private Cactus cactus;

    public GameStates(Handler handler){
        super(handler);
        world = new World(handler, "res/Worlds/w1.txt");
        handler.setWorld(world);
        //player = new Player(handler, 110, 110);
        //cactus = new Cactus(handler, 200,200);
        //world = new World(handler, "res/Worlds/w1.txt");

       //handler.getCamera().move(0,0);
    }


    @Override
    public void update()
    {
        world.update();
       // player.update();
        //cactus.update();
        //handler.getCamera().move(1,1);
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
        //player.render(g);
        //cactus.render(g);
        //Tile.tiles[3].render(g, 0 , 0);
        //Tile.tiles[5].render(g, 1,0);
       //Tile.tiles[2].render(g, 2,0);
    }
}
