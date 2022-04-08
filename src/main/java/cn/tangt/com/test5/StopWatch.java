package cn.tangt.com.test5;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : tgt
 * @version : 1.0
 * @class : StopWatch
 * @description : StopWatch
 * @date : 2022/4/3
 */
class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}

class Demo {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        Random rad = new Random();
        int[] array = new int[100001];
        for (int i = 0; i < 100000; i++) {
            array[i] = rad.nextInt(1000001);
        }
        sw.start();
        Arrays.sort(array);
        sw.stop();
        long l = sw.getElapsedTime();
        System.out.println(l + " ms");
    }
}

