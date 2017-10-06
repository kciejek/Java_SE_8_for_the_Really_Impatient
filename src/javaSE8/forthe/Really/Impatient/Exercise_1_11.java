package javaSE8.forthe.Really.Impatient;

interface I {
    static void f() {
        System.out.println("f from interface");
    }
}

interface J {
    static void f() {
        System.out.println("f from interface");
    }
}

public class Exercise_1_11 implements I, J {

    public static void main(String[] args) {
        I obj = (I) new Exercise_1_11();
        I.f();
    }


}
