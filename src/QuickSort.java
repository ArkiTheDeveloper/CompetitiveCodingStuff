import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static void sort(Integer[] array, int startIndex, int endIndex) {
        // If the segment is invalid, just return
        if (startIndex >= endIndex) {
            return;
        }

        // Selecting the segment partitioning index
        // "semi-sorts" the array by selecting the pivot element
        // and placing it where all the elements lesser than the
        // pivot element are on the left and all the elements greater
        // than the pivot element are on the right.
        int partitionIndex = getPartition(array, startIndex, endIndex);

        // Calling recursively to sort the left segment
        sort(array, startIndex, partitionIndex - 1);

        // Calling recursively to sort the right segment
        sort(array, partitionIndex + 1, endIndex);
    }

    private static int getPartition(Integer[] array, int startIndex, int endIndex) {

        Random random = new Random();

        // Select the last element of the whole array
        // as the pivot element

        /*
        int pivotElementIndex = random.nextInt(endIndex);
        swap(array, pivotElementIndex, endIndex);
        */
        int pivotElement = array[endIndex];

        // Get the starting index to start
        // the comparison
        int partitionIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (pivotElement >= array[i]) {
                swap(array, partitionIndex, i);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, endIndex);
        return partitionIndex;
    }

    private static void swap(Integer[] array, int partitionIndex, int i) {
        int swap = array[i];
        array[i] = array[partitionIndex];
        array[partitionIndex] = swap;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{20, 12, 42, 53, 6, 2, 1, 6};
        sort(array, 0, 7);
        Arrays.stream(array).forEach(System.out::println);
    }
}
