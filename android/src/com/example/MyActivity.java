package com.example;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ListView;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyActivity extends Activity {
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        this.setContentView(R.layout.main);
        //ListView lv = (ListView) this.findViewById(R.id.lv);
        //ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.item, new String[]{"1", "2", "3", "4"});
        //lv.setAdapter(aa);
        //init();
        URL url = new URL("http://www.163.com");
        HttpURLConnection httpURLConnection = new HttpURLConnection() {
            @Override
            public void disconnect() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean usingProxy() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void connect() throws IOException {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        HttpClient httpClient=new HttpClient() {
            public HttpParams getParams() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public ClientConnectionManager getConnectionManager() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }
    }

    /**
     * 初始化
     */
    private void init() {
        //To change body of created methods use File | Settings | File Templates.

        if (locationManager == null) {
            locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        }
        ListView lv;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);    //To change body of overridden methods use File | Settings | File Templates.
        System.out.println(v);
        ;
        menu.add("aaaaaaaaaaaa");
        menu.add("aaaaaaaaaaaa");
        menu.add("aaaaaaaaaaaa");
        menu.add("aaaaaaaaaaaa");
        menu.add("aaaaaaaaaaaa");


        this.registerForContextMenu(v);
    }

}
