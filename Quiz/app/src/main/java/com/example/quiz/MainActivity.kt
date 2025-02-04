package com.example.quiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.databinding.ActivityMainBinding

const val QUIZ_COUNT = 7

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var rightAnser: String? = null
    private var rightAnserCount = 0
    private var quizCount = 1

    private val quizData = mutableListOf(
        listOf("프랑스의 수도", "파리"),
        listOf("손흥민의 소속팀", "토트넘"),
        listOf("삼성전자 회장 이름", "이재용"),
        listOf("오타니의 소속팀", "다저스"),
        listOf("별다방의 정식명칭", "스타벅스"),
        listOf("사랑합니다를 영어로", "알러뷰"),
        listOf("사랑합니다를 불어로", "쥬댕"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizData.shuffle()

        showNextQuiz()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 퀴즈를 출제하는 메소드
    private fun showNextQuiz() {
        binding.countLabel.text = getString(R.string.count_label, quizCount)
        val quiz = quizData[0]
        binding.quizLabel.text = quiz[0]
        rightAnser = quiz[1]

        quizData.removeAt(0)
    }

    // 채점하는 메소드
    private fun checkAnswer() {
        val answerText = binding.answerText.toString()

        val alertTitle: String
        if(answerText == rightAnser) {
            alertTitle = "정답!"
            rightAnserCount++
        } else {
            alertTitle = "오답..."
        }

        val answerDialogFragment = AnswerDialogFragment()
        val bundle = Bundle().apply {
            putString("TITLE", alertTitle)
            putString("MESSAGE", "정답은 ${rightAnser}")
        }
        answerDialogFragment.arguments = bundle
        answerDialogFragment.isCancelable = false
        answerDialogFragment.show(supportFragmentManager, "my_dialog")
    }

    // 문제수를 확인하는 메소드
    fun checkQuizCount() {
        if (quizCount == QUIZ_COUNT) {
        } else {
            binding.answerText.text.clear()
            quizCount++
            showNextQuiz()
        }

    }


}