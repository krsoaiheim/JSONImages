package com.example.jsonimages;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class ImageAdapter extends RecyclerView.Adapter<ImageHolder> {
  private final MainPresenter presenter;


  ImageAdapter(MainPresenter repositoriesPresenter) {
    this.presenter = repositoriesPresenter;
  }


  @Override
  public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ImageHolder(LayoutInflater.from(parent.getContext())
          .inflate(R.layout.recycler_image_item, parent, false));
  }


  @Override
  public void onBindViewHolder(ImageHolder holder, int position) {
    presenter.onBindViewAtPosition(position, holder);
  }


  @Override
  public int getItemCount() {
    return presenter.getRepositoriesRowsCount();
  }
}