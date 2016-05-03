package ir.mbaas.acratest;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Mahdi Moradi on 12/10/2014.
 */

public class CustomDialogs {

    public static void showOkMessage(Context context, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.create().show();
    }

    public static void showErrorAlert(Context context, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();
    }

    public static void showWarningAlert(Context context, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(android.R.string.cancel, null);
        builder.create().show();
    }
}

