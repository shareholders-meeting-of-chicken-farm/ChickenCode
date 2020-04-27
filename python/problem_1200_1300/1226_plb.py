from threading import Lock, Semaphore
from typing import Callable


class DiningPhilosophers:
    def __init__(self):
        self.available_forks = Semaphore(4)
        self.forks = [Lock() for _ in range(5)]

    # call the functions directly to execute, for example, eat()
    def wantsToEat(self,
                   philosopher: int,
                   pickLeftFork: 'Callable[[], None]',
                   pickRightFork: 'Callable[[], None]',
                   eat: 'Callable[[], None]',
                   putLeftFork: 'Callable[[], None]',
                   putRightFork: 'Callable[[], None]') -> None:
        right = philosopher
        left = philosopher - 1 if philosopher > 0 else 4

        self.available_forks.acquire()
        self.available_forks.acquire()

        self.forks[left].acquire()
        self.forks[right].acquire()

        pickLeftFork()
        pickRightFork()
        eat()
        putLeftFork()
        putRightFork()

        self.forks[left].release()
        self.forks[right].release()

        self.available_forks.release()
        self.available_forks.release()
