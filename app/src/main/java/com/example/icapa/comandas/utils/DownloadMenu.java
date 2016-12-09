package com.example.icapa.comandas.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.model.Dish;
import com.example.icapa.comandas.model.Menu;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * Created by icapa on 9/12/16.
 */

public class DownloadMenu extends AsyncTask<Void,Void,LinkedList<Dish>> {

    // Barra de progreso
    private ProgressDialog mProgressDialog;
    // ViewGroup
    private ViewGroup mViewGroup;
    // La actividad
    private WeakReference<Activity> mActivity;

    // Constructor
    public DownloadMenu(ViewGroup container, Activity activity) {
        super();
        mViewGroup = container;
        mActivity = new WeakReference<>(activity);
    }

    @Override
    protected LinkedList<Dish> doInBackground(Void... voids) {
        // Simular tiempo de red
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Menu.downloadMenu();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog = new ProgressDialog(mActivity.get());
        mProgressDialog.setTitle(R.string.downloading);
        mProgressDialog.show();
    }

    @Override
    protected void onPostExecute(LinkedList<Dish> dishes) {
        super.onPostExecute(dishes);
        try {
            mProgressDialog.dismiss();
        } catch (IllegalArgumentException ex) {
        }
        if (dishes == null) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mActivity.get());
            alertDialog.setTitle(R.string.error);
            alertDialog.setMessage(R.string.error_downloading_menu);
            alertDialog.setCancelable(false);
            alertDialog.setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mActivity.get().finish();
                }
            });
            alertDialog.show();
        }
        else if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mViewGroup.animate()
                    .setDuration(mViewGroup.getContext().getResources().getInteger(R.integer.anim_duration))
                    .alpha(1.0f);
        }

    }
}
