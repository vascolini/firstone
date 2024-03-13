package cz.upce.fei.zzapr.w05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArraySumTest {

    @Test
    public void testSumArrays() {
        // Test case 1: Arrays with equal length
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] expectedResult1 = {7, 9, 11, 13, 15};
        assertArrayEquals(expectedResult1, ArraySum.sumArrays(array1, array2));

        // Test case 2: Arrays with different lengths
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {6, 7, 8, 9, 10};
        assertNull(ArraySum.sumArrays(array3, array4));
    }
}
