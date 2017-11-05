package com.example.jsonimages.model;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class ConnectionProvider implements Callable {
  private URL url;


  ConnectionProvider(URL url) {
    this.url = url;
  }


  @Override
  public InputStream call() throws Exception {
    HttpURLConnection connection;
    connection = (HttpURLConnection) url.openConnection();
    InputStream stream;
    stream = connection.getInputStream();
    return stream;
  }
}

