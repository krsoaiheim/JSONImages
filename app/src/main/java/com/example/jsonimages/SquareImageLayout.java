package com.example.jsonimages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SquareImageLayout extends FrameLayout {
  public SquareImageLayout(Context context) {
    super(context);
  }


  public SquareImageLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }


  public SquareImageLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }


  @Override
  public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, widthMeasureSpec);
  }
}
