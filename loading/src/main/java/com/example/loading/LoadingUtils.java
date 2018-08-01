package com.example.loading;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by Snail on 2018/7/31.
 */

public class LoadingUtils {

    private static Dialog loadingDialog;

    public static void init(Context mContext) {
        LoadingDialog.Builder builder = new LoadingDialog.Builder(mContext);
        builder.setMessage("加载中...");
        loadingDialog = builder.creat();
    }

    public static void show() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public static void dismiss() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

}
