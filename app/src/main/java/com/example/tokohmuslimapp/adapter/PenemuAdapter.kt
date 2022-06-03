package com.example.tokohmuslimapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tokohmuslimapp.DetailPenemuActivity
import com.example.tokohmuslimapp.databinding.RowItemLayoutBinding
import com.example.tokohmuslimapp.databinding.RowPenemuBinding
import com.example.tokohmuslimapp.model.PenemuItem

class PenemuAdapter: RecyclerView.Adapter<PenemuAdapter.PenemuViewHolder>() {

    class PenemuViewHolder (val penemuItemBinding: RowPenemuBinding): RecyclerView.ViewHolder(penemuItemBinding.root) {

        fun bindView(item : PenemuItem) {
            itemView.run {
                penemuItemBinding.txtName.text = item.nama
                penemuItemBinding.txtJenis.text = item.judul
                Glide.with(this).load(item.gambar).into(penemuItemBinding.imageView)
            }
        }

    }

    private var listItemPenemu = arrayListOf<PenemuItem>()

    fun addData(items : List<PenemuItem>) {
        listItemPenemu.clear()
        listItemPenemu.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenemuAdapter.PenemuViewHolder {
        val listItemPenemuBinding = RowPenemuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PenemuViewHolder(listItemPenemuBinding)
    }

    override fun onBindViewHolder(holder: PenemuAdapter.PenemuViewHolder, position: Int) {
        val data = listItemPenemu[position]
        holder.bindView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailPenemuActivity::class.java)
            intent.putExtra(DetailPenemuActivity.Detail_Data,data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listItemPenemu.size
    }
}