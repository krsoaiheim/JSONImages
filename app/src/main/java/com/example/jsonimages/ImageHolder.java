package com.example.jsonimages;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class ImageHolder extends RecyclerView.ViewHolder implements RecyclerGridView {
  private ImageView imageView;


  ImageHolder(View itemView) {
    super(itemView);
    imageView = itemView.findViewById(R.id.imageView);
  }


  @Override
  public void setImage(Bitmap bitmap) {
    imageView.setImageBitmap(bitmap);
  }
}