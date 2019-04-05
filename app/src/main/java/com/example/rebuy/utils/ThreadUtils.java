package com.example.rebuy.utils;


import android.os.Handler;

/**
 * @author YangZhaoxin.
 * @since 2019/4/5 0:10.
 * email yangzhaoxin@hrsoft.net.
 */

public class ThreadUtils {

    public static Handler mHandler = new Handler();

    /**
     * 子线程中执行task
     * @param task
     */
    public static void runInThread(Runnable task) {
        new Thread(task).start();
    }

    /**
     * 主线程中执行task
     * @param task
     */
    public static void runInUIThread(Runnable task) {
        mHandler.post(task);
    }
}
