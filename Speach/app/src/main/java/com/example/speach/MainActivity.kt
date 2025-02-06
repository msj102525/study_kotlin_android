package com.example.speach

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.speach.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener, TextToSpeech.OnInitListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFast.setOnClickListener(this)
        binding.btnNormal.setOnClickListener(this)
        binding.btnSlow.setOnClickListener(this)

        tts = TextToSpeech(this@MainActivity, this@MainActivity)

        binding.btnFast.visibility = View.INVISIBLE
        binding.btnNormal.visibility = View.INVISIBLE
        binding.btnSlow.visibility = View.INVISIBLE

    }

    override fun onClick(v: View?) {
        tts.stop()

        val speakText = binding.editText.text.toString()

        Log.v("MY_LOG", "speakText: ${speakText}")


        val rate = when (v?.id) {
            R.id.btnFast -> 2.0f
            R.id.btnSlow -> 0.5f
            else -> 1.0f
        }
        tts.setSpeechRate(rate)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(speakText, TextToSpeech.QUEUE_FLUSH, null, "utteranceId")
        } else {
            tts.speak(speakText, TextToSpeech.QUEUE_FLUSH, null)
        }

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            if (tts.isLanguageAvailable(Locale.KOREA) >= TextToSpeech.LANG_AVAILABLE) {
                tts.language = Locale.KOREA

                binding.btnFast.visibility = View.VISIBLE
                binding.btnNormal.visibility = View.VISIBLE
                binding.btnSlow.visibility = View.VISIBLE
            } else {
                Log.v("MY_LOG", "TextToSpeach가 초기화 되었지만 한국어를 사용할 수 업습니다.")
            }
        } else {
            Log.v("MY_LOG", "TextToSpeach가 초기화가 실패하였습니다")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        tts.shutdown()
    }

}