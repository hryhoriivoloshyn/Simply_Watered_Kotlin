package com.example.simply_watered_kotlin

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simply_watered_kotlin.Adapter.MyMovieAdapter
import com.example.simply_watered_kotlin.Interface.ApiInterface
import com.example.simply_watered_kotlin.Model.RegionGroup
import com.example.simply_watered_kotlin.R
import com.example.simply_watered_kotlin.SslCertificate.NetworkHandler


import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class MainActivity : AppCompatActivity() {

    lateinit var mService: ApiInterface
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mService = Common.retrofitService
        mService= NetworkHandler.getRetrofit().create(ApiInterface::class.java)

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()



        mService.getMovieList().enqueue(object : Callback<MutableList<RegionGroup>> {
            override fun onFailure(call: Call<MutableList<RegionGroup>>, t: Throwable) {
                dialog.dismiss()
            }

            override fun onResponse(call: Call<MutableList<RegionGroup>>, response: Response<MutableList<RegionGroup>>) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<RegionGroup>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}