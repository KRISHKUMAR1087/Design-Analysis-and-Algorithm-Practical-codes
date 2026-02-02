import java.util.Arrays;
import java.util.Random;

public class binaryRecursive {

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > target)
            return binarySearch(arr, left, mid - 1, target);
        return binarySearch(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("InputSize AvgTime(ns)");

        for (int size = 1; size <= 1000000; size += 50000) {
            int[] data = new int[size];

            for (int i = 0; i < size; i++)
                data[i] = rand.nextInt(size * 10);

            Arrays.sort(data);

            int trials = 5000;
            long totalTime = 0;

            binarySearch(data, 0, size - 1, data[0]);

            for (int i = 0; i < trials; i++) {
                int target = data[rand.nextInt(size)];
                long start = System.nanoTime();
                binarySearch(data, 0, size - 1, target);
                long end = System.nanoTime();
                totalTime += end - start;
            }

            double avgTime = (double) totalTime / trials;
            System.out.println(size + " " + avgTime);
        }
    }
}
