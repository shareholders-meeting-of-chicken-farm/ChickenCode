package leetcode_1250;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for LeetCode 1250 - Check If It Is a Good Array
 *
 * Given an array nums of positive integers, a good array is an array where
 * you can select some elements of this array and multiply each of them by
 * an integer and get a sum equal to 1.
 *
 * This is essentially checking if GCD of all elements equals 1.
 */
public class Solution_momo262_v0Test {

    private Solution_momo262_v0 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution_momo262_v0();
    }

    @Test
    @DisplayName("Example 1: [12,5,7,23] should return true (GCD = 1)")
    void testExample1() {
        int[] nums = {12, 5, 7, 23};
        assertTrue(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Example 2: [29,6,10] should return true (GCD = 1)")
    void testExample2() {
        int[] nums = {29, 6, 10};
        assertTrue(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Example 3: [3,6] should return false (GCD = 3)")
    void testExample3() {
        int[] nums = {3, 6};
        assertFalse(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Single element 1 should return true")
    void testSingleElementOne() {
        int[] nums = {1};
        assertTrue(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Single element greater than 1 should return false")
    void testSingleElementGreaterThanOne() {
        int[] nums = {5};
        assertFalse(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Two coprime numbers should return true")
    void testTwoCoprimeNumbers() {
        int[] nums = {3, 5};
        assertTrue(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Array with 1 should always return true")
    void testArrayWithOne() {
        int[] nums = {4, 8, 12, 1};
        assertTrue(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("All even numbers should return false")
    void testAllEvenNumbers() {
        int[] nums = {2, 4, 6, 8, 10};
        assertFalse(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Consecutive numbers should return true (GCD = 1)")
    void testConsecutiveNumbers() {
        int[] nums = {10, 11};
        assertTrue(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Powers of same prime should return false")
    void testPowersOfSamePrime() {
        int[] nums = {2, 4, 8, 16, 32};
        assertFalse(solution.isGoodArray(nums));
    }

    @Test
    @DisplayName("Large coprime numbers should return true")
    void testLargeCoprimeNumbers() {
        int[] nums = {1000000007, 1000000009};
        assertTrue(solution.isGoodArray(nums));
    }
}
