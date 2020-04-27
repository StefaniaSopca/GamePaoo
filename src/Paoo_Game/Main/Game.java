package Paoo_Game.Main;

import Paoo_Game.Display.*;
import Paoo_Game.Graphics.*;
import Paoo_Game.Input.Keyboard;
import Paoo_Game.Input.Mouse;
import Paoo_Game.States.States;
import Paoo_Game.States.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Displayclass display;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public States gameState;
    public States menuState;
    public States instructionState;

    private Keyboard key;
    private Mouse mouse;

    private Camera camera;

    private Handler handler;

    private int width;
    private int height;
    public String title;
    private boolean running;
    public Game(String t, int w, int h)
    {
        width=w;
        height=h;
        title=t;
        key = new Keyboard();
        mouse = new Mouse();
    }

    private void init()
    {
        display = new Displayclass(title,width,height);
        display.getFrame().addKeyListener(key);

        display.getFrame().addMouseListener(mouse);
        display.getFrame().addMouseMotionListener(mouse);

        display.getCanvas().addMouseListener(mouse);
        display.getCanvas().addMouseMotionListener(mouse);

        Assets.init();
        handler = new Handler(this);
        camera = new Camera(handler,0, 0);

        //handler = new Handler(this);

        gameState = new GameStates(handler);
        menuState = new MenuState(handler);
        instructionState = new InstructionState(handler);

        States.setState(menuState);

    }


    private void update()
    {
        key.update();

        if(States.getState() != null)
            States.getState().update();
    }



    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return ;
        }

        g= bs.getDrawGraphics();

        g.clearRect(0, 0 ,width , height); //clean the screen

        if(States.getState() != null)
            States.getState().render(g);

       // g.drawImage(Assets.grass , 0,90,null);
        //g.drawImage(Assets.stairs1, 64,64,null);
        //g.drawImage(Assets.water, 189,189,null);

        //g.drawImage(Assets.player, 0,32 , null);
       // g.drawImage(Assets.play1, 250,250 , null);
        //g.drawImage(Assets.play2, 350,350 , null);

        bs.show();
        g.dispose();

    }


    public void run() {
        init();
        long oldTime = System.nanoTime(); //timp frame anterior;
        long currentTime; //timp de executie;
        long timer = 0;
        long updates= 0; //timer and update pt rularea corecta a codului- verificare

        final int framesPerSecond = 60;
        final double timeFrame = 1000000000 / framesPerSecond ;


        while(running) {                    //cat timp e threadul pornit

            currentTime = System.nanoTime();
            timer += currentTime - oldTime;

            if((currentTime - oldTime) > timeFrame) {
                update();
                render();
                updates++;
                oldTime = currentTime;
            }

        }
        stop();
    }


    public Keyboard getKey()
    {
        return key;
    }

    public Mouse getMouse() {return mouse;}

    public Camera getCamera()
    {
        return camera;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public synchronized  void start() //synchronized ~ semaforizat
    {
        if(running)
            return;

        running=true;
        thread = new Thread(this);
        thread.start();//apeleaza run methode
    }

    public synchronized  void stop()
    {
        if(running ==true) {
            running = false;
            try {
                thread.join(); //oprire a threadului
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            return;  //threadul este deja oprit;
        }
    }


}
