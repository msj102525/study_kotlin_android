package com.example.favorite

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.favorite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = listOf(
            "일본 여성", "먹방", "외로운 남자", "상어모자",
            "소리지름", "행가레", "오덕후", "근육남", "말 두명",
            "먕1", "먕2", "먕3"
        )

        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@MainActivity, "${data[position]}을 선택하셨습니다", Toast.LENGTH_SHORT)
                .show()
        }

    }
}