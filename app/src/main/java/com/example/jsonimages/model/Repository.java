package com.example.jsonimages.model;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Repository {
  private Connection connection;


  public Repository() {
    connection = new Connection();
  }


  private List<URL> getArray() throws UnknownHostException {
    JSONArray arr;
    List<URL> list = new ArrayList<>();
    try {
      String json = connection.getArrayJson();
      arr = new JSONArray(json);
      System.out.println(arr.get(0));
      for (int i = 0; i<arr.length(); i++) {
        list.add(new URL(arr.get(i).toString()));
      }
    } catch (JSONException e) {
      e.printStackTrace();
      list = null;
    } catch (MalformedURLException e) {
      e.printStackTrace();
      list = null;
    } catch (NullPointerException e) {
      e.printStackTrace();
      list = null;
    }
    return list;
  }


  public List<Bitmap> getImages() throws UnknownHostException {
    List<URL> list = getArray();
    if (connection.loadBitmap(list) == null) {
      return null;
    }
    else {
      return connection.loadBitmap(list);
    }
  }
}