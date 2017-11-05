package com.example.jsonimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

import com.example.jsonimages.model.Repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter {
  private Repository repo;
  private List<Bitmap> datas = new ArrayList<>();
  private MainActivity view;
  private Boolean isConnected;


  public MainPresenter() {
    repo = new Repository();
  }


  void init() {
    if (isConnected == null) {
      ConnectivityManager cm = (ConnectivityManager) view.getApplicationContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE);
      if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
        Network[] activeNetwork = new Network[0];
        if (cm != null) {
          activeNetwork = cm.getAllNetworks();
        }
        isConnected = activeNetwork.length != 0;
      }
      else {
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null;
      }
      if (isConnected) {
        try {
          this.datas = repo.getImages();
        } catch (UnknownHostException e) {
          e.printStackTrace();
          view.showError("Сервер недоступен");
        }
      }
      else {
        view.showError("Отсутствует подключение к интернету");
      }
    }
  }


  boolean isConnected() {
    return isConnected;
  }


  void onBindViewAtPosition(int position, ImageHolder rowView) {
    if (datas != null) {
      Bitmap bitmap = datas.get(position);
      rowView.setImage(bitmap);
    }
    else {
      view.showError("Ошибка загрузки данных");
    }
  }


  int getRepositoriesRowsCount() {
    return datas.size();
  }


  void attachView(MainActivity mvpView) {
    view = mvpView;
  }


  void detachView() {
    view = null;
  }
}