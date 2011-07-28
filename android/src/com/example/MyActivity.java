package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class MyActivity extends Activity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) this.findViewById(R.id.btn);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
