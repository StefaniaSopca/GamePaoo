package Paoo_Game.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageO extends  UIObject{

    //private BufferedImage [] instruction;
    private BufferedImage background;
    //private ClickListener clicker;

    public UIImageO(float x, float y, int width, int height, BufferedImage background) {
        super(x, y, width, height);

        this.background  = background;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(background, 0 ,0 , 900, 700, null);


    }

    @Override
    public void onClick() {

    }
}
