package Paoo_Game.Graphics;

import Paoo_Game.Entity.Entity;
import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;
import Paoo_Game.Tiles.Tile;

public class Camera {

    private float xOffset;
    private float yOffset;
    private Handler handler;
    public Camera(Handler handler, float xOffset, float yOffset)
    {
        this.handler =handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void spaceCamera()
    {
        if(xOffset < 0)
        {
            xOffset = 0 ; //spatiu sus
        }
        else
             if ( xOffset > handler.getWorld().getWidth() * Tile.TILE_W - handler.getWidth())
                 xOffset = handler.getWorld().getWidth() * Tile.TILE_W - handler.getWidth();  //spatiu jos
        if(yOffset < 0 )
        {
            yOffset = 0; //spatiu stanga
        }
        else
            if( yOffset > handler.getWorld().getHeigth() *Tile.TILE_H -handler.getHeigth())
                yOffset =handler.getWorld().getHeigth() *Tile.TILE_H -handler.getHeigth();

    }

    public  void centerEntity(Entity e)
    {
        xOffset = e.getX() - handler.getWidth() /2 +e.getWidth() /2;
        yOffset = e.getY()- handler.getHeigth()/2 +e.getHeight()/2;
        spaceCamera();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }


    public void move(float x,float y){
        xOffset +=x;
        yOffset +=y;
        spaceCamera();
    }
}
