package com.example.jsonimages.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class ImageLoader implements Callable<Bitmap> {
  private URL url;


  ImageLoader(URL url) {
    this.url = url;
  }


  @Override
  public Bitmap call() throws Exception {
    Bitmap bitmap;
    Log.i("Bitmap", "call: begin");
    HttpURLConnection connection;
    connection = (HttpURLConnection) url.openConnection();
    InputStream stream;
    connection.setDoInput(true);
    connection.connect();
    stream = connection.getInputStream();
    bitmap = BitmapFactory.decodeStream(stream);
    return bitmap;
  }
}

