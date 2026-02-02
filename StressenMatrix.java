import java.util.Random;

public class StrassenMatrix {

   
    static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    
    static int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

   
    static int[][] multiplyNormal(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    
    static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;

       
        if (n <= 64) {
            return multiplyNormal(A, B);
        }

        int mid = n / 2;

        int[][] A11 = new int[mid][mid];
        int[][] A12 = new int[mid][mid];
        int[][] A21 = new int[mid][mid];
        int[][] A22 = new int[mid][mid];

        int[][] B11 = new int[mid][mid];
        int[][] B12 = new int[mid][mid];
        int[][] B21 = new int[mid][mid];
        int[][] B22 = new int[mid][mid];

        
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + mid];
                A21[i][j] = A[i + mid][j];
                A22[i][j] = A[i + mid][j + mid];

                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + mid];
                B21[i][j] = B[i + mid][j];
                B22[i][j] = B[i + mid][j + mid];
            }
        }

      
        int[][] M1 = strassen(add(A11, A22), add(B11, B22));
        int[][] M2 = strassen(add(A21, A22), B11);
        int[][] M3 = strassen(A11, sub(B12, B22));
        int[][] M4 = strassen(A22, sub(B21, B11));
        int[][] M5 = strassen(add(A11, A12), B22);
        int[][] M6 = strassen(sub(A21, A11), add(B11, B12));
        int[][] M7 = strassen(sub(A12, A22), add(B21, B22));

        int[][] C11 = add(sub(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(sub(add(M1, M3), M2), M6);

   
        int[][] C = new int[n][n];
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                C[i][j] = C11[i][j];
                C[i][j + mid] = C12[i][j];
                C[i + mid][j] = C21[i][j];
                C[i + mid][j + mid] = C22[i][j];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int n = 64; // change to 4,16,64,512,1024
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextInt(10);
                B[i][j] = rand.nextInt(10);
            }

        long start = System.nanoTime();
        strassen(A, B);
        long end = System.nanoTime();

        System.out.println("Matrix Size: " + n + " x " + n);
        System.out.println("Execution Time: " + (end - start) / 1e6 + " ms");
    }
}
