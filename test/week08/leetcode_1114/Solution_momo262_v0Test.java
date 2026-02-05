package leetcode_1114;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test cases for LeetCode 1114 - Print in Order
 *
 * Three different threads will call first(), second(), third() methods.
 * The methods should ensure "first" is printed before "second" and
 * "second" is printed before "third".
 */
public class Solution_momo262_v0Test {

    private Solution_momo262_v0 solution;
    private StringBuilder output;

    @BeforeEach
    void setUp() {
        solution = new Solution_momo262_v0();
        output = new StringBuilder();
    }

    @Test
    @DisplayName("Order [1,2,3]: Natural order should print 'firstsecondthird'")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testOrder123() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        executor.submit(() -> {
            try {
                solution.first(() -> output.append("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        executor.submit(() -> {
            try {
                solution.second(() -> output.append("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        executor.submit(() -> {
            try {
                solution.third(() -> output.append("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        latch.await();
        executor.shutdown();
        assertEquals("firstsecondthird", output.toString());
    }

    @Test
    @DisplayName("Order [1,3,2]: Threads started out of order should still print correctly")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testOrder132() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        executor.submit(() -> {
            try {
                solution.first(() -> output.append("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        executor.submit(() -> {
            try {
                solution.third(() -> output.append("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        executor.submit(() -> {
            try {
                solution.second(() -> output.append("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        latch.await();
        executor.shutdown();
        assertEquals("firstsecondthird", output.toString());
    }

    @Test
    @DisplayName("Order [2,1,3]: Second before first should wait correctly")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testOrder213() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        // Start second first
        executor.submit(() -> {
            try {
                solution.second(() -> output.append("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        // Small delay to ensure second is waiting
        Thread.sleep(50);

        executor.submit(() -> {
            try {
                solution.first(() -> output.append("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        executor.submit(() -> {
            try {
                solution.third(() -> output.append("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        latch.await();
        executor.shutdown();
        assertEquals("firstsecondthird", output.toString());
    }

    @Test
    @DisplayName("Order [3,2,1]: Reverse order should still print correctly")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testOrder321() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        // Start in reverse order
        executor.submit(() -> {
            try {
                solution.third(() -> output.append("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        Thread.sleep(50);

        executor.submit(() -> {
            try {
                solution.second(() -> output.append("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        Thread.sleep(50);

        executor.submit(() -> {
            try {
                solution.first(() -> output.append("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });

        latch.await();
        executor.shutdown();
        assertEquals("firstsecondthird", output.toString());
    }

    @Test
    @DisplayName("Multiple runs should work correctly with fresh instance")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testMultipleRuns() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            solution = new Solution_momo262_v0();
            output = new StringBuilder();

            ExecutorService executor = Executors.newFixedThreadPool(3);
            CountDownLatch latch = new CountDownLatch(3);

            executor.submit(() -> {
                try {
                    solution.first(() -> output.append("first"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            executor.submit(() -> {
                try {
                    solution.second(() -> output.append("second"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            executor.submit(() -> {
                try {
                    solution.third(() -> output.append("third"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            latch.await();
            executor.shutdown();
            assertEquals("firstsecondthird", output.toString(), "Failed on iteration " + i);
        }
    }
}
