package Paoo_Game.Tiles;

import Paoo_Game.Graphics.Assets;

import java.awt.image.BufferedImage;

public class WaterTile extends Tile {


    public WaterTile( int ID) {
        super(Assets.water, ID);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
