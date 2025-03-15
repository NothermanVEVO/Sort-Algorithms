package Sort;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.imgui.GuiButton;
import br.com.davidbuzatto.jsge.imgui.GuiTheme;

public abstract class Sort extends EngineFrame {

    protected int array[];

    protected final static int WINDOW_WIDTH = 800;
    protected final static int WINDOW_HEIGHT = 450;

    protected double countdown = 0.0f;
    protected final static double DELAY = 0.500f;

    protected final static int ARRAY_WEIGHT = 10;
    protected final static int ARRAY_WIDTH = 25;
    protected final static int ARRAY_SEPARATION = 10;

    private final static int BUTTON_WIDTH = 150;
    private final static int BUTTON_HEIGHT = 75;
    private final static int BUTTON_SEPARATION = 10;

    protected final GuiButton startButton = new GuiButton(WINDOW_WIDTH - BUTTON_WIDTH - BUTTON_SEPARATION, WINDOW_HEIGHT - BUTTON_HEIGHT - BUTTON_SEPARATION, BUTTON_WIDTH, BUTTON_HEIGHT, "Start", this);

    public Sort(int windowWidth, int windowHeight, String windowTitle, int targetFPS, boolean antialiasing) {
        super(windowWidth, windowHeight, windowTitle, targetFPS, antialiasing);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        startButton.apply(GuiTheme.buildLightTheme());
    }

    public Sort(int windowWidth, int windowHeight, String windowTitle, int targetFPS, boolean antialiasing,
            boolean resizable, boolean fullScreen, boolean undecorated, boolean alwaysOnTop) {
        super(windowWidth, windowHeight, windowTitle, targetFPS, antialiasing, resizable, fullScreen, undecorated, alwaysOnTop);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
