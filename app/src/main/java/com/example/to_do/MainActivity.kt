package com.example.to_do

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var tasks: MutableList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views in the layout
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val taskTitleInput: EditText = findViewById(R.id.taskTitleInput)
        val taskDescriptionInput: EditText = findViewById(R.id.taskDescriptionInput)
        val addTaskButton: Button = findViewById(R.id.addTaskButton)

        // Initialize task list and adapter
        tasks = mutableListOf(
            Task("Task 1", "Description 1", false),
            Task("Task 2", "Description 2", true)
        )
        taskAdapter = TaskAdapter(tasks)

        // Set the layout manager and adapter for the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        // Handle add task button click
        addTaskButton.setOnClickListener {
            val title = taskTitleInput.text.toString()
            val description = taskDescriptionInput.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()) {
                val newTask = Task(title, description, false)
                taskAdapter.addTask(newTask)
                taskTitleInput.text.clear()
                taskDescriptionInput.text.clear()
            }
        }
    }
}
