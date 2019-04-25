package com.doslingo.skilltree

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.doslingo.R
import com.doslingo.model.Skill
import com.doslingo.model.SkillTree
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader

class SkillTreeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)

        val reader = InputStreamReader(assets.open("skills.json"))
        val skillTree = Gson().fromJson(reader, SkillTree::class.java)
        viewAdapter = SkillTreeAdapter(skillTree.skills)

        recyclerView = findViewById<RecyclerView>(R.id.skills).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}

