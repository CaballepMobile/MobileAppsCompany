package com.example.admin.threadpoolpractice;

import android.os.Message;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolManager {
    private WeakReference<MainActivity.UIHandler> uiHandler;
    private static CustomThreadPoolManager INSTANCE;
    public static int NUMBER_OF_CORES = 4;
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final ExecutorService executorService;
    private final BlockingQueue<Runnable> taskQueue;
    private List<Future> runningTaskList;

    public static CustomThreadPoolManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CustomThreadPoolManager();
        }

        return INSTANCE;
    }

    private CustomThreadPoolManager(){
        taskQueue = new LinkedBlockingDeque<>();
        runningTaskList = new ArrayList<>();
        executorService = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, taskQueue);

    }

    public void setHandler(MainActivity.UIHandler uiHandler){
        this.uiHandler = new WeakReference<>(uiHandler);
    }

    public void addRunnable() {
        Future future = executorService.submit(new CustomRunnable(this));
        runningTaskList.add(future);
    }

    public void cancelAllTasks(){
        taskQueue.clear();

        for(Future future : runningTaskList){
            if(!future.isDone()){
                future.cancel(true);
            }
            runningTaskList.clear();
        }
    }

    public void postUiThread(Message message){
        uiHandler.get().sendMessage(message);
    }
}