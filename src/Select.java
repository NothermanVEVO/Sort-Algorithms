import Sort.BubbleSort;
import Sort.InsertionSort;
import Sort.MergeSort;
import Sort.SelectionSort;
import Sort.Sort;
import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.imgui.GuiButton;

public class Select extends EngineFrame {

    private final static int WINDOW_WIDTH = 800;
    private final static int WINDOW_HEIGHT = 450;

    private final static int BUTTON_WIDTH = 150;
    private final static int BUTTON_HEIGHT = 75;
    private final static int BUTTON_SEPARATION = 10;

    GuiButton selectionButton = new GuiButton((WINDOW_WIDTH / 2) - (BUTTON_WIDTH / 2), (WINDOW_HEIGHT / 2) - ((BUTTON_HEIGHT + BUTTON_SEPARATION) * 4 / 2), BUTTON_WIDTH, BUTTON_HEIGHT, "Selection Sort", this);
    GuiButton insertionButton = new GuiButton((WINDOW_WIDTH / 2) - (BUTTON_WIDTH / 2), (WINDOW_HEIGHT / 2) - ((BUTTON_HEIGHT + BUTTON_SEPARATION)), BUTTON_WIDTH, BUTTON_HEIGHT, "Insertion Sort", this);
    GuiButton bubbleButton = new GuiButton((WINDOW_WIDTH / 2) - (BUTTON_WIDTH / 2), (WINDOW_HEIGHT / 2), BUTTON_WIDTH, BUTTON_HEIGHT, "Bubble Sort", this);
    GuiButton mergeButton = new GuiButton((WINDOW_WIDTH / 2) - (BUTTON_WIDTH / 2), (WINDOW_HEIGHT / 2) + ((BUTTON_HEIGHT + BUTTON_SEPARATION)), BUTTON_WIDTH, BUTTON_HEIGHT, "Merge Sort", this);

    Select(){
        super (
            WINDOW_WIDTH,                 
            WINDOW_HEIGHT,                 
            "Title Screen",      
            60,                  
            true,                
            false,               
            false,               
            false,               
            false                
        );
    }

    @Override
    public void create() {
        Sort.setMainFrame(this);
    }

    @Override
    public void update(double delta) {
        selectionButton.update(delta);
        insertionButton.update(delta);
        bubbleButton.update(delta);
        mergeButton.update(delta);

        if (selectionButton.isMousePressed()) {
            new SelectionSort(new int[]{9, 3, 1, 5, 4, 8, 10, 9, 2});
            setState(ICONIFIED);
        } else if (insertionButton.isMousePressed()) {
            new InsertionSort(new int[]{9, 3, 1, 5, 4, 8, 10, 9, 2});
            setState(ICONIFIED);
        } else if (bubbleButton.isMousePressed()) {
            new BubbleSort(new int[]{9, 3, 1, 5, 4, 8, 10, 9, 2});
            setState(ICONIFIED);
        } else if (mergeButton.isMousePressed()) {
            new MergeSort(new int[]{9, 3, 1, 5, 4, 8, 10, 9, 2});
            setState(ICONIFIED);
        }
    }

    @Override
    public void draw() {
        selectionButton.draw();
        insertionButton.draw();
        bubbleButton.draw();
        mergeButton.draw();
    }

    public static void main(String[] args){
        new Select();
    }

}
