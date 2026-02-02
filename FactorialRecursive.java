public class FactorialRecursive {

    static long Factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    public static void main(String[] args) {

        System.out.println("Individual Recursive Factorial Time (1 to 20)");

        for (int n = 1; n <= 20; n++) {

            long start = System.nanoTime();     // start ONLY for this n

            long result = Factorial(n);         // calculate ONLY factorial(n)

            long end = System.nanoTime();       // end ONLY for this n

            long timeNano = end - start;

            System.out.println(
                "n = " + n +
                " | time = " + timeNano + " ns"
            );
        }
    }
}
