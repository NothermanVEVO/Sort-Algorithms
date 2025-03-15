package Sort;

import br.com.davidbuzatto.jsge.math.Vector2;

public class InsertionSort extends Sort{

    private boolean canStart = false;

    private int[] startArray;

    public InsertionSort(int[] array){
        super (
            800,                 
            450,                 
            "Insertion Sort",      
            60,                  
            true,                
            false,               
            false,               
            false,               
            false                
        );
        this.array = array;
        startArray = array.clone();
    }

    @Override
    public void create() {
    }

    @Override
    public void update(double delta) {
        startButton.update(delta);

        if (startButton.isMouseDown()) {
            tI = 0;
            countdown = 0;
            array = startArray.clone();
            canStart = true;
        }

        if (canStart) {
            countdown += delta;
            if(countdown >= DELAY){
                countdown -= DELAY;
                selectionSort(array);
            }
        }
    }

    @Override
    public void draw() {
        clearBackground(BLACK);
        startButton.draw();
        int startX = (int) ((WINDOW_WIDTH / 2.0) - ((ARRAY_WIDTH + ARRAY_SEPARATION) * (array.length / 2.0)));
        for (int i = 0; i < array.length; i++) {
            Vector2 position = new Vector2(startX + ((ARRAY_WIDTH + ARRAY_SEPARATION) * i), (WINDOW_HEIGHT / 2) - (ARRAY_WEIGHT * array[i]));
            fillRectangle(position, ARRAY_WIDTH, ARRAY_WEIGHT * array[i], WHITE);
            setFontSize(15);
            drawText(Integer.toString(array[i]), position.add(new Vector2((ARRAY_WIDTH / 2) - 7, (ARRAY_WEIGHT * array[i]) + 15)), WHITE);
        }
    }
    
}
