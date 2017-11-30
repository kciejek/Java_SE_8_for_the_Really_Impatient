package javaSE8.forthe.Really.Impatient;

public class Exercise_8_3 {
/*3. Euclid’s algorithm (which is over two thousand years old) computes the
    greatest common divisor of two numbers as gcd(a, b) = a if b is zero, and
    gcd(b, rem(a, b)) otherwise, where rem is the remainder. Clearly, the gcd
    should not be negative, even if a or b are (since its negation would then be a
            greater divisor). Implement the algorithm with %, floorMod, and a rem function
    that produces the mathematical (non-negative) remainder. Which of the three
    gives you the least hassle with negative values?*/

    public static void main(String[] args) {

        int a = 10;
        int b = -4;
        System.out.println("gcd: " + gcd(a,b));

    }

    private static int gcd(int a, int b){

        if(b == 0){
            return a;
        }else{
            int rem = Math.abs(a % b);
            //int rem = Math.floorMod (a % b , a);
            return gcd(b, rem);
        }

    }

}
