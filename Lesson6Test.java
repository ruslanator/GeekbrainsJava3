import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;



@RunWith(Parameterized.class)
public class Lesson6Test {
    private int[] originalArray;
    private int[] expectedArray;
    private String message;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[]{new int[]{1, 4, 5, 4, 3, 7, 2}, new int[]{1, 7}, "1"},
                new Object[]{new int[]{4, 3}, new int[]{1, 3}, "2"},
                new Object[]{new int[]{4, 2, 9, 5, 323}, new int[]{2, 9}, "3"});
    }

    public Lesson6Test(int[] originalArray, int[] expectedArray, String message) {
        this.originalArray = originalArray;
        this.expectedArray = expectedArray;
        this.message = message;
    }

    @Test
    public void checkArray() {
        Assert.assertArrayEquals("Сравнение массивов", this.expectedArray, Lesson6.checkArray(this.originalArray));
    }
    @Test
    public void test1checkArray(){
        Assert.assertArrayEquals(new int[]{5, 2, 6}, Lesson6.checkArray(new int[]{5, 4, 33333}));
    }

    @Test(
            expected = RuntimeException.class
    )
    public void testExceptionCheckArray() {
        Lesson6.checkArray(new int[]{1, 2, 4});
    }

    @Test
    public void checkNumber() {
        TestCase.assertTrue("Наличие других цифр кроме 1 и 4", Lesson6.checkNumber(new int[]{1, 1, 1, 1, 1, 4, 4, 4, 4, 4}));
    }


    @Test
    public void testCheckNumberContainsOne() {
        Assert.assertTrue("В массиве есть 1", Lesson6.checkNumber(new int[]{5, 6}));
    }

    @Test
    public void testCheckNumberContainsFour() {
        Assert.assertTrue("В массиве есть 4", Lesson6.checkNumber(new int[]{4, 4}));
    }
    @Test
    public void testCheckNumberAnotherNumbers() {
        TestCase.assertTrue("Наличие других цифр кроме 1 и 4", Lesson6.checkNumber(new int[]{1, 1, 1, 1, 1, 4, 4, 4, 4, 4}));
    }

    @Test(
            expected = RuntimeException.class
    )
    public void testCheckNumberOnlyInitialNumbers() {
        Assert.assertFalse("В массиве только 1 и 4", Lesson6.checkNumber(new int[]{7, 5, 4, 2, 5, 6}));
    }
}