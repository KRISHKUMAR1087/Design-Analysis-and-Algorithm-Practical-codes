import java.util.Random;
import java.util.Arrays;

public class BinarySearchTiming {

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("BINARY SEARCH TIME ANALYSIS");
        for (int n = 0; n <= 100000; n += 5000) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(1000000);
            }
            Arrays.sort(arr); // Binary search requires sorted array
            int target = -1; // worst case (not present)
            long start = System.nanoTime();
            binarySearch(arr, target);
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("n = " + n + "  time = " + time + " ns");
        }
    }
}