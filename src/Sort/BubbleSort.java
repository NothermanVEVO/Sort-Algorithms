package Sort;

import br.com.davidbuzatto.jsge.math.Vector2;

public class BubbleSort extends Sort{

    private int tI = 0;
    private int tJ = 0;
    private boolean hasSwapped = false;

    public BubbleSort(int[] array){
        super (
            800,                 
            450,                 
            "Bubble Sort",      
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
            tJ = 0;
            hasSwapped = false;
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
                bubbleSort(array);
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

    private void bubbleSort(int arr[]){
        isSorted = false;
        int i, j, temp;
        boolean swapped;
        int n = arr.length;
        for (i = tI; i < n - 1;) {
            swapped = hasSwapped;
            for (j = tJ; j < n - i - 1;) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    hasSwapped = true;
                }
                tJ++;
                return;
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false){
                break;
            }
            tI++;
            tJ = 0;
            hasSwapped = false;
            return;
        }
        canStart = false;
        isSorted = true;
    }
    
}
