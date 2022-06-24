package com.bitcode.intentfilters

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import com.bitcode.intentfilters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder().build()
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDisplayImage.setOnClickListener {

            //explicit intent
            //var intent = Intent(this, MyImageActivity::class.java)

            var intent = Intent("in.bitcode.media.VIEW")
            intent.addCategory("in.bitcode.category.TECH")
            intent.setDataAndType(
                Uri.parse(binding.edtFilePath.text.toString()),
                "image/jpeg"
            )

            //intent.putExtra("path", binding.edtFilePath.text.toString())

            startActivity(intent)

        }
    }
}