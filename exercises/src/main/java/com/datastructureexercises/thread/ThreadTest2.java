package com.datastructureexercises.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @Author Tianlong Liu
 * @Email liutlong@yonyou.com
 * @Date 2024年03月06日 14:08
 * @Description thread
 */
@Slf4j
public class ThreadTest2 {

    public static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    public static final ExecutorService THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(6, 20, 60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10000),
            THREAD_FACTORY,
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Test
    public void test2() {
        System.out.println("加了join");
//        threadTest(true);
        System.out.println("没加join");
        threadTest(false);
    }

    private void threadTest(Boolean flag) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        System.out.println("开始==========");
        long start = System.currentTimeMillis();
        List<CompletableFuture<Integer>> ls = new ArrayList<>();
        for (Integer integer : list) {
            ls.add(CompletableFuture.supplyAsync(() -> {
                if (integer % 2 == 0) {
                    try {
                        Thread.sleep(1000 * 10);
//                        System.out.println("延迟排名：" + integer);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
//                    System.out.println("排名：" + integer);
                }
                return integer;
            }, THREAD_POOL_EXECUTOR));
        }
        if (flag) {
            CompletableFuture.allOf(ls.toArray(new CompletableFuture[0])).join();
        }
        List<Integer> integerList = new ArrayList<>();
        for (CompletableFuture<Integer> future : ls) {
            try {
                Integer resultList = future.get();
                integerList.add(resultList);
            } catch (Exception e) {
                log.info("exception:" + e.getMessage());
            }
        }
        System.out.println(integerList);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("结束============");
    }

    public static void main(String[] args) {
        log.error("main-start");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.error("start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.error("end");
            }
        };
        THREAD_POOL_EXECUTOR.execute(runnable);
        log.error("main-end");
        THREAD_POOL_EXECUTOR.shutdown();
    }

    @Test
    public void test() {
        log.info("start");
        List<CompletableFuture> cfList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture cf = CompletableFuture.runAsync(() -> {
                int i1 = getException(finalI);
                vector.add(i1);
            });
            cfList.add(cf);
        }
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[0])).join();
        log.info(vector.toString());
        log.info("end");
    }

    private int getException(int i) {
        if (i % 2 == 0) {
            try {
                Thread.sleep(1000 * 20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            throw new RuntimeException("error.");
        }
        log.info("number-{}", i);
        return i;
    }
}
