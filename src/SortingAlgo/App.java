package SortingAlgo;
public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        int [] intArray = new int[]{0,12,10,9,0,13,105, -9,98};
        // int [] sortedArray = app.bSort(intArray);
        // System.out.println("-----------------Bubble Sort----------------------------");
        // for (int i : sortedArray) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("---------------------------------------------");

        // int[] sortedArray = app.sSort(intArray);
        // System.out.println("-----------------Selection Sort----------------------------");
        // for (int i : sortedArray) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("---------------------------------------------");

        // int [] sortedArray = app.iSort(intArray);
        // System.out.println("-----------------Insertion Sort----------------------------");
        // for (int i : sortedArray) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("---------------------------------------------");

        // iSortRecursive(intArray, intArray.length);
        // System.out.println("-----------------Insertion Sort- Recursive---------------------------");
        // for (int i : intArray) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("---------------------------------------------");

        //System.out.println(app.factorial(10));

        // mergeSort(intArray, 0, intArray.length);
        // System.out.println("-----------------Merge Sort----------------------------");
        // for (int i : intArray) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("---------------------------------------------");

        // quickSort(intArray, 0, intArray.length);
        // System.out.println("-----------------Quick Sort----------------------------");
        // for (int i : intArray) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("---------------------------------------------");
         
        int[] resultArr = app.twoSum(intArray, 22);
        for(int k : resultArr) {
            System.out.println(k);
        }
    }

    // Bubble Sort Algo
    /** In Bubble Sort algorithm for Ascending order we partition the array into sorted and unsorted parts.
     * This is logical partitioning. The way it works is we bubble the highest element to the end of the array,
     * and we keep doing it till we have completly sorted array.
     * This is a Stable and In-Place Algorithm with Quadratic O(n2) complexity, i.e., algo degrades quickly.
     * @param intArray
     * @return
     */
    public int[] bSort(int [] intArray) {
        for (int index = 0; index < intArray.length - 1; index++) {
            for (int j = 0; j < intArray.length - 1 - index; j++) {
                if (intArray[j] > intArray[j+1]) {
                    int temp = intArray[j+1];
                    intArray[j+1] = intArray[j];
                    intArray[j] = temp;
                }
                
            }
        }
        return intArray;
    }

    // Selection Sort Algo 
    /** In Selection sort Descending order, we assume the first element is the sorted array.
     * Then wwe compare that element to all other elements and find the largest element. We then swap it with
     * sorted element and increment the counter. Thus with every iteration creating a sorted array.
     * @param intArray
     * @return
    */
    public int[] sSort(int [] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            int j;
            int maxIndex = i;
            for ( j = i + 1; j < intArray.length; j++) {
                if (intArray[j] > intArray[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (intArray[i] != intArray[maxIndex]) {
                int temp = intArray[i];
                intArray[i] = intArray[maxIndex];
                intArray[maxIndex] = temp;
            }
        }
        return intArray;
    }
    
    // Insertion Sort
    /** In Insertion sort we logically devide the array in sorted and unsorted elements.
     * We then add an unsorted element, find it's suitable position and then insert it in that position.
     * Thus eventually creating a sorted array.
     * @param intArray
     * @return
     */
    public int[] iSort(int [] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            int newElement = intArray[i];
            int j;
            for (j = i; j > 0 && intArray[j - 1] > newElement ; j--) {
                intArray [j] = intArray [j - 1];
            }
            intArray[j] = newElement;
        }
        return intArray;
    }

    public static void iSortRecursive(int [] intArray, int length) {
        int i = length;
        if (i == 1) {
            return;
        }
        iSortRecursive(intArray, --i);
        insert(intArray, i);
    }

    private static void insert(int[] intArray, int length) {
        int newElement = intArray[length];
        int j;
        for (j = length; j > 0 && intArray[j - 1] > newElement; j--) {
            intArray[j] = intArray[j - 1];
        }
        intArray[j] = newElement;
    }


    // Factorial using recursion
    public int factorial(int number) {
        if (number == 0) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    //Merge Sort using Recursive technic
    /** In merge sort we partition the array then keep on partitioning it until we have individual elements
     * We then start sorting them one by one from left to right. Below algorithm is a recursive one.
     */
    public static void mergeSort(int[] inputArr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (end + start) / 2;
        mergeSort(inputArr, start, mid); // left
        mergeSort(inputArr, mid, end);   // right
        //mergeAsc(inputArr, start, mid, end);
        mergeDesc(inputArr, start, mid, end);
    }

    private static void mergeAsc(int[] inputArr, int start, int mid, int end) {
        if (inputArr[mid - 1] <= inputArr[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];
        while(i < mid && j < end) {
            temp[tempIndex++] = inputArr[i] <= inputArr[j] ? inputArr[i++] : inputArr[j++];
        }
        System.arraycopy(inputArr, i, inputArr, (start + tempIndex), mid - i);
        System.arraycopy(temp, 0, inputArr, start, tempIndex);

    }

    private static void mergeDesc(int[] inputArr, int start, int mid, int end) {
        if (inputArr[mid - 1] >= inputArr[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];
        while(i < mid && j < end) {
            temp[tempIndex++] = inputArr[i] >= inputArr[j] ? inputArr[i++] : inputArr[j++];
        }
        System.arraycopy(inputArr, i, inputArr, (start + tempIndex), mid - i);
        System.arraycopy(temp, 0, inputArr, start, tempIndex);
    }

    /** Quick Sort Recursive ****************************
     * In quick sort we randomly choose a pivot and then sort elements around the pivot value.
     * So, for say, elements greater than pivot will be on right side and elements smaller 
     * than pivot will be on left side, thus cementing that element's position. 
     * Then, we continue on changing pivot and adjuting array values until
     * each and every element becomes pivot once and thus cementing it's position.
     * @param inputArr
     * @param start
     * @param end
     */
    public static void quickSortRecursive(int[] inputArr, int start, int end) {
        // if only one element then return
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(inputArr, start, end);
        quickSort(inputArr, start, pivotIndex);   // sort left
        quickSort(inputArr, pivotIndex + 1, end); // sort right
    }

    public static void quickSort(int[] inputArr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        for (int i = 0; i < inputArr.length; i++) {
            int pivotIndex = partition(inputArr, start, end);
            start = pivotIndex;
            System.out.println("pivotIndex: " + pivotIndex);
        }

    }

    private static int partition(int[] inputArr, int start, int end) {
        int i = start;
        int j = end;
        int pivot = inputArr[start];

        while (i < j) {

            while (i < j && inputArr[--j] >= pivot);
            if (i < j) {
                inputArr[i] = inputArr[j];
            }

            while(i < j && inputArr[++i] <= pivot);
            if (i < j) {
                inputArr[j] = inputArr[i];
            }
        }
        inputArr[j] = pivot;
        return j;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] towSumIndex = new int[2];
        for (int i=0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    towSumIndex[0] = i;
                    towSumIndex[1] = j;
                }
            }
        }
        return towSumIndex;
        
    }
}
