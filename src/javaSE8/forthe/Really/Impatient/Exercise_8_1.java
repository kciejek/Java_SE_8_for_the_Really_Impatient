package javaSE8.forthe.Really.Impatient;

public class Exercise_8_1 {
/*1. Write a program that adds, subtracts, divides, and compares numbers between
0 and 2^32 – 1, using int values and unsigned operations. Show why
    divideUnsigned and remainderUnsigned are necessary.*/

    public static void main(String[] args) {

        int i = -1;
        int j = 2;

        long add = Integer.toUnsignedLong(i) + Integer.toUnsignedLong(j);
        long sub = Integer.toUnsignedLong(i) - Integer.toUnsignedLong(j);

        int divUnsigned = Integer.divideUnsigned(i,j);
        int divSigned = i / j;

        int remUnsigned = Integer.remainderUnsigned(i,j);
        int remSigned = i % j;

        long comp = Integer.compareUnsigned(i,j);

        System.out.println("add: " + add);
        System.out.println("sub: " + sub);
        System.out.println("divSigned: " + divSigned);
        System.out.println("divSigned result unsigned: " +  Integer.toUnsignedLong(divSigned));
        System.out.println("divUnsigned: " +  divUnsigned);
        System.out.println("remSigned: " + remSigned);
        System.out.println("remSigned result unsigned: " +  Integer.toUnsignedLong(remSigned));
        System.out.println("remUnsigned: " +  remUnsigned);
        System.out.println("comp: " + comp);

    }

}
