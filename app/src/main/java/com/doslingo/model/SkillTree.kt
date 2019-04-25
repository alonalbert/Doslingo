package com.doslingo.model

import com.google.gson.annotations.SerializedName

data class SkillTree(
        val skills: List<List<Skill>>
)

data class Skill(
        val accessible: Boolean,
        val experimentIds: List<Any>,
        val experimentalLessons: List<Any>,
        val explanation: Explanation,
        val finishedLessons: Int,
        val finishedLevels: Int,
        val iconId: Int,
        val id: String,
        val lessons: Int,
        val levels: Int,
        val name: String,
        val progressRemaining: List<Double>,
        val shortName: String,
        val strength: Double,
        val tipsAndNotes: String,
        val urlName: String
)

data class Explanation(
        val title: String,
        val url: String
)
