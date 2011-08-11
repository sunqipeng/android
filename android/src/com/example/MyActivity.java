package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button button = (Button) this.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TelephonyManager telephonyManager = (TelephonyManager) MyActivity.this.getSystemService(TELEPHONY_SERVICE);
                button.setText(telephonyManager.getLine1Number());
            }
        });
    }
}
