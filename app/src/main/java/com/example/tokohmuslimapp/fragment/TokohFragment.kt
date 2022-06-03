package com.example.tokohmuslimapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokohmuslimapp.adapter.TokohAdapter
import com.example.tokohmuslimapp.databinding.FragmentTokohBinding
import com.example.tokohmuslimapp.model.TokohItem
import com.example.tokohmuslimapp.network.RetrofitInterface
import com.example.tokohmuslimapp.network.RetrofitService
import com.example.tokohmuslimapp.room.RoomDB
import kotlinx.coroutines.launch

class TokohFragment : Fragment() {

    private lateinit var binding : FragmentTokohBinding
    private lateinit var tokohAdapter: TokohAdapter
    private lateinit var roomDB : RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTokohBinding.inflate(inflater,container,false)

        roomDB = RoomDB.getRoomDatabaseItem(context!!)

        tokohAdapter = TokohAdapter {
            viewLifecycleOwner.lifecycleScope.launch {
                roomDB.roomDao().deleteData(it)
            }
        }

        binding.rvTokoh.adapter = tokohAdapter
        binding.rvTokoh.setHasFixedSize(true)
        binding.rvTokoh.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //memberi data nama yang berasal dari gallery fragment
        val dataItemTokoh = roomDB.roomDao().getDatabyType("tokoh")
        dataItemTokoh.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                tokohAdapter.addData(it)
                tokohAdapter.notifyDataSetChanged()
            }else {
                Toast.makeText(context, "Database Kosong", Toast.LENGTH_SHORT).show()

                val retrofitService = RetrofitService.buildServices(RetrofitInterface::class.java)

                viewLifecycleOwner.lifecycleScope.launch {
                    val getTokoh = retrofitService.getDataTokoh()
                    //kondisi saat sukses show data
                    if (getTokoh.isSuccessful) {
                        val dataTokoh = getTokoh.body() as List<TokohItem>
                        dataTokoh.forEach {
                            it.type = "tokoh"
                        }
                        roomDB.roomDao().insertData(dataTokoh)
                    }
                }

            }
        })

    }

}