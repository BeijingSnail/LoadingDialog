package com.example.loading;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by Snail on 2018/7/31.
 */

public class LoadingUtils {

    public static LoadingDialog getInstance(Context mContext) {
        LoadingDialog.Builder builder = new LoadingDialog.Builder(mContext);
        builder.setMessage("加载中...");
        LoadingDialog dialog = builder.creat();
        return dialog;
    }

    public static void show(Dialog dialog) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public static void dismiss(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
