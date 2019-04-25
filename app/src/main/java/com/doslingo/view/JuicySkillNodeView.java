package com.doslingo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.doslingo.R;
import com.doslingo.typeface.widget.JuicyTextView;

public class JuicySkillNodeView extends ConstraintLayout {
  private static final int[] LEVEL_BACKGROUNDS = new int[]{
      R.drawable.skill_icon_background_locked,
      R.drawable.skill_icon_background_beetle,
      R.drawable.skill_icon_background_macaw,
      R.drawable.skill_icon_background_owl,
      R.drawable.skill_icon_background_cardinal,
      R.drawable.skill_icon_background_fox,
      R.drawable.skill_icon_background_mastery,
  };
  private static final String[] LEVEL_ICON_PREFIX = new String[]{
      "levelslocked",
      "purple",
      "blue",
      "green",
      "red",
      "orange",
      "levelsgold",
  };

  private final JuicyFillingRingView progressRing;
  private final AppCompatImageView icon;
  private final AppCompatImageView crownLevel;
  private final JuicyTextView crownCount;

  private int level;
  private int skill;

  public JuicySkillNodeView(Context context) {
    this(context, null);
  }

  public JuicySkillNodeView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public JuicySkillNodeView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    LayoutInflater.from(context).inflate(R.layout.view_skill_node_juicy, this, true);

    progressRing = findViewById(R.id.progressRing);
    icon = findViewById(R.id.icon);
    crownLevel = findViewById(R.id.levelCrown);
    crownCount = findViewById(R.id.crownCount);
    final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.JuicySkillNodeView, defStyleAttr, 0);
    try {
      level = a.getInteger(R.styleable.JuicySkillNodeView_level, 0);
      skill = a.getInteger(R.styleable.JuicySkillNodeView_skill, 1);
      setProgress(a.getFloat(R.styleable.JuicySkillNodeView_progress, 0));
    } finally {
      a.recycle();
    }
    update();
  }

  private void setSkill(int skill) {
    this.skill = skill;
    update();
  }

  private void setLevel(int level) {
    this.level = level;
    update();
  }

  private void update() {
    icon.setBackgroundResource(LEVEL_BACKGROUNDS[this.level]);
    icon.setImageResource(getResources().getIdentifier("icon_" + LEVEL_ICON_PREFIX[level] + "_" + skill, "drawable", getContext().getPackageName()));
    crownLevel.setImageResource(level <= 1 ? R.drawable.crown_grey_stroked : R.drawable.crown_stroked);
    crownCount.setText(level <= 1 ? "" : String.valueOf(level - 1));
  }

  public void setProgress(float progress) {
    progressRing.setProgress(progress);
  }
}
