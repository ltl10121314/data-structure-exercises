package com.exercises.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutianlong
 */
public class AbcLock {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbcLock.class);
    private static final Lock lock = new ReentrantLock();
    private static int state = 0;

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            int count = 10;
            for (int i = 0; i < count; ) {
                lock.lock();
                try {
                    while (state % 3 == 0) {
                        System.out.print("A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ThreadB extends Thread {
        @Override
        public void run() {
            int count = 10;
            for (int i = 0; i < count; ) {
                lock.lock();
                try {
                    while (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ThreadC extends Thread {
        @Override
        public void run() {
            int count = 10;
            for (int i = 0; i < count; ) {
                lock.lock();
                try {
                    while (state % 3 == 2) {
                        System.out.print("C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
