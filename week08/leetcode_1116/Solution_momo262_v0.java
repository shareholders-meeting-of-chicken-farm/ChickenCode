package leetcode_1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Solution_momo262_v0 {

    private int n;

    private Semaphore a = new Semaphore(1);

    private Semaphore b = new Semaphore(0);

    private Semaphore c = new Semaphore(0);

    public Solution_momo262_v0(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++) {
            a.acquire();
            printNumber.accept(0);

            if (i%2 == 0) {
                b.release();
            } else {
                c.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2) {
            c.acquire();
            printNumber.accept(i);
            a.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2) {
            b.acquire();
            printNumber.accept(i);
            a.release();
        }
    }

}
