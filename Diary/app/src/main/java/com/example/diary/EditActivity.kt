package com.example.diary

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diary.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private lateinit var dbHelper: DatabaseHelper

    private var textFeeling: String? = ""
    private var textAction: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditBinding.inflate(layoutInflater)

        setContentView(binding.root)

        intent?.extras?.let {
            binding.diaryDate.setText(it.getString("DIARY_DATE"))
            binding.diaryText.setText(it.getString("DIARY_TEXT"))
        }

        dbHelper = DatabaseHelper(this@EditActivity)

        binding.btnSave.setOnClickListener {
            if (binding.diaryDate.text.isNullOrBlank() ||
                binding.diaryText.text.isNullOrBlank()
            ) {
                Toast.makeText(this, "날짜나 내용은 필수 입력입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            dbHelper.writableDatabase.use { db ->
                val values = ContentValues().apply {
                    put("diary_date", binding.diaryDate.text.toString())
                    put("diary_text", binding.diaryText.text.toString())
                }
                db.insertWithOnConflict(
                    "items", null, values,
                    SQLiteDatabase.CONFLICT_REPLACE
                )
                startActivity(Intent(this@EditActivity, MainActivity::class.java))
            }
        }

        binding.btnDelete.setOnClickListener {
            if (binding.diaryDate.text.isNullOrBlank()) {
                Toast.makeText(this, "날짜가 입력되지 않았습니다.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            dbHelper.writableDatabase.use { db ->
                val params = arrayOf(binding.diaryDate.text.toString())
                db.delete("items", "diary_date = ?", params)
                startActivity(Intent(this@EditActivity, MainActivity::class.java))
            }
        }

        binding.diaryDate.setOnClickListener {
            val datePicker = DatePickerFragment()
            datePicker.show(supportFragmentManager, "datePicker")
        }

        binding.feelGreat.setOnClickListener { feelClicked(it) }
        binding.feelGood.setOnClickListener { feelClicked(it) }
        binding.feelNormal.setOnClickListener { feelClicked(it) }
        binding.feelAwful.setOnClickListener { feelClicked(it) }
        binding.feelBad.setOnClickListener { feelClicked(it) }

        binding.actionWork.setOnClickListener { actionClicked(it) }
        binding.actionWorkOut.setOnClickListener { actionClicked(it) }
        binding.actionMovie.setOnClickListener { actionClicked(it) }
        binding.actionShopping.setOnClickListener { actionClicked(it) }
        binding.actionSleep.setOnClickListener { actionClicked(it) }

    }

    private fun feelClicked(view: View) {
        textFeeling = when (view.id) {
            R.id.feelGreat -> "오늘은 최고의 날이었다!"
            R.id.feelGood -> "오늘은 좋은 날이었다!"
            R.id.feelNormal -> "오늘은 보통이었다!"
            R.id.feelAwful -> "오늘은 기분이 좀 안좋았다!!"
            else -> {
                "오늘은 최악의 하루였다..!"
            }
        }
        updateDiaryText()
    }

    private fun actionClicked(view: View) {
        textAction = when (view.id) {
            R.id.actionWork -> "오늘은 열심히 일한 날이었다."
            R.id.actionWorkOut -> "오늘은 하루종일 운동을 하였다."
            R.id.actionShopping -> "오늘은 물건사러 돌아다닌 하루였다."
            R.id.actionMovie -> "오늘은 영화 정주행한 날이었다."
            else -> "오늘은 하루종일 잠만 잤다..."
        }
        updateDiaryText()
    }

    private fun updateDiaryText() {
        binding.diaryText.setText(getString(R.string.diary_text, textFeeling, textAction))
    }
}