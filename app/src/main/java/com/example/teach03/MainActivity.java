package com.example.teach03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    //need to create an instance of the Evens and Odds classes
    //this is because the onclick function for buttons can only use methods
    //from the activity class. Then use a method in this activity to run the function.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    //count even numbers button handler
    //a button handler (onclick or event listener) requires that the method be:
    // 1. a public method
    // 2. a method that returns void
    // 3. a method taking View as parameter
    public void countEvens(View view) {
        Evens evens = new Evens(this);
        Thread thread = new Thread(evens, "Counting Evens:");
        thread.start();
    }

    // count odd numbers button handler
    public void countOdds(View view) {
        Odds odds = new Odds(this);
        Thread thread = new Thread(odds, "Counting Odds:");
        thread.start();
    }

    //the toast display function
    public void showToast() {
        Context context = this.getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}