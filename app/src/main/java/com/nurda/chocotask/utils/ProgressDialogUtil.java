package com.nurda.chocotask.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtil {
    public static ProgressDialog showDialog(Context context, String message){

        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.show();

        return dialog;
    }
}
