package Paoo_Game.States;

import Paoo_Game.Graphics.Assets;
import Paoo_Game.Main.Handler;
import Paoo_Game.UI.ClickListener;
import Paoo_Game.UI.UIImageB;
import Paoo_Game.UI.UIImageO;
import Paoo_Game.UI.UIManager;

import java.awt.*;

public class MenuState extends States {
    private UIManager uiManager;

    public MenuState(Handler handler)
    {
        super(handler);
        uiManager = new UIManager(handler);

        handler.getMouse().setUiManager(uiManager);

        uiManager.addObject(new UIImageO(0, 0, 900, 700, Assets.meniubackground ));

        uiManager.addObject(new UIImageB(350, 100, 180, 70, Assets.start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouse().setUiManager(null);
                States.setState(handler.getGame().gameState);
                //States.setState(handler.getGame().instructionState);

            }
        }));



        uiManager.addObject(new UIImageB(350, 300, 180, 70, Assets.instruction,new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouse().setUiManager(null);
                States.setState(handler.getGame().instructionState);
                //States.setState(handler.getGame().instructionState);

            }
        }));


    }



    @Override
    public void update()
    {
        //if(handler.getMouse().isLeftPressed() && handler.getMouse().isRightPressed())
            //States.setState(handler.getGame().gameState);
        //
        // System.out.println(handler.getMouse().getMouseX() + " " +handler.getMouse().getMouseY());
        uiManager.update();
    }


    @Override
    public void render(Graphics g)
    {
        uiManager.render(g);
        ///g.setColor(Color.pink);
       // g.fillRect(handler.getMouse().getMouseX(), handler.getMouse().getMouseY(),8,8);
    }
}

