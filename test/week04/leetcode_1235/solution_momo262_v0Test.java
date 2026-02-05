package leetcode_1235;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for LeetCode 1235 - Maximum Profit in Job Scheduling
 *
 * Given n jobs where each job starts at startTime[i], ends at endTime[i],
 * and provides profit[i], find the maximum profit you can take such that
 * there are no overlapping jobs.
 */
public class solution_momo262_v0Test {

    private solution_momo262_v0 solution;

    @BeforeEach
    void setUp() {
        solution = new solution_momo262_v0();
    }

    @Test
    @DisplayName("Example 1: Jobs with overlapping times")
    void testExample1() {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        assertEquals(120, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Example 2: Best to take all jobs")
    void testExample2() {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        assertEquals(150, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Example 3: Non-overlapping jobs")
    void testExample3() {
        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        assertEquals(6, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Single job")
    void testSingleJob() {
        int[] startTime = {1};
        int[] endTime = {5};
        int[] profit = {100};
        assertEquals(100, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Two non-overlapping jobs - take both")
    void testTwoNonOverlappingJobs() {
        int[] startTime = {1, 5};
        int[] endTime = {4, 8};
        int[] profit = {50, 60};
        assertEquals(110, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Two overlapping jobs - take better one")
    void testTwoOverlappingJobs() {
        int[] startTime = {1, 2};
        int[] endTime = {5, 6};
        int[] profit = {50, 60};
        assertEquals(60, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Jobs ending at same time")
    void testJobsEndingAtSameTime() {
        int[] startTime = {1, 2, 3};
        int[] endTime = {5, 5, 5};
        int[] profit = {10, 20, 30};
        assertEquals(30, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Sequential jobs with same end-start time")
    void testSequentialJobs() {
        int[] startTime = {1, 3, 5};
        int[] endTime = {3, 5, 7};
        int[] profit = {10, 20, 30};
        assertEquals(60, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("All jobs at same time - pick max profit")
    void testAllJobsSameTime() {
        int[] startTime = {1, 1, 1, 1};
        int[] endTime = {10, 10, 10, 10};
        int[] profit = {10, 20, 30, 40};
        assertEquals(40, solution.jobScheduling(startTime, endTime, profit));
    }

    @Test
    @DisplayName("Complex scheduling scenario")
    void testComplexScheduling() {
        int[] startTime = {1, 2, 2, 3, 4, 5};
        int[] endTime = {3, 4, 4, 5, 6, 7};
        int[] profit = {50, 20, 30, 40, 10, 60};
        // Best: job 0 (1-3, 50) + job 3 (3-5, 40) + job 5 (5-7, 60) = 150
        assertEquals(150, solution.jobScheduling(startTime, endTime, profit));
    }
}
