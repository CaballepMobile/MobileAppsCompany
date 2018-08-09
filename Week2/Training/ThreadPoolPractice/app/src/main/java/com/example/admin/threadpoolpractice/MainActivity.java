package com.example.admin.threadpoolpractice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private TextView tvFirst, tvSecond, tvThird, tvFourth;
    private ProgressBar pbFirst, pbSecond, pbThird, pbFourth;
    private UIHandler uiHandler;
    private CustomThreadPoolManager customThreadPoolManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirst = findViewById(R.id.tvFirst);
        tvSecond = findViewById(R.id.tvSecond);
        tvThird = findViewById(R.id.tvThird);
        tvFourth = findViewById(R.id.tvFourth);

        pbFirst = findViewById(R.id.pbFirst);
        pbSecond = findViewById(R.id.pbSecond);
        pbThird = findViewById(R.id.pbThird);
        pbFourth = findViewById(R.id.pbFourth);

        uiHandler = new UIHandler( getMainLooper(),
                tvFirst,
                tvSecond,
                tvThird,
                tvFourth,
                pbFirst,
                pbSecond,
                pbThird,
                pbFourth
        );
        customThreadPoolManager = CustomThreadPoolManager.getInstance();
        customThreadPoolManager.setHandler(uiHandler);
    }

    public void evtAddCallable(View view) {
        customThreadPoolManager.addRunnable();
    }

    public void evtCleanTasks(View view) {
        customThreadPoolManager.cancelAllTasks();
    }

    public static class UIHandler extends Handler{
        private WeakReference<TextView> tvFirstThread, tvSecondThread, tvThirdThread, tvFourthThread;
        private WeakReference<ProgressBar> pbFirstThread, pbSecondThread, pbThirdThread, pbFourthThread;

        public UIHandler(
            Looper looper,
            TextView tvFirstThread,
            TextView tvSecondThread,
            TextView tvThirdThread,
            TextView tvFourthThread,
            ProgressBar pbFirstThread,
            ProgressBar pbSecondThread,
            ProgressBar pbThirdThread,
            ProgressBar pbFourthThread
        ){
            super(looper);
            this.tvFirstThread = new WeakReference<>(tvFirstThread);
            this.tvSecondThread = new WeakReference<>(tvSecondThread);
            this.tvThirdThread = new WeakReference<>(tvThirdThread);
            this.tvFourthThread = new WeakReference<>(tvFourthThread);

            this.pbFirstThread = new WeakReference<>(pbFirstThread);
            this.pbSecondThread = new WeakReference<>(pbSecondThread);
            this.pbThirdThread = new WeakReference<>(pbThirdThread);
            this.pbFourthThread = new WeakReference<>(pbFourthThread);


        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case 1:
                    pbFirstThread.get().setProgress(msg.getData().getInt("int"));
                    tvFirstThread.get().setText(msg.getData().getString("message"));
                    break;
                case 2:
                    pbSecondThread.get().setProgress(msg.getData().getInt("int"));
                    tvSecondThread.get().setText(msg.getData().getString("message"));
                    break;
                case 3:
                    pbThirdThread.get().setProgress(msg.getData().getInt("int"));
                    tvThirdThread.get().setText(msg.getData().getString("message"));
                    break;
                case 4:
                    pbFourthThread.get().setProgress(msg.getData().getInt("int"));
                    tvFourthThread.get().setText(msg.getData().getString("message"));
                    break;
            }
        }
    }


}
