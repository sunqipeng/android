package com.example;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    Map<String, String> suolvetu = null;
    private static int CHOOSE_IMAGE = 0;
    private static String TEMP_DIRECTORY = "/sdcard/aaaa/";

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
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("image/*");
//        Intent choose = Intent.createChooser(intent, "选择图片");
        //this.startActivityForResult(choose, ClothesList.CHOOSE_IMAGE);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.startActivityForResult(intent, 999);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super
                .onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {

            Object object = data.getExtras().get("data");

            Log.e("app", object.toString());
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

                    File f = new File(((Uri) o).getPath());
                    //Bitmap t = BitmapFactory.decodeFile(f.getAbsolutePath());
                    Bitmap bitmap = BitmapFactory.decodeFile(((Uri) o).getPath());
                    if (bitmap == null)
                        return false;
                    Bitmap t = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 20, bitmap.getHeight() / 20, true);
                    ((ImageView) view).setImageBitmap(t);

                    return true;
                } else {
                    return false;
                }

            }
        };
        Camera camera = Camera.open();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.test_detail, new String[]{"name", "image"}, new int[]{R.id.test, R.id.test2});
        simpleAdapter.setViewBinder(viewBinder);
        this.setListAdapter(simpleAdapter);
    }


    /**
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    private String checkExist(File file) throws FileNotFoundException {

        if (suolvetu == null) {
            suolvetu = new HashMap<String, String>();
            File f = new File(ClothesList.TEMP_DIRECTORY);
            for (String str : f.list()) {
                suolvetu.put(str, ClothesList.TEMP_DIRECTORY);
            }
            build(file);
        } else {
            if (suolvetu.containsKey(file.getName())) {
                return suolvetu.get(file.getName());
            } else {
                build(file);
            }
        }

        File f = new File(ClothesList.TEMP_DIRECTORY + file.getName());
        return f.getAbsolutePath();
    }

    private void build(File file) throws FileNotFoundException {
        File f = new File(ClothesList.TEMP_DIRECTORY + file.getName());
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 10, bitmap.getHeight() / 10, true).compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(f));
    }


}
