package Sort;

import br.com.davidbuzatto.jsge.math.Vector2;

public class InsertionSort extends Sort{

    private int tI = 1;

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
            tI = 1;
            countdown = 0;
            array = startArray.clone();
            waitingToSort = false;
            canStart = true;
            isSorted = false;
            textAnim = 0;
        }

        if (canStart) {
            countdown += delta;
            if(countdown >= DELAY){
                textAnim++;
                if (textAnim > 3) {
                    textAnim = 0;
                }
                countdown -= DELAY;
                insertionSort(array);
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
        setFontSize(30);
        if (waitingToSort) {
            drawText("Waiting to sort...", new Vector2(15, WINDOW_HEIGHT - 30), RED);
        } else if (canStart) {
            drawText("Sorting" + (textAnim == 0 ? "" : textAnim == 1 ? "." : textAnim == 2 ? ".." : "..."), new Vector2(15, WINDOW_HEIGHT - 30), WHITE);
        } else if (isSorted) {
            drawText("Sorted!", new Vector2(15, WINDOW_HEIGHT - 30), GREEN);
        }
    }

    private void insertionSort(int arr[]){
        isSorted = false;
        int n = arr.length;
        for (int i = tI; i < n;) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            ++tI;
            return;
        }
        canStart = false;
        isSorted = true;
    }
    
}
