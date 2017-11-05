package com.example.jsonimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jsonimages.model.ApplicationController;

public class MainActivity extends AppCompatActivity {
  MainPresenter mainPresenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      mainPresenter = ApplicationController.getInstance().getPresenter();
    } catch (Exception e) {
      e.printStackTrace();
      showError("Что-то пошло не так");
    }
    mainPresenter.attachView(this);
    setContentView(R.layout.activity_main);
    mainPresenter.init();
    if (mainPresenter.isConnected()) {
      RecyclerView rv = findViewById(R.id.image_grid);
      boolean isTablet = getResources().getBoolean(R.bool.isTablet);
      int colCount = isTablet ? 3 : 2;
      rv.setLayoutManager(new GridLayoutManager(this, colCount));
      rv.setAdapter(new ImageAdapter(mainPresenter));
    }
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    mainPresenter.detachView();
    /*if (isFinishing()) {
      mainPresenter.destroy();
    }*/
  }


  public void showError(String error) {
    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
  }
}
