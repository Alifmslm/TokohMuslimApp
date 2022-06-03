package com.example.tokohmuslimapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tokohmuslimapp.databinding.ActivityDetailBinding
import com.example.tokohmuslimapp.model.TokohItem

class DetailTokohActivity : AppCompatActivity() {

    companion object {
        const val Detail_Data1 = ""
    }

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<TokohItem>(Detail_Data1)

        binding.txtDetailJudul.text = data?.judul
        binding.txtDetailDesk.text = data?.desk
        binding.txtDetailNama.text = data?.nama
        Glide.with(this).load(data?.gambar).into(binding.imageView3)

    }
}