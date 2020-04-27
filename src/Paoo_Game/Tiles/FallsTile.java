package Paoo_Game.Tiles;

import Paoo_Game.Graphics.Assets;

import java.awt.image.BufferedImage;

public class FallsTile extends Tile {
    public FallsTile( int ID) {
        super(Assets.falls, ID);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
