package Paoo_Game.Tiles;

import Paoo_Game.Graphics.Assets;

public class StoneWallTile extends Tile{


    public StoneWallTile(int ID) {
        super(Assets.stonewall ,ID);
    }

    @Override
    public boolean isSolid() {
        return true ;
    }
}
