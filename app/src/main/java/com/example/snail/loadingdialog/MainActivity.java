package com.example.snail.loadingdialog;

import android.app.Dialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.loading.LoadingUtils;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = LoadingUtils.getInstance(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        LoadingUtils.show(dialog);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingUtils.dismiss(dialog);
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
