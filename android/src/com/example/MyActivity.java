package com.example;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends Activity {
    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);    //To change body of overridden methods use File | Settings | File Templates.

    }

    @Override
    protected void onPause() {
        super.onPause();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);    //To change body of overridden methods use File | Settings | File Templates.
        System.out.println("操作结束了");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);    //To change body of overridden methods use File | Settings | File Templates.

    }

    boolean state = false;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) this.findViewById(R.id.btn);
        Intent intent = new Intent(MyActivity.this, BoundService.class);
        MyActivity.this.bindService(intent, MyActivity.this.sc, Context.BIND_AUTO_CREATE);

        if (lb == null) {
            Log.e("app", "获取的现在是ibinder为空  ");
        } else {
            //Toast.makeText(MyActivity.this, lb.getService().getCurrentDate(), Toast.LENGTH_LONG).show();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, lb.getService().getCurrentDate(), Toast.LENGTH_LONG).show();
            }
        });
    }

    BoundService.LocalBinder lb;
    private ServiceConnection sc = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //To change body of implemented methods use File | Settings | File Templates.
            Log.e("app", "conservice connected " + componentName.toShortString());
            //Log.e("app", iBinder == null ? "无法获取ibinder", iBinder.toString());
            Log.e("app", iBinder == null ? "无法获取" : iBinder.toString());
            lb = (BoundService.LocalBinder) iBinder;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            //To change body of implemented methods use File | Settings | File Templates.
            Log.e("app", "conservice disconnected " + componentName.toShortString());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (int i = 0; i < 10; i++)
            menu.add("aaaaaaaaa");
        return true;
    }
}
