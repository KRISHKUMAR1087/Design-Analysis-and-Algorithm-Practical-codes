public class FactorialIterative {

    static Long Factorial(int a) {

        long mul = 1;
        for (int i = 1; i <= a; i++) {
            mul *= i;
        }
        return System.nanoTime();
    }

    public static void main(String[] args) {

        System.out.println("Factorial Time Calculation (1 to 20) in Nanoseconds");

        for (int n = 1; n <= 20; n++) {

            long start = System.nanoTime();
            long end = Factorial(n);

            long timeNano = end - start;

            System.out.println(
                "n = " + n + " | time = " + timeNano + " ns"
            );
        }
    }
}
