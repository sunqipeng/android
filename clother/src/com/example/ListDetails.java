package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-13
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class ListDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        this.setContentView(R.layout.image_detail);
        ImageView imageView = (ImageView) this.findViewById(R.id.detail_image);
        imageView.setImageURI(this.getIntent().getData());


    }
}
