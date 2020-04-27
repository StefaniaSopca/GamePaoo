package Paoo_Game.States;

import Paoo_Game.Graphics.Assets;
import Paoo_Game.Main.Handler;
import Paoo_Game.UI.UIImageB;
import Paoo_Game.UI.UIImageO;
import Paoo_Game.UI.UIManager;

import java.awt.*;

public class InstructionState extends  States{
    //private BufferedImage instruction;
    private UIManager uiManager;


    public InstructionState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        uiManager.addObject(new UIImageO(0, 0, 900, 700, Assets.instr_background));


       // SpriteSheet instruction = new SpriteSheet(ImageLoader.loaderImage("/instruction.png"));
    }

    @Override
    public void update() {
        //uiManager.update();
        //handler.getMouse().setUiManager(uiManager);
        //uiManager.addObject();

    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

    }
}
