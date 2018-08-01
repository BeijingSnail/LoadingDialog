package com.example.loading;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Snail on 2018/7/31.
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context mContext;
        private String message;
        private boolean isShowMessage = true;
        private boolean isCancelable = true;
        private boolean isCancelOutside = false;

        public Builder(Context context) {
            this.mContext = context;
        }

        /**
         * 设置提示信息
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 设置是否显示提示信息(默认显示)
         */
        public Builder setShowMessage(boolean isShowMessage) {
            this.isShowMessage = isShowMessage;
            return this;
        }

        /**
         * 设置是否可以按返回键取消(默认可以)
         */
        public Builder setCancelable(boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        /**
         * 设置是否可以点击屏幕取消(默认不可以)
         */
        public Builder setCancelOutside(boolean isCancelOutside) {
            this.isCancelOutside = isCancelOutside;
            return this;
        }

        public LoadingDialog creat() {

            View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_layout, null);

            LoadingDialog dialog = new LoadingDialog(mContext, R.style.LoadingDialogStyle);

            TextView messageTv = view.findViewById(R.id.message_tv);

            if (isShowMessage) {
                messageTv.setText(TextUtils.isEmpty(message) ? mContext.getResources().getString(R.string.loading_text) : message);
            } else {
                messageTv.setVisibility(View.GONE);
            }

            dialog.setContentView(view);
            dialog.setCancelable(isCancelable);
            dialog.setCanceledOnTouchOutside(isCancelOutside);
            return dialog;
        }
    }

}
