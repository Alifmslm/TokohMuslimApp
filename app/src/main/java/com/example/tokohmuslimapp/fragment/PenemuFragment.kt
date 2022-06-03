package com.example.tokohmuslimapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokohmuslimapp.R
import com.example.tokohmuslimapp.adapter.PenemuAdapter
import com.example.tokohmuslimapp.databinding.FragmentPenemuBinding
import com.example.tokohmuslimapp.model.PenemuItem
import com.example.tokohmuslimapp.network.RetrofitInterface
import com.example.tokohmuslimapp.network.RetrofitService
import kotlinx.coroutines.launch


class PenemuFragment : Fragment() {

    private lateinit var binding : FragmentPenemuBinding
    private lateinit var penemuAdapter: PenemuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPenemuBinding.inflate(inflater,container,false)

        penemuAdapter = PenemuAdapter()
        binding.rvPenemu.adapter = penemuAdapter
        binding.rvPenemu.setHasFixedSize(true)
        binding.rvPenemu.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildServices(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val requestDataPenemu = retrofitService.getDataPenemu()
            // Kondisi saat sukses show data
            if (requestDataPenemu.isSuccessful) {
                val dataPenemu = requestDataPenemu.body() as List<PenemuItem>
                penemuAdapter.addData(dataPenemu)
                penemuAdapter.notifyDataSetChanged()
            }
        }

    }

}