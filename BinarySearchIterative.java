import java.util.Arrays;
import java.util.Random;

public class BinarySearchIterative {

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        Random rand = new Random();

        System.out.println("InputSize AvgTime(ns)");

        for (int size = 1; size <= 1000000; size += 50000) {
            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);
            }

            Arrays.sort(data);

            int trials = 5000;
            long totalTime = 0;

            for (int i = 0; i < 1000; i++) {
                binarySearch(data, data[0]);
            }

            for (int i = 0; i < trials; i++) {
                int target = data[rand.nextInt(size)];
                long start = System.nanoTime();
                binarySearch(data, target);
                long end = System.nanoTime();
                totalTime += (end - start);
            }

            double avgTime = (double) totalTime / trials;
            System.out.println(size + " " + avgTime);
        }
    }
}
