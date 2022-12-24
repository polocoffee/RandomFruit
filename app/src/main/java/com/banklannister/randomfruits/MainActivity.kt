package com.banklannister.randomfruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.banklannister.randomfruits.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var fruits = listOf(R.drawable.apple, R.drawable.grape, R.drawable.orange)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.randomImageButton.setOnClickListener {
            val random = (fruits).shuffled().first()
            binding.imageViewFruit.setImageResource(random)
            Toast.makeText(this, "random number is $random", Toast.LENGTH_SHORT).show()
        }
        binding.imageViewFruit.setImageResource(R.drawable.ic_orange_vector)
        binding.switchFruit.setOnCheckedChangeListener { _, isChecked ->
            toggleImage(isChecked)

        }
    }

    private fun toggleImage(isChecked: Boolean) {
        if (isChecked) {
            binding.imageViewFruit.setImageResource(R.drawable.grape)
            binding.switchFruit.text = getString(R.string.switch_to_apple)
        } else {
            binding.imageViewFruit.setImageResource(R.drawable.apple)
            binding.switchFruit.text = getString(R.string.switch_to_grapes)
        }
    }

}