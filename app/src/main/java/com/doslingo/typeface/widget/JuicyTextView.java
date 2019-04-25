package com.doslingo.typeface.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class JuicyTextView extends AppCompatTextView {
  public JuicyTextView(Context context) {
    super(context);
    init(context, null, 0);
  }

  public JuicyTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, 0);
  }

  public JuicyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {

  }

}
