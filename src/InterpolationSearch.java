import java.util.Arrays;
import java.util.Scanner;

public class InterpolationSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the search key: ");
        int key = scanner.nextInt();

        long startTime = System.nanoTime(); // Start measuring time

        // Sort the array in ascending order
        Arrays.sort(array);

        int result = interpolationSearch(array, key);

        long endTime = System.nanoTime(); // Stop measuring time
        long duration = endTime - startTime; // Calculate duration in nanoseconds

        if (result != -1) {
            System.out.println("Using Interpolation Search:");
            System.out.println("Search key FOUND at index " + result);
        } else {
            System.out.println("Using Interpolation Search:");
            System.out.println("Search key NOT FOUND");
        }

        System.out.println("Running time: " + duration + " nanoseconds");

        scanner.close();
    }

    static int interpolationSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && key >= array[low] && key <= array[high]) {
            if (low == high) {
                if (array[low] == key)
                    return low; // key FOUND and index returned
                return -1; // key NOT FOUND and -1 returned
            }

            int pos = (key - array[low]) / (array[high] - array[low]);
            int mid = low + (int) Math.ceil((high - low) * pos);

            if (array[mid] == key)
                return mid; // key FOUND and index returned
            else if (key < array[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1; // key NOT FOUND and -1 returned
    }
}
