import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted halves
    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Fill array with random numbers
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt();
        }

        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;

        System.out.println("Array Size: " + n);
        System.out.println("Running Time: " + timeMs + " ms");

        sc.close();
    }
}
