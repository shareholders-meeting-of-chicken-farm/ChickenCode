package leetcode_1117;

import java.util.concurrent.Semaphore;

public class Solution_momo262_v0 {

    private Semaphore H = new Semaphore(2);

    private Semaphore O = new Semaphore(0);

    public Solution_momo262_v0() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        H.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        O.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        O.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        H.release(2);
    }

}
