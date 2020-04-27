package Paoo_Game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean []keys;
    public boolean up, down ,left, right;


    public Keyboard()
    {
        keys = new boolean [256];
    }


    public void update()
    {
        up = keys[KeyEvent.VK_UP] ;
        down = keys[KeyEvent.VK_DOWN] ;
        left = keys[KeyEvent.VK_LEFT] ;
        right = keys[KeyEvent.VK_RIGHT] ;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        keys[e.getKeyCode()] = true;
        System.out.println("Pressed.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
