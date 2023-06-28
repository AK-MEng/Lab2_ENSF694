import java.util.Scanner;

public class LinearSearch {
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

        int result = linearSearch(array, key);

        long endTime = System.nanoTime(); // Stop measuring time
        long duration = endTime - startTime; // Calculate duration in nanoseconds

        if (result != -1) {
            System.out.println("Using Linear Search:");
            System.out.println("Search key FOUND at index " + result);
        } else {
            System.out.println("Using Linear Search:");
            System.out.println("Search key NOT FOUND");
        }

        System.out.println("Running time: " + duration + " nanoseconds");

        scanner.close();
    }

    static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i; // key FOUND and index returned
        }
        return -1; // key NOT FOUND and -1 returned
    }
}
