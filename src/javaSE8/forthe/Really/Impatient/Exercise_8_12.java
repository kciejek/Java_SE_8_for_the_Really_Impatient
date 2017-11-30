package javaSE8.forthe.Really.Impatient;

import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Repeatable(TestCases.class)
@interface TestCase {
    int params();

    int expected();
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestCases {
    TestCase[] value();
}

public class Exercise_8_12 {
/*12. Implement the TestCase annotation and a program that loads a class with such
            annotations and invokes the annotated methods, checking whether they yield
            the expected values. Assume that parameters and return values are integers.*/


    @TestCase(params = 4, expected = 24)
    @TestCase(params = 0, expected = 1)
    public static int factorial(Integer n) {
        if (n > 0) {
            return (n * factorial(--n));
        }
        return 1;
    }

    @Test
    public void runTest() throws NoSuchMethodException {

        Exercise_8_12 exer = new Exercise_8_12();
        Class c = exer.getClass();
        Method m = c.getMethod("factorial", Integer.class);
        TestCase[] t = m.getAnnotationsByType(TestCase.class);

        assertTrue(t.length > 0);
        System.out.println("TestCase array length: " + t.length);
        System.out.println("\nparam : expected");
        for (TestCase test : t) {
            assertEquals(test.expected(), Exercise_8_12.factorial(test.params()));
            System.out.println(test.params() + " : " + test.expected());
        }


    }

}
