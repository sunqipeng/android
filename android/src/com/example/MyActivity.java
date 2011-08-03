package com.example;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.*;
import android.widget.*;

import java.io.FileOutputStream;

public class MyActivity extends Activity implements SurfaceHolder.Callback {
    private Camera camera;
    private SurfaceView sv;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sv = (SurfaceView) this.findViewById(R.id.sv);
        create();

        Button btn = (Button) this.findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                camera.takePicture(null, null, new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] bytes, Camera camera) {
                        //To change body of implemented methods use File | Settings | File Templates.
                        try {
                            TextView tv = (TextView) MyActivity.this.findViewById(R.id.tv);
                            tv.setText(Environment.getExternalStorageDirectory().getAbsolutePath());
                            Bitmap bm = android.graphics.BitmapFactory.decodeByteArray(bytes, 0, 300, null);

                            FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory() +String.valueOf(System.currentTimeMillis()) +".jpg");
                            fos.write(bytes);

                            fos.close();
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
                    }
                });
            }
        });
        TextView tv = (TextView) this.findViewById(R.id.tv);
        tv.setText(this.getPreferences(Context.MODE_PRIVATE).getString("date", "默认字符串"));
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.item, new String[]{"1", "2", "3"});
        ListView lv = (ListView) this.findViewById(R.id.lv);
        lv.setAdapter(aa);
        ContentResolver cr = this.getContentResolver();


        EditText et = (EditText) this.findViewById(R.id.e);
        et.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                System.out.println(i);

                return true;
            }
        });


    }

    private void create() {

        this.sv.getHolder().addCallback(this);
        this.sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        this.sv.getHolder().setFixedSize(400, 300);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        //To change body of implemented methods use File | Settings | File Templates.
        camera = Camera.open();
        try {
            camera.getParameters().setRotation(90);
            camera.setPreviewDisplay(this.sv.getHolder());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        camera.startPreview();
    }


    @Override
    protected void onPause() {
        super.onPause();    //To change body of overridden methods use File | Settings | File Templates.
        camera.stopPreview();
        camera.release();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //To change body of implemented methods use File | Settings | File Templates.
        camera.stopPreview();
        camera.release();

    }
}
