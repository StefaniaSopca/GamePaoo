package Paoo_Game.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loaderImage(String path)
    {
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
