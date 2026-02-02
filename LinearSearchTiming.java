import java.util.Random;

public class LinearSearchTiming {

    static int linearSearch(int[] collection, int target) {
        for (int value : collection) {
            if (value == target) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Random rand = new Random();

        System.out.println("LINEAR SEARCH TIME ANALYSIS");

        for (int size = 0; size <= 100000; size += 5000) {

            int[] collection = new int[size];

            for (int index = 0; index < size; index++) {
                collection[index] = rand.nextInt(1000000);
            }

            int target = -1;

            long start = System.nanoTime();
            linearSearch(collection, target);
            long end = System.nanoTime();

            long time = end - start;

            System.out.println("size = " + size + "  time = " + time + " ns");
        }
    }
}