package com.example.jsonimages;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.jsonimages.model.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
  @Test
  public void getArray() throws Exception {
    Connection.Repository repo=new Connection.Repository();
    Log.i("Bitmap",repo.getImages().toString());
  }
}
