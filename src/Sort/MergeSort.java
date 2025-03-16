package Sort;

import br.com.davidbuzatto.jsge.math.Vector2;

public class MergeSort extends Sort {

    private int tI = 1;
    private int tJ = 0;

    public MergeSort(int[] array){
        super (
            800,                 
            450,                 
            "Merge Sort",      
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
            tJ = 0;
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
                mergeSort(array);
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

    // Main sorting function
    private void mergeSort(int[] arr) {
        isSorted = false;
        int n = arr.length;
        
        // Iterate through subarrays of increasing size
        for (int currSize = tI; currSize <= n - 1;) {
            
            // Pick starting points of different
            // subarrays of current size
            for (int leftStart = tJ; leftStart < n - 1;) {
                
                // Find endpoints of the subarrays to be merged
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);
                
                // Merge the subarrays arr[leftStart...mid]
                // and arr[mid+1...rightEnd]
                merge(arr, leftStart, mid, rightEnd);
                tJ += 2 * currSize;
                return;
            }
            tJ = 0;
            tI = 2 * currSize;
            return;
        }
        canStart = false;
        isSorted = true;
    }

    // Helper function to merge two sorted portions of the array
    private void merge(int[] arr, int left, int mid, int right) {
        
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays 
        // for left and right subarrays
        int[] arr1 = new int[n1], arr2 = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            arr1[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            arr2[j] = arr[mid + 1 + j];
        
        int i = 0;    
        int j = 0;    
        int k = left; 
        
        // Merge the temp arrays back into arr
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of arr1[] if any
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of arr2[] if any
        while (j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
    
}
