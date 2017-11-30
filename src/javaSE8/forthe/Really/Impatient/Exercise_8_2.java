package javaSE8.forthe.Really.Impatient;

public class Exercise_8_2 {
/*    2. For which integer n does Math.negateExact(n) throw an exception? (Hint: There
    is only one.)*/

    public static void main(String[] args) {
        System.out.println("negate normal: " + Math.negateExact(Integer.MAX_VALUE));
        System.out.println("negate exception: " + Math.negateExact(Integer.MAX_VALUE+1));
    }

}
