package com.doslingo.skilltree

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doslingo.R
import com.doslingo.model.Skill

class SkillTreeAdapter(val skills: List<List<Skill>>) :
        RecyclerView.Adapter<SkillTreeAdapter.ViewHolder>() {

    class ViewHolder(val skillRowView: SkillTreeSkillRowView) : RecyclerView.ViewHolder(skillRowView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_skill_tree_skill_row, parent, false) as SkillTreeSkillRowView
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return skills.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.skillRowView.bind(skills[position])
    }
}