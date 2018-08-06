package com.example.admin.daily5.Tools;

public class MyChronometer extends Thread {

    private int time = 0;

    @Override
    public void run() {
        try {
            while(time < Integer.MAX_VALUE - 1){
                Thread.sleep(1000);
                time++;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //super.run();
    }

    public String TimeSpent(){
        short minutes = (short)(time/60);
        byte seconds = (byte)(time%60);

        return "You have spent " + minutes + " minutes" + " and " + seconds + " seconds in this app";
    }
}
