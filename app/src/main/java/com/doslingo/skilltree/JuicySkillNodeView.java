package com.doslingo.skilltree;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.doslingo.R;
import com.doslingo.model.Skill;
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
  private final JuicyTextView title;

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
    title = findViewById(R.id.title);
    final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.JuicySkillNodeView, defStyleAttr, 0);
    final int level;
    final int skill;
    try {
      level = a.getInteger(R.styleable.JuicySkillNodeView_level, 0);
      skill = a.getInteger(R.styleable.JuicySkillNodeView_skill, 1);
      setProgress(a.getFloat(R.styleable.JuicySkillNodeView_progress, 0));
      setTitle(a.getString(R.styleable.JuicySkillNodeView_title));
    } finally {
      a.recycle();
    }
    updateSkillAndLevel(skill, level);
  }



  public void bind(Skill skill) {
    final int level;
    if (!skill.getAccessible()) {
      level = 0;
    } else {
      level = skill.getFinishedLevels() + 1;
    }
    updateSkillAndLevel(skill.getIconId(), level);
    setTitle(skill.getShortName());
    setProgress(((float)skill.getFinishedLessons()) / skill.getLessons());
  }

  private void setTitle(String title) {
    if (title == null) {
      title = "";
    }
    this.title.setText(title);
  }

  private void updateSkillAndLevel(int skill, int level) {
    icon.setBackgroundResource(LEVEL_BACKGROUNDS[level]);
    icon.setImageResource(getResources().getIdentifier("icon_" + LEVEL_ICON_PREFIX[level] + "_" + skill, "drawable", getContext().getPackageName()));
    if (level <= 1) {
      crownLevel.setImageResource(R.drawable.crown_grey_stroked);
      crownCount.setVisibility(GONE);
    } else {
      crownLevel.setImageResource(R.drawable.crown_stroked);
      crownCount.setText(String.valueOf(level - 1));
      crownCount.setVisibility(VISIBLE);
    }
  }

  public void setProgress(float progress) {
    progressRing.setProgress(progress);
  }
}
