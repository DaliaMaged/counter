package com.example.liveandmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.liveandmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
       // val textView=findViewById<TextView>(R.id.textView)
        //val countBtn=findViewById<Button>(R.id.button)
        //provider to viewmodel lifecyle
        viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        //observe the change
        viewModel.count.observe(this, Observer {
            binding.textView.text=it.toString()
        })

        binding.button.setOnClickListener {
            viewModel.updateCount()
        }
    }
}
