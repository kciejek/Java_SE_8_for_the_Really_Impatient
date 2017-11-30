package javaSE8.forthe.Really.Impatient;

import java.util.Arrays;

    public class Exercise_6_9 {

/*    You can use the parallelPrefix method to parallelize the computation of Fibonacci
    numbers. We use the fact that the nth Fibonacci number is the top
    left coefficient of Fn, where F = ( 1 1
                                        1 0 ) . Make an array filled with 2 × 2 matrices.
    Define a Matrix class with a multiplication method, use parallelSetAll to
            make an array of matrices, and use parallelPrefix to multiply them.*/

    public static void main(String[] args) {

        Matrix[] m = new Matrix[10];
        final int[][] f = { {1,1}, {1,0} };

        Arrays.parallelSetAll(m, i -> new Matrix( f ) );
        Arrays.parallelPrefix(m, (m1, m2) -> m1.multiply(m2));
        Arrays.stream(m).forEach(i -> System.out.println(i.m[0][0]));

    }

     static class Matrix{

        public int[][] m;
        private final int NUMBER_OF_ROWS = 2;
        private final int NUMBER_OF_COLUMNS = 2;

        public Matrix(int[][] m){
            this.m = m;
        }

        public Matrix multiply(Matrix other){
            int[][] res = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
            res[0][0] = ( m[0][0] * other.m[0][0] ) + ( m[0][1] * other.m[1][0] );
            res[0][1] = ( m[0][0] * other.m[0][1] ) + ( m[0][1] * other.m[1][1] );
            res[1][0] = ( m[1][0] * other.m[0][0] ) + ( m[1][1] * other.m[1][0] );
            res[1][1] = ( m[1][0] * other.m[0][1] ) + ( m[1][1] * other.m[1][1] );

            return new Matrix(res);
        }

    }


}
