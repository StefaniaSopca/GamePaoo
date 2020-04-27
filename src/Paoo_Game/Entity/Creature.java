package Paoo_Game.Entity;

import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;
import Paoo_Game.Tiles.Tile;

public abstract class Creature  extends Entity{

    public static final int  HEALTH =10;
    public static final float SPEED = 3.0f;
    public static final int WIDTH_C = 48;
    public static final int HEIGHT_C = 48;

    protected int health ;
    protected float speed;

    protected float xMove, yMove;


    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y , width , height);
        health = HEALTH;
        speed = SPEED;
        xMove =0;
        yMove = 0;
    }

    public void move()
    {
        if(!checkCollesionEntity(xMove, 0f))
            moveX();
        if(!checkCollesionEntity(0f, yMove))
            moveY();
    }

    public void moveX()
    {
        if(xMove > 0) //dreapta
        {
            int aux = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILE_W;
            if(! collesionTile(aux , (int)(y + bounds.y ) / Tile.TILE_H) && !collesionTile(aux, (int)(y + bounds.y + bounds.height)/Tile.TILE_H))
            {
                x +=xMove;
            }else
            {
                x = aux * Tile.TILE_W - bounds.x - bounds.width -1;
            }
        }
        else if(xMove < 0) //stanga
        {
            int aux = (int)(x + xMove + bounds.x ) / Tile.TILE_W;
            if(! collesionTile(aux , (int)(y + bounds.y ) / Tile.TILE_H) && !collesionTile(aux, (int)(y + bounds.y + bounds.height)/Tile.TILE_H))
            {
                x +=xMove;
            }else
            {
                x = aux *Tile.TILE_W + Tile.TILE_W - bounds.x;
            }
        }
    }

    public void moveY()
    {
        if( yMove < 0) //sus
        {
            int aux = (int)(y + yMove +bounds.y) / Tile.TILE_H;
            if(! collesionTile((int)(x + bounds.x ) / Tile.TILE_W , aux) && !collesionTile((int)(x + bounds.x +bounds.width) / Tile.TILE_W , aux))
            {
                y+= yMove;
            }
            else
            {
                y = aux * Tile.TILE_H + Tile.TILE_H - bounds.y ;
            }
        }
        else if(yMove >0 ) //jos
        {
            int aux = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_H;
            if (!collesionTile((int) (x + bounds.x) / Tile.TILE_W, aux) && !collesionTile((int) (x + bounds.x + bounds.width) / Tile.TILE_W, aux)) {
                y += yMove;
            }
            else{
                y = aux * Tile.TILE_H - bounds.width -bounds.y -1;
            }
        }

    }

    protected boolean collesionTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).isSolid();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
