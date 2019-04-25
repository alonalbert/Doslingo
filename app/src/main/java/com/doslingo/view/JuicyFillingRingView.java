package com.doslingo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class JuicyFillingRingView extends View {

  public JuicyFillingRingView(Context context) {
    super(context);
    init(context, null, 0);
  }

  public JuicyFillingRingView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, 0);
  }

  public JuicyFillingRingView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {
  }
}

