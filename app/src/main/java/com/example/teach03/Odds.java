package com.example.teach03;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class Odds implements Runnable {

    private final Activity mainActivity;

    public Odds(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void run() {
        int i = 1;
        do {
            i = i + 2;
            System.out.println(i);
        } while (i <= 100);

        try {
            Thread.sleep(250);
            i = 1;

            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Context context = mainActivity.getApplicationContext();
                    CharSequence text = "Counting Complete";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();}

                });

            } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
