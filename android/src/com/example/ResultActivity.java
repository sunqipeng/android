package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-7-26
 * Time: 下午4:57
 * To change this template use File | Settings | File Templates.
 */
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        this.setContentView(R.layout.hello);
        Button btn = (Button) this.findViewById(R.id.endOperation);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ResultActivity.this.setResult(Activity.RESULT_OK);
                ResultActivity.this.finish();
            }
        });
    }
}
