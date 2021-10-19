package com.example.teach03;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class Evens implements Runnable {

    private final Activity mainActivity;

    public Evens(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }
    
    @Override
    public void run() {
        int i = 0;
        do {
            i = i + 2;
            System.out.println(i);
        } while (i <= 100);

        try {
            Thread.sleep(250);
            i = 0;

            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Context context = mainActivity.getApplicationContext();
                    CharSequence text = "Counting Complete";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
