package com.example.jsonimages;

import com.example.jsonimages.model.Connection;

import org.junit.Test;

/**
 * Created by ACER on 26.10.2017.
 */
public class RepositoryTest {
  @Test
  public void getArray() throws Exception {
    Connection.Repository repo=new Connection.Repository();
    System.out.println(repo.getImages());
  }
}