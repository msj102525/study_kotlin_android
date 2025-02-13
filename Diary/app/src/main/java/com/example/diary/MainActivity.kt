package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary.databinding.ActivityMainBinding
import com.example.diary.recyclerview.MyListAdaptor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sampleData = mutableListOf(
//            mapOf("date" to "2024/01/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/02/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/03/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/04/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/05/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/06/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/07/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/08/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/09/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/10/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/11/01", "text" to "여기에 일기내용이 들어갑니다."),
//            mapOf("date" to "2024/12/01", "text" to "여기에 일기내용이 들어갑니다."),
//        )

        val sampleData = mutableListOf<Map<String, String>>()
        dbHelper = DatabaseHelper(this@MainActivity)
        dbHelper.readableDatabase.use { db ->
            val cursor = db.query(
                "items", null, null, null, null, null,
                "diary_date DESC", null

            )

            cursor.use {
                while (it.moveToNext()) {
                    sampleData.add(mapOf("date" to it.getString(0), "text" to it.getString(1)))
                }
            }

        }


        binding.recyclervView.layoutManager = LinearLayoutManager(this)
        binding.recyclervView.adapter = MyListAdaptor(sampleData)

        val dividerItemDecoration = DividerItemDecoration(
            this@MainActivity,
            DividerItemDecoration.VERTICAL
        )
        binding.recyclervView.addItemDecoration(dividerItemDecoration)

        binding.fab.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, EditActivity::class.java)
            )
        }


    }
}