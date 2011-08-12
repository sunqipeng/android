package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Button imageButton = (Button) this.findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Toast.makeText(MyActivity.this, "Send a email", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"qipengsun@yeah.net"});
                intent.putExtra("android.intent.extra.SUBJECT", "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "the main body");
                if (result != null)
                    intent.putExtra(Intent.EXTRA_STREAM, result.getData());
                Intent i = Intent.createChooser(intent, "Please ");

                //MyActivity.this.startActivity(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                MyActivity.this.startActivity(i);
            }
        });


        Button imageButton2 = (Button) this.findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "Select a attchment", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                Intent i = Intent.createChooser(intent, "Please select a attach ");
                MyActivity.this.startActivityForResult(i, 999);
            }
        });

        initSelectImage();
        initImageSwitch();
    }

    private void initSelectImage() {
        Button imageButton2 = (Button) this.findViewById(R.id.imageButton3);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "Select a attchment", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                Intent i = Intent.createChooser(intent, "Please select a attach ");
                MyActivity.this.startActivityForResult(i, 999);

            }
        });
    }

    /**
     *
     */
    private void initImageSwitch() {
        ImageSwitcher imageSwitcher = (ImageSwitcher) this.findViewById(R.id.imageswitch);
        try {
            if (result != null) {
                //imageSwitcher.setImageURI(result.getData());
                ImageView image = new ImageView(this);
                image.setImageURI(result.getData());
                if (imageSwitcher.getNextView() == null)
                    imageSwitcher.addView(image);
                imageSwitcher.setImageURI(result.getData());
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);    //To change body of overridden methods use File | Settings | File Templates.
        if (resultCode == RESULT_OK && requestCode == 999) {
            Toast.makeText(this, "selected a data" + data.getData().toString(), Toast.LENGTH_LONG).show();
            result = data;
            initImageSwitch();
        } else {
            Toast.makeText(this, "does not select a attachment", Toast.LENGTH_LONG).show();
        }
    }

    Intent result = null;
}
