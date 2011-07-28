package com.example;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
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
        ContentResolver cr = this.getContentResolver();

        MyActivity.this.bindService(intent, MyActivity.this.sc, Context.BIND_AUTO_CREATE);


        if (lb == null) {
            Log.e("app", "获取的现在是ibinder为空  ");
        } else {
            //Toast.makeText(MyActivity.this, lb.getService().getCurrentDate(), Toast.LENGTH_LONG).show();
        }

        btn.setKeyListener(new KeyListener() {
            public int getInputType() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {

                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public void clearMetaKeyState(View view, Editable editable, int i) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MyActivity.this, lb.getService().getCurrentDate(), Toast.LENGTH_LONG).show();
                final Handler h = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        TextView tv = (TextView) MyActivity.this.findViewById(R.id.tv);
                        tv.setText("当前的执行为" + msg.what);
                        Log.e("app", "当前线程id" + Thread.currentThread().getId());
                        Toast.makeText(MyActivity.this.getApplicationContext(), "程序执行完毕", Toast.LENGTH_LONG).show();
                        super.handleMessage(msg);    //To change body of overridden methods use File | Settings | File Templates.
                    }
                };

                new Thread(new Runnable() {
                    public void run() {
                        int i = 0;
                        System.out.println("Thread in inner class id is" + Thread.currentThread().getId());
                        while (i < 115) {
                            i++;

                            Message m = new Message();
                            m.what = i;
                            h.sendMessage(m);
                            try {
                                Thread.currentThread().join(1000l);
                            } catch (InterruptedException e) {
                                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                            }
                        }
                        Log.e("app", "线程执行完毕");

                    }
                }).start();

                Log.e("app", "当前线程Outer id" + Thread.currentThread().getId());
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
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            item.setChecked(!item.isChecked());
        }
        return super.onOptionsItemSelected(item);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        this.registerForContextMenu(v);
        super.onCreateContextMenu(menu, v, menuInfo);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
