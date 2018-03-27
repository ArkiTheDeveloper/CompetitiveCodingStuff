import java.util.Arrays;

public class MergeSort {

    private static void sort(Integer[] array) {
        // If the size is 1, array is already sorted
        if (array.length <= 1) {
            return;
        }
        // Calculating the mid element
        int mid = array.length / 2;

        // Computing array from 0 -- mid-1
        // Computing array from mid -- length -1;
        Integer[] leftArray = getSubArray(array, 0, mid);
        Integer[] rightArray = getSubArray(array, mid, array.length);

        // recursively calling to sort the left part
        sort(leftArray);
        // recursively calling to sort the right part
        sort(rightArray);
        // Merging the two sub arrays
        merge(array, leftArray, rightArray);
    }

    private static Integer[] getSubArray(Integer[] array, int startIndex, int lastIndex) {
        Integer [] newArray = new Integer[lastIndex - startIndex];
        int counter = 0;
        for (int i = startIndex; i< lastIndex; i ++) {
            newArray[counter++] = array[i];
        }
        return newArray;
    }

    private static void merge(Integer[] array, Integer[] leftArray, Integer[] rightArray) {
        int aIn = 0;
        int lIn = 0;
        int rIn = 0;

        // Merging the two sub arrays
        while (lIn < leftArray.length && rIn < rightArray.length) {
            if (leftArray[lIn] <= rightArray[rIn]) {
                array[aIn++] = leftArray[lIn++];
            } else {
                array[aIn++] = rightArray[rIn++];
            }
        }

        // Merging the remaining elements of either of the arrays
        if (lIn < leftArray.length) {
            while (lIn < leftArray.length) {
                array[aIn++] = leftArray[lIn++];
            }
        } else {
            while (rIn < rightArray.length) {
                array[aIn++] = rightArray[rIn++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{20, 12, 42, 53, 6, 2, 1, 6};
        sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
