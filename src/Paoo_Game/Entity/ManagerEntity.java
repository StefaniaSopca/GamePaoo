package Paoo_Game.Entity;

import Paoo_Game.Main.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ManagerEntity {

    private Player player;
    private Handler handler;
    private ArrayList<Entity> entities;
    private Comparator<Entity> sortRender = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if( a.getY() + a.getHeight()< b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };


    public ManagerEntity(Handler handler, Player player)
    {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void update()
    {
        for(int i = 0 ; i< entities.size(); i++)
        {
            Entity e = entities.get(i);
            e.update();
        }

        entities.sort(sortRender);
        //player.update();
    }


    public void render(Graphics g)
    {
        for(Entity e : entities)
        {
            e.render(g);
        }
        //player.render(g);
    }

    public void addEntity(Entity e)
    {
        entities.add(e);
    }



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
