package Paoo_Game.Entity;

import Paoo_Game.Graphics.Animation;
import Paoo_Game.Graphics.Assets;
import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Player extends Creature{

    private  Animation down , right, left,up ;


    public Player(Handler handler, float x, float y)
    {
        super(handler,x, y, Creature.WIDTH_C, Creature.HEIGHT_C);
        bounds.x =20;
        bounds.y = 30;
        bounds.width = 15;
        bounds.height  =5;
        right = new Animation(500 , Assets.playerRight);
        down = new Animation(500 , Assets.playerDown);
        up = new Animation(500 , Assets.playerUp);
        left= new Animation(500 , Assets.playerLeft);
        //right = new Animation(500 , Assets.playerRight);

    }

    @Override
    public void update()
    {
        /*if(game.getKey().up)
            y -= 3;

        if(game.getKey().down)
            y += 3;

        if(game.getKey().left)
            x -= 3;

        if(game.getKey().right)
            x += 3;
            */
        right.update();
        down.update();
        up.update();
        left.update();
        //right.update();
        getInput();
        move();
        handler.getCamera().centerEntity(this);
    }

    private void getInput()
    {
        xMove = 0;
        yMove = 0;

        if( handler.getKey().up)
        {
            yMove = -speed;
        }

        if( handler.getKey().down)
        {
            yMove = speed;
        }


        if( handler.getKey().left)
        {
            xMove = -speed;
        }


        if( handler.getKey().right)
        {
            xMove = speed;
        }

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(getCurrentAniFrame(), (int)(x - handler.getCamera().getxOffset() ), (int)(y - handler.getCamera().getyOffset()) , width, height, null); //x, y from Entity


        //g.setColor(Color.RED);
        //g.fillRect((int)(x +bounds.x - handler.getCamera().getxOffset()) ,(int)(y +bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAniFrame()
    {
        if( xMove < 0){
            return left.getCurrentFrame();}
        else
            if(xMove > 0){
                return right.getCurrentFrame();}
            else
                if(yMove < 0){
                    return up.getCurrentFrame();}
                else{
                    return down.getCurrentFrame();}

    }
}
