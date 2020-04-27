package Static;

import Paoo_Game.Graphics.Assets;
import Paoo_Game.Main.Handler;
import Paoo_Game.Tiles.Tile;

import java.awt.*;

public class Cactus extends  StaticEntity{

    public Cactus(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_W , Tile.TILE_H);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cactus, (int)(x - handler.getCamera().getxOffset()),(int)(y - handler.getCamera().getyOffset()), width, height, null);
    }


    public boolean isSolid() {
        return true;
    }
}
