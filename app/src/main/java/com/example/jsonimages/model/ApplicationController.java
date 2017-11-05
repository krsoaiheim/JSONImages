package com.example.jsonimages.model;

import android.app.Application;

import com.example.jsonimages.MainPresenter;

public class ApplicationController extends Application {
  private static ApplicationController instance;
  private MainPresenter mPresenter;


  public static synchronized ApplicationController getInstance() {
    instance = (instance == null ? new ApplicationController() : instance);
    return instance;
  }


  @Override
  public void onCreate() {
    super.onCreate();
  }


  public MainPresenter getPresenter() throws Exception {
    if (mPresenter == null) {
      mPresenter = new MainPresenter();
    }
    return mPresenter;
  }


  public void removePresenter() {
    this.mPresenter = null;
  }
}