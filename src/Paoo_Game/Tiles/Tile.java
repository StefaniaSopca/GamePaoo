package Paoo_Game.Tiles;

import Static.BushTile;
import Static.PancardaTile;
import Static.RedFlowersTile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0 );
    public static Tile stoneWallTile = new StoneWallTile(1);
    public static Tile stairs21Tile = new Stairs21Tile(2);
    public static Tile stairs22Tile = new Stairs22Tile(3);
    public static Tile waterTile = new WaterTile(4);
    public static Tile fallsTile = new FallsTile(5);
    //public static Tile cactusTile = new CactusTile(6);
    //public static Tile redFlowersTile = new RedFlowersTile(7);
    //public static Tile bushTile = new BushTile(8);
    public static Tile ponton1Tile = new Ponton1Tile(9);
    public static Tile ponton2Tile = new Ponton2Tile(10);
   // public static Tile pancardaTile = new PancardaTile(11);


    protected BufferedImage texture;
    protected final int ID;

    public static final int TILE_W =48;
    public static final int TILE_H = 48; /////////////////DACA SE SUPRAPUNE PUNE 33       !!!!!!!!!!!!!



    public Tile(BufferedImage texture , int ID)
    {
        this.texture = texture;
        this.ID = ID;

        tiles[ID] = this;
    }

    public int getID()
    {
        return ID;
    }


    public void update()
    {

    }

    public boolean isSolid()
    {
        return false;
    }

    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x , y, TILE_W, TILE_H , null);
    }
}
