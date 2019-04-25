package com.doslingo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.doslingo.R;

public class JuicySkillNodeView extends ConstraintLayout {

  private JuicyFillingRingView progressRing;

  public JuicySkillNodeView(Context context) {
    super(context);
    init(context, null, 0);
  }

  public JuicySkillNodeView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, 0);
  }

  public JuicySkillNodeView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    LayoutInflater.from(context).inflate(R.layout.view_skill_node_juicy, this, true);

    progressRing = findViewById(R.id.progressRing);
    final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.JuicySkillNodeView, defStyleAttr, 0);
    try {
      progressRing.setProgress(a.getFloat(R.styleable.JuicySkillNodeView_progress, 0));
    } finally {
      a.recycle();
    }
  }

}
