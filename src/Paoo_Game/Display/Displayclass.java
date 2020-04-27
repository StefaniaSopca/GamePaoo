package Paoo_Game.Display;

import javax.swing.*;
import java.awt.*;

public class Displayclass {

    private JFrame frame ;//display
    private Canvas canvas; //grafics


    private String title;
    private int width;
    private int height;

    public Displayclass(String t, int w, int h)
    {
        title=t;
        width=w;
        height=h;

        createDisplay();
    }

    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//w/o this the console closes but not the game

        frame.setResizable(false);//with width and height not resizeable
        frame.setLocationRelativeTo(null);//center location
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));

        canvas.setFocusable(false); //!!!!!!!move the player

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame(){ return frame;}
}
