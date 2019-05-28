package com.zenhog.java.subarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarrayTest {

    private void checkNumberOfNegativeSubArrays(int expected, int actual) {
        assertEquals(expected, actual);
    }

    private int[] asIntArray(int... args) {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++)
            array[i] = args[i];
        return array;
    }

    @Test
    public void numberOfNegativeSubarraysOfArray() {
        checkNumberOfNegativeSubArrays(0, negativeSubarrayCount(asIntArray()));
        checkNumberOfNegativeSubArrays(0, negativeSubarrayCount(asIntArray(1)));
        checkNumberOfNegativeSubArrays(1, negativeSubarrayCount(asIntArray(-1)));
        checkNumberOfNegativeSubArrays(0, negativeSubarrayCount(asIntArray(1, 1)));
        checkNumberOfNegativeSubArrays(1, negativeSubarrayCount(asIntArray(-1, 1)));
        checkNumberOfNegativeSubArrays(2, negativeSubarrayCount(asIntArray(-2, 1)));
        checkNumberOfNegativeSubArrays(3, negativeSubarrayCount(asIntArray(-1, -1)));
        checkNumberOfNegativeSubArrays(6, negativeSubarrayCount(asIntArray(-1, -1, -1)));
        checkNumberOfNegativeSubArrays(10, negativeSubarrayCount(asIntArray(-1, -1, -1, -1)));
    }

    @Test
    public void acceptanceTest() {
        checkNumberOfNegativeSubArrays(9, negativeSubarrayCount(asIntArray(1, -2, 4, -5, 1)));
    }

    private int negativeSubarrayCount(int[] ints) {
        int result = 0;
        for (int i = 0; i < ints.length; i++) {
            int count = ints.length;
            for (int j = i; j < ints.length; j++) {
                if (i < count) {
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += ints[k];
                    }
                    if (sum < 0)
                        result++;
                }
                count--;
            }

        }
        return result;
    }
}

