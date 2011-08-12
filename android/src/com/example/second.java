package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.R.id.sendemail;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-12
 * Time: 上午9:08
 * To change this template use File | Settings | File Templates.
 */
public class second extends Activity {

    private View.OnClickListener sendEmail;

    {
        sendEmail = new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = Intent.createChooser(new Intent(Intent.ACTION_SEND), "发送邮件");
                Log.e("app", "选择");

            }
        };
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.second);
        Button sendEmailButton = (Button) this.findViewById(sendemail);
        sendEmailButton.setOnClickListener(sendEmail);
    }
}