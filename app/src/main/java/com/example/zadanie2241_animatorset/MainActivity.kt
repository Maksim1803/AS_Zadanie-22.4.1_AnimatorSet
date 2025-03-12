package com.example.zadanie2241_animatorset

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie2241_animatorset.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sunAnim = ObjectAnimator.ofFloat(binding.sun, View.TRANSLATION_Y, -1600f)
        sunAnim.duration = 4500

        val nightAnim = ObjectAnimator.ofFloat(binding.night, View.ALPHA, 0f)
        nightAnim.duration = 4500

        val cloud1 = ObjectAnimator.ofFloat(binding.cloud1, View.TRANSLATION_X, -100f, binding.root.width.toFloat() + 1000)
        cloud1.duration = 11000

        val cloud2 = ObjectAnimator.ofFloat(binding.cloud2, View.TRANSLATION_X, -100f, binding.root.width.toFloat() + 1500)
        cloud2.duration = 8000

        val animatorSun = AnimatorSet()
        animatorSun.playTogether(sunAnim, nightAnim)
        animatorSun.play(cloud1).after(sunAnim)
        animatorSun.play(cloud2).after(sunAnim).after(2500)

        animatorSun.start()
    }
}