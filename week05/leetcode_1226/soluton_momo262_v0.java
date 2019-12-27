package leetcode_1226;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class soluton_momo262_v0 {
//    public static List<ReentrantLock> lockList = new ArrayList<ReentrantLock>();
//
//    static {
//        for (int i=0;i<5;i++) {
//            lockList.add(new ReentrantLock());
//        }
//    }


    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
//        lockList.get(philosopher%5).lock();
//        lockList.get((philosopher+1)%5).lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
//        lockList.get(philosopher%5).unlock();
//        lockList.get((philosopher+1)%5).unlock();
//        Condition condition = lock.newCondition();
//        condition.signal();
    }


}
