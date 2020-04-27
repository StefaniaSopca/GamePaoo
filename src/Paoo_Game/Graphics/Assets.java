package Paoo_Game.Graphics;

import jdk.jshell.JShellException;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 33;
    private static final int height  = 33;

    public static BufferedImage []playerDown;
    public static BufferedImage []playerUp;
    public static BufferedImage []playerLeft;
    public static BufferedImage []playerRight;
    public static BufferedImage []start ;
    public static BufferedImage []instruction;


    public static BufferedImage meniubackground, instr_background;
    public static BufferedImage  water, grass, stonewall, stonedoor, stairs1 , stairs21 , stairs22 , falls, ponton1, ponton2, pancarda, redFlowers, cactus, bush;


    public static void init()
    {
        SpriteSheet background = new SpriteSheet(ImageLoader.loaderImage("/map_tile.png"));
        SpriteSheet character = new SpriteSheet(ImageLoader.loaderImage("/character_tile.png"));
        SpriteSheet startB = new SpriteSheet(ImageLoader.loaderImage("/start.png"));
        SpriteSheet meniuback = new SpriteSheet(ImageLoader.loaderImage("/background.png"));
        SpriteSheet instr = new SpriteSheet(ImageLoader.loaderImage("/instruction.png"));
        SpriteSheet instrBackground = new SpriteSheet(ImageLoader.loaderImage("/back.png"));

        instr_background =  instrBackground.crop(0,0,1920, 1080);

        start = new BufferedImage[2];
        start [0] = startB.crop(0 , 0 , 392,102);
        start[ 1] = startB.crop(0, 102,392 , 102);

        instruction = new BufferedImage[2];
        instruction [0] = instr.crop(0 , 0 , 393,103);
        instruction[ 1] = instr.crop(0, 102,393 , 103);

        meniubackground = meniuback.crop(0,0, 1920, 1080 );
        playerDown = new BufferedImage[3];
        playerUp = new BufferedImage[3];
        playerLeft = new BufferedImage[3];
        playerRight = new BufferedImage[3];


        playerDown[ 0 ] = character.crop(0,0 , 33, 36);
        playerDown[ 1 ] = character.crop(46,0 , 33, 36);
        playerDown[ 2 ] = character.crop(91,0 ,33, 36);

        playerUp[ 0 ] = character.crop(0,2 *36 , 33, 36);
        playerUp[ 1 ] = character.crop(46,2 *36 , 33, 36);
        playerUp[ 2 ] = character.crop(91,2 *36 , 33, 36);


        playerLeft[ 0 ] = character.crop(0,3 *36, 33, 36);
        playerLeft[ 1 ] = character.crop(46,3*36 , 33, 36);
        playerLeft[ 2 ] = character.crop(91,3 *36,33, 36);

        playerRight[ 0 ] = character.crop(0,1*36 , 33, 36);
        playerRight[ 1 ] =character.crop(46,1 *36, 33, 36);
        playerRight[ 2 ] = character.crop(91,1 *36,33, 36);


        grass = background.crop(1 * width +1, 2* height +1  , 32,32);
        stonewall = background.crop(3* width +1 , 1* height +1 ,32,32);
        stonedoor = background.crop(5* width+1 , 2* height +1 ,32,32);
        water =background.crop(3* width +1, 21* height +1 ,32,32);
        stairs1 = background.crop( 13*width+1 ,6* height  +1,32,32);
        stairs21 = background.crop( 11* width+1 ,3* height  +1,32,32);
        stairs22 = background.crop( 12* width+1 ,3* height  +1,32,32);
        falls  = background.crop( 0* width+1 ,18* height +1 ,32,32);
        ponton1 = background.crop( 3* width+1,18* height  +1,32,32);
        ponton2 = background.crop( 2* width+1 ,18* height +1 ,32,32);
        pancarda = background.crop( 7* width+1,4* height  +1,32,33);
        redFlowers = background.crop( 1* width+1 ,10* height +1 ,32,32);
        cactus = background.crop( 0* width +1,11*height  +1,32,32);
        bush = background.crop( 3* width+1 ,11* height +1 ,32,32);

      // player = character.crop(0,0 , 41, 36);
      // play1 = character.crop(1,0 , 41, 36);
       //play2=character.crop(2,2, 41, 36);
    }
}
