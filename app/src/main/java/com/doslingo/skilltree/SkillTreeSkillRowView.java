package com.doslingo.skilltree;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.doslingo.R;
import com.doslingo.model.Skill;

import java.util.List;


public final class SkillTreeSkillRowView extends FrameLayout {

  private final JuicySkillNodeView[] skillViews = new JuicySkillNodeView[3];

  public SkillTreeSkillRowView(Context context) {
    this(context, null);
  }

  public SkillTreeSkillRowView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SkillTreeSkillRowView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    skillViews[0]= findViewById(R.id.skillNode1);
    skillViews[1] = findViewById(R.id.skillNode2);
    skillViews[2] = findViewById(R.id.skillNode3);
  }

  public void bind(List<Skill> skills) {
    skillViews[0].bind(skills.get(0));
    bindSkill(skills, 1);
    bindSkill(skills, 2);
  }

  private void bindSkill(List<Skill> skills, int i) {
    if (skills.size() > i) {
      skillViews[i].bind(skills.get(i));
      skillViews[i].setVisibility(VISIBLE);
    } else {
      skillViews[i].setVisibility(GONE);
    }
  }
}
