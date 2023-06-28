import java.util.Arrays;
import java.util.Scanner;

public class SearchComparison {
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

        long linearSearchStartTime = System.nanoTime();
        int linearSearchResult = linearSearch(array, key);
        long linearSearchEndTime = System.nanoTime();
        long linearSearchTime = linearSearchEndTime - linearSearchStartTime;

        if (linearSearchResult != -1) {
            System.out.println("Using Linear Search:");
            System.out.println("Search key FOUND at index " + linearSearchResult);
        } else {
            System.out.println("Using Linear Search:");
            System.out.println("Search key NOT FOUND");
        }

        long interpolationSearchStartTime = System.nanoTime();
        int interpolationSearchResult = interpolationSearch(array, key);
        long interpolationSearchEndTime = System.nanoTime();
        long interpolationSearchTime = interpolationSearchEndTime - interpolationSearchStartTime;

        if (interpolationSearchResult != -1) {
            System.out.println("Using Interpolation Search:");
            System.out.println("Search key FOUND at index " + interpolationSearchResult);
        } else {
            System.out.println("Using Interpolation Search:");
            System.out.println("Search key NOT FOUND");
        }

        System.out.println("Linear Search Time: " + linearSearchTime + " nanoseconds");
        System.out.println("Interpolation Search Time: " + interpolationSearchTime + " nanoseconds");

        scanner.close();
    }

    static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i; // key FOUND and index returned
        }
        return -1; // key NOT FOUND and -1 returned
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
