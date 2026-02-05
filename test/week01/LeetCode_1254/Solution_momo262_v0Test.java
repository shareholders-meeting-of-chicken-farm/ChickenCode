package LeetCode_1254;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for LeetCode 1254 - Number of Closed Islands
 *
 * A closed island is an island totally (all left, top, right, bottom)
 * surrounded by 1s. The grid contains 0s (land) and 1s (water).
 */
public class Solution_momo262_v0Test {

    private Solution_momo262_v0 solution;

    @BeforeEach
    void setUp() {
        solution = new Solution_momo262_v0();
    }

    @Test
    @DisplayName("Example 1: Grid with 2 closed islands")
    void testExample1() {
        int[][] grid = {
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        };
        assertEquals(2, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("Example 2: Grid with 1 closed island")
    void testExample2() {
        int[][] grid = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0}
        };
        assertEquals(1, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("Example 3: Grid with 2 closed islands (larger grid)")
    void testExample3() {
        int[][] grid = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };
        assertEquals(2, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("No closed islands when all 0s touch boundary")
    void testNoClosedIslands() {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        assertEquals(0, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("All water (1s) - no islands at all")
    void testAllWater() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        assertEquals(0, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("Single closed island in center")
    void testSingleClosedIsland() {
        int[][] grid = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        };
        assertEquals(1, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("Minimum grid size 3x3 with closed island")
    void testMinimumGridWithClosedIsland() {
        int[][] grid = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        assertEquals(1, solution.closedIsland(grid));
    }

    @Test
    @DisplayName("Island connected to top boundary is not closed")
    void testIslandConnectedToTopBoundary() {
        int[][] grid = {
            {0, 1, 0},
            {1, 0, 1},
            {1, 1, 1}
        };
        assertEquals(0, solution.closedIsland(grid));
    }
}
