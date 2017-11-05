package com.example.jsonimages;

import com.example.jsonimages.model.Connection;

import org.junit.Test;

/**
 * Created by ACER on 25.10.2017.
 */
public class ConnectionTest {
  @Test
  public void getConnection() throws Exception {
    System.out.println(new Connection().getArrayJson());  }
}