import java.util.Arrays;
import java.util.Scanner;

public class ImprovedLinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array); // Sort the array

        System.out.print("Enter the search key: ");
        int key = scanner.nextInt();

        long startTime = System.nanoTime(); // Start measuring time

        int result = binarySearch(array, key);

        long endTime = System.nanoTime(); // Stop measuring time
        long duration = endTime - startTime; // Calculate duration in nanoseconds

        if (result != -1) {
            System.out.println("Using Binary Search:");
            System.out.println("Search key FOUND at index " + result);
        } else {
            System.out.println("Using Binary Search:");
            System.out.println("Search key NOT FOUND");
        }

        System.out.println("Running time: " + duration + " nanoseconds");

        scanner.close();
    }

    static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid; // key FOUND and index returned
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // key NOT FOUND and -1 returned
    }
}
