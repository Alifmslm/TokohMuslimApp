package com.example.tokohmuslimapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tokohmuslimapp.DetailPenemuActivity
import com.example.tokohmuslimapp.DetailTokohActivity
import com.example.tokohmuslimapp.databinding.RowItemLayoutBinding
import com.example.tokohmuslimapp.model.TokohItem

class TokohAdapter(private val clickListener: (TokohItem) -> Unit) : RecyclerView.Adapter<TokohAdapter.TokohViewHolder>() {

    class TokohViewHolder (val tokohItemBinding: RowItemLayoutBinding): RecyclerView.ViewHolder(tokohItemBinding.root) {

        fun bindView(item : TokohItem, clickListener: (TokohItem) -> Unit) {
            itemView.run {
                tokohItemBinding.txtName.text = item.nama
                tokohItemBinding.txtJenis.text = item.judul
                Glide.with(this).load(item.gambar).into(tokohItemBinding.imageView)
                tokohItemBinding.btnDelete.setOnClickListener { clickListener(item) }
            }
        }

    }

    private var listItemTokoh = arrayListOf<TokohItem>()


    fun addData(itema : List<TokohItem>) {
        listItemTokoh.clear()
        listItemTokoh.addAll(itema)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TokohViewHolder {
        val listItemTokohBinding = RowItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TokohViewHolder(listItemTokohBinding)
    }

    override fun onBindViewHolder(holder: TokohViewHolder, position: Int) {
        val data = listItemTokoh[position]
        holder.bindView(data, clickListener)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailTokohActivity::class.java)
            intent.putExtra(DetailTokohActivity.Detail_Data1,data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listItemTokoh.size
    }


}