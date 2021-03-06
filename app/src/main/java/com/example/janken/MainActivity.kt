package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.janken.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gu.setOnClickListener{onJankenButtonTapped(it)}
        binding.choki.setOnClickListener{onJankenButtonTapped(it)}
        binding.pa.setOnClickListener{onJankenButtonTapped(it)}

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear()
    }

    fun onJankenButtonTapped(view: View?){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("MY_HAND", view?.id)
        startActivity(intent)
    }

}