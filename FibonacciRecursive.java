public class FibonacciRecursive {

    static void Calculation(int n) {

        // base cases
        if (n <= 1) {
            return;
        }

        // recursive calls
        Calculation(n - 1);
        Calculation(n - 2);
    }

    public static void main(String[] args) {

        System.out.println("Fibonacci Recursive Time (1 to 20) - Individual");

        for (int n = 1; n <= 20; n++) {

            long start = System.nanoTime();   

            Calculation(n);                   

            long end = System.nanoTime();     

            long timeNano = end - start;

            System.out.println(
                "n = " + n + " | time = " + timeNano + " ns"
            );
        }
    }
}
