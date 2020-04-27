package Paoo_Game.Graphics;

import Paoo_Game.Tiles.Tile;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    //private static final int tileW = 33;
    //private static final int tileH = 33;


    public SpriteSheet(BufferedImage sheet) //constructor
    {
        this.sheet = sheet;
    }

    public BufferedImage crop( int x, int y , int width, int heigth )
    {
        return sheet.getSubimage(x , y  , width, heigth); //returneaza o dala
    }

}
