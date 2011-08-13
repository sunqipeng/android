package com.example;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-13
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class ClothesList extends ListActivity {
    List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
    private static int CHOOSE_IMAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        init();
        initClickHandler();
    }

    private void initClickHandler() {

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, ListDetails.class);

        String fileName = "/sdcard/DCIM/Camera/" + this.listFileName()[position];
        File file = new File(fileName);
        intent.setData(Uri.fromFile(file));
        this.startActivity(intent);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("ToDetail");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("选择图片");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        Intent choose = Intent.createChooser(intent, "选择图片");
        this.startActivityForResult(choose, ClothesList.CHOOSE_IMAGE);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            Map<String, Object> map = new HashMap<String, Object>();
        }
    }

    /**
     * 返回摄像头拍摄后的目录中的所有文件
     *
     * @return
     */
    private String[] listFileName() {
        File file = new File("/sdcard/DCIM/Camera");
        return file.list();
    }


    private void init() {

        File file = null;
        for (String fileName : this.listFileName()) {
            fileName = "/sdcard/DCIM/Camera/" + fileName;
            Map<String, Object> map = new HashMap<String, Object>();
            file = new File(fileName);
            Log.e("app", fileName);
            map.put("image", Uri.fromFile(file));
            map
                    .put("name", file.getName());
            list.add(map);

        }
        SimpleAdapter.ViewBinder viewBinder = new SimpleAdapter.ViewBinder() {
            public boolean setViewValue(View view, Object o, String s) {
                if (view.getId() == R.id.test2) {
                    ((ImageView) view).setImageURI((Uri) o);
                    return true;
                } else {
                    return false;
                }

            }
        };

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.test_detail, new String[]{"name", "image"}, new int[]{R.id.test, R.id.test2});
        simpleAdapter.setViewBinder(viewBinder);
        this.setListAdapter(simpleAdapter);
    }


}
