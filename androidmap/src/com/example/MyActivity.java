package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.*;

public class MyActivity extends Activity {
    private static int SHOW_OPEN_BLUE_ADAPTER_DIALOG = 1;
    private static int ENABLE_BLUETOOTH = 2;
    private boolean isBlusOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        this.setContentView(R.layout.main);
        //SimpleAdapter<Map<String, String>> arrayAdapter = new ArrayAdapter<Map<String, String>>(this, R.layout.sensor_detail);


        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        for (Sensor sensor : sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", sensor.getName());
            map.put("vender", sensor.getVendor());
            map.put("type", getType(sensor.getType()));
            list.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.sensor_detail, new String[]{"name", "vender", "type"}, new int[]{R.id.name, R.id.vender, R.id.type});

        ListView listView = (ListView) this.findViewById(R.id.sensorListView);
        listView.setAdapter(simpleAdapter);
        simpleAdapter.notifyDataSetChanged();


        for (Sensor sensor : sensorManager.getSensorList(Sensor.TYPE_ORIENTATION)) {
            //sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_UI);
        }
        initBlueAdapter();

    }

    private void initBlueAdapter() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()) {
            this.isBlusOpen = false;
            this.showDialog(SHOW_OPEN_BLUE_ADAPTER_DIALOG);
        } else {
            this.isBlusOpen = true;
        }

        if (this.isBlusOpen) {
            listPairDevice();
        }
    }

    /**
     * 显示出所有的设备配对信息
     */
    private void listPairDevice() {

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        TextView textView = (TextView) this.findViewById(R.id.orientation);
        for (BluetoothDevice device : pairedDevices) {
            String value = "device:" + device.getName() + "  " + device.getAddress();
            textView.append(value);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.isBlusOpen) {
            menu.add("关闭蓝牙设备");
        } else {
            menu.add("打开蓝牙设备");
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getOrder() == 0) {
            if (this.isBlusOpen) {
                shutdownBlueTooth();
            } else {
                openBlueTooth();
            }
        }
        return true;
    }

    private void shutdownBlueTooth() {


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        if (id == SHOW_OPEN_BLUE_ADAPTER_DIALOG) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("蓝牙设备设置");
            builder.setMessage("当前设备的蓝牙接口没有打开，是否开启?");
            builder.setCancelable(true);
            builder.setPositiveButton("开启",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            openBlueTooth();
                        }
                    });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            dialog = builder.create();
        }
        return dialog;
    }


    /**
     * enable the bluetooth device
     */
    private void openBlueTooth() {
        //To change body of created methods use File | Settings | File Templates.
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        this.startActivityForResult(intent, ENABLE_BLUETOOTH);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == MyActivity.ENABLE_BLUETOOTH) {
                this.isBlusOpen = true;
            }
        } else {
            this.isBlusOpen = false;
        }
    }

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent sensorEvent) {
            //To change body of implemented methods use File | Settings | File Templates.
            TextView textView = (TextView) MyActivity.this.findViewById(R.id.orientation);
            textView.append("\n");
            for (int i = 0; i < sensorEvent.values.length; i++) {
                textView.append(String.valueOf(sensorEvent.values[i]));
                textView.append("-");
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    };

    private String getType(int type) {
        switch (type) {
            case Sensor.TYPE_ACCELEROMETER:
                return "accelerometer";
            case Sensor.TYPE_GYROSCOPE:
                return "gyroscope";
            case Sensor.TYPE_LIGHT:
                return "light";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "magnetic";
            case Sensor.TYPE_ORIENTATION:
                return "orientation";
            case Sensor.TYPE_PRESSURE:
                return "presure";
            case Sensor.TYPE_PROXIMITY:
                return "proximity";
            case Sensor.TYPE_TEMPERATURE:
                return "temperature";
            default:
                return "can not ";

        }
    }
}
