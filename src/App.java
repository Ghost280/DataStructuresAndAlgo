public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        int [] intArray = new int[]{12,10,9,0,13,105};
        int [] sortedArray = app.bSort(intArray);
        System.out.println("-----------------Bubble Sort----------------------------");
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------------");

        sortedArray = app.sSort(intArray);
        System.out.println("-----------------Selection Sort----------------------------");
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
    }

    // Bubble Sort Algo
    public int[] bSort(int [] intArray) {
        for (int index = 0; index < intArray.length - 2; index++) {
            for (int j = 0; j < intArray.length - 2 - index; j++) {
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

    // public int[] iSort(int [] intArray) {
    //     for (int i = 0; i < intArray.length - 1; i++) {
    //         int minIndex = i;
    //         for (int j = i + 1; j > 0; j--) {
    //             if (intArray[j] <= intArray[minIndex]) {
    //                 minIndex = j;
    //             }
    //         }
    //         int temp = intArray[minIndex];
    //         intArray[minIndex]
    //     }
    // }

}
