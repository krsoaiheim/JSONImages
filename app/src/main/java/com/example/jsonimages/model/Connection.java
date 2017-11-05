package com.example.jsonimages.model;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Connection {
  public String getArrayJson() throws UnknownHostException {
    URL url;
    StringBuilder buffer = new StringBuilder();
    String result;
    try {
      url = new URL("http://devcandidates.alef.im/list.php");
      ExecutorService executor = Executors.newSingleThreadExecutor();
      ConnectionProvider requestTask = new ConnectionProvider(url);
      Future responseFuture = executor.submit(requestTask);
      InputStream stream = (InputStream) responseFuture.get();
      executor.shutdownNow();
      String line;
      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
      while ((line = reader.readLine()) != null) {
        buffer.append(line);
      }
      reader.close();
      stream.close();
      result = buffer.toString();
    } catch (MalformedURLException e) {
      e.printStackTrace();
      result = null;
    } catch (InterruptedException e) {
      e.printStackTrace();
      result = null;
    } catch (ExecutionException e) {
      e.printStackTrace();
      result = null;
    } catch (IOException e) {
      e.printStackTrace();
      result = null;
    }
    return result;
  }


  List<Bitmap> loadBitmap(List<URL> list) throws UnknownHostException {
    List<Bitmap> imagesList = new ArrayList<>();
    try {
      List<Callable<Bitmap>> tasks = new ArrayList<>();
      for (URL url : list) {
        tasks.add(new ImageLoader(url));
      }
      ExecutorService executor = Executors.newFixedThreadPool(tasks.size());
      List<Future<Bitmap>> futures = executor.invokeAll(tasks);
      for (Future<Bitmap> future : futures) {
        imagesList.add(future.get());
        executor.shutdownNow();
      }
      Log.e("Bitmap", "returned");
    } catch (InterruptedException e) {
      e.printStackTrace();
      imagesList=null;
    } catch (ExecutionException e) {
      e.printStackTrace();
      imagesList=null;
    }
    return imagesList;
  }
}
