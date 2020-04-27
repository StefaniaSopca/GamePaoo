package Paoo_Game.Entity;

import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;

import java.awt.*;

public abstract class Entity {
    protected Handler handler;

    protected float x, y;    //position

    protected int width ;
    protected int height;
    protected Rectangle bounds;


    public Entity(Handler handler,float x, float y, int w, int h)
    {
        this.handler = handler;
        this.x =x ;
        this.y =y;
        height = h;
        width = w;

        bounds = new Rectangle(0,0,width ,height);

    }




    public abstract void update();

    public abstract void render(Graphics g);

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int)(x + bounds.x + xOffset ), (int)(y + bounds.y + yOffset), bounds.width  , bounds.height);
    }

    public boolean checkCollesionEntity(float xOffset, float yOffset)
    {

        for( Entity e: handler.getWorld().getManagerEntity().getEntities()) {
            if( e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
