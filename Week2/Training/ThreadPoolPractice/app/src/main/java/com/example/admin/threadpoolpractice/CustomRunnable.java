package com.example.admin.threadpoolpractice;

import android.os.Bundle;
import android.os.Message;

import java.lang.ref.WeakReference;

public class CustomRunnable implements Runnable {

    private WeakReference<CustomThreadPoolManager> customThreadPoolManagerWeakReference;

    public CustomRunnable(CustomThreadPoolManager customThreadPoolManagerWeakReference){
        this.customThreadPoolManagerWeakReference = new WeakReference<>(customThreadPoolManagerWeakReference);
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 5; i++){
                Thread.sleep(1000);
                String message = "Random int: " + i + "\n"
                        +String.valueOf(Thread.currentThread().getId()) + "\n Completed";
                Bundle bundle = new Bundle();
                bundle.putString("message", message);
                bundle.putInt("int", i);
                Message message1 = new Message();
                message1.setData(bundle);
                message1.what = (int)(Thread.currentThread().getId() % 4 + 1);
                customThreadPoolManagerWeakReference.get().postUiThread(message1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
