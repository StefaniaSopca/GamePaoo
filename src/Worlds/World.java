package Worlds;

import Paoo_Game.Entity.ManagerEntity;
import Paoo_Game.Entity.Player;
import Paoo_Game.Main.Game;
import Paoo_Game.Main.Handler;
import Paoo_Game.Tiles.Tile;
import Static.Cactus;
import Static.RedFlowersTile;
import Utils.Util;

import java.awt.*;

public class World {

    private int width;
    private int heigth;
    private Handler handler;
    private int spawnX, spawnY;

    private int[][] tiles;

    private ManagerEntity managerEntity;

    public World(Handler handler, String path)
    {
        this.handler = handler;
        managerEntity = new ManagerEntity(handler, new Player(  handler, 400,400)); ///////////////////////////////

        managerEntity.addEntity(new Cactus(handler, 90, 40));
        managerEntity.addEntity(new Cactus(handler, 200, 40));
        managerEntity.addEntity(new Cactus(handler, 400, 40));

        managerEntity.addEntity(new RedFlowersTile( handler, 190, 190));
        loadWorld(path);
        managerEntity.getPlayer().setX(spawnX);
        managerEntity.getPlayer().setY(spawnY);
    }

    public void update()
    {
        managerEntity.update();
    }

    public void render(Graphics g)
    {
        int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_W);
        int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_W + 1);
        int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_H);
        int yEnd = (int) Math.min(heigth, (handler.getCamera().getyOffset() + handler.getHeigth()) / Tile.TILE_H + 1);

        for(int y = yStart;y < yEnd;y++){
            for(int x = xStart;x < xEnd;x++){
                getTile(x, y).render(g, (int) (x * Tile.TILE_W - handler.getCamera().getxOffset()),
                        (int) (y * Tile.TILE_H - handler.getCamera().getyOffset()));
            }
        }

        managerEntity.render(g);
    }

    public Tile getTile(int x, int y)
    {
        if( x < 0 || y<0 || x>= width || y >=heigth)
            return Tile.stoneWallTile;

        Tile t = Tile.tiles[tiles[x][y]];

        if( t ==null)
            return Tile.grassTile;//DALA IMPLICITA
        return t;
    }

    private void loadWorld(String path)
    {
       /* width = 30;
        heigth =30;
        tiles = new int [width][heigth];

        for( int x = 0; x < width ; x++) {
            for (int y = 0; y < heigth; y++) {
                tiles[x][y] = 0;
            }
        }*/

       String file = Util.loadFileAsString(path);
       String[] token = file.split("\\s+");

       width = Util.parseInt(token[0]);
       heigth = Util.parseInt(token[1]);
       spawnX = Util.parseInt(token[2]);
       spawnY =Util.parseInt(token[3]);

       tiles = new int[width][heigth];

        for (int y = 0; y < heigth; y++) {
            for( int x = 0; x < width ; x++)
            {
                tiles[x][y] = Util.parseInt(token[(x + y * width) +4]); //4 primele 4 variabile
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public ManagerEntity getManagerEntity() {
        return managerEntity;
    }

    public void setManagerEntity(ManagerEntity managerEntity) {
        this.managerEntity = managerEntity;
    }
}
