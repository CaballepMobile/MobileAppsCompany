package com.example.admin.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class TestThreadHandlerMessage extends Thread {

    Handler handler;

    public TestThreadHandlerMessage(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        String data = "Message from " + this.getName().toString();
        System.out.println("running Thread: " + Thread.currentThread() + "Data: " + data);

        Bundle bundle = new Bundle();
        bundle.putString("KEY", data);

        Message message = new Message();
        message.setData(bundle);

        handler.sendMessage(message);
    }
}
