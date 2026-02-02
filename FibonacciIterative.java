public class FibonacciIterative {

    static void Calculation(int n) {

        if (n <= 1) return;

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }

    public static void main(String[] args) {

        System.out.println("Individual time for each n (Fibonacci Iterative)");

        for (int n = 1; n <= 20; n++) {

            long start = System.nanoTime();   // start ONLY for this n

            Calculation(n);                   // compute ONLY fib(n)

            long end = System.nanoTime();     // end ONLY for this n

            long timeNano = end - start;

            System.out.println(
                "n = " + n + " -> time = " + timeNano + " ns"
            );
        }
    }
}
