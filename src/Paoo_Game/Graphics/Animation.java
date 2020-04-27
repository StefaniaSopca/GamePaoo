package Paoo_Game.Graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private int speed;
    private int index;
    private long oldTime;
    private long timer;
    private BufferedImage[] frames;

    public Animation(int s, BufferedImage[] f)
    {
        speed = s;
        frames = f;
        index = 0;
        oldTime = System.currentTimeMillis();
        timer = 0;
    }

    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }

    public void update()
    {
        timer += System.currentTimeMillis() - oldTime;
        oldTime = System.currentTimeMillis();
        if( timer > speed )
        {
            index ++;
            timer= 0;
            if( index >= frames.length)
                index = 0;
        }
    }
}
