package Sort;

import br.com.davidbuzatto.jsge.math.Vector2;

public class SelectionSort extends Sort {

    private int tI = 0;

    private boolean canStart = false;

    private int[] startArray;

    public SelectionSort(int[] array){
        super (
            WINDOW_WIDTH,                 
            WINDOW_HEIGHT,                 
            "Selection Sort",      
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

    private void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = tI; i < n - 1;) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;

            tI++;
            return;
        }
    }
    
}
